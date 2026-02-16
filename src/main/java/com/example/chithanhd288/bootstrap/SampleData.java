package com.example.chithanhd288.bootstrap;


import com.example.chithanhd288.dao.CustomerRepository;
import com.example.chithanhd288.dao.DivisionRepository;
import com.example.chithanhd288.entities.Customer;
import com.example.chithanhd288.entities.Division;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Optional;

@Configuration
public class SampleData {
    @Bean
    CommandLineRunner initCustomer(CustomerRepository customerRepository, DivisionRepository divisionRepository){
        return args -> {

            System.out.println("Loading Data");

            if (customerRepository.count() > 1) {
                System.out.println("Sample already loaded");
                return;
            }
            Optional<Division> divisionOpt = divisionRepository.findById(31L);

            if (divisionOpt.isEmpty()) {
                System.out.println("No division found");
                return;
            }

            Division division = divisionOpt.get();

            //Sample 1
            Customer c5 = new Customer();
            c5.setFirstName("Jack");
            c5.setLastName("Sam");
            c5.setAddress("555 5th St");
            c5.setPostal_code("55555");
            c5.setPhone("5555555555");
            c5.setDivision(division);

            //Sample 2
            Customer c6 = new Customer();
            c6.setFirstName("Sarah");
            c6.setLastName("Lee");
            c6.setAddress("666 6th St");
            c6.setPostal_code("66666");
            c6.setPhone("6666666666");
            c6.setDivision(division);

            //Sample 3
            Customer c7 = new Customer();
            c7.setFirstName("Michael");
            c7.setLastName("Johnson");
            c7.setAddress("777 7th St");
            c7.setPostal_code("77777");
            c7.setPhone("7777777777");
            c7.setDivision(division);

            //Sample 4
            Customer c8 = new Customer();
            c8.setFirstName("John");
            c8.setLastName("Smith");
            c8.setAddress("888 8th St");
            c8.setPostal_code("88888");
            c8.setPhone("8888888888");
            c8.setDivision(division);

            //Sample 5
            Customer c9 = new Customer();
            c9.setFirstName("Emily");
            c9.setLastName("Perez");
            c9.setAddress("999 9th St");
            c9.setPostal_code("99999");
            c9.setPhone("9999999999");
            c9.setDivision(division);

            customerRepository.save(c5);
            customerRepository.save(c6);
            customerRepository.save(c7);
            customerRepository.save(c8);
            customerRepository.save(c9);

            System.out.println("Customer saved");
        };
    }
}
