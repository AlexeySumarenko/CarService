<template>
  <div class="edit-form">
  <div> <!--v-if="!submitted"-->
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

    <b-button v-b-modal.modal-center pill variant="danger">Delete</b-button>

    <b-button pill variant="success" @click="updateCar" >Update</b-button>
  </div>

<!--    <div v-else>
      <b-button pill :href="'/cars/'">Back</b-button>
    </div>-->

    <b-modal id="modal-center" centered title="Delete Car" @ok="deleteCar" >
      <p class="my-4">Are you sure you want to delete this car?</p>
    </b-modal>
  </div>
</template>

<script>
import CarService from "../../services/CarService";
export default {
  name: "Car",
  data(){
    return {
      currentCar: {},
      message: '',
      idCarDelete: null,
      submitted: false,

    }
  },
  mounted(){
    this.message = '';
    this.getCar(this.$route.params.id);
  },
  methods: {
    async getCar(id) {
      try {
        const response = await CarService.get(id)
        this.currentCar = response.data
      } catch (err) {
        this.error = err
      }
    },
    async deleteCar() {
      try {
        await CarService.delete(this.$route.params.id);
        this.$router.push(`/cars`);
        this.submitted = true;
        this.$bvToast.toast('Car success deleted', {
          title: `Car delete`,
          variant: 'success',
          solid: true,
        });
      } catch (e) {
      }
    },
    async updateCar() {
      try {
        await CarService.update(this.$route.params.id, this.currentCar)
        this.submitted = false;
        this.currentCar = {};
        this.$bvToast.toast('Car was updated successfully!', {
          title: `Update car`,
          variant: 'success',
          solid: true,
        });
      } catch (e) {
        this.$bvToast.toast('Car not updated', {
          title: `Update car`,
          variant: 'danger',
          solid: true,
        });
      }
    },
  }
}
</script>

<style>
.edit-form {
  max-width: 300px;
  margin: auto;
}
</style>