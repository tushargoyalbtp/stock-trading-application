package com.stock_trade.stock_trading_application.service;

import com.stock_trade.stock_trading_application.model.StockTrade;

import java.util.List;

public interface StockTradeService {
    void createStockTrade(StockTrade stockTrade);
    StockTrade getStockTradeById(Long id);
    List<StockTrade> getAllStockTrades();
    StockTrade updateStock(Long id, StockTrade stockTrade);
    void removeTrade(Long id);
}
