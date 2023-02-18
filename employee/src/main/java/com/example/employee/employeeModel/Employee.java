package com.example.employee.employeeModel;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.http.HttpStatus;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Entity
public class Employee {

    @Id
    @Column(nullable = false, unique = true)
    private long employeeId;

    @Column(nullable = false)
    private String employeeName;

    private double employeeSalary;

    private String employeeDesignation;

    @Column(nullable = false, unique = true, length = 20)
    private long employeeMobno;

    private String employeeGrade;

    @Column(nullable = false, unique = true, length = 45)
    private String employeeEmailId;

    @Column(nullable = false, unique = true, length = 45)
    private String username;

    @Column(nullable = false, unique = true, length = 45)
    private String password;



}



