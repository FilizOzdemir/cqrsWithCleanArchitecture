package com.etiya.cqrsWithCleanArchitecture.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

import com.etiya.cqrsWithCleanArchitecture.domain.AccountType;

public interface AccountTypeRepository extends JpaRepository<AccountType, String>{

	
}
