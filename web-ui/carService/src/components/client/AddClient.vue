<template>
  <div class="submit-form">
    <div v-if="!submitted">
      <div class="form-group">
        <label for="title">ClientId</label>
        <input
            type="text"
            class="form-control"
            id="CarId"
            required
            v-model="client.idClient"
            name="CarId"
        />
      </div>

      <div class="form-group">
        <label for="description">FullName</label>
        <input
            type="text"
            class="form-control"
            id="idClient"
            required
            v-model="client.fullName"
            name="idClient"
        />
      </div>

      <div class="form-group">
        <label for="description">UserName</label>
        <input
            type="text"
            class="form-control"
            id="carBrand"
            required
            v-model="client.userName"
            name="carBrand"
        />
      </div>

      <div class="form-group">
        <label for="description">Password</label>
        <input
            type="text"
            class="form-control"
            id="type"
            required
            v-model="client.password"
            name="type"
        />
      </div>

      <div class="form-group">
        <label for="description">Gender</label>
        <input
            type="text"
            class="form-control"
            id="model"
            required
            v-model="client.gender"
            name="model"
        />
      </div>

      <div class="form-group">
        <label for="description">Phone</label>
        <input
            type="text"
            class="form-control"
            id="type"
            required
            v-model="client.phone"
            name="type"
        />
      </div>

      <button @click="saveClient" class="btn btn-success">Submit</button>
    </div>

    <div v-else>
      <h4>You submitted successfully!</h4>
      <button class="btn btn-success" @click="newClient">Add</button>
    </div>
  </div>
</template>

<script>
import ClientService from "../../services/ClientService";

export default {
  name: "add-client",
  data() {
    return {
      client: {
        idClient: "",
        fullName: "",
        userName: "",
        password: "",
        gender: "",
        phone: "",
      },
      submitted: false
    };
  },
  methods: {
    saveClient() {
      var data = {
        idClient: this.client.idClient,
        fullName: this.client.fullName,
        userName: this.client.userName,
        password: this.client.password,
        gender: this.client.gender,
        phone: this.client.phone,
      };

      ClientService.create(data)
          .then(response => {
            this.client.idClient = response.data.idClient;
            console.log(response.data);
            this.submitted = true;
          })
          .catch(e => {
            console.log(e);
          });
    },

    newClient() {
      this.submitted = false;
      this.client = {};
    }
  }
};
</script>

<style>
.submit-form {
  max-width: 300px;
  margin: auto;
}
</style>