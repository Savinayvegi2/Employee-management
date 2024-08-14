package com.employee.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "employeeDetails")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class EmployeeDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long empId;
    private String empName;
    private int empAge;
    private String empGender;
    private double empSalary;
    private String empAddress;
    private String empDepartment;
    private String empJobTitle;
    private long empPhoneNumber;
    private String empEmail;
}
