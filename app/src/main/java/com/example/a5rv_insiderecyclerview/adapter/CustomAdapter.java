package com.example.a5rv_insiderecyclerview.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.a5rv_insiderecyclerview.R;
import com.example.a5rv_insiderecyclerview.model.User;
import com.example.a5rv_insiderecyclerview.model.UserSub;

import java.util.List;

public class CustomAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private static final int TYPE_ITEM_VIEW = 0;
    private static final int TYPE_ITEM_LIST = 1;

    private Context context;
    private List<User>users;

    public CustomAdapter(Context context, List<User> users) {
        this.context = context;
        this.users = users;
    }

    @Override
    public int getItemViewType(int position) {
        User user = users.get(position);
        if (users.get(position).getUserSubs()!=null)return TYPE_ITEM_LIST;
        return TYPE_ITEM_VIEW;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (TYPE_ITEM_LIST == viewType){
            View header = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_layout_list,parent,false);
            return new CustomListHolder(header);
        }
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_layout_view,parent,false);
        return  new CustomViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        User user = users.get(position);
        if (holder instanceof CustomViewHolder){

        }
        if (holder instanceof CustomListHolder){
            RecyclerView recyclerView = ((CustomListHolder) holder).recyclerView;
            recyclerView.setLayoutManager(new GridLayoutManager(context,1));

            List<UserSub>userSubs = user.getUserSubs();
            refreshSubAdapter(recyclerView,userSubs);
        }
    }

    private void refreshSubAdapter(RecyclerView recyclerView,List<UserSub>userSubs){
        CustomSubAdapter adapter = new CustomSubAdapter(context,userSubs);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public int getItemCount() {
        return users.size();
    }

    public class CustomViewHolder extends RecyclerView.ViewHolder{
        public View view;

        public CustomViewHolder(@NonNull View itemView) {
            super(itemView);
            view = itemView;
        }
    }
    public class CustomListHolder extends RecyclerView.ViewHolder{
        public View view;
        public RecyclerView recyclerView;
        TextView name, password;

        public CustomListHolder(@NonNull View itemView) {
            super(itemView);

            recyclerView = itemView.findViewById(R.id.recyclerView);
        }
    }
}
