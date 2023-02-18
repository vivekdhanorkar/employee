package com.example.employee.employeeRepository;



import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.employee.employeeModel.Employee;

import java.util.List;

@Repository
public interface EmployeeRepository extends CrudRepository<Employee,Long> {

    List<Employee> findByUsernameAndPassword(String username, String password);

}
