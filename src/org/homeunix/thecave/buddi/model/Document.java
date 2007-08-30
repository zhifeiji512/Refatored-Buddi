/*
 * Created on Jul 30, 2007 by wyatt
 */
package org.homeunix.thecave.buddi.model;

import java.io.File;
import java.util.Date;
import java.util.List;

import org.homeunix.thecave.buddi.model.exception.ModelException;
import org.homeunix.thecave.moss.exception.DocumentSaveException;
import org.homeunix.thecave.moss.model.StandardDocument;

public interface Document extends ModelObject, StandardDocument {

	public void addAccount(Account account) throws ModelException;
	public void addAccountType(AccountType type) throws ModelException;
	public void addBudgetCategory(BudgetCategory budgetCategory) throws ModelException;
	public void addScheduledTransaction(ScheduledTransaction scheduledTransaction) throws ModelException;
	public void addTransaction(Transaction transaction) throws ModelException;
	public Account getAccount(String name);
	public List<Account> getAccounts();
	public AccountType getAccountType(String name);
	public List<AccountType> getAccountTypes();
	public List<BudgetCategory> getBudgetCategories();
	public BudgetCategory getBudgetCategory(String fullName);
	public ModelObject getObjectByUid(String uid);
	public List<ScheduledTransaction> getScheduledTransactions();
	public List<Source> getSources();
	public List<Transaction> getTransactions();
	public List<Transaction> getTransactions(Date startDate, Date endDate);
	public List<Transaction> getTransactions(Source source);
	public List<Transaction> getTransactions(Source source, Date startDate, Date endDate);
	public void refreshUidMap() throws ModelException;
	public boolean removeAccount(Account account) throws ModelException;
	public boolean removeAccountType(AccountType type) throws ModelException;
	public boolean removeBudgetCategory(BudgetCategory budgetCategory) throws ModelException;
	public boolean removeScheduledTransaction(ScheduledTransaction scheduledTransaction) throws ModelException;
	public boolean removeTransaction(Transaction transaction) throws ModelException;
	public void save() throws DocumentSaveException;
	public void saveAs(File file, int flags) throws DocumentSaveException;
	public String saveToString();
	public void updateAllBalances();

}