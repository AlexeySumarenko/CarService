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
            v-model="employee.fullName"
            name="fullName"
        />
      </div>

      <div class="form-group">
        <label for="description">JobPosition</label>
        <input
            type="text"
            class="form-control"
            id="jobPosition"
            required
            v-model="employee.jobPosition"
            name="jobPosition"
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
        <label for="description">Age</label>
        <input
            type="text"
            class="form-control"
            id="age"
            required
            v-model="employee.age"
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
            v-model="employee.phone"
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
            v-model="employee.address"
            name="address"
        />
      </div>

      <button @click="saveEmployee" class="btn btn-success">Submit</button>
    </div>

    <div v-else>
      <h4>You submitted successfully!</h4>
      <button class="btn btn-success" @click="newEmployee">Add</button>
    </div>
  </div>
</template>

<script>
import EmployeeService from "@/services/EmployeeService";

export default {
  name: "AddEmployee",
  data() {
    return {
      employee: {
        fullName: "",
        jobPosition: "",
        age: "",
        phone: "",
        address: ""
      },
      submitted: false
    };
  },
  methods: {
    async saveEmployee() {
      var data = {
        fullName: this.employee.fullName,
        jobPosition: this.employee.jobPosition,
        age: parseInt(this.employee.age),
        phone: this.employee.phone,
        address: this.employee.address
      };
      try {
        await EmployeeService.create(data)
        this.submitted = true;
        this.$bvToast.toast('Toast body content', {
          title: `Employee success added`,
          variant: 'success',
          solid: true,
        });
      } catch (e) {
        this.$bvToast.toast('Toast body content', {
          title: `Employee not added`,
          variant: 'danger',
          solid: true,
        });
      }
    },

    newEmployee() {
      this.submitted = false;
      this.employee = {};
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

