package com.etiya.cqrsWithCleanArchitecture.application.accountTypes.commands.create;

import lombok.Data;

@Data
public class AccountTypeCreatedEvent { //Hesap Türü Oluşturma
	
	private String accountTypeId;
	private String accountName;
	private String description;
	private double price;
}
