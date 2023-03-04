<template>
  <div class="container" >

    <h1 class="text-center">Employee list</h1>
    <div>
      <b-button-toolbar aria-label="Панель инструментов с группами кнопок и раскрывающимся меню">
        <b-button-group class="mx-1">
          <b-button href="/add_employee">Add Employee</b-button>
        </b-button-group>
        <b-dropdown class="mx-1" right text="menu">
          <b-dropdown-item>Элемент 1</b-dropdown-item>
          <b-dropdown-item>Элемент 2</b-dropdown-item>
          <b-dropdown-item>Элемент 3</b-dropdown-item>
        </b-dropdown>


            <div class="col-md-auto row justify-content-md per-page">
              <b-form-select v-model="perPage" :options="options"></b-form-select>
            </div>

      </b-button-toolbar>
    </div>

    <b-table id="emoloyee-table" striped hover :items="employees" :fields="fields" :per-page="perPage"
             :current-page="currentPage" primary-key="idEmployee">
      <template v-slot:cell(edit)="data">
        <b-button  :href="'/employees/' + data.item.idEmployee" >Edit</b-button>
      </template>
      <template v-slot:cell(delete)="data">
        <b-button  v-b-modal.modal-center @click="idEmployeeDelete = data.item.idEmployee" >Delete</b-button>
      </template>
    </b-table>

    <b-pagination
        v-model="currentPage"
        :total-rows="rows"
        :per-page="perPage"
        first-text="First"
        prev-text="Prev"
        next-text="Next"
        last-text="Last"
        aria-controls="employee-table"
    ></b-pagination>

    <b-modal id="modal-center" centered title="Delete Employee" @ok="deleteEmployee(idEmployeeDelete)" >
      <p class="my-4">Are you sure you want to delete this Employee?</p>
    </b-modal>


  </div>
</template>

<script>
import EmployeeService from "@/services/EmployeeService";

export default {
  name: "EmployeeList",
  data(){
    return {
      employees:[],
      fields: ['idEmployee', 'fullName', 'jobPosition', 'age', 'phone', 'address', 'edit', 'delete'],
      perPage: 3,
      currentPage: 1,
      idEmployeeDelete: null,
      options: [
        { value: 3, text: 'Elements per page: 3' },
        { value: 5, text: 'Elements per page: 5' },
        { value: 10, text: 'Elements per page: 10' },
        { value: 15, text: 'Elements per page: 15' },
        { value: 20, text: 'Elements per page: 20' }
      ]
    }
  },

  async mounted(){
    try {
      const response = await EmployeeService.getAll()
      this.employees = response.data
    } catch (err) {
      this.error = err
    }
  },
  computed: {
    rows() {
      return this.employees.length;
    }},
  methods:{
    async deleteEmployee(idEmployeeDelete) {
      try {
        await EmployeeService.delete(idEmployeeDelete);
        this.$bvToast.toast('Employee success deleted', {
          title: `Employee delete`,
          variant: 'success',
          solid: true,
        });
        const response = await EmployeeService.getAll()
        this.employees = response.data
      } catch (e) {
      }
    },


    setLocation(id){
      history.pushState("object or string", "Title", "/employees/ + id");
    },
    showModal: function () {
      this.$refs.delModal.modalShow = true
    },


  }
}
</script>

<style>
.per-page {
  margin-left: auto;
}
</style>