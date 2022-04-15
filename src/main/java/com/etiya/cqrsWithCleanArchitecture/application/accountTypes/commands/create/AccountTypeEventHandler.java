package com.etiya.cqrsWithCleanArchitecture.application.accountTypes.commands.create;

import org.axonframework.eventhandling.EventHandler;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.etiya.cqrsWithCleanArchitecture.domain.AccountType;
import com.etiya.cqrsWithCleanArchitecture.persistence.AccountTypeRepository;

@Component
public class AccountTypeEventHandler {

	private AccountTypeRepository accountTypeRepository;

	@Autowired
	public AccountTypeEventHandler(AccountTypeRepository accountTypeRepository) {
		this.accountTypeRepository = accountTypeRepository;
	}


	@EventHandler //Yaratılmış event geldikten sonra gelen eventleri dinlemek için kullanılır
	public void on(AccountTypeCreatedEvent accountTypeCreatedEvent) {
		//iş kuralları
		AccountType accountType = new AccountType();
		BeanUtils.copyProperties(accountTypeCreatedEvent, accountType);
		this.accountTypeRepository.save(accountType);
	}
	
	
	
	
	
	
	
	
}

