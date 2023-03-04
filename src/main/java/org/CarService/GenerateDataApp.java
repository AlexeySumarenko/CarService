package org.CarService;


import org.CarService.entity.*;
import org.CarService.repository.CarRepository;
import org.CarService.repository.ClientRepository;
import org.CarService.repository.EmployeeRepository;
import org.CarService.repository.OrderRepository;
import org.CarService.repository.ProducerRepository;
import org.CarService.repository.ServiceRepository;
import org.CarService.repository.SparePartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.Date;
import java.util.ArrayList;

@SpringBootApplication
public class GenerateDataApp implements CommandLineRunner {
    @Autowired
    private CarRepository carRepository;
    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    public EmployeeRepository employeeRepository;

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private ProducerRepository producerRepository;

    @Autowired
    private ServiceRepository serviceRepository;

    @Autowired
    private SparePartRepository sparePartRepository;


    public static void main( String[] args ) {
        SpringApplication.run(GenerateDataApp.class);

    }

    @Override
    public void run(String... args) throws Exception {

        ArrayList<Client> clients = new ArrayList<>();



 /*for ( int i = 0; i < 10; i++) {
            Client client = new Client();
            client.setFullName("Client full name " + i);
            client.setUserName("Client user name " + i);
            client.setPassword("Client password " + i);
            client.setGender("Client gender " + i);
            client.setPhone("Client phone " + i);
            int clientId = this.clientRepository.saveClient(client);

            Car car = new Car();
            car.setIdClient(clientId);
            car.setCarBrand("Car brand " + i);
            car.setModel("Model " + i);
            car.setType("Type " + i);
            car.setReleaseYear(2000 + i);
            int carId = this.carRepository.saveCar(car);

            Employee employee = new Employee();
            employee.setFullName("Employee full name " + i);
            employee.setJobPosition("Employee job position " + i);
            employee.setAge(20+i);
            employee.setPhone("Employee phone " + i);
            employee.setAddress("Employee address " + i);
            int employeeId = this.employeeRepository.saveEmployee(employee);

            Producer producer = new Producer();
            producer.setCompany("Company " + i);
            producer.setAddress("Address " + i);
            int producerId = this.producerRepository.saveProducer(producer);

            Service service = new Service();
            service.setServiceName("Service name " + i);
            service.setPrice((double) 100 + (i*20));
            service.setGuarantee(i + " Months");
            service.setIdEmployee(employeeId);
            int serviceId = this.serviceRepository.saveService(service);

            SparePart sparePart = new SparePart();
            sparePart.setSparePartName("Spare part name " + i);
            sparePart.setPrice((double) 50 + (i*5));
            sparePart.setQuantity(i);
            sparePart.setIdProducer(producerId);
            int sparePartId = this.sparePartRepository.saveSparePart(sparePart);

            Order order = new Order();
            order.setDateOfReceiving(Date.valueOf("2023-08-12"));
            order.setDateOfCompletion(Date.valueOf("2023-08-25"));
            order.setIdClient(clientId);
            order.setIdEmployee(employeeId);
            order.setPrice((double) (200 + (i*10)));
            order.setStatus("in progress");
            order.setIdCar(carId);
            order.setIdSparePart(sparePartId);
            order.setIdService(serviceId);
            int orderId = this.orderRepository.saveOrder(order);
        }*/


        String[] carBrands = new String[]{"BMW", "Audi", "Mercedes", "Nissan", "Honda", "Skoda", "Volvo", "Ford"};
        String[][] models = new String[][]{{"M3","M4","M5","X3","X5"},{"A4","A5","A6","Q5","RS6"},{"CLK","AMG","C-class","G-class","M-class"},{"Almera","Skyline","Maxima","Primera","Silvia"},{"Accord","Civic","Jazz","CR-X","Pilot"},{"Octavia","Superb","Rapid","Fabia","Yeti"},{"V70","V40","XC60","XC90","S60"},{"Mustang","Focus","Fusion","Mondeo","Escape"}};
        String[] types = new String[]{"Hatchback", "Crossover", "Sedan", "Coupe"};
        int[] releaseYears = new int[]{2000, 2001, 2002, 2003, 2004, 2005, 2006, 2007, 2008};
        Car[][] car = new Car[5][10];


        String[] fullName = new String[]{"Valeriy Semenov", "Sasha Antonova", "Vera Volkova", "Ivan Romanov", "Misha Mikhailov", "Andrey Borisov", "Egor Dyatlov", "Aleksey Durov"};
        String[] userName = new String[]{"V.Semenov","S.Antonova","V.Volkova","I.Romanov","M.Mikhailov","A.Borisov","E.Dyatlov","A.Durov"};
        String[] password = new String[]{"Sema6542", "Sasha.Ant1265", "Vera.052364", "RomanIva135", "Mikhail987", "BorisAndr465", "EgorDyat465", "AleksDur798"};
        String[] gender = new String[]{"Male", "Female", "Female", "Male", "Male", "Male", "Male", "Male"};
        String[] phone = new String[]{"4624621", "4569875", "7854632", "9653214", "4521365", "7854123", "9685471", "6543298"};
        Client client[] = new Client[8];




    }
}
