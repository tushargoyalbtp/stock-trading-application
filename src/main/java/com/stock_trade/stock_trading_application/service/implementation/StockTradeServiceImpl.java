package com.stock_trade.stock_trading_application.service.implementation;

import com.stock_trade.stock_trading_application.model.StockTrade;
import com.stock_trade.stock_trading_application.repository.StockTradeRepository;
import com.stock_trade.stock_trading_application.service.StockTradeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StockTradeServiceImpl implements StockTradeService {


    @Autowired
    private StockTradeRepository stockTradeRepository;

    @Override
    public void createStockTrade(StockTrade stockTrade) {
        stockTradeRepository.save(stockTrade);
    }

    /**
     * @param id
     * @return
     */
    @Override
    public StockTrade getStockTradeById(Long id) {
        return stockTradeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Trade not found with ID: " + id));
    }

    /**
     * @return
     */
    @Override
    public List<StockTrade> getAllStockTrades() {
        return stockTradeRepository.findAll();
    }

    /**
     * @param id
     * @param stockTrade
     * @return
     */
    @Override
    public StockTrade updateStock(Long id, StockTrade stockTrade) {
        StockTrade oldStockTrade = stockTradeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Trade not found with ID: " + id));

        // Update fields
        oldStockTrade.setSymbol(stockTrade.getSymbol());
        oldStockTrade.setPrice(stockTrade.getPrice());
        oldStockTrade.setQuantity(stockTrade.getQuantity());
        oldStockTrade.setTradeDate(stockTrade.getTradeDate());
        oldStockTrade.setTradeType(stockTrade.getTradeType());

        return stockTradeRepository.save(oldStockTrade);
    }

    /**
     * @param id
     */
    @Override
    public void removeTrade(Long id) {
        stockTradeRepository.deleteById(id);
        return;
    }
}
