package com.test.test;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import com.ex.ServiceClass.EmployeeService;
import com.ex.EmployeeTable.Employee;
import com.ex.RepositoryClass.EmployeeRepository;


public class SpringTestApplication {

	 private EmployeeService employeeService;

	    @Mock
	    private EmployeeRepository employeeRepository;

	    @BeforeEach
	    public void setUp() {
	        MockitoAnnotations.initMocks(this); // Initialize mocks
	        employeeService = new EmployeeService(employeeRepository);
	    }

	    @Test
	    public void testGetAllEmployees() {
	        // Arrange: Mock the behavior of the repository
	        List<Employee> mockEmployees = new ArrayList<Employee>();
	        mockEmployees.add(new Employee(300, "danny", 1236456, "903647"));
	        when(employeeRepository.findAll()).thenReturn(mockEmployees);

	        // Act: Call the service method
	        List<Employee> employees = employeeService.getAllEmployees();
	        System.out.println(employees);

	        // Assert: Verify the result
	        Assertions.assertEquals(1, employees.size());
	        Employee employee = employees.get(0);
	        Assertions.assertEquals(300, employee.getEid());
	        Assertions.assertEquals("danny", employee.getEname());
	        Assertions.assertEquals(1236456, employee.getContactno());
	        Assertions.assertEquals("903647", employee.getSalary());
	    }
}
