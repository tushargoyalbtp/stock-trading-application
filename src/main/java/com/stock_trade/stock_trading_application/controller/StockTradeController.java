package com.stock_trade.stock_trading_application.controller;

import com.stock_trade.stock_trading_application.model.StockTrade;
import com.stock_trade.stock_trading_application.service.StockTradeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/stockTrade")
public class StockTradeController {

    @Autowired
    private StockTradeService stockTradeService;

    // Allow TRADER and ADMIN to create trades
    @PostMapping("/createTrades")
    @PreAuthorize("hasAnyRole('TRADER', 'ADMIN')")
    public ResponseEntity<?> createTrades(@RequestBody StockTrade stockTrade) {
        stockTradeService.createStockTrade(stockTrade);
        return ResponseEntity.ok(HttpStatus.CREATED);
    }

    // Allow all authenticated roles to view all trades
    @GetMapping("/allTrades")
    @PreAuthorize("hasAnyRole('USER', 'TRADER', 'ADMIN')")
    public ResponseEntity<List<StockTrade>> getAllTrades() {
        return ResponseEntity.ok(stockTradeService.getAllStockTrades());
    }

    // Allow all authenticated roles to view individual trade
    @GetMapping("/trade/{id}")
    @PreAuthorize("hasAnyRole('USER', 'TRADER', 'ADMIN')")
    public ResponseEntity<StockTrade> getStockTradeById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(stockTradeService.getStockTradeById(id));
    }

    // Only TRADER and ADMIN can update trades
    @PutMapping("/trade/{id}")
    @PreAuthorize("hasAnyRole('TRADER', 'ADMIN')")
    public ResponseEntity<StockTrade> updateStockTrade(@PathVariable("id") Long id, @RequestBody StockTrade stockTrade) {
        return ResponseEntity.ok(stockTradeService.updateStock(id, stockTrade));
    }

    // Only ADMIN can delete trades
    @DeleteMapping("/trade/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<String> deleteTrade(@PathVariable("id") Long id) {
        stockTradeService.removeTrade(id);
        return ResponseEntity.ok("Deleted successfully");
    }

}

