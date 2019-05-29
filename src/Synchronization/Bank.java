package Synchronization;

import java.util.Vector;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Bank {
	private final double[] accounts;
	private Object lock = new Object();
	
	public Bank(int n, double initialBalance) {
		accounts = new double[n];
		for (int i = 0; i < accounts.length; i++)
			accounts[i] = initialBalance;
	}
	/**
	* Transfers money from one account to another.
	* @param from the account to transfer from
	* @param to the account to transfer to
	* @param amount the amount to transfer
	 * @throws InterruptedException 
	*/
	public void transfer(Vector<Double> accounts, int from, int to, double amount) {
		synchronized (accounts) {
			accounts.set(from, accounts.get(from) - amount);
			accounts.set(to, accounts.get(to) +amount);
		}
			System.out.print(Thread.currentThread());
			System.out.printf(" %10.2f from %d to %d", amount, from, to);
			System.out.printf(" Total Balance: %10.2f%n", getTotalBalance());
	}
	/**
	* Gets the sum of all account balances.
	* @return the total balance
	*/
	public synchronized double getTotalBalance()
	{
			double sum = 0;
			for (double a : accounts)
			sum += a;
			return sum;
	}
	/**
	* Gets the number of accounts in the bank.
	* @return the number of accounts
	*/
	public int size() {
		return accounts.length;
	}

}
