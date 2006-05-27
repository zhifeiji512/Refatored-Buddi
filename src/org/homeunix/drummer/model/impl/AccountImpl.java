/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.homeunix.drummer.model.impl;

import java.util.Date;

import java.util.Vector;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.homeunix.drummer.Strings;
import org.homeunix.drummer.controller.DataInstance;
import org.homeunix.drummer.model.Account;
import org.homeunix.drummer.model.ModelPackage;
import org.homeunix.drummer.model.Source;
import org.homeunix.drummer.model.Transaction;
import org.homeunix.drummer.model.Type;
import org.homeunix.drummer.util.Formatter;
import org.homeunix.drummer.util.Log;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Account</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.homeunix.drummer.model.impl.AccountImpl#getBalance <em>Balance</em>}</li>
 *   <li>{@link org.homeunix.drummer.model.impl.AccountImpl#getStartingBalance <em>Starting Balance</em>}</li>
 *   <li>{@link org.homeunix.drummer.model.impl.AccountImpl#getAccountType <em>Account Type</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class AccountImpl extends SourceImpl implements Account {
	/**
	 * The default value of the '{@link #getBalance() <em>Balance</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBalance()
	 * @generated
	 * @ordered
	 */
	protected static final long BALANCE_EDEFAULT = 0L;

	/**
	 * The cached value of the '{@link #getBalance() <em>Balance</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBalance()
	 * @generated
	 * @ordered
	 */
	protected long balance = BALANCE_EDEFAULT;

	/**
	 * The default value of the '{@link #getStartingBalance() <em>Starting Balance</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStartingBalance()
	 * @generated
	 * @ordered
	 */
	protected static final long STARTING_BALANCE_EDEFAULT = 0L;

	/**
	 * The cached value of the '{@link #getStartingBalance() <em>Starting Balance</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStartingBalance()
	 * @generated
	 * @ordered
	 */
	protected long startingBalance = STARTING_BALANCE_EDEFAULT;

	/**
	 * The cached value of the '{@link #getAccountType() <em>Account Type</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAccountType()
	 * @generated
	 * @ordered
	 */
	protected Type accountType = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected AccountImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return ModelPackage.eINSTANCE.getAccount();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public long getBalance() {
		return balance;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBalance(long newBalance) {
		long oldBalance = balance;
		balance = newBalance;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.ACCOUNT__BALANCE, oldBalance, balance));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public long getStartingBalance() {
		return startingBalance;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setStartingBalance(long newStartingBalance) {
		long oldStartingBalance = startingBalance;
		startingBalance = newStartingBalance;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.ACCOUNT__STARTING_BALANCE, oldStartingBalance, startingBalance));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Type getAccountType() {
		if (accountType != null && accountType.eIsProxy()) {
			Type oldAccountType = accountType;
			accountType = (Type)eResolveProxy((InternalEObject)accountType);
			if (accountType != oldAccountType) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ModelPackage.ACCOUNT__ACCOUNT_TYPE, oldAccountType, accountType));
			}
		}
		return accountType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Type basicGetAccountType() {
		return accountType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAccountType(Type newAccountType) {
		Type oldAccountType = accountType;
		accountType = newAccountType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.ACCOUNT__ACCOUNT_TYPE, oldAccountType, accountType));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object eGet(EStructuralFeature eFeature, boolean resolve) {
		switch (eDerivedStructuralFeatureID(eFeature)) {
			case ModelPackage.ACCOUNT__NAME:
				return getName();
			case ModelPackage.ACCOUNT__DELETED:
				return isDeleted() ? Boolean.TRUE : Boolean.FALSE;
			case ModelPackage.ACCOUNT__CREATION_DATE:
				return getCreationDate();
			case ModelPackage.ACCOUNT__BALANCE:
				return new Long(getBalance());
			case ModelPackage.ACCOUNT__STARTING_BALANCE:
				return new Long(getStartingBalance());
			case ModelPackage.ACCOUNT__ACCOUNT_TYPE:
				if (resolve) return getAccountType();
				return basicGetAccountType();
		}
		return eDynamicGet(eFeature, resolve);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void eSet(EStructuralFeature eFeature, Object newValue) {
		switch (eDerivedStructuralFeatureID(eFeature)) {
			case ModelPackage.ACCOUNT__NAME:
				setName((String)newValue);
				return;
			case ModelPackage.ACCOUNT__DELETED:
				setDeleted(((Boolean)newValue).booleanValue());
				return;
			case ModelPackage.ACCOUNT__CREATION_DATE:
				setCreationDate((Date)newValue);
				return;
			case ModelPackage.ACCOUNT__BALANCE:
				setBalance(((Long)newValue).longValue());
				return;
			case ModelPackage.ACCOUNT__STARTING_BALANCE:
				setStartingBalance(((Long)newValue).longValue());
				return;
			case ModelPackage.ACCOUNT__ACCOUNT_TYPE:
				setAccountType((Type)newValue);
				return;
		}
		eDynamicSet(eFeature, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void eUnset(EStructuralFeature eFeature) {
		switch (eDerivedStructuralFeatureID(eFeature)) {
			case ModelPackage.ACCOUNT__NAME:
				setName(NAME_EDEFAULT);
				return;
			case ModelPackage.ACCOUNT__DELETED:
				setDeleted(DELETED_EDEFAULT);
				return;
			case ModelPackage.ACCOUNT__CREATION_DATE:
				setCreationDate(CREATION_DATE_EDEFAULT);
				return;
			case ModelPackage.ACCOUNT__BALANCE:
				setBalance(BALANCE_EDEFAULT);
				return;
			case ModelPackage.ACCOUNT__STARTING_BALANCE:
				setStartingBalance(STARTING_BALANCE_EDEFAULT);
				return;
			case ModelPackage.ACCOUNT__ACCOUNT_TYPE:
				setAccountType((Type)null);
				return;
		}
		eDynamicUnset(eFeature);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean eIsSet(EStructuralFeature eFeature) {
		switch (eDerivedStructuralFeatureID(eFeature)) {
			case ModelPackage.ACCOUNT__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case ModelPackage.ACCOUNT__DELETED:
				return deleted != DELETED_EDEFAULT;
			case ModelPackage.ACCOUNT__CREATION_DATE:
				return CREATION_DATE_EDEFAULT == null ? creationDate != null : !CREATION_DATE_EDEFAULT.equals(creationDate);
			case ModelPackage.ACCOUNT__BALANCE:
				return balance != BALANCE_EDEFAULT;
			case ModelPackage.ACCOUNT__STARTING_BALANCE:
				return startingBalance != STARTING_BALANCE_EDEFAULT;
			case ModelPackage.ACCOUNT__ACCOUNT_TYPE:
				return accountType != null;
		}
		return eDynamicIsSet(eFeature);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer();
		result.append("[ ");
		result.append(name);
		result.append(" (");
		result.append(accountType);
		result.append(") ]");

		return result.toString();
	}
	
	public String toStringLong() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(name);
		result.append(" (");
		result.append(accountType);
		result.append("): ");
		if ((isCredit() ^ balance <= 0) && balance != 0)
			result.append("-");
		result.append(Strings.inst().get(Strings.CURRENCY_SIGN));
		result.append(Formatter.getInstance().getDecimalFormat().format(Math.abs((double) balance / 100.0)));
		return result.toString();
	}

	
	public void calculateBalance(){
		long balance = this.getStartingBalance();
//		long balance = 0;
		
		Vector<Transaction> transactions = DataInstance.getInstance().getTransactions(this);
		
		for (Transaction transaction : transactions) {
			//We are moving money *to* this account
			if (transaction.getTo().equals(this)){
				balance = balance + transaction.getAmount();
				transaction.setBalanceTo(balance);
			}
			
			//We are moving money *from* this account
			else{
				balance = balance - transaction.getAmount();
				transaction.setBalanceFrom(balance);
			}
		}
		
		this.setBalance(balance);
	}
	
	public boolean isCredit(){
		if (getAccountType() != null)
			return getAccountType().isCredit();
		else{
			Log.critical("null type for account " + this.toStringLong());
			return false;
		}
	}
	
	public int compareTo(Source arg0) {
		if (arg0 instanceof Account){
			Account a = (Account) arg0;
			if (this.isCredit() != a.isCredit()){
				return new Boolean(this.isCredit()).compareTo(new Boolean(a.isCredit()));
			}
		}
		return super.compareTo(arg0);
	}

	
} //AccountImpl