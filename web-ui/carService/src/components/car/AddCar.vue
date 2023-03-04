<template>
  <div class="submit-form">
    <div v-if="!submitted">

      <div class="form-group">
        <label for="description">Client FullName</label>
        <div>
        <select v-model="car.idClient" >
          <option v-for="option in options" :value="option.idClient">
            {{ option.fullName }}
          </option>
        </select>
        </div>
        <div>idClient: {{ selected }}</div>
      </div>

      <div class="form-group">
        <label for="description">carBrand</label>
        <input
            type="text"
            class="form-control"
            id="carBrand"
            required
            v-model="car.carBrand"
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
            v-model="car.model"
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
            v-model="car.type"
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
            v-model="car.releaseYear"
            name="releaseYear"

        />
      </div>

      <button @click="saveCar" class="btn btn-success">Submit</button>
    </div>

    <div v-else>
      <button class="btn btn-success" @click="newCar">Ok</button>
    </div>
  </div>
</template>

<script>
import CarService from "../../services/CarService";
import ClientService from "@/services/ClientService";

export default {
  name: "Add_car",
  data() {
    return {
      car: {
        idClient: "",
        carBrand: "",
        model: "",
        type: "",
        releaseYear: ""
      },
      submitted: false,
      selected: '1',
      options: []
    };
  },
  async mounted(){
    try {
      const response = await ClientService.getAll()
      this.options = response.data
    } catch (err) {
      this.error = err
    }
  },
  methods: {
    async saveCar() {
      var data = {
        idClient: parseInt(this.car.idClient),
        carBrand: this.car.carBrand,
        model: this.car.model,
        type: this.car.type,
        releaseYear: parseInt(this.car.releaseYear)
      };
      try {
        await CarService.create(data)
              this.submitted = true;
              this.$bvToast.toast('Car success added', {
                title: `Add car`,
                variant: 'success',
                solid: true,
            });
      } catch (e) {
        this.$bvToast.toast('Car not added', {
          title: `Add car`,
          variant: 'danger',
          solid: true,
        });
      }

    },

    newCar() {
      this.submitted = false;
      this.car = {};
    },

  }
};
</script>

<style>
.submit-form {
  max-width: 300px;
  margin: auto;
}
</style>