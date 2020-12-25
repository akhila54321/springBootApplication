package com.org.customerApp.repository;

import com.org.customerApp.model.CustomerDetails;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerDataRepository extends JpaRepository<CustomerDetails, Long> {
}
