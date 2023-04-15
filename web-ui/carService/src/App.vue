<template>
  <div id="app">
    <navigation></navigation>
    <home></home>
  </div>
</template>

<script>
import AdminNavigation from './components/AdminNavigation'
import Home from "@/components/Home";
import Navigation from "@/components/Navigation";

export default {
  name: 'app',
  components: {
    //'admin-navigation': AdminNavigation,
    'home': Home,
    'navigation': Navigation
  }
}
</script>

<style>
#app {
  font-family: 'Avenir', Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;

}
</style>