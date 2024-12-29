package com.app.runner;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Component;

import com.app.model.Employee;
import com.app.repository.EmployeeRepository;

@Component
public class TestRunner implements ApplicationRunner{
	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Override
	public void run(ApplicationArguments args) throws Exception {
		System.out.println("From run method in TestRunner class.");
		
		System.out.println("---- To get record by getEmployeeByEmployeeId(Integer employeeId) method ----");
		Employee employee1 = employeeRepository.getEmployeeByEmployeeId(6);
		if(employee1 != null) {
			System.out.println(employee1.getEmployeeId()+" --> "+employee1.getEmployeeName()+"["+employee1.getEmployeeCode()+"]");
		}
		
		System.out.println("---- To get records by getEmployeesByDesignation(String desination) method ----");
		List<Employee> employeeList1 = employeeRepository.getEmployeesByDesignation("Software Engineer");
		employeeList1.forEach(e -> {
			System.out.println(e.getEmployeeId()+" --> "+e.getEmployeeName()+"["+e.getEmployeeCode()+"] --> "+e.getDesignation());
		});
		
		System.out.println("---- To get records by getAllEmployees() method ----");
		List<String> employeeNameList1 = employeeRepository.getAllEmployees();
		employeeNameList1.forEach(e -> {
			System.out.println(e);
		});
		
		System.out.println("---- To get records by getEmployeeByIds(List<Integer> employeeIdList) method ----");
		List<Integer> employeeIdList = Arrays.asList(2, 4, 6);
		List<Employee> employeeList2 = employeeRepository.getEmployeeByIds(employeeIdList);
		employeeList2.forEach(e -> {
			System.out.println(e.getEmployeeId()+" --> "+e.getEmployeeName()+"["+e.getEmployeeCode()+"] --> "+e.getDesignation());
		});
		
		System.out.println("---- To get records by getEmployeeByEmployeeCode(@Param(\"employeeCode\") List<String> employeeCodeList) method ----");
		List<String> employeeCodeList = Arrays.asList("A001", "A005", "A006");
		List<Employee> employeeList3 = employeeRepository.getEmployeeByEmployeeCode(employeeCodeList);
		employeeList3.forEach(e -> {
			System.out.println(e.getEmployeeId()+" --> "+e.getEmployeeName()+"["+e.getEmployeeCode()+"] --> "+e.getDesignation());
		});
		
	}

}
