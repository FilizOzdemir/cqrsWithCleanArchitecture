package com.etiya.cqrsWithCleanArchitecture.application.accountTypes.commands.create;

import lombok.Data;

@Data
public class AccountTypeCreatedEvent {
	
	private String accountTypeId;
	private String accountName;
	private String description;
	private double price;
}
