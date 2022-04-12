package com.etiya.cqrsWithCleanArchitecture.application.accountTypes.commands.create;

import org.axonframework.modelling.command.TargetAggregateIdentifier;

import lombok.Builder;
import lombok.Data;

@Data
@Builder

public class CreateAccountTypeCommand {

	@TargetAggregateIdentifier
	private String accountTypeId;
	private String accountName;
	private String description;
	private double price;
}
