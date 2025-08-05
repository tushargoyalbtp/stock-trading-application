package com.stock_trade.stock_trading_application.repository;

import com.stock_trade.stock_trading_application.model.StockTrade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StockTradeRepository extends JpaRepository<StockTrade, Long> {

}
