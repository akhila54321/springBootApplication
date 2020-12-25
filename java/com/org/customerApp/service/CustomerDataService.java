package com.org.customerApp.service;

import com.org.customerApp.model.CustomerDetails;

import java.util.List;

public interface CustomerDataService {
    List<CustomerDetails>  addCustomer(CustomerDetails customerdetails);
    CustomerDetails updateCustomer(CustomerDetails customerdetails);
    CustomerDetails getCustomerById(String id);
    List<CustomerDetails>  getAllCustomers();
    CustomerDetails getCustomerByName(String name);
    CustomerDetails updateCustomerByName(String name,String id);
    void deleteCustomerById(String Id);

}
