package com.example.a5rv_insiderecyclerview.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.a5rv_insiderecyclerview.R;
import com.example.a5rv_insiderecyclerview.model.User;
import com.example.a5rv_insiderecyclerview.model.UserSub;

import java.util.List;

public class CustomSubAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private Context context;
    private List<UserSub>userSubs;

    public CustomSubAdapter(Context context, List<UserSub>userSubs){
        this.context = context;
        this.userSubs = userSubs;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View footer = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_layout_view_sub,parent,false);
        return new CustumFooterSubHolder(footer);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        UserSub userSub = userSubs.get(position);
    }

    @Override
    public int getItemCount() {
        return userSubs.size();
    }

    public class CustumFooterSubHolder extends RecyclerView.ViewHolder{
        public View view;
        public CustumFooterSubHolder(@NonNull View itemView) {
            super(itemView);
            view = itemView;
        }
    }
}
