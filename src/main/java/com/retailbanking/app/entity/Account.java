package com.retailbanking.app.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "Bank_Account")
@Data
public class Account implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "Account_Number", nullable = false)
    private Long acNumber;
    @Column(name = "Account_Type", nullable = false)
    private String acType;
    @Column(name = "Account_Holder_Name", nullable = false)
    private String acHolderName;
    @Column(name = "Account_Balance")
    private double acBalance;
    @Column(name = "Account_Opening_Balance")
    private double acOpeningBalance;
    @Column(name = "Account_Opening_Date")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    private Date acOpeningDate;
    @Column(name = "Ac_Cutomer_Id")
    private int acCustomerId;
    @Column(name = "Ac_Interest")
    private double acInterest;


}
