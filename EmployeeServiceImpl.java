package com.chandu.employee;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class EmployeeServiceImpl implements EmployeeService {
@Autowired
private EmployeeRepository employeeRepo;
	@Override
	public Employee create(EmployeeDTO employee) {
		Employee e = new Employee();
		e.setFirstname(employee.getFirstname());
		e.setLastname(employee.getLastname());
		e.setAge(employee.getAge());
		e.setSalary(employee.getSalary());
		e.setCompanyName(employee.getCompanyName());
		e.setUsername(employee.getFirstname()+employee.getLastname()+employee.getAge()+employee.getCompanyName());
		employeeRepo.save(e);
		return e;
	}

	@Override
	public Employee update(EmployeeDTO employee) {
		Employee emp =employeeRepo.findById(employee.getId()).get();
		if(employee!=null && emp!=null){
			if(employee.getFirstname()!=null){
				emp.setFirstname(employee.getFirstname());
			}
			if(employee.getLastname()!=null){
				emp.setLastname(employee.getLastname());
			}
			if(employee.getAge()!=0){
				emp.setAge(employee.getAge());
			}
			if(employee.getCompanyName()!=null){
				emp.setCompanyName(employee.getCompanyName());
			}
			if(employee.getSalary()!=0){
				emp.setSalary(employee.getSalary());
			}
			employeeRepo.save(emp);
		}
		return emp;
	}

	@Override
	public List<Employee> findAll() {
		return employeeRepo.findAll();
	}

	@Override
	public Employee findById(int id) {
		return employeeRepo.findById(id).get();
	}

	@Override
	public void delete(int id) {
		employeeRepo.deleteById(id);
	}

}
