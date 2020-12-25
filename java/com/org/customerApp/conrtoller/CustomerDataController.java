package com.org.customerApp.conrtoller;

import com.org.customerApp.model.CustomerDetails;
import com.org.customerApp.service.CustomerDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CustomerDataController {
    @Autowired
    private CustomerDataService customerdataService;

    @RequestMapping(method = RequestMethod.GET , value = "getAllCustomerDetails")
    public List<CustomerDetails> getAllCustomers() {
        return customerdataService.getAllCustomers();
    }
    @RequestMapping(method = RequestMethod.GET , value = "/getAllCustomerDetailsById/{id}")
    public CustomerDetails getCustomerById(@PathVariable String id) {
        CustomerDetails getCustomerById = customerdataService.getCustomerById(id);
        return getCustomerById;
    }
    @RequestMapping(method = RequestMethod.POST , value = "/addCustomer")
    public List<CustomerDetails> addCustomer(@RequestBody CustomerDetails customerdetails) {
        return customerdataService.addCustomer(customerdetails);
    }
    @RequestMapping(method = RequestMethod.DELETE, value = "/deleteCustomerById/{id}")
    public void deleteCustomerById(@PathVariable String id) {
        customerdataService.deleteCustomerById(id);
    }
    @RequestMapping(method = RequestMethod.GET , value = "/getCustomerByName/{Name}")
    public CustomerDetails getCustomerByName(@PathVariable String Name) {
        return customerdataService.getCustomerByName(Name);
    }
    @RequestMapping(method = RequestMethod.GET , value = "/getCustomerByName/{newName},{id}")
    public CustomerDetails updateCustomerByName(@PathVariable String newName, String id) {
        return customerdataService.updateCustomerByName(newName,id);
    }
   

}
