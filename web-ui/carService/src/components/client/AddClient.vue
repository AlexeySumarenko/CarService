<template>
  <div class="submit-form">
    <div v-if="!submitted">

<!--      <div class="form-group">
        <label for="title">ClientId</label>
        <input
            type="text"
            class="form-control"
            id="CarId"
            required
            v-model="client.idClient"
            name="CarId"
        />
      </div>-->

      <div class="form-group">
        <label for="description">FullName</label>
        <input
            type="text"
            class="form-control"
            id="fullName"
            required
            v-model="client.fullName"
            name="fullName"
        />
      </div>

      <div class="form-group">
        <label for="description">UserName</label>
        <input
            type="text"
            class="form-control"
            id="userName"
            required
            v-model="client.userName"
            name="userName"
        />
      </div>

<!--      <div class="form-group">
        <label for="description">Password</label>
        <input
            type="text"
            class="form-control"
            id="type"
            required
            v-model="client.password"
            name="type"
        />
      </div>-->

      <div class="form-group">
        <label for="description">Gender</label>
        <input
            type="text"
            class="form-control"
            id="gender"
            required
            v-model="client.gender"
            name="gender"
        />
      </div>

      <div class="form-group">
        <label for="description">Phone</label>
        <input
            type="text"
            class="form-control"
            id="phone"
            required
            v-model="client.phone"
            name="phone"
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
        fullName: "",
        userName: "",
        gender: "",
        phone: "",
      },
      submitted: false
    };
  },
  methods: {
    saveClient() {
      var data = {
        fullName: this.client.fullName,
        userName: this.client.userName,
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