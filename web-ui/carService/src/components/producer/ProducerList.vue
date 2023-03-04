<template>
  <div class="container" >

    <h1 class="text-center">Producer list</h1>
    <div>
      <b-button-toolbar aria-label="Панель инструментов с группами кнопок и раскрывающимся меню">
        <b-button-group class="mx-1">
          <b-button href="/add_producer">Add Producer</b-button>
        </b-button-group>
        <b-dropdown class="mx-1" right text="menu">
          <b-dropdown-item>Элемент 1</b-dropdown-item>
          <b-dropdown-item>Элемент 2</b-dropdown-item>
          <b-dropdown-item>Элемент 3</b-dropdown-item>
        </b-dropdown>


            <div class="col-md-auto row justify-content-md per-page">
              <b-form-select v-model="perPage" :options="options"></b-form-select>
            </div>
      </b-button-toolbar>
    </div>

    <b-table id="producer-table" striped hover :items="producers" :fields="fields" :per-page="perPage"
             :current-page="currentPage" primary-key="idProducer">
      <template v-slot:cell(edit)="data">
        <b-button  :href="'/producers/' + data.item.idProducer" >Edit</b-button>
      </template>
      <template v-slot:cell(delete)="data">
        <b-button  v-b-modal.modal-center @click="idProducerDelete = data.item.idProducer" >Delete</b-button>
      </template>
    </b-table>



    <b-pagination
        v-model="currentPage"
        :total-rows="rows"
        :per-page="perPage"
        first-text="First"
        prev-text="Prev"
        next-text="Next"
        last-text="Last"
        aria-controls="producer-table"
        align="center"
    ></b-pagination>

    <b-modal id="modal-center" centered title="Delete Car" @ok="deleteProducer(idProducerDelete)" >
      <p class="my-4">Are you sure you want to delete this car?</p>
    </b-modal>


  </div>
</template>

<script>
import ProducerService from "@/services/ProducerService";

export default {
  name: "ProducerList",
  data(){
    return {
      producers:[],
      fields: ['company', 'address', 'edit', 'delete'],
      perPage: 3,
      currentPage: 1,
      idProducerDelete: null,
      options: [
        { value: 3, text: 'Elements per page: 3' },
        { value: 5, text: 'Elements per page: 5' },
        { value: 10, text: 'Elements per page: 10' },
        { value: 15, text: 'Elements per page: 15' },
        { value: 20, text: 'Elements per page: 20' }
      ]
    }
  },

  async mounted(){
    try {
      const response = await ProducerService.getAll()
      this.producers = response.data
    } catch (err) {
      this.error = err
    }
  },
  computed: {
    rows() {
      return this.producers.length;
    }},
  methods:{
    async deleteProducer(idProducerDelete) {
      try {
        await ProducerService.delete(idProducerDelete);
        this.$bvToast.toast('Producer success deleted', {
          title: `Delete producer`,
          variant: 'success',
          solid: true,
        });
        const response = await ProducerService.getAll()
        this.producers = response.data
      } catch (e) {
      }
    },

  }
}
</script>

<style>
.per-page {
  margin-left: auto;
}
</style>