package com.etiya.cqrsWithCleanArchitecture.ws.controllers;

import java.util.UUID;

import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.etiya.cqrsWithCleanArchitecture.application.accountTypes.commands.create.CreateAccountTypeCommand;
import com.etiya.cqrsWithCleanArchitecture.ws.models.CreateAccountTypeModel;

@RestController
@RequestMapping("/api/accounttypes")
public class AccountTypeController {

	//CommandGateway:Axonun komut işleme birleşenlerine yönelik arayüzüdür.
	//Command gateway ile gönderilen komutların sonuçları beklenebilir.

	private CommandGateway commandGateway;

	public AccountTypeController(CommandGateway commandGateway) {
		this.commandGateway = commandGateway;
	}

	@PostMapping("add")
	public void add(@RequestBody CreateAccountTypeModel createAccountTypeModel) {
		CreateAccountTypeCommand command = CreateAccountTypeCommand.builder()
				.price(createAccountTypeModel.getPrice())
				.accountName(createAccountTypeModel.getAccountName())
				.description(createAccountTypeModel.getDescription()).build();
		command.setAccountTypeId(UUID.randomUUID().toString());
		this.commandGateway.sendAndWait(command);


	}
}
