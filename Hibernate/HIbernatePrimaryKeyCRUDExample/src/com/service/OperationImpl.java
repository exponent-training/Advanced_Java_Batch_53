package com.service;

import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.model.AccountData;
import com.util.HibernateUtil;

public class OperationImpl implements OperationI{

	
	SessionFactory sf = HibernateUtil.getSessionFactory();
	
	
	@Override
	public void createAccountInfo() {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		AccountData accountData = new AccountData();
		
		System.out.println("Please Enter Your Account id");
		String acNo = sc.next();
		accountData.setAcno(acNo);
		
		System.out.println("Please Enter Your Account Holder name");
		String acName = sc.next();
		accountData.setAcHolderName(acName);
		
		System.out.println("Please Enter Your Account Type");
		String acType = sc.next();
		accountData.setActype(acType);
		
		System.out.println("Please Enter Your Account Holder mob No");
		String acMobNo = sc.next();
		accountData.setAcholdermobno(acMobNo);
		
		System.out.println("Please Enter Your Account amount");
		double acAmount = sc.nextDouble();
		accountData.setAmount(acAmount);
		
		Session session = sf.openSession();
		session.save(accountData);
		
		session.beginTransaction().commit();
		System.out.println("Account Created Successfully.");
	}


	@Override
	public void getAccountDataUsingId() {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void updateAccountDataUsingId() {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void deleteAccountDatausingId() {
		// TODO Auto-generated method stub
		
	}

}
