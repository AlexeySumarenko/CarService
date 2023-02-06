<template>
  <div class="edit-form">

    <h1 class="text-center">Client</h1>
    <div class="form-group">
      <label for="description">Full name</label>
      <input
          type="text"
          class="form-control"
          id="fullName"
          required
          v-model="currentClient.fullName"
          name="fullName"
      />
    </div>

    <div class="form-group">
      <label for="description">User name</label>
      <input
          type="text"
          class="form-control"
          id="userName"
          required
          v-model="currentClient.userName"
          name="userName"
      />
    </div>

    <div class="form-group">
      <label for="description">Gender</label>
      <input
          type="text"
          class="form-control"
          id="gender"
          required
          v-model="currentClient.gender"
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
          v-model="currentClient.phone"
          name="phone"
      />
    </div>

    <b-button pill :href="'/clients/'">Back</b-button>

    <b-button pill variant="danger" @click="deleteClient">Delete</b-button>

    <b-button pill variant="success" @click="updateClient">Update</b-button>

    <p>{{ message }}</p>
  </div>
</template>

<script>
import ClientService from "../../services/ClientService";

export default {
  name: "Client",
  data(){
    return {
      currentClient: {},
      message: ''
    }
  },
  mounted(){
    this.message = '';
    this.getClient(this.$route.params.id);
  },
  methods:{
    async getClient(id){
      try {
        const response = await ClientService.get(id)
        this.currentClient = response.data
      } catch (err) {
        this.error = err
      }
    },
    deleteClient() {
      ClientService.delete(this.$route.params.id)
          .then(response => {
            console.log(response.data);
            this.$router.push({ name: "clients" });
          })
          .catch(e => {
            console.log(e);
          });
    },
    updateClient() {
      ClientService.update(this.$route.params.id, this.currentClient)
          .then(response => {
            console.log(response.data);
            this.message = 'The client was updated successfully!';
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