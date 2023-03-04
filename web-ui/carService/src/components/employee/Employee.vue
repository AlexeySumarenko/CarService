<template>
  <div class="edit-form">

    <h1 class="text-center">Employee</h1>
    <div class="form-group">
      <label for="description">Full name</label>
      <input
          type="text"
          class="form-control"
          id="fullName"
          required
          v-model="currentEmployee.fullName"
          name="fullName"
      />
    </div>

    <div class="form-group">
      <label for="description">Job position</label>
      <input
          type="text"
          class="form-control"
          id="jobPosition"
          required
          v-model="currentEmployee.jobPosition"
          name="jobPosition"
      />
    </div>

    <div class="form-group">
      <label for="description">Age</label>
      <input
          type="text"
          class="form-control"
          id="age"
          required
          v-model="currentEmployee.age"
          name="age"
      />
    </div>

    <div class="form-group">
      <label for="description">Phone</label>
      <input
          type="text"
          class="form-control"
          id="phone"
          required
          v-model="currentEmployee.phone"
          name="phone"
      />
    </div>

    <div class="form-group">
      <label for="description">Address</label>
      <input
          type="text"
          class="form-control"
          id="address"
          required
          v-model="currentEmployee.address"
          name="address"
      />
    </div>

    <b-button pill :href="'/employees/'">Back</b-button>

    <b-button pill variant="danger" @click="deleteEmployee">Delete</b-button>

    <b-button pill variant="success" @click="updateEmployee">Update</b-button>

    <p>{{ message }}</p>
  </div>
</template>

<script>
import EmployeeService from "@/services/EmployeeService";

export default {
  name: "Employee",
  data(){
    return {
      currentEmployee: {},
      message: ''
    }
  },
  mounted(){
    this.message = '';
    this.getEmployee(this.$route.params.id);
  },
  methods:{
    async getEmployee(id){
      try {
        const response = await EmployeeService.get(id)
        this.currentEmployee = response.data
      } catch (err) {
        this.error = err
      }
    },
    deleteEmployee() {
      EmployeeService.delete(this.$route.params.id)
          .then(response => {
            console.log(response.data);
            this.$router.push({ name: "employees" });
          })
          .catch(e => {
            console.log(e);
          });
    },
    updateEmployee() {
      EmployeeService.update(this.$route.params.id, this.currentEmployee)
          .then(response => {
            console.log(response.data);
            this.message = 'The employee was updated successfully!';
          })
          .catch(e => {
            console.log(e);
          });
    }


  }}
</script>

<style scoped>

</style>