<template>
  <div class="container">

    <h1 class="text-center">Client list</h1>
    <button class="badge badge-danger mr-2"
            @click="getClient(2)">
      getClient
    </button>
    <table class="table table-striped">
      <thead>
      <th>Client Id</th>
      <th>Full name</th>
      <th>User name</th>
      <th>Gender</th>
      <th>Phone</th>
      <th></th>
      </thead>
      <tbody>
      <tr>
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
  name: "Client",
  data(){
    return { client:{}
    }
  },
  methods:{
    async getClient(id){
      try {
        const response = await ClientService.get(id)
        this.client = response.data
      } catch (err) {
        this.error = err
      }
    }

  }

}
</script>

<style>

</style>