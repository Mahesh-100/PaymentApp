package com.controller.entity;



import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "transaction_info")
public class StatementDTO {
        @Id
	    @GeneratedValue(strategy = GenerationType.AUTO)
	    @Column(name = "transactionID")
	    private int transactionID;

	    @Column(name = "sourceAcctID")
	    private int sourceAcctID;

	    @Column(name = "targetAcctID")
	    private int targetAcctID;

	    @Column(name = "amount")
	    private double amount;

	    @Column(name = "transactionType")
	    private String transactionType;

	    @Column(name = "transactionDate", columnDefinition = "DATE")
	    private Date transactionDate;

		

		


		public StatementDTO(int sourceAcctID, int targetAcctID, double amount, String transactionType,
				Date transactionDate) {
			super();
			this.sourceAcctID = sourceAcctID;
			this.targetAcctID = targetAcctID;
			this.amount = amount;
			this.transactionType = transactionType;
			this.transactionDate = transactionDate;
		}

		public StatementDTO() {
			super();
			// TODO Auto-generated constructor stub
		}

		public int getTransactionID() {
			return transactionID;
		}

		public void setTransactionID(int transactionID) {
			this.transactionID = transactionID;
		}

		public int getSourceAcctID() {
			return sourceAcctID;
		}

		public void setSourceAcctID(int sourceAcctID) {
			this.sourceAcctID = sourceAcctID;
		}

		public int getTargetAcctID() {
			return targetAcctID;
		}

		public void setTargetAcctID(int targetAcctID) {
			this.targetAcctID = targetAcctID;
		}

		public double getAmount() {
			return amount;
		}

		public void setAmount(double amount) {
			this.amount = amount;
		}

		public String getTransactionType() {
			return transactionType;
		}

		public void setTransactionType(String transactionType) {
			this.transactionType = transactionType;
		}

		public Date getTransactionDate() {
			return transactionDate;
		}

		public void setTransactionDate(Date transactionDate) {
			this.transactionDate = transactionDate;
		}

	    
	
}
