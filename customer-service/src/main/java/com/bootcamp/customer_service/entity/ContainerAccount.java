package com.bootcamp.kelompok4.customer_service.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class ContainerAccount {

	@Id
	private String containerAccount;
	private Double balance;
	private String cif;
	
	
	
	public String getContainerAccount() {
		return containerAccount;
	}
	public void setContainerAccount(String containerAccount) {
		this.containerAccount = containerAccount;
	}
	public Double getBalance() {
		return balance;
	}
	public void setBalance(Double balance) {
		this.balance = balance;
	}
	public String getCif() {
		return cif;
	}
	public void setCif(String cif) {
		this.cif = cif;
	}
	
	
}
