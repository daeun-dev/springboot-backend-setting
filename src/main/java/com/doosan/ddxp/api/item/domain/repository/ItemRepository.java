package com.doosan.ddxp.api.item.domain.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.doosan.ddxp.api.item.domain.model.Item;

@Mapper
@Repository
public interface ItemRepository{
	
	List<Item> getItemList();

}
