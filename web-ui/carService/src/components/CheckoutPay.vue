<template>
    <stripe-checkout
        ref="checkoutRef"
        mode="payment"
        :pk="this.publishableKey"
        :line-items="lineItems"
        :successUrl="successUrl"
        :cancelUrl="cancelUrl"
        @loading="v => this.loading = v"
    >
        <button @click="submit">Shutup and take my money!</button>
    </stripe-checkout>
</template>

<script>
import {StripeCheckout} from '@vue-stripe/vue-stripe';

export default {
  name: 'CheckoutPay',
  components: {
    'stripe-checkout': StripeCheckout
  },
  data: () => ({
    loading: false,
    publishableKey: 'pk_test_51MldLJLHDfnmJ0JKXAHMvCxfacPkjvfsbRH25Vqb7RWkqZe3RdVACcZOVWyTWI1IvGZ5RzUClU8J8Ir0h0AaAzg500s1goY4tu',
    lineItems: [
      {
        price: 'price_1MldsnLHDfnmJ0JKZfBPQjZ4',
        quantity: 1
      }
    ],
    successUrl: '/cars',
    cancelUrl: '/clients',
  }),
  methods: {
    submit() {
      this.$refs.checkoutRef.redirectToCheckout();
    }
  }
}
</script>