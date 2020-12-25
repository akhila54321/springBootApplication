package com.org.customerApp.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name = "customerDetails")
public class CustomerDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column( name = "customerId")
    private int customerId;
    @Column( name = "firstName")
    private String firstName;
    @Column( name = "lastName")
    private String lastName;

}
