package com.example.foodappordering_uiloverchannel.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.foodappordering_uiloverchannel.R;
import com.example.foodappordering_uiloverchannel.databinding.ViewholderCategoryBinding;
import com.example.foodappordering_uiloverchannel.domain.CategoryDomain;

import java.util.ArrayList;

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.ViewHolder> {


    private ArrayList<CategoryDomain> categoryDomains;

    public CategoryAdapter(ArrayList<CategoryDomain> categoryDomains) {
        this.categoryDomains = categoryDomains;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater inflater=LayoutInflater.from(parent.getContext());
        ViewholderCategoryBinding binding= DataBindingUtil.inflate(inflater, R.layout.viewholder_category,parent,false);



        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
    holder.binding.categoryName.setText(categoryDomains.get(position).getTitle());
    String picUrl ="";
    switch (position){
        case 0:{
            picUrl="cat_1";
            holder.binding.mainLayour.setBackground(ContextCompat.getDrawable(holder.itemView.getContext(), R.drawable.cat_background));
            break;
        }
        case 1:{
            picUrl="cat_2";
            holder.binding.mainLayour.setBackground(ContextCompat.getDrawable(holder.itemView.getContext(), R.drawable.cat_background2));
            break;
        }
        case 3:{
            picUrl="cat_3";
            holder.binding.mainLayour.setBackground(ContextCompat.getDrawable(holder.itemView.getContext(), R.drawable.cat_background3));
            break;
        }
        case 4:{
            picUrl="cat_4";
            holder.binding.mainLayour.setBackground(ContextCompat.getDrawable(holder.itemView.getContext(), R.drawable.cat_background4));
            break;
        }
        case 5:{
            picUrl="cat_5";
            holder.binding.mainLayour.setBackground(ContextCompat.getDrawable(holder.itemView.getContext(), R.drawable.cat_background5));
            break;
        }

    }

    int drawableResourceId=holder.binding.getRoot().getContext().getResources().getIdentifier(picUrl,"drawable", String.valueOf(holder.binding.getRoot().getContext()));
        Glide.with(holder.binding.getRoot().getContext())
                .load(drawableResourceId)
                .into(holder.binding.categoryPic);

    }

    @Override
    public int getItemCount() {
        return categoryDomains.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private ViewholderCategoryBinding binding;
        public ViewHolder(@NonNull ViewholderCategoryBinding binding) {
            super(binding.getRoot());
            this.binding=binding;
        }
    }
}
