package com.service;

public interface OperationI {

	void insertEmployeeWithCompanyData();
	
	void insertCompanyDataWithEmployeeData();
	
	void getEmployeeDatawithCompanyDataUsingEmployeeId();
	
	void getCompanyDataWithEmployeeDataUsingCompanyId();
	
	void ExistingEmployeeAddingCompanyDetails();
	
	void getAllEmployeeData();
	
	void getAllCompanyDaetals();
	
	void updateCompanyDataWithEmployeeDataUsingCompanyId();
	
	void updateEmployeeDataWithCompanyDataUsingEmployeeId();
}
