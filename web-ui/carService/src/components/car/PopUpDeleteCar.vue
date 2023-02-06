<template>
  <div>
    <b-modal v-model="modalShow" centered>Привет из модального окна!</b-modal>
  </div>
</template>

<script>
export default {
  name: "PopUpDeleteCar",
  data() {
    return {
      modalShow: false
    }
  }
}
</script>