<template>
  <div class="container">
    <h1 class="text-center">Car list</h1>
    <table class="table table-striped">
      <thead>
      <th>Car Id</th>
      <th>Client Id</th>
      <th>Car Brand</th>
      <th>Model</th>
      <th>Type</th>
      <th>Release Year</th>
      </thead>
      <tbody>
        <tr v-for="car in cars" v-bind:key = "car.id">
            <td>{{car.idCar}}</td>
            <td>{{car.idClient}}</td>
            <td>{{car.carBrand}}</td>
            <td>{{car.model}}</td>
            <td>{{car.type}}</td>
            <td>{{car.releaseYear}}</td>

        </tr>
      </tbody>
    </table>
  </div>
</template>

<script>
import CarService from "../services/CarService";
export default {
  name: "Cars",
  data(){
    return { cars:[]
    }
  },
  methods: {
    getCars(){
      CarService.getCars().then((response) => this.cars = response.data)
    }
  },
    created(){
    this.getCars()
  }
}
</script>

<style>

</style>