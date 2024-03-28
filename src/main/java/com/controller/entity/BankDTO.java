package com.controller.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="bank_info")
public class BankDTO {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int accountID;
	@Column
	private int user_id;
	@Column
	private String bank_account_no;
	@Column
	private String bank_name;
	@Column
	private String IFSC_code;
	@Column
	private String account_type;
	@Column
	private double current_balance;
	
	
	
	
	public BankDTO(int user_id, String bank_account_no, String bank_name, String iFSC_code, String account_type,
			double current_balance) {
		super();
		this.user_id = user_id;
		this.bank_account_no = bank_account_no;
		this.bank_name = bank_name;
		IFSC_code = iFSC_code;
		this.account_type = account_type;
		this.current_balance = current_balance;
	}
	public BankDTO() {
		// TODO Auto-generated constructor stub
	}
	
	
	
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public int getAccountID() {
		return accountID;
	}
	public void setAccountID(int accountID) {
		this.accountID = accountID;
	}
	public String getBank_account_no() {
		return bank_account_no;
	}
	public void setBank_account_no(String bank_account_no) {
		this.bank_account_no = bank_account_no;
	}
	public String getBank_name() {
		return bank_name;
	}
	public void setBank_name(String bank_name) {
		this.bank_name = bank_name;
	}
	public String getIFSC_code() {
		return IFSC_code;
	}
	public void setIFSC_code(String iFSC_code) {
		IFSC_code = iFSC_code;
	}
	public String getAccount_type() {
		return account_type;
	}
	public void setAccount_type(String account_type) {
		this.account_type = account_type;
	}
	public double getCurrent_balance() {
		return current_balance;
	}
	public void setCurrent_balance(double current_balance) {
		this.current_balance = current_balance;
	}
	
	
	

}
