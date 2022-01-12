package com.example.a5rv_insiderecyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;

import com.example.a5rv_insiderecyclerview.adapter.CustomAdapter;
import com.example.a5rv_insiderecyclerview.model.User;
import com.example.a5rv_insiderecyclerview.model.UserSub;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private Context context;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();

        List<User> users = prepareUserList();
        refreshAdapter(users);
    }

    private void initViews() {
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new GridLayoutManager(context,1));
    }

    public void refreshAdapter(List<User> users){
        CustomAdapter adapter = new CustomAdapter(context,users);
        recyclerView.setAdapter(adapter);
    }

    private List<User> prepareUserList(){
        List<User> users = new ArrayList<>();
        users.add(new User());

        for (int i=1; i<20; i++){
            if (i==2||i==5) {
                users.add(new User("Tohir " + i, "qwerty " + i, prepareSubUserList()));
            }else {
                users.add(new User("Akmal "+i,"agent "+i,null));
            }
        }
        users.add(new User());
        return users;
    }
    private List<UserSub> prepareSubUserList(){
        List<UserSub> userSubs = new ArrayList<>();
        for (int i=1; i<5; i++){
            userSubs.add(new UserSub());
        }
        return userSubs;
    }

}