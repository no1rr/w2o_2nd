package com.company;

import java.time.LocalDate;

import static com.company.MyThread.main;

public class Main {

    public static void main(String[] args) {

        //MyThread.main();//多线程测试

        Beer drink1=new Beer("Tom",23.12,LocalDate.parse("2020-11-05"), (float) 99.9);//过期测试&toString测试
        Juice drink2=new Juice("alice",99.9,LocalDate.parse("2020-11-01"));
        System.out.println(drink1.toString());
        if(drink1.isOutofDate())
            System.out.println(drink1.toString()+" is out of date");
        else
            System.out.println(drink1.toString()+" hasn't out of date");

        //System.out.println(drink2.toString());
        if(drink2.isOutofDate())
            System.out.println(drink2.toString()+" is out of date");
        else
            System.out.println(drink2.toString()+" hasn't out of date");                           //


        Juice j1=new Juice("J1",3.5,LocalDate.parse("2020-11-05"));         //
        Juice j2=new Juice("J1",3.5,LocalDate.parse("2020-10-05"));
        Juice j3=new Juice("J1",3.5,LocalDate.parse("2019-11-05"));
        Juice j4=new Juice("J2",3.15,LocalDate.parse("2020-11-07"));
        Juice j5=new Juice("J2",3.15,LocalDate.parse("2020-10-05"));
        Juice j6=new Juice("J2",3.15,LocalDate.parse("2020-11-03"));
        Juice j7=new Juice("J2",3.15,LocalDate.parse("2020-11-01"));
        Juice j8=new Juice("J3",3.15,LocalDate.parse("2020-10-25"));
        Juice j9=new Juice("J4",13.5,LocalDate.parse("2020-10-31"));
        Juice j10=new Juice("J4",13.5,LocalDate.parse("2020-11-06"));
        Juice j11=new Juice("J5",31.5,LocalDate.parse("2020-11-21"));
        Juice j12=new Juice("J5",31.5,LocalDate.parse("2020-11-10"));
        Juice j13=new Juice("J5",31.5,LocalDate.parse("2020-11-01"));

        Beer b1=new Beer("B1",23.12,LocalDate.parse("2020-11-05"), (float) 99.9);
        Beer b2=new Beer("B1",243.12,LocalDate.parse("2020-11-15"), (float) 89.9);
        Beer b3=new Beer("B2",23.152,LocalDate.parse("2020-10-05"), (float) 99.8);
        Beer b4=new Beer("B2",0.12,LocalDate.parse("2020-11-03"), (float) 79.9);
        Beer b5=new Beer("B2",12.12,LocalDate.parse("2020-11-01"), (float) 99.1);
        Beer b6=new Beer("B3",11.11,LocalDate.parse("2020-11-02"), (float) 96.9);
        Beer b7=new Beer("B4",99.99,LocalDate.parse("2020-10-05"), (float) 91.9);
        Beer b8=new Beer("B5",9.99,LocalDate.parse("2020-10-25"), (float) 92.9);
        Beer b9=new Beer("B6",999.9,LocalDate.parse("2020-10-31"), (float) 94.9);
        Beer b10=new Beer("B6",99.9,LocalDate.parse("2020-10-03"), (float) 94.9);
        Beer b11=new Beer("B6",959.9,LocalDate.parse("2020-10-09"), (float) 54.9);
        Beer b12=new Beer("B6",129.9,LocalDate.parse("2020-10-31"), (float) 74.9);

        West2FriedChickenRestaurant w2fc=new West2FriedChickenRestaurant();

        w2fc.AddBeerList(b1);       //添加啤酒和果汁列表
        w2fc.AddBeerList(b2);
        w2fc.AddBeerList(b3);
        w2fc.AddBeerList(b4);
        w2fc.AddBeerList(b5);
        w2fc.AddBeerList(b6);
        w2fc.AddBeerList(b7);
        w2fc.AddBeerList(b8);
        w2fc.AddBeerList(b9);
        w2fc.AddBeerList(b10);
        w2fc.AddBeerList(b11);
        w2fc.AddBeerList(b12);
        w2fc.AddJuiceList(j1);
        w2fc.AddJuiceList(j2);
        w2fc.AddJuiceList(j3);
        w2fc.AddJuiceList(j4);
        w2fc.AddJuiceList(j5);
        w2fc.AddJuiceList(j6);
        w2fc.AddJuiceList(j7);
        w2fc.AddJuiceList(j8);
        w2fc.AddJuiceList(j9);
        w2fc.AddJuiceList(j10);
        w2fc.AddJuiceList(j11);
        w2fc.AddJuiceList(j12);
        w2fc.AddJuiceList(j13);         //

        w2fc.AddAccountBalance(2390.9);



//        System.out.println("测试购买套餐----------");
//        w2fc.SellSetMeal("SM4");
//        w2fc.SellSetMeal("SM1");
//        w2fc.SellSetMeal("SM1");
//        w2fc.SellSetMeal("SM1");
//        w2fc.SellSetMeal("SM4");



        System.out.println("测试进货----------");
        w2fc.PurchaseIngredient(new Beer("B1",23.12,(float) 99.9),100);
        w2fc.PurchaseIngredient(new Juice("J5",(float)31.5),100);



    }
}
