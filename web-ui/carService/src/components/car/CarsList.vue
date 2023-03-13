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

            <div class="col-md-auto row justify-content-md per-page">
              <b-form-select v-model="perPage" :options="options" @change="getCars"></b-form-select>
            </div>

      </b-button-toolbar>
    </div>

    <b-table id="car-table" striped hover :items="cars" :fields="fields"  primary-key="idCar">
      <template v-slot:cell(edit)="data">
        <b-button  :href="'/cars/' + data.item.idCar" >Edit</b-button>
      </template>
      <template v-slot:cell(delete)="data">
        <b-button  v-b-modal.modal-center @click="idCarDelete = data.item.idCar" >Delete</b-button>
      </template>
    </b-table>

    <b-pagination
        v-model="currentPage"
        :total-rows="totalRows"
        :per-page="perPage"
        @input="getCars">
    </b-pagination>

    <b-modal id="modal-center" centered title="Delete Car" @ok="deleteCar(idCarDelete)" >
      <p class="my-4">Are you sure you want to delete this car?</p>
    </b-modal>


  </div>
</template>

<script>
import CarService from "../../services/CarService";
export default {
  name: "car-list",
  data(){
    return {
      cars:[],
      fields: ['idCar', 'idClient', 'carBrand', 'model', 'type', 'releaseYear', 'edit', 'delete'],
      currentPage: 1,
      perPage: 3,
      totalRows: 0,
      totalPages: 0,
      idCarDelete: null,
      options: [
        { value: 3, text: 'Elements per page: 3' },
        { value: 5, text: 'Elements per page: 5' },
        { value: 10, text: 'Elements per page: 10' },
        { value: 15, text: 'Elements per page: 15' },
        { value: 20, text: 'Elements per page: 20' }
      ],

    }
  },
  computed: {
    getPerPage() {
      return this.perPage;
    },
    getCurrentPage() {
      return this.currentPage;
    }
  },

  created() {
    this.getCars(this.getCurrentPage, this.getPerPage)
  },
  methods:{
    async deleteCar(idCarDelete) {
      try {
        await CarService.delete(idCarDelete);
        this.$bvToast.toast('Car success deleted', {
          title: `Delete car`,
          variant: 'success',
          solid: true,
        });
        await this.getCars(this.getCurrentPage, this.getPerPage)
      } catch (e) {
      }
    },
    async getCars(){
      const response = await CarService.getAll(this.getCurrentPage, this.getPerPage)
      this.totalPages = response.data.pageCount
      this.totalRows = response.data.totalRows
      this.cars = response.data.cars
    }

  }
}
</script>

<style>
.per-page {
  margin-left: auto;
}
</style>