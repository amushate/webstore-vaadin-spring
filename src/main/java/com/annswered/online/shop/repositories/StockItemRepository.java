package com.annswered.online.shop.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.annswered.online.shop.model.StockItem;

public interface StockItemRepository extends JpaRepository<StockItem, Long> {

	
}
