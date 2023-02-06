<template>
  <div class="container">

    <h1 class="text-center">Client list</h1>
    <div>
      <b-button-toolbar aria-label="Панель инструментов с группами кнопок и раскрывающимся меню">
        <b-button-group class="mx-1">
          <b-button href="/add_client">Add Client</b-button>
        </b-button-group>
        <b-dropdown class="mx-1" right text="menu">
          <b-dropdown-item>Элемент 1</b-dropdown-item>
          <b-dropdown-item>Элемент 2</b-dropdown-item>
          <b-dropdown-item>Элемент 3</b-dropdown-item>
        </b-dropdown>
      </b-button-toolbar>
    </div>
    <b-table id="client-table" striped hover :items="clients" :fields="fields" :per-page="perPage"
             :current-page="currentPage" primary-key="idClient">
      <template v-slot:cell(edit)="data">
        <b-button  :href="'/clients/' + data.item.idClient" >Edit</b-button>
      </template>
      <template v-slot:cell(delete)="data">
        <b-button  v-b-modal.modal-center @click="idClientDelete = data.item.idClient" >Delete</b-button>
      </template>
    </b-table>

    <p class="mt-3">Текущая страница: {{ currentPage }}</p>
    <b-pagination
        v-model="currentPage"
        :total-rows="rows"
        :per-page="perPage"
        first-text="First"
        prev-text="Prev"
        next-text="Next"
        last-text="Last"
        aria-controls="client-table"
    ></b-pagination>
    <b-modal id="modal-center" centered title="Delete Client" @ok="deleteClient(idClientDelete)">
      <p class="my-4">Are you sure you want to delete this client?</p>
    </b-modal>

  </div>
</template>

<script>
import ClientService from "../../services/ClientService";
import CarService from "@/services/CarService";
export default {
  name: "client-list",
  data(){
    return {
      clients:[],
      fields: ['idClient', 'fullName', 'userName', 'gender', 'phone', 'edit', 'delete'],
      perPage: 3,
      currentPage: 1,
      idClientDelete: null
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
  computed: {
    rows() {
      return this.clients.length;
    }},
  methods:{
    deleteClient(idClientDelete) {
      ClientService.delete(idClientDelete)
          .then(response => {
            console.log(response.data);
            this.$router.push({ name: "client" });
          })
          .catch(e => {
            console.log(e);
          });
    }
  }
}
</script>

<style>

</style>