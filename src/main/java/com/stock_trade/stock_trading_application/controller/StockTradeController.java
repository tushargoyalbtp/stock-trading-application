package com.stock_trade.stock_trading_application.controller;

import com.stock_trade.stock_trading_application.model.StockTrade;
import com.stock_trade.stock_trading_application.service.StockTradeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/stockTrade")
public class StockTradeController {

    @Autowired
    private StockTradeService stockTradeService;


    @PostMapping("/createTrades")
    public ResponseEntity<?> createTrades(@RequestBody StockTrade stockTrade){
        stockTradeService.createStockTrade(stockTrade);
        return  ResponseEntity.ok(HttpStatus.CREATED);
    }

    @GetMapping("/allTrades")
    public ResponseEntity<List<StockTrade>> getAllTrades(){
        return ResponseEntity.ok(stockTradeService.getAllStockTrades());
    }


    @GetMapping("/trade/{id}")
    public ResponseEntity<StockTrade> getStockTradeById(@PathVariable("id") Long id){
        return ResponseEntity.ok(stockTradeService.getStockTradeById(id));
    }

    @PutMapping("/trade/{id}")
    public ResponseEntity<StockTrade> updateStockTrade(@PathVariable("id") Long id, @RequestBody StockTrade stockTrade){
        return ResponseEntity.ok(stockTradeService.updateStock(id, stockTrade));
    }

    @DeleteMapping("/trade/{id}")
    public ResponseEntity<String> deleteTrade(@PathVariable("id") Long id){
        stockTradeService.removeTrade(id);
        return ResponseEntity.ok("Deleted successfully");
    }

}
