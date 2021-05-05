package com.doosan.ddxp.api.item.domain.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class Item {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private String ITEMID;
	private String ITEMNM;
	private String DESCRIPTION;
}
