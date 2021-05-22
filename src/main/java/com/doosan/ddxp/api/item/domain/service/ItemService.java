package com.doosan.ddxp.api.item.domain.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.doosan.ddxp.api.item.domain.model.Item;

@Service
public interface ItemService {
	
	List<Item> getItemList();

}
