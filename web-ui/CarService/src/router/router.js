import Vue from 'vue'
import Router from 'vue-router'


import Home from '@/components/Home'
import About from '@/components/About'
import Contact from '@/components/Contact'
import Car from "@/components/Car";

Vue.use(Router)

export default new Router({
    routes: [
        {
            path: '/',
            name: 'Home',
            component: Home
        },
        {
            path: '/cars',
            name: 'Car',
            component: Car
        },
        {
            path: '/clients',
            name: 'Clients',
            component: Home
        },
        {
            path: '/about',
            name: 'About',
            component: About
        },
        {
            path: '/contact',
            name: 'Contact',
            component: Contact
        }
    ]
})