package net.javaguides.springboot.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.javaguides.springboot.model.Employee;
import net.javaguides.springboot.service.EmployeeService;

/*we can use @Controller also but we have to use @ResponseBody on top of each restapi
that define in the controller instead of that provide @RestController*/


@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

	
	private EmployeeService employeeService;

	public EmployeeController(EmployeeService employeeService) {
		super();
		this.employeeService = employeeService;
	}
	
	// build create employee REST API
	//we can provide complete response details in ResponseEntity
	
	@PostMapping("/addemployee")
	public ResponseEntity<Employee> saveEmployee(@RequestBody Employee employee){
		return new ResponseEntity<Employee>(employeeService.saveEmployee(employee),HttpStatus.CREATED);
	}
	
	//Build get all employees REST API
	@GetMapping("/getallemployees")
	public List<Employee> getAllEmployees(){
		return employeeService.getAllEmployees();
	}
	
	//Build get  employees by id REST API
	//https:localhost:8080/api/employees/getemployeebyid/1
	@GetMapping("/getemployeebyid/{id}")
	public Employee getEmployeeById(@PathVariable("id") long employeId) {
		return employeeService.getEmployeeById(employeId);
	}
	
	//Build update employee REST API
	//https:localhost:8080/api/employees/updateemployeebyid/1
	@PutMapping("/updateemployeebyid/{id}")
	public Employee updateEmployee(@PathVariable("id") long id,@RequestBody Employee employee) {
		return employeeService.updateEmployee(employee, id);
		
	}
	
	//Build delete employee REST API
	//https:localhost:8080/api/employees/updateemployeebyid/1
	@DeleteMapping("/deleteemployeebyid/{id}")
	public ResponseEntity<String> deleteEmployee(@PathVariable("id") long id) {
		
		//delete employee from DB
		employeeService.deleteEmployeeById(id);
		 
		 return new ResponseEntity<String>("Employee deleted successfully!. ", HttpStatus.OK);
	
}
}