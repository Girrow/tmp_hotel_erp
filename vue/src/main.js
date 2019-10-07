import Vue from 'vue'
import './plugins/axios'
import App from './App.vue'
import router from './router'
import store from './store'
import vuetify from './plugins/vuetify';
// import VueGoogleCharts from 'vue-google-charts'

// import axios from 'axios'
// Vue.prototype.$http= axios;

 /* eslint-disable no-console */
// Vue.use(VueGoogleCharts);
Vue.config.productionTip = false

new Vue({
  router,
  store,
  vuetify,
  render: h => h(App)
}).$mount('#app')
