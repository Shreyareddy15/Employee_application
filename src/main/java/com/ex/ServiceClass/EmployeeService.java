package com.ex.ServiceClass;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ex.EmployeeTable.Employee;
import com.ex.RepositoryClass.EmployeeRepository;

@Service
public class EmployeeService {
	
	private EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }
    public List<Employee> getAllEmployees() {
    	System.out.println("Data from db"+employeeRepository.findAll());
        return employeeRepository.findAll();
    }

    public Employee getEmployeeById(Long id) {
        return employeeRepository.findById(id).orElse(null);
    }

    public Employee insertEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    public void deleteEmployee(Long id) {
        employeeRepository.deleteById(id);
    }
    public Employee updateEmployees(Long eid, Employee employeeUpdates) {
       Employee existingEmployee = employeeRepository.findById(eid).orElse(null);

        // Update fields based on employeeUpdates object
        if (employeeUpdates.getEname() != null) {
            existingEmployee.setEname(employeeUpdates.getEname());
        }
        if (employeeUpdates.getContactno() != 0) {
            existingEmployee.setContactno(employeeUpdates.getContactno());
        }
        if (employeeUpdates.getSalary() != null) {
            existingEmployee.setSalary(employeeUpdates.getSalary());
        }

        return employeeRepository.save(existingEmployee);
    }

    
}
