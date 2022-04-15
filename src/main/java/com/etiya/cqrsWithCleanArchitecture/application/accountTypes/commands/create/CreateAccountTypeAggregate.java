package com.etiya.cqrsWithCleanArchitecture.application.accountTypes.commands.create;

import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;
import org.springframework.beans.BeanUtils;

@Aggregate
public class CreateAccountTypeAggregate {
	
	//gönderilecek bilgiler
	@AggregateIdentifier
	private String accountTypeId;
	private String accountName;
	private String description;
	private double price;

	@CommandHandler //Gönderilen komutun işleyicisini belirtmek için kullanılan axon anotasyonu
	public CreateAccountTypeAggregate(CreateAccountTypeCommand command) {
		AccountTypeCreatedEvent accountTypeCreatedEvent=new AccountTypeCreatedEvent();
		BeanUtils.copyProperties(command, accountTypeCreatedEvent);
		AggregateLifecycle.apply(accountTypeCreatedEvent);

		//AggreagateLifeCycle:Bir aggreagete üzerinden olay(event)yayınlamak için kullanılır yani
    	// Bir command execyte edilerken uygulamanın gerikalanına yeni bir event oluşturulduğunu bildirir.
	}
	
	@EventSourcingHandler //Gönderilen eventin işleyicisini belirtmek için kullanılan axon anotasyonu
	public void on(AccountTypeCreatedEvent accountTypeCreatedEvent) {
	 
		this.accountTypeId=accountTypeCreatedEvent.getAccountTypeId();
		this.accountName=accountTypeCreatedEvent.getAccountName();
		this.description=accountTypeCreatedEvent.getDescription();
		this.price=accountTypeCreatedEvent.getPrice();
	}
}


