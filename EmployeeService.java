package com.chandu.employee;

import java.util.List;

public interface EmployeeService {
public Employee create(EmployeeDTO employee);
public Employee update(EmployeeDTO employee);
public void delete(int id);
public List<Employee> findAll();
public Employee findById(int id);

}
