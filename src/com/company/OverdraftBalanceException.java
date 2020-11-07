package com.company;

public class OverdraftBalanceException extends RuntimeException{
    public OverdraftBalanceException(String errInformation){
        super(errInformation);
    }
}
