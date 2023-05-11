package com.example.foodappordering_uiloverchannel.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;

import com.example.foodappordering_uiloverchannel.Adapter.CartListAdapter;
import com.example.foodappordering_uiloverchannel.R;
import com.example.foodappordering_uiloverchannel.databinding.ActivityCartListBinding;
import com.example.foodappordering_uiloverchannel.domain.FoodDomain;
import com.example.foodappordering_uiloverchannel.handle.ChangeNumberItemListener;
import com.example.foodappordering_uiloverchannel.helper.ManagementCart;

import java.util.ArrayList;

public class CartListActivity extends AppCompatActivity {

    private ActivityCartListBinding binding;
    private RecyclerView.Adapter adapter;
    private ManagementCart managementCart;
    private ArrayList<FoodDomain> foodDomains;
    private RecyclerView.LayoutManager layoutManager;

    private double tax;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityCartListBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
managementCart=new ManagementCart(this);
        initList();
        calculateCart();
    }

    private void initList() {
        layoutManager=new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
        binding.rvCartList.setLayoutManager(layoutManager);

        adapter=new CartListAdapter(managementCart.getListCart(), this, new ChangeNumberItemListener() {
            @Override
            public void changed() {
                calculateCart();
            }
        });
        binding.rvCartList.setAdapter(adapter);
        if (managementCart.getListCart().isEmpty()){
             binding.emptyTxt.setVisibility(View.VISIBLE);
             binding.scrollView2.setVisibility(View.GONE);
        }else {
            binding.emptyTxt.setVisibility(View.GONE);
            binding.scrollView2.setVisibility(View.VISIBLE);
        }


    }

    private void calculateCart(){
        double percentTax=0.02;
        double delivery=10;

        tax=Math.round((managementCart.getTotalFee()*percentTax)*100)/100;
        double total = Math.round((managementCart.getTotalFee()+tax+delivery)*100)/100;
        double itemTotal = Math.round(managementCart.getTotalFee()*100)/100;

        binding.totalFeeTxt.setText("$"+itemTotal);
        binding.taxTotal.setText("$"+tax);
        binding.deliveryTxt.setText("$"+delivery);
        binding.allFee.setText("$"+total);

    }
}