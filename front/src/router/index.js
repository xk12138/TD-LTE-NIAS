import Vue from 'vue'
import Router from 'vue-router'
import login from '@/components/login'
import 'element-ui/lib/theme-chalk/index.css';
//import App from './App.vue';

Vue.use(Router)
export default new Router({
  routes: [
    {
      path: '/',
      name: 'login',
      component: login
    }
  ]
})



// Vue.use(ElementUI);
// new Vue({
//   el: '#app',
//   render: h => h(App)
// });
