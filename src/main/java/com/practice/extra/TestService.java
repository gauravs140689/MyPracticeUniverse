package com.practice.extra;
import java.util.Arrays;
import java.util.List;

public class TestService {
	
	public List<Employee> getEmployeeList(String status, List<String> employeeIds){
	
		Employee e1 = new Employee(1, "Ram1", 24, "TCS", "Active");
		Employee e2 = new Employee(2, "Ram2", 24, "Adobe", "Active");
		Employee e3 = new Employee(3, "Ram3", 24, "Wipro", "InActive");
		Employee e4 = new Employee(4, "Ram4", 24, "IBM","None");
		
		if(status.equals("Active")){
			return Arrays.asList(e1, e2);
		}else if(status.equals("InActive")){
			return Arrays.asList(e3);
		}else{
			return Arrays.asList(e4);
		}
	}

}
