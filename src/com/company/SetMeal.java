package com.company;

public class SetMeal {
    protected String SetMealName;
    protected double SetMealPrice;
    protected String Chicken;
    protected Drinks Drink;
    public SetMeal(String SetMealName,double SetMealPrice,String Chicken,Drinks drink){
        this.SetMealName=SetMealName;
        this.SetMealPrice=SetMealPrice;
        this.Chicken=Chicken;
        this.Drink=drink;

    }

    @Override
    public String toString() {
        return "SetMeal{" +
                "SetMealName='" + SetMealName + '\'' +
                ", SetMealPrice=" + SetMealPrice +
                ", Chicken='" + Chicken + '\'' +
                ", Drink=" + Drink.name +
                '}';
    }




}
