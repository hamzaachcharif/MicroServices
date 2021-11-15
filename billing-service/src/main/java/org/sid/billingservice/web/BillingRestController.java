package org.sid.billingservice.web;

import org.sid.billingservice.entities.Bill;
import org.sid.billingservice.feign.CustomerServiceClient;
import org.sid.billingservice.feign.ProductServiceClient;
import org.sid.billingservice.models.Customer;
import org.sid.billingservice.models.Product;
import org.sid.billingservice.repositories.BillingRepository;
import org.sid.billingservice.repositories.ProductItemRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BillingRestController {
    private BillingRepository billingRepository;
    private ProductItemRepository productItemRepository;
    private CustomerServiceClient customerServiceClient;
    private ProductServiceClient productServiceClient;

    public BillingRestController(BillingRepository billingRepository, ProductItemRepository productItemRepository, CustomerServiceClient customerServiceClient, ProductServiceClient productServiceClient) {
        this.billingRepository = billingRepository;
        this.productItemRepository = productItemRepository;
        this.customerServiceClient = customerServiceClient;
        this.productServiceClient = productServiceClient;
    }
    @GetMapping(path="/fullBill/{id}")
    public Bill getBill(@PathVariable(name = "id") Long id){
        Bill bill=billingRepository.findById(id).get();
        Customer customer=customerServiceClient.findCustomerById(bill.getCustomerId());
        bill.setCustomer(customer);
        bill.getProductItems().forEach(pi->{
            Product product=productServiceClient.getProductById(pi.getProductId());
            pi.setProduct(product);
        });
        return bill;

    }
}
