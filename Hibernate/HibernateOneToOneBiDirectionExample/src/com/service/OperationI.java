package com.service;

public interface OperationI {
	
	
	void savePersonDataWithPassport();
	
	void savePassportwithPersonData();
	
	void getPassportDataByPersonId();
	
	void getPersonDataByPassportId();
	
	void getPersonAllDataWithPassportData();

	void getPassportAllDataWithPersonData();
}
