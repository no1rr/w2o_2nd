package com.company;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

abstract class Drinks {
    protected String name;
    protected double costs;
    protected LocalDate ProdDate;  //生产日期
    protected long ShelLife;			//保质期

    public Drinks(String name, double costs, LocalDate ProdDate, int ShelLife) {  //构造函数
        this.name=name;
        this.costs=costs;
        this.ProdDate=ProdDate;
        this.ShelLife=ShelLife;
    }

    public Drinks(String name){     //测试用
        this.name=name;
    }

    public double getCosts() {
        return costs;
    }

    public String getname(){return name;}//测试用

    abstract public String toString();      //抽象toString

    public boolean isOutofDate()
    {
        return ShelLife < ProdDate.until(LocalDate.now(), ChronoUnit.DAYS);
    }
}
