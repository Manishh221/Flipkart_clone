package FlipKart.clone.Flipkart.controller;

import FlipKart.clone.Flipkart.entity.Customer;
import FlipKart.clone.Flipkart.service.CustomerService;
import FlipKart.clone.Flipkart.service.CustomerServiceImpl;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@Controller
@Slf4j
public class CustomerController {

    @Autowired
    private CustomerServiceImpl customerService;

    @ResponseBody
    @DeleteMapping("/deleteCustomer/{customerId}")
    public ResponseEntity<Map<String, Object>> deleteByCustomerId(@PathVariable String customerId) {
        log.info("checking is customer exist with the customer ID {}", customerId);

        if (!customerService.isCustomerExists(customerId)) {
            log.info("customer does not exist with the ID {}", customerId);
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(Map.of("error", "Customer does not exist"));
        }

        customerService.deleteCustomerById(customerId);

        Map<String, Object> response = new HashMap<>();
        response.put("message", " Customer deleted successfully!");
        response.put("id", customerId);

        return new ResponseEntity<>(response, HttpStatus.GONE);
    }

    @ResponseBody
    @PostMapping("/saveCustomer")
    public ResponseEntity<Map<String, Object>> saveCustomerInfo(@Valid @RequestBody Customer customer) {
        log.info("Controller: class, method name saveCustomer: customer is being transfer to service class");
        Customer saveCustomer = customerService.saveCustomer(customer);

        Map<String, Object> response = new HashMap<>();
        response.put("message", " Customer saved successfully!");
        response.put("data", saveCustomer);

        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @ResponseBody
    @GetMapping("/getCustomerById/{customerId}")
    public ResponseEntity<Customer> findCustomerById(@PathVariable String customerId){
        log.info("Controller: finding customer by id: {}", customerId);
        Customer customer = customerService.findCustomerById(customerId);
        return new ResponseEntity<>(customer, HttpStatus.FOUND);
    }
}
