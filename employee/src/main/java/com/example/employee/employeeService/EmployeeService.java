package com.example.employee.employeeService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.employee.employeeModel.Employee;
import com.example.employee.employeeRepository.EmployeeRepository;

@Service
public class EmployeeService {

    @Autowired
	EmployeeRepository er;


	public Employee saveData(Employee e) {

		// Check if the employee id is valid
		if (e.getEmployeeId() < 0 || e.getEmployeeId() == 0) {
			throw new IllegalArgumentException("Invalid employee id");
		}

		// Check if the employee name is valid
		if (e.getEmployeeName() == null || e.getEmployeeName().isEmpty()) {
			throw new IllegalArgumentException("Invalid employee name");
		}

		// Check if the employee designation is valid
		if (e.getEmployeeDesignation() == null || e.getEmployeeDesignation().isEmpty()) {
			throw new IllegalArgumentException("Invalid employee designation");
		}

		// Check if the employee mobile number is valid
		if (e.getEmployeeMobno() < 0 || e.getEmployeeMobno()==0) {
			throw new IllegalArgumentException("Invalid employee mobile number");
		}

		// Check if the employee grade is valid
		if (e.getEmployeeGrade() == null || e.getEmployeeGrade().isEmpty()) {
			throw new IllegalArgumentException("Invalid employee grade");
		}

		// Check if the employee email address is valid
		if (e.getEmployeeEmailId() == null || e.getEmployeeEmailId().isEmpty()) {
			throw new IllegalArgumentException("Invalid employee email address");
		}

		// Check if the employee username is valid
		if (e.getUsername() == null || e.getUsername().isEmpty()) {
			throw new IllegalArgumentException("Invalid employee username");
		}

		// Check if the employee password is valid
		if (e.getPassword() == null || e.getPassword().isEmpty()) {
			throw new IllegalArgumentException("Invalid employee password");
		}

		// Save the employee object to the database
		return er.save(e);
	}

	public List<Employee> getEmployeeDetails(String username, String password) throws IllegalAccessException {

		if (username.equals(username) && password.equals(password)) {
			return er.findByUsernameAndPassword(username,password); // The username and password are correct.
		} else {
			throw new IllegalAccessException("Invalid employee username and password"); // The username and/or password are incorrect.
		}

	}


	public Employee updateEmployeeDetails(Employee e, String username, String password) throws IllegalAccessException {

		if (username.equals(username) && password.equals(password)) {

			// Check if the employee name is valid
			if (e.getEmployeeName() == null || e.getEmployeeName().isEmpty()) {
				throw new IllegalArgumentException("Invalid employee name");
			}

			// Check if the employee designation is valid
			if (e.getEmployeeDesignation() == null || e.getEmployeeDesignation().isEmpty()) {
				throw new IllegalArgumentException("Invalid employee designation");
			}

			// Check if the employee mobile number is valid
			if (e.getEmployeeMobno() < 0 || e.getEmployeeMobno()==0) {
				throw new IllegalArgumentException("Invalid employee mobile number");
			}

			// Check if the employee grade is valid
			if (e.getEmployeeGrade() == null || e.getEmployeeGrade().isEmpty()) {
				throw new IllegalArgumentException("Invalid employee grade");
			}

			// Check if the employee email address is valid
			if (e.getEmployeeEmailId() == null || e.getEmployeeEmailId().isEmpty()) {
				throw new IllegalArgumentException("Invalid employee email address");
			} else {
				e.setUsername(username);
				e.setPassword(password);
			}

			// Save the updated employee to the database
			Employee updatedEmployee = er.save(e);

			// Return the updated employee
			return updatedEmployee;

		} else {
			throw new IllegalAccessException("Invalid employee username and password"); // The username and/or password are incorrect.
		}


	}


	String adminusername="admin";
	String adminpassword="password123";

	public List<Employee> allEmployeeDetails(String adminusername, String adminpassword) throws IllegalAccessException {

		 this.adminusername = adminusername;
		 this.adminpassword = adminpassword;

		if (adminusername.equals("admin") && adminpassword.equals("password123") ){
			return (List<Employee>) er.findAll();
		}else{
			throw new IllegalAccessException("Invalid admin username and password");
		}


	}


	public Employee upadteEmployeeUsernameAndPassword(Employee e,long employeeMobno) {


		if (e.getEmployeeEmailId() == null || e.getEmployeeEmailId().isEmpty()) {
			throw new IllegalArgumentException("Invalid employee email address");
		} else {
			e.setEmployeeMobno(employeeMobno);
		}

		if (e.getUsername() == null || e.getUsername().isEmpty()) {
			throw new IllegalArgumentException("Invalid employee email address");
		} else {
			e.setEmployeeMobno(employeeMobno);
		}

		if (e.getPassword() == null || e.getPassword().isEmpty()) {
			throw new IllegalArgumentException("Invalid employee email address");
		} else {
			e.setEmployeeMobno(employeeMobno);
		}

		return er.save(e);
	}
}
