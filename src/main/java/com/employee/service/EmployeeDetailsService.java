package com.employee.service;

import com.employee.entity.EmployeeDetails;
import com.employee.repository.EmployeeDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeDetailsService {

    @Autowired
    private EmployeeDetailsRepository employeeDetailsRepository;

    public List<EmployeeDetails> listEmployeeDetails(EmployeeDetails employeeDetails) {
            return employeeDetailsRepository.findAll();
    }

    public EmployeeDetails saveEmployeeDetails(EmployeeDetails employeeDetails) {
        return employeeDetailsRepository.save(employeeDetails);
    }

    public EmployeeDetails findByEmployeeId(long empId) {
        if (employeeDetailsRepository.existsById(empId)) {
            return employeeDetailsRepository.findById(empId).get();
        } else {
            throw new RuntimeException("Employee Not Found");
        }
    }

    public Optional<EmployeeDetails> saveByEmployeeId(EmployeeDetails employeeDetails) {
        if(employeeDetailsRepository.existsById(employeeDetails.getEmpId())) {
            return employeeDetailsRepository.findById(employeeDetails.getEmpId());
        } else if(!employeeDetailsRepository.existsById(employeeDetails.getEmpId())){
            return employeeDetailsRepository.existsById(employeeDetails.getEmpId()) ? employeeDetailsRepository.findById(employeeDetails.getEmpId()) : null;
        } else {
            throw new RuntimeException("Employee Already Exists");
        }
    }

    public void deleteByEmployeeId(long empId) {
        Optional<EmployeeDetails> employeeDetailsOptional = employeeDetailsRepository.findById(empId);
        if(employeeDetailsOptional.isPresent()) {
            employeeDetailsRepository.deleteById(empId);
        } else if(!employeeDetailsRepository.existsById(empId)) {
            throw new RuntimeException("Employee Not Found");
        }
    }
}
