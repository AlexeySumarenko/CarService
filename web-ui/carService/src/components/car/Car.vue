<template>
  <div class="edit-form">

    <h1 class="text-center">Car</h1>
    <div class="form-group">
      <label for="description">carBrand</label>
      <input
          type="text"
          class="form-control"
          id="carBrand"
          required
          v-model="currentCar.carBrand"
          name="carBrand"
      />
    </div>

    <div class="form-group">
      <label for="description">model</label>
      <input
          type="text"
          class="form-control"
          id="model"
          required
          v-model="currentCar.model"
          name="model"
      />
    </div>

    <div class="form-group">
      <label for="description">type</label>
      <input
          type="text"
          class="form-control"
          id="type"
          required
          v-model="currentCar.type"
          name="type"
      />
    </div>

    <div class="form-group">
      <label for="description">releaseYear</label>
      <input
          type="text"
          class="form-control"
          id="releaseYear"
          required
          v-model="currentCar.releaseYear"
          name="releaseYear"
      />
    </div>

    <b-button pill :href="'/cars/'">Back</b-button>

    <b-button pill variant="danger" @click="deleteCar">Delete</b-button>

    <b-button pill variant="success" @click="updateCar" >Update</b-button>

    <p>{{ message }}</p>
  </div>
</template>

<script>
import CarService from "../../services/CarService";
export default {
  name: "Car",
  data(){
    return {
      currentCar: {},
      message: ''
    }
  },
  mounted(){
    this.message = '';
    this.getCar(this.$route.params.id);
  },
  methods:{
    async getCar(id){
      try {
        const response = await CarService.get(id)
        this.currentCar = response.data
      } catch (err) {
        this.error = err
      }
    },
    deleteCar() {
      CarService.delete(this.$route.params.id)
          .then(response => {
            console.log(response.data);
            this.$router.push({ name: "cars" });
          })
          .catch(e => {
            console.log(e);
          });
    },
    updateCar() {
      CarService.update(this.$route.params.id, this.currentCar)
          .then(response => {
            console.log(response.data);
            this.message = 'The car was updated successfully!';
          })
          .catch(e => {
            console.log(e);
          });
    }


}}
</script>

<style>
.edit-form {
  max-width: 300px;
  margin: auto;
}
</style>