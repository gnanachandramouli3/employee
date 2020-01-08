package com.chandu.employee;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping(value="/employee")
@RestController
public class EmployeeController {
@Autowired
private EmployeeService employeeService;	
@PostMapping()
private Employee create(@RequestBody EmployeeDTO employeeDTO){
	return employeeService.create(employeeDTO);
}
@PutMapping()
private Employee update(@RequestBody EmployeeDTO employeeDTO){
	return employeeService.update(employeeDTO);
}
@DeleteMapping(value="/{id}")
private void delete(@PathVariable("id") int id){
	employeeService.delete(id);
}
@GetMapping()
public List<Employee> getAll(){
	return employeeService.findAll();
}
@GetMapping(value="/{id}")
public Employee getById(@PathVariable("id") int id){
	return employeeService.findById(id);
}

}
