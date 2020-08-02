import Vue from 'vue'
import Router from 'vue-router'
import login from '@/components/login'
import index from '@/components/index'
import register from '@/components/register'
import data_control from '@/components/data_control'
import C2I_analyze from '@/components/C2I_analyze'
import info_search from '@/components/info_search'
import triple_search from '@/components/triple_search'

Vue.use(Router)

export default new Router({
  routes: [
    {
      path: '/',
      name: 'login',
      component: login
    },
    {
      path: '/index',
      name: 'index',
      component: index
    },
    {
      path: '/register',
      name: 'register',
      component: register
    },
    {
      path: '/data_control',
      name: 'data_control',
      component: data_control
    },
    {
      path: '/C2I_analyze',
      name: 'C2I_analyze',
      component: C2I_analyze
    },
    {
      path: '/info_search',
      name: 'info_search',
      component: info_search
    },
    {
      path: '/triple_search',
      name: 'triple_search',
      component: triple_search
    }
  ]
})
