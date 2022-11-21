import { createApp, Vue } from 'vue'
import App from './App.vue'
import 'bootstrap/dist/css/bootstrap.css'
import 'bootstrap-vue/dist/bootstrap-vue.css'
import { BootstrapVue, IconsPlugin } from 'bootstrap-vue'
import TablePlugin from 'bootstrap-vue'

Vue.use(BootstrapVue)
Vue.use(TablePlugin)
createApp(App).mount('#app')