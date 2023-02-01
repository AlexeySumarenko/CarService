import Vue from 'vue'
import Router from 'vue-router'


import Home from '@/components/Home'
import About from '@/components/About'
import Contact from '@/components/Contact'
import Car from "@/components/car/Car";
import CarsList from "@/components/car/CarsList";
import AddCar from "@/components/car/AddCar";
import Client from "@/components/client/Client";
import ClientList from "@/components/client/ClientList";
import AddClient from "@/components/client/AddClient";
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
            name: 'Cars',
            component: CarsList
        },
        {
            path: '/car',
            name: 'Car',
            component: Car
        },
        {
            path: '/add_car',
            name: 'Add_car',
            component: AddCar
        },
        {
            path: '/clients',
            name: 'Clients',
            component: ClientList
        },
        {
            path: '/client',
            name: 'Client',
            component: Client
        },
        {
            path: '/add_client',
            name: 'Add_client',
            component: AddClient
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