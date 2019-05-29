package Synchronization;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Bank {
	private final double[] accounts;
	private Lock bankLock = new ReentrantLock();
	private Condition sufficientFunds;
	public Bank(int n, double initialBalance) {
		accounts = new double[n];
		for (int i = 0; i < accounts.length; i++)
			accounts[i] = initialBalance;
		bankLock = new ReentrantLock();
		sufficientFunds = bankLock.newCondition();
	}
	/**
	* Transfers money from one account to another.
	* @param from the account to transfer from
	* @param to the account to transfer to
	* @param amount the amount to transfer
	 * @throws InterruptedException 
	*/
	public synchronized void transfer(int from, int to, double amount) throws InterruptedException {
			while (accounts[from] < amount)
			wait();
			System.out.print(Thread.currentThread());
			accounts[from] -= amount;
			System.out.printf(" %10.2f from %d to %d", amount, from, to);
			accounts[to] += amount;
			System.out.printf(" Total Balance: %10.2f%n", getTotalBalance());
			notifyAll();
	}
	/**
	* Gets the sum of all account balances.
	* @return the total balance
	*/
	public synchronized double getTotalBalance()
	{
		bankLock.lock();
		try {
			double sum = 0;
			for (double a : accounts)
			sum += a;
			return sum;
		}
		finally {
			bankLock.unlock();
		}
		
	}
	/**
	* Gets the number of accounts in the bank.
	* @return the number of accounts
	*/
	public int size() {
		return accounts.length;
	}

}
