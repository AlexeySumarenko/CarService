<template>
  <div class="submit-form">
    <div v-if="!submitted">

      <div class="form-group">
        <label for="description">Company</label>
        <input
            type="text"
            class="form-control"
            id="company"
            required
            v-model="producer.company"
            name="company"
        />
      </div>

      <div class="form-group">
        <label for="description">Address</label>
        <input
            type="text"
            class="form-control"
            id="address"
            required
            v-model="producer.address"
            name="address"
        />
      </div>



      <button @click="saveProducer" class="btn btn-success">Submit</button>
    </div>

    <div v-else>
      <button class="btn btn-success" @click="newProducer">Ok</button>
    </div>
  </div>
</template>

<script>
import ProducerService from "@/services/ProducerService";

export default {
  name: "AddProducer",
  data() {
    return {
      producer: {
        company: "",
        address: "",
      },
      submitted: false
    };
  },
  methods: {
    async saveProducer() {
      var data = {
        company: this.producer.company,
        address: this.producer.address,
      };
      try {
        await ProducerService.create(data)
        this.submitted = true;
        this.$bvToast.toast('Producer success added', {
          title: `Producer add`,
          variant: 'success',
          solid: true,
        });
      } catch (e) {
        this.$bvToast.toast('Producer not added', {
          title: `Producer add`,
          variant: 'danger',
          solid: true,
        });
      }},

    newProducer() {
      this.submitted = false;
      this.producer = {};
    }
  }
};
</script>

<style scoped>

</style>