package com.company;


import java.time.LocalDate;
import java.util.*;
 interface SellandPurchase{           //接口
    void SellSetMeal(String SetMealName);
    void PurchaseIngredient(Drinks Drink,int Amount) throws OverdraftBalanceException;
}

public class West2FriedChickenRestaurant implements SellandPurchase{
    protected Double AccountBalance=0.0;
    protected List<Beer> BeerList=new LinkedList<>();//链表删除快
    protected List<Juice> JuiceList=new LinkedList<>();
    protected static List<SetMeal> SetMealList=new ArrayList<>();//数组查询快
    //protected static Map<String, String> SMCorrespondDrink = new HashMap<>();//套餐对应的饮料
    public West2FriedChickenRestaurant()//
    {
        SetMeal SM0=new SetMeal("SM0",12.5,"C1",new Juice("J5"));   //套餐列表初始化
        SetMeal SM1=new SetMeal("SM1",324.0,"C1",new Juice("J1"));
        SetMeal SM2=new SetMeal("SM2",11.9,"C3",new Beer("B1"));
        SetMeal SM3=new SetMeal("SM3",3.0,"C2",new Juice("J2"));
        SetMeal SM4=new SetMeal("SM4",9.9,"C1",new Beer("B2"));
        SetMeal SM5=new SetMeal("SM5",99.9,"C5",new Juice("J3"));
        SetMeal SM6=new SetMeal("SM6",11.11,"C4",new Beer("B3"));
        SetMeal SM7=new SetMeal("SM7",0.01,"C3",new Juice("J4"));
        SetMeal SM8=new SetMeal("SM8",342.23,"C1",new Beer("B4"));
        SetMealList.addAll(Arrays.asList(SM0,SM1,SM2,SM3,SM4,SM5,SM6,SM7,SM8));                        //
    }


    public void use(Beer beer)//啤酒
    {   //boolean
        //boolean isinList=false;     //所需啤酒是否在列表中
        boolean getbeerfromlist=false;      //所需啤酒是否成功从列表中获取

        for(int size=BeerList.size(),i=0;i<size;i++){
            if(BeerList.get(i).name.equals(beer.name)){
                //isinList=true;

                if(!BeerList.get(i).isOutofDate()){   //第一个符合条件的

                    getbeerfromlist=true;
                    BeerList.remove(i);
                    //System.out.println("successfully sold ");
                    break;
                }else                                   //  过期移出List
                {
                    BeerList.remove(i);                    //更新List长度
                    size=BeerList.size();
                }
            }
        }
        if(!getbeerfromlist){
            throw new IngredientSoldOutException("To customer:"+beer.name+" sold out!");
        }
    }
    public void use(Juice juice)//果汁
    {
        boolean getjuicefromlist=false;      //所需果汁是否成功从列表中获取

        for(int size=JuiceList.size(),i=0;i<size;i++){
            //System.out.println(JuiceList.get(i).name);
            //System.out.println(juice.getname());

             if(JuiceList.get(i).getname().equals(juice.getname())){
                 if(!JuiceList.get(i).isOutofDate()){
                     getjuicefromlist=true;
                     JuiceList.remove(i);
                     break;
                 }else
                 {
                     JuiceList.remove(i);
                     size=JuiceList.size();             //删除过期的果汁后List长度减小
                 }
             }

        }
        if(!getjuicefromlist){
            throw new IngredientSoldOutException("To customer:"+juice.name+" sold out!");
        }
    }


    public void SellSetMeal(String SetMealName)//套餐购买
    {
        for(int size= SetMealList.size(),i=0;i<size;i++){
            //System.out.println(SetMealList.get(i).SetMealName+SetMealName);
            if(SetMealList.get(i).SetMealName.equals(SetMealName)){
                if(SetMealList.get(i).Drink instanceof Beer){
                    //System.out.println("1111111111111111111111111");
                    use((Beer)SetMealList.get(i).Drink);
                }else
                {
                    use((Juice)SetMealList.get(i).Drink);
                    //System.out.println("1111111111111111111111111");
                }
                System.out.println("succesfully sold "+SetMealName);
                AccountBalance+=SetMealList.get(i).SetMealPrice;            //营业收入
                break;
            }
        }
    }


    public void PurchaseIngredient(Drinks Drink, int Amount) throws OverdraftBalanceException //进货
    {
        double SinglePrice=0.0;
        if(Drink instanceof Beer){                          //判断饮料类型
            Beer tempBeer=(Beer)Drink;
            SinglePrice= tempBeer.getcosts();
        }else if(Drink instanceof Juice){
            Juice tempJuice=(Juice)Drink;
            SinglePrice=tempJuice.getcosts();
        }

        if(AccountBalance<SinglePrice*Amount)
            throw new OverdraftBalanceException("to Shopkeeper:进货"+Amount+"瓶"+Drink.getname()+"失败，还差￥" + (SinglePrice * Amount - AccountBalance));
        else
        {
            if(Drink instanceof Beer){                          //判断饮料类型
                System.out.println("成功进货"+Amount+"瓶"+(Drink).getname());
                for(int i=0;i<Amount;i++){
                    BeerList.add((new Beer((Drink).getname(),SinglePrice,LocalDate.now(),((Beer)Drink).getalcohol())));   //假设生产日期是购买时间
                }
            }else if(Drink instanceof Juice){
                System.out.println("成功进货"+Amount+"瓶"+(Drink).getname());
                for(int i=0;i<Amount;i++){
                    JuiceList.add(new Juice((Drink).getname(),SinglePrice,LocalDate.now()));                             //假设生产日期是购买时间

                }
            }
        }

    }


    @Override
    public String toString() {
        return "";
    }
    public void AddBeerList(Beer beer){             //增加啤酒List
        BeerList.add(beer);
    }
    public void AddJuiceList(Juice juice){          //增加果汁List
        JuiceList.add(juice);
    }
    public void AddSetMealList(SetMeal setmeal){    //增加套餐List
        SetMealList.add(setmeal);
    }
    public void AddAccountBalance(double add){      //增加账户余额
        AccountBalance+=add;
    }
}
