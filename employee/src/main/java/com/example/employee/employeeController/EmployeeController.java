package com.example.employee.employeeController;

import com.example.employee.employeeModel.Employee;
import com.example.employee.employeeService.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmployeeController {
    
    @Autowired
	EmployeeService es;

	@PostMapping("/saveData")
	public ResponseEntity<Employee> addEmployee(@RequestBody Employee e ) {

		return new ResponseEntity<>(es.saveData(e), HttpStatus.ACCEPTED);

	}

	@GetMapping("/{username}/{password}")
	public List<Employee> getEmployeeData(@PathVariable("username") String username, @PathVariable("password") String password) throws IllegalAccessException {

		return (es.getEmployeeDetails(username,password));

	}

	@PutMapping("/updateEmployeeDetails/{username}/{password}")
	public ResponseEntity<Employee> updateEmployee(@RequestBody Employee e,
												   @PathVariable ("username") String username,
												   @PathVariable ("password") String password) throws IllegalAccessException {

		return new ResponseEntity<>(es.updateEmployeeDetails(e, username, password), HttpStatus.OK);

	}


	@GetMapping("/getAllEmployeeDetails/{adminusername}/{adminpassword}")
	public ResponseEntity<List<Employee>> getAllEmployeeDetails(@PathVariable("adminusername") String adminusername, @PathVariable("adminpassword") String adminpassword) throws IllegalAccessException {
		return new ResponseEntity<List<Employee>>(es.allEmployeeDetails(adminusername,adminpassword), HttpStatus.OK);

	}


	@PutMapping("/updateIDandPassword/{employeeMobno}")
	public ResponseEntity<Employee> updateIDandPass(@RequestBody Employee e, @PathVariable ("employeeMobno") long employeeMobno){

		return new ResponseEntity<Employee>(es.upadteEmployeeUsernameAndPassword(e,employeeMobno), HttpStatus.OK);
	}

}
