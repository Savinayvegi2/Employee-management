package com.employee.controller;

import com.employee.entity.EmployeeDetails;
import com.employee.service.EmployeeDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/employee")
public class EmployeeDetailsController {

    @Autowired
    private EmployeeDetailsService employeeDetailsService;

    @GetMapping
    public List<EmployeeDetails> listEmployeeDetails(@RequestBody EmployeeDetails employeeDetails) {
        return employeeDetailsService.listEmployeeDetails(employeeDetails);
    }
    @PostMapping
    public EmployeeDetails saveEmployeeDetails(@RequestBody EmployeeDetails employeeDetails) {
        return employeeDetailsService.saveEmployeeDetails(employeeDetails);
    }
    @GetMapping("/{id}")
    public EmployeeDetails findEmployeeDetails(@PathVariable long empId) {
        return employeeDetailsService.findByEmployeeId(empId);
    }
    @PutMapping("/{id}")
    public Optional<EmployeeDetails> updateEmployeeDetails(@PathVariable long empId, @RequestBody EmployeeDetails employeeDetails) {
        return employeeDetailsService.saveByEmployeeId(employeeDetails);
    }
    @DeleteMapping("/{id}")
    public void deleteEmployeeDetails(@PathVariable long empId) {
        employeeDetailsService.deleteByEmployeeId(empId);
    }
}
