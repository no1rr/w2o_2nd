package com.company;

import java.time.LocalDate;

public class Juice extends Drinks{
    public Juice(String name, double costs, LocalDate ProdDate)
    {
        super(name, costs, ProdDate, 2);

    }
    public Juice(String name){      //测试用
        super(name);
    }
    public Juice(String name,double costs){ //购买原料用
        super(name,costs,LocalDate.parse("1970-01-01"),2);
    }
    @Override
    public String toString(){
        return "Juice{name:"+name+" costs:"+costs+" ProDate:"+ProdDate+" ShelLife:"+ShelLife+"}";
    }

    public double getcosts(){ return costs; }


}
