<template>
  <div>
    <b-carousel
        id="carousel-1"
        v-model="slide"
        :interval="0"
        controls
        indicators
        img-width="1024"
        img-height="480"
        @sliding-start="onSlideStart"
        @sliding-end="onSlideEnd"
    >

      <b-carousel-slide
          caption="Первый слайд"
          text="Nulla vitae elit libero, a pharetra augue mollis interdum."
          img-src="../src/assets/banner1.jpg"
      ></b-carousel-slide>
      <b-carousel-slide
          caption="Второй слайд"
          text="Nulla vitae elit libero, a pharetra augue mollis interdum."
          img-src="../src/assets/banner2.jpg"
      ></b-carousel-slide>
      <b-carousel-slide
          caption="Третий слайд"
          text="Nulla vitae elit libero, a pharetra augue mollis interdum."
          img-src="../src/assets/banner3.jpg"
      ></b-carousel-slide>


    </b-carousel>
    <p class="mt-4">
      Слайд #: {{ slide }}<br>
      Слайдинг: {{ sliding }}
    </p>
  </div>
</template>

<script>
export default {
  name: "Home",
  data() {
    return {
      slide: 0,
      sliding: null
    }
  },
  methods: {
    onSlideStart(slide) {
      this.sliding = true
    },
    onSlideEnd(slide) {
      this.sliding = false
    }
  }
}
</script>

<style >

</style>