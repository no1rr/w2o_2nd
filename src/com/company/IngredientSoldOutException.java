package com.company;


public class IngredientSoldOutException extends RuntimeException{       //果汁或啤酒售完
    public IngredientSoldOutException(String errInformation){
        super(errInformation);
    }
}
