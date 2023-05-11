package com.example.foodappordering_uiloverchannel.helper;

import android.content.Context;
import android.widget.Toast;

import com.example.foodappordering_uiloverchannel.domain.FoodDomain;
import com.example.foodappordering_uiloverchannel.handle.ChangeNumberItemListener;

import java.util.ArrayList;

public class ManagementCart {

    private Context context;
    private TinyDB tinyDB;

    public ManagementCart(Context context) {
        this.context = context;
        this.tinyDB = new TinyDB(context);
    }

    public void insertFood(FoodDomain item) {

        ArrayList<FoodDomain> foodList = getListCart();
        boolean exitAlready = false;
        int n = 0;

        for (int i = 0; i <foodList.size() ; i++) {
            if (item.getTitle().equals(foodList.get(i).getTitle())) {
                exitAlready = true;
                n = i;
                break;
            }
        }

        if (exitAlready){
            foodList.get(n).setNumberInCart(item.getNumberInCart());
        }else {
            foodList.add(item);
        }
        
        tinyDB.putListObject("cartList",foodList);
        Toast.makeText(context, "add to cart", Toast.LENGTH_SHORT).show();




    }

    public ArrayList<FoodDomain> getListCart() {
        return tinyDB.getListObject("cartList");
    }

    public void plusNumFood(ArrayList<FoodDomain> foodDomains, int positon, ChangeNumberItemListener changeNumberItemListener){
        foodDomains.get(positon).setNumberInCart(foodDomains.get(positon).getNumberInCart()+1);
        tinyDB.putListObject("cartList",foodDomains);
        changeNumberItemListener.changed();
    }

    public void minusNumFood(ArrayList<FoodDomain> foodDomains, int positon, ChangeNumberItemListener changeNumberItemListener){
        if (foodDomains.get(positon).getNumberInCart()==1){
            foodDomains.remove(positon);
        }else {
            foodDomains.get(positon).setNumberInCart(foodDomains.get(positon).getNumberInCart()-1);

        }

        tinyDB.putListObject("cartList",foodDomains);
        changeNumberItemListener.changed();

    }

    public Double getTotalFee(){
        ArrayList<FoodDomain> foodDomains=getListCart();
        double fee=0;

        for (int i=0;i<foodDomains.size();i++){
            fee+=foodDomains.get(i).getFee()*foodDomains.get(i).getNumberInCart();
        }

        return fee;
    }

}
