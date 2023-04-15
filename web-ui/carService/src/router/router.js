import Vue from 'vue'
import Router from 'vue-router'


import Home from '@/components/Home'
import Contact from '@/components/Contact'
import Car from "@/components/car/Car";
import Client from "@/components/client/Client";
import Employee from "@/components/employee/Employee";
import Order from "@/components/order/Order";
import Producer from "@/components/producer/Producer";
import Service from "@/components/service/Service";
import SparePart from "@/components/sparePart/SparePart";
import CarsList from "@/components/car/CarsList";
import ClientList from "@/components/client/ClientList";
import EmployeeList from "@/components/employee/EmployeeList";
import OrderList from "@/components/order/OrderList";
import ProducerList from "@/components/producer/ProducerList";
import ServiceList from "@/components/service/ServiceList";
import SparePartList from "@/components/sparePart/SparePartList";
import AddCar from "@/components/car/AddCar";
import AddClient from "@/components/client/AddClient";
import AddEmployee from "@/components/employee/AddEmployee";
import AddOrder from "@/components/order/AddOrder";
import AddProducer from "@/components/producer/AddProducer";
import AddService from "@/components/service/AddService";
import AddSparePart from "@/components/sparePart/AddSparePart";
import AdminHome from "@/components/AdminHome";

Vue.use(Router)

export default new Router({
    mode: 'history',
    routes: [
        {
            path: '/home',
            name: 'Home',
            component: Home
        },
        {
            path: '/contact',
            name: 'Contact',
            component: Contact
        },
        {
            path: '/cars',
            name: 'Cars',
            component: CarsList
        },
        {
            path: '/cars/:id',
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
            path: '/clients/:id',
            name: 'Client',
            component: Client
        },
        {
            path: '/add_client',
            name: 'Add_client',
            component: AddClient
        },
        {
            path: '/employees',
            name: 'Employees',
            component: EmployeeList
        },
        {
            path: '/employees/:id',
            name: 'Employee',
            component: Employee
        },
        {
            path: '/add_employee',
            name: 'Add_employee',
            component: AddEmployee
        },
        {
            path: '/orders',
            name: 'Orders',
            component: OrderList
        },
        {
            path: '/orders/:id',
            name: 'Order',
            component: Order
        },
        {
            path: '/add_order',
            name: 'Add_order',
            component: AddOrder
        },
        {
            path: '/producers',
            name: 'Producers',
            component: ProducerList
        },
        {
            path: '/producers/:id',
            name: 'Producer',
            component: Producer
        },
        {
            path: '/add_producer',
            name: 'Add_producer',
            component: AddProducer
        },
        {
            path: '/services',
            name: 'Services',
            component: ServiceList
        },
        {
            path: '/services/:id',
            name: 'Service',
            component: Service
        },
        {
            path: '/add_service',
            name: 'Add_Service',
            component: AddService
        },
        {
            path: '/spare_parts',
            name: 'SpareParts',
            component: SparePartList
        },
        {
            path: '/spare_parts/:id',
            name: 'SparePart',
            component: SparePart
        },
        {
            path: '/add_spare_part',
            name: 'Add_spare_part',
            component: AddSparePart
        }
    ]
})