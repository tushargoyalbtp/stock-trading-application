package com.stock_trade.stock_trading_application.model;


import com.stock_trade.stock_trading_application.ENUM.TradeType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Entity;
import jakarta.persistence.Column;
import jakarta.persistence.Enumerated;
import jakarta.persistence.EnumType;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "stock_trade", schema = "trading") // use snake_case for DB naming convention
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class StockTrade {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "trade_id") // clarified for DB field
    private Long tradeId;

    @Column(nullable = false)
    private String symbol;

    @Column(nullable = false)
    private Integer quantity;

    @Column(nullable = false)
    private Double price;

    @Enumerated(EnumType.STRING)
    @Column(name = "trade_type", nullable = false)
    private TradeType tradeType;

    @Column(name = "trade_date", nullable = false)
    private LocalDateTime tradeDate;
}
