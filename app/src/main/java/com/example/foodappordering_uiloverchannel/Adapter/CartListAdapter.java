package com.example.foodappordering_uiloverchannel.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.example.foodappordering_uiloverchannel.R;
import com.example.foodappordering_uiloverchannel.databinding.ViewholderCartlistBinding;
import com.example.foodappordering_uiloverchannel.domain.FoodDomain;
import com.example.foodappordering_uiloverchannel.handle.ChangeNumberItemListener;
import com.example.foodappordering_uiloverchannel.helper.ManagementCart;

import java.util.ArrayList;

public class CartListAdapter extends RecyclerView.Adapter<CartListAdapter.ViewHolder> {

    private ArrayList<FoodDomain> foodDomains;
    private ManagementCart managementCart;
    private Context context;
    private ChangeNumberItemListener changeNumberItemListener;

    public CartListAdapter( ArrayList<FoodDomain> foodDomains,Context context, ChangeNumberItemListener changeNumberItemListener) {
        this.foodDomains=foodDomains;
        this.context=context;
        this.managementCart = new ManagementCart(context);
        this.changeNumberItemListener = changeNumberItemListener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ViewholderCartlistBinding binding= DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.viewholder_cartlist,parent,false);
        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        holder.binding.titleEachCart.setText(foodDomains.get(position).getTitle());
        holder.binding.feeEachItem.setText(String.valueOf(foodDomains.get(position).getFee()));
        holder.binding.totalEachtem.setText(String.valueOf(Math.round(foodDomains.get(position).getNumberInCart()*foodDomains.get(position).getFee())));
        holder.binding.numberItem.setText(String.valueOf(foodDomains.get(position).getNumberInCart()));

        holder.binding.pluseCart.setOnClickListener(v -> {
            managementCart.plusNumFood(foodDomains,position,new ChangeNumberItemListener() {
                @Override
                public void changed() {
                    notifyDataSetChanged();
                    changeNumberItemListener.changed();
                }
            });
        });

        holder.binding.minusCart.setOnClickListener(v -> {
            managementCart.minusNumFood(foodDomains, position, new ChangeNumberItemListener() {
                @Override
                public void changed() {
                    notifyDataSetChanged();
                    changeNumberItemListener.changed();
                }
            });
        });



    }

    @Override
    public int getItemCount() {
        return foodDomains.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
private ViewholderCartlistBinding binding;
        public ViewHolder(@NonNull ViewholderCartlistBinding binding) {
            super(binding.getRoot());
            this.binding=binding;
        }
    }
}
