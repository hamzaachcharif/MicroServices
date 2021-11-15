package com.costumer.customerservice;

import com.costumer.customerservice.entities.Customer;
import com.costumer.customerservice.repository.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

@SpringBootApplication
public class CustomerServiceApplication {

    public static void main(String[] args) {

        SpringApplication.run(CustomerServiceApplication.class, args);
    }
    @Bean
    CommandLineRunner start(CustomerRepository customerRepository ,RepositoryRestConfiguration repositoryRestConfiguration

                            ){
        repositoryRestConfiguration.exposeIdsFor(Customer.class);
        return args ->{
             customerRepository.save(new Customer(null,"zaid","zaid@gmail.com"));
             customerRepository.save(new Customer(null,"Hamza","hamza@gmail.com"));
             customerRepository.save(new Customer(null,"Khawla","khawla@gmail.com"));
             customerRepository.findAll().forEach(c->{
                     System.out.println(c.toString());

                     }
             );
        };
    }
}
