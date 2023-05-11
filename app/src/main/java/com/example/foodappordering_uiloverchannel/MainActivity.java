package com.example.foodappordering_uiloverchannel;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import com.example.foodappordering_uiloverchannel.Adapter.CategoryAdapter;
import com.example.foodappordering_uiloverchannel.Adapter.PapularAdapter;
import com.example.foodappordering_uiloverchannel.activity.CartListActivity;
import com.example.foodappordering_uiloverchannel.databinding.ActivityMainBinding;
import com.example.foodappordering_uiloverchannel.domain.CategoryDomain;
import com.example.foodappordering_uiloverchannel.domain.FoodDomain;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
private ActivityMainBinding binding;
private RecyclerView.Adapter adapter,adapter2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        recyclerCategory();
        recyclerPopular();

        binding.floatingHome.setOnClickListener(v -> {
            startActivity(new Intent(this, CartListActivity.class));
        });
    }

    private void recyclerCategory() {
        LinearLayoutManager layoutManager=new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false);
        binding.recyclerViewCategoryList.setLayoutManager(layoutManager);

        ArrayList<CategoryDomain> categoryDomainArrayList=new ArrayList<>();
        categoryDomainArrayList.add(new CategoryDomain("Pizza","cat_1"));
        categoryDomainArrayList.add(new CategoryDomain("Burger","cat_2"));
        categoryDomainArrayList.add(new CategoryDomain("HotDog","cat_3"));
        categoryDomainArrayList.add(new CategoryDomain("Drink","cat_4"));
        categoryDomainArrayList.add(new CategoryDomain("Donut","cat_5"));

        adapter=new CategoryAdapter(categoryDomainArrayList);
        binding.recyclerViewCategoryList.setAdapter(adapter);

    }

    private void recyclerPopular(){
        LinearLayoutManager layoutManager=new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false);
        binding.rvPopular.setLayoutManager(layoutManager);
        ArrayList<FoodDomain> foodDomains=new ArrayList<>();
        foodDomains.add(new FoodDomain("peprony","pizza1","toamto, sorty food, vernob, dirgenarty",5.5));
        foodDomains.add(new FoodDomain("pizza","pizza1","toamto, sorty food, vernob, dirgenarty",9.0));
        foodDomains.add(new FoodDomain("tomato","pizza1","toamto, sorty food, vernob, dirgenarty",12.2));
        foodDomains.add(new FoodDomain("orange","pizza1","toamto, sorty food, vernob, dirgenarty",8.2));
        foodDomains.add(new FoodDomain("apple","pizza1","toamto, sorty food, vernob, dirgenarty",15.6));
        foodDomains.add(new FoodDomain("bannana","pizza1","toamto, sorty food, vernob, dirgenarty",20.0));

        adapter2 = new PapularAdapter(foodDomains);
        binding.rvPopular.setAdapter(adapter2);
    }
}