<template>
   <div>
      <b-overlay :show="show" rounded="sm">
        <b-card title="Карточка с наложением" :aria-hidden="show ? 'true' : null">
          <b-card-text>Laborum consequat non elit enim exercitation cillum.</b-card-text>
          <b-card-text>Нажмите кнопку, чтобы переключить наложение:</b-card-text>
          <b-button :disabled="show" variant="primary" @click="show = true">
            Показать наложение
          </b-button>
        </b-card>
      </b-overlay>
      <b-button class="mt-3" @click="show = !show">Переключить наложение</b-button>
    </div>
</template>

<script>
  export default {
     data() {
       return {
         show: false
       }
     }
   }
</script>
