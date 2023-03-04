<template>
  <div class="edit-form">
    <div>
      <h1 class="text-center">Producer</h1>
      <div class="form-group">
        <label for="description">company</label>
        <input
            type="text"
            class="form-control"
            id="company"
            required
            v-model="currentProducer.company"
            name="company"
        />
      </div>

      <div class="form-group">
        <label for="description">address</label>
        <input
            type="text"
            class="form-control"
            id="address"
            required
            v-model="currentProducer.address"
            name="address"
        />
      </div>



      <b-button pill :href="'/producers/'">Back</b-button>

      <b-button v-b-modal.modal-center pill variant="danger">Delete</b-button>

      <b-button pill variant="success" @click="updateProducer" >Update</b-button>
    </div>


    <b-modal id="modal-center" centered title="Delete Producer" @ok="deleteProducer" >
      <p class="my-4">Are you sure you want to delete this producer?</p>
    </b-modal>
  </div>
</template>

<script>
import ProducerService from "@/services/ProducerService";

export default {
  name: "Producer",
  data(){
    return {
      currentProducer: {},
      message: '',
      idProducerDelete: null,
      submitted: false,

    }
  },
  mounted(){
    this.message = '';
    this.getProducer(this.$route.params.id);
  },
  methods: {
    async getProducer(id) {
      try {
        const response = await ProducerService.get(id)
        this.currentProducer = response.data
      } catch (err) {
        this.error = err
      }
    },
    async deleteProducer() {
      try {
        await ProducerService.delete(this.$route.params.id);
        this.$router.push(`/producers`);
        this.submitted = true;
        this.$bvToast.toast('Producer success deleted', {
          title: `Producer delete`,
          variant: 'success',
          solid: true,
        });
      } catch (e) {
      }
    },
    async updateProducer() {
      try {
        await ProducerService.update(this.$route.params.id, this.currentProducer)
        this.submitted = false;
        this.currentProducer = {};
        this.$bvToast.toast('Producer was updated successfully!', {
          title: `Producer update`,
          variant: 'success',
          solid: true,
        });
      } catch (e) {
        this.$bvToast.toast('Producer not updated', {
          title: `Producer update`,
          variant: 'danger',
          solid: true,
        });
      }
    },
  }
}
</script>

<style scoped>

</style>