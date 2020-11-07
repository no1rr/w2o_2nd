package com.company;

import java.time.LocalDate;

public class Beer extends Drinks{
    private float Alcohol;
    public Beer(String name, double costs, LocalDate ProdDate,float Alcohol)
    {
        super(name, costs, ProdDate, 30);
        this.Alcohol=Alcohol;
    }
    public Beer(String name){       //测试用
        super(name);
    }
    public Beer(String name, double costs, float Alcohol){      //购买原料时用
        super(name,costs,LocalDate.parse("1970-01-01"),30);
    }
    @Override
    public String toString() {
        return "Beer{name:"+name+" "+"costs:"+costs+" "+"ProdDate:"+ProdDate+" "+"ShelLife:"+ShelLife+"}";
    }


    public double getcosts(){ return costs; }
    public float getalcohol(){return Alcohol;}
}
