package com.swabhavtechlabs.accountNew;

public class Test {

	public static void main(String[] args) {
		CurrentAccount currentAccount = new CurrentAccount(101, 10000, "Manoj");
		Saving savingAccount = new Saving(102, 10000, "Umesh");
		
//		if(currentAccount.withDraw(11000)) {
//			System.out.println("Current account: Withdrawn amount successfully and\nnew balance is "+currentAccount.getBalance()+"\tOverdraft limit is "+currentAccount.getOVERDRAFT_LIMIT());
//		} else {
//			if(currentAccount.getOVERDRAFT_LIMIT() > 0) {
//				System.out.println("Current account: Sorry! insufficient balance,\nYou can only withdraw "+currentAccount.getOVERDRAFT_LIMIT()+".");
//			}else
//				System.out.println("Current account: Sorry! insufficient balance,\n Balance is "+currentAccount.getBalance()+"\t Overdraft limit is "+currentAccount.getOVERDRAFT_LIMIT());
//		}

		if(savingAccount.withDraw(5000)) {
			System.out.println("Saving account: Withdrawn amount successfully and new balance is "+savingAccount.getBalance());
		} else {
			System.out.println("Saving account: Sorry! insufficient balance,\nBalance is "+savingAccount.getBalance()+"\nYou can withdraw only "+(savingAccount.getBalance()-Saving.getLIMIT()));
		}
	}

}
