<template>
  <div class="container" >

    <h1 class="text-center">Car list</h1>
    <div>
      <b-button-toolbar aria-label="Панель инструментов с группами кнопок и раскрывающимся меню">
        <b-button-group class="mx-1">
          <b-button href="/add_car">Add Car</b-button>
        </b-button-group>
        <b-dropdown class="mx-1" right text="menu">
          <b-dropdown-item>Элемент 1</b-dropdown-item>
          <b-dropdown-item>Элемент 2</b-dropdown-item>
          <b-dropdown-item>Элемент 3</b-dropdown-item>
        </b-dropdown>
      </b-button-toolbar>
    </div>

    <b-table id="car-table" striped hover :items="cars" :fields="fields" :per-page="perPage"
             :current-page="currentPage" primary-key="idCar">
      <template v-slot:cell(edit)="data">
        <b-button  :href="'/cars/' + data.item.idCar" >Edit</b-button>
      </template>
      <template v-slot:cell(delete)="data">
        <b-button  v-b-modal.modal-center @click="idCarDelete = data.item.idCar" >Delete</b-button>
      </template>
    </b-table>

    <p class="mt-3">Текущая страница: {{ currentPage }}</p>
    <b-pagination
        v-model="currentPage"
        :total-rows="rows"
        :per-page="perPage"
        first-text="First"
        prev-text="Prev"
        next-text="Next"
        last-text="Last"
        aria-controls="car-table"
    ></b-pagination>

    <b-modal id="modal-center" centered title="Delete Car" @ok="deleteCar(idCarDelete)" >
      <p class="my-4">Are you sure you want to delete this car?</p>
    </b-modal>


  </div>
</template>

<script>
import CarService from "../../services/CarService";
import PopUpDeleteCar from "@/components/car/PopUpDeleteCar";
export default {
  name: "car-list",
  components: {
    PopUpDeleteCar
  },
  data(){
    return {
      cars:[],
      fields: ['idCar', 'idClient', 'carBrand', 'model', 'type', 'releaseYear', 'edit', 'delete'],
      perPage: 3,
      currentPage: 1,
      idCarDelete: null,
    }
  },

  async mounted(){
    try {
      const response = await CarService.getAll()
      this.cars = response.data
    } catch (err) {
      this.error = err
    }
  },
  computed: {
    rows() {
      return this.cars.length;
    }},
  methods:{
    async deleteCar(idCarDelete) {
      try {
        await CarService.delete(idCarDelete);
        this.$bvToast.toast('Toast body content', {
          title: `Item success deleted`,
          variant: 'success',
          solid: true,
        });
        const response = await CarService.getAll()
        this.cars = response.data
      } catch (e) {
      }
  },


    setLocation(id){
      history.pushState("object or string", "Title", "/cars/ + id");
    },
    showModal: function () {
      this.$refs.delModal.modalShow = true
    },


  }
}
</script>

<style>

</style>