package com.org.customerApp.service;

import com.org.customerApp.model.CustomerDetails;
import com.org.customerApp.repository.CustomerDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

@Service
@Transactional
public class CustomerDataServiceImpl implements CustomerDataService {
    @Autowired
    private CustomerDataRepository customerDataRepository;

    @Override
    public List<CustomerDetails> getAllCustomers() {
        List<CustomerDetails> fullCustomerData = customerDataRepository.findAll();
        return fullCustomerData;
    }

    @Override
    public List<CustomerDetails> addCustomer(CustomerDetails customerdetails) {
        customerDataRepository.save(customerdetails);
        List<CustomerDetails> fullCustomerData = customerDataRepository.findAll();
        return fullCustomerData;
    }

    @Override
    public CustomerDetails updateCustomer(CustomerDetails customerdetails) {
        return null;
    }

    @Override
    public CustomerDetails getCustomerById(String customerId) {
        CustomerDetails reqCustomer = null;
        List<CustomerDetails> fullCustomerData = customerDataRepository.findAll();
        for(CustomerDetails customerData : fullCustomerData)
        {
           if(Integer.valueOf(customerId).equals((customerData.getCustomerId())))
            {
                reqCustomer = customerData;
            }
        }
        return reqCustomer;
    }
    @Override
    public CustomerDetails getCustomerByName(String name) {
        CustomerDetails reqCustomer = null;
        List<CustomerDetails> fullCustomerData = customerDataRepository.findAll();
        for(CustomerDetails customerData : fullCustomerData)
        {
            if(name.equalsIgnoreCase(customerData.getFirstName()))
            {
                reqCustomer = customerData;
            }
        }
        return reqCustomer;
    }

    @Override
    public CustomerDetails updateCustomerByName(String newName, String id) {
        List<CustomerDetails> fullCustomerData = customerDataRepository.findAll();
        CustomerDetails customerData = null;
        fullCustomerData.stream().filter(customer -> Integer.valueOf(id).equals(customer.getCustomerId()))
                          .forEach(customer ->
        {
            if(Integer.valueOf(id).equals((customerData.getCustomerId())))
            {
                customerData.setFirstName(newName);

            }
        });
        return customerData;
    }

    @Override
    public void deleteCustomerById(String Id) {
        List<CustomerDetails> fullCustomerData = customerDataRepository.findAll();
        for(CustomerDetails customerData : fullCustomerData)
        {
            if(Integer.valueOf(Id).equals((customerData.getCustomerId())))
            {
                Long idValue = customerData.getId();
                customerDataRepository.deleteById(idValue);
            }
        }

    }
}
