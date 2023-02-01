<template>
  <div class="container">

    <h1 class="text-center">Car list</h1>
    <button class="badge badge-danger mr-2"
            @click="getCar(2)">
      getCar
    </button>
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
        <tr>
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
import CarService from "../../services/CarService";
export default {
  name: "Car",
  data(){
    return { car:{}
    }
  },
  methods:{
    async getCar(id){
      try {
        const response = await CarService.get(id)
        this.car = response.data
      } catch (err) {
        this.error = err
      }
    }

  }

}
</script>

<style>

</style>