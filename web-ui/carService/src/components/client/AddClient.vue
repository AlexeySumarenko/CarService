<template>
  <div class="submit-form">
    <div v-if="!submitted">

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
      <button class="btn btn-success" @click="newClient">Ok</button>
    </div>
  </div>
</template>

<script>
import ClientService from "../../services/ClientService";

export default {
  name: "Add_client",
  data() {
    return {
      client: {
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
   async saveClient() {
      var data = {
        fullName: this.client.fullName,
        userName: this.client.userName,
        password: this.client.password,
        gender: this.client.gender,
        phone: this.client.phone,
      };
     try {
       await ClientService.create(data)
       this.submitted = true;
       this.$bvToast.toast('Toast body content', {
         title: `Client success added`,
         variant: 'success',
         solid: true,
       });
     } catch (e) {
       this.$bvToast.toast('Toast body content', {
         title: `Client not added`,
         variant: 'danger',
         solid: true,
       });
     }},

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