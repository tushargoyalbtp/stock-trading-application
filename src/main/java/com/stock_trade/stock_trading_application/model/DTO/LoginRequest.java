package com.stock_trade.stock_trading_application.model.DTO;


import lombok.Data;

@Data
public class LoginRequest {

    private String username;
    private String password;
}
