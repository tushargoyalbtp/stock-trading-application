package com.stock_trade.stock_trading_application.model.DTO;


import lombok.Data;

@Data
public class SignupRequest {
    private String username;
    private String password;
    private String email;
}
