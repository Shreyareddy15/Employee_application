package com.ex.ControllerClass;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ex.EmployeeTable.Employee;
import com.ex.ServiceClass.EmployeeService;

@RestController
@CrossOrigin(origins = "http://localhost:4200") 
@RequestMapping("/employees")
public class EmployeeController
{
	private EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping
    public List<Employee> getAllEmployees() {
        return employeeService.getAllEmployees();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable Long id) {
        Employee employee = employeeService.getEmployeeById(id);
        if (employee != null) {
            return new ResponseEntity<Employee>(employee, HttpStatus.OK);
        } else {
            return new ResponseEntity<Employee>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<Employee> createEmployee(@RequestBody Employee employee) {
        Employee savedEmployee = employeeService.insertEmployee(employee);
        return new ResponseEntity<Employee>(savedEmployee, HttpStatus.CREATED);
    }

    @PutMapping("{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable Long id, @RequestBody Employee employee) {
        Employee existingEmployee = employeeService.getEmployeeById(id);
        if (existingEmployee != null) {
            employee.setEid(id);        
            Employee updatedEmployee = employeeService.insertEmployee(employee);
            return new ResponseEntity<Employee>(updatedEmployee, HttpStatus.OK);
        } else {
            return new ResponseEntity<Employee>(HttpStatus.NOT_FOUND);
        }
    }
    @PatchMapping("{eid}")
    public ResponseEntity<Employee> updateEmployees(@PathVariable Long eid, @RequestBody Employee employeeUpdates) {
        Employee updatedEmployee = employeeService.updateEmployees(eid, employeeUpdates);
        return ResponseEntity.ok(updatedEmployee);
    }


    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteEmployee(@PathVariable Long id) {
        Employee existingEmployee = employeeService.getEmployeeById(id);
        if (existingEmployee != null) {
            employeeService.deleteEmployee(id);
            return new ResponseEntity<Void>(HttpStatus.OK);
        } else {
            return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
        }
    }
    
   


}
