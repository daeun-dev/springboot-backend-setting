package com.doosan.ddxp.api.item.domain.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.doosan.ddxp.api.item.domain.model.Item;

@Mapper
public interface ItemRepository{
	
	List<Item> getItemList();

}
