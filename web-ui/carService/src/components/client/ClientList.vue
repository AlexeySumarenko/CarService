<template>
  <div class="container">

    <h1 class="text-center">Client list</h1>
    <table class="table table-striped">
      <thead>
      <th>Client Id</th>
      <th>Full name</th>
      <th>User name</th>
      <th>Gender</th>
      <th>Phone</th>
      </thead>
      <tbody>
      <tr v-for="client in clients" v-bind:key = "client.id">
        <td>{{client.idClient}}</td>
        <td>{{client.fullName}}</td>
        <td>{{client.userName}}</td>
        <td>{{client.gender}}</td>
        <td>{{client.phone}}</td>

      </tr>
      </tbody>
    </table>
  </div>
</template>

<script>
import ClientService from "../../services/ClientService";
export default {
  name: "client-list",
  data(){
    return { clients:[]
    }
  },
  async mounted(){
    try {
      const response = await ClientService.getAll()
      this.clients = response.data
    } catch (err) {
      this.error = err
    }
  },
  methods:{

  }
}
</script>

<style>

</style>