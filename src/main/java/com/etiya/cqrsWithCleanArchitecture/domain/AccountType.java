package com.etiya.cqrsWithCleanArchitecture.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name="accountTypes")
@AllArgsConstructor
@NoArgsConstructor
public class AccountType {

	//Hesap Tipleri

	@Id
	@Column(name="id")
	private String accountTypeId;
	@Column(name="accountName")
	private String accountName;//ücretli-ücretsiz-business
	@Column(name="description")
	private String description;//acıklama
	@Column(name="price")
	private double price;//ücret
}
