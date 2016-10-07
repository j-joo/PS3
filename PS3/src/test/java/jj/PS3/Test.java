package jj.PS3;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;

public class Test {
	
	private static int id;
	private static double balance;
	private static double annualInterestRate;
	private static double withdrawAmount;
	private static double depositAmount;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		id = 1122;
		balance = 20000;
		annualInterestRate = 4.5;
		withdrawAmount = 2500;
		depositAmount = 3000;
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}
	
	@org.junit.Test
	public void test_ArgConstructor() throws InsufficientFundsException{
		
		try {
		Account newAccount = new Account(id, balance);
		Account noArgsAccount = new Account();
		
		newAccount.setAnnualInterestRate(annualInterestRate);
		
		assertEquals(newAccount.getId(), id);
		assertEquals(newAccount.getBalance(), balance, 0);
		assertEquals(newAccount.getAnnualInterestRate(), annualInterestRate, 0);
		assertEquals(newAccount.getMonthlyInterestRate(), annualInterestRate / 12, 0);
			
		noArgsAccount.setId(id);
		noArgsAccount.setBalance(balance);
		
		//Testing: 20000 - 2500 = 17500
		newAccount.withdraw(withdrawAmount);
		assertEquals(newAccount.getBalance(), 17500, 0);
		
		//Testing: 17500 + 3000 = 20500
		newAccount.deposit(depositAmount);
		assertEquals(newAccount.getBalance(), 20500, 0);
		
		System.out.println("The date is: " + newAccount.getDateCreated());	
		
		newAccount.withdraw(25000);
		
		} catch(InsufficientFundsException e) {
			System.out.println("You need $" + e.getAmount() + 
					" more to be able to draw that amount.");
		}
	}
}