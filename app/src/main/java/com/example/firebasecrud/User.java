package com.example.firebasecrud;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class User extends AppCompatActivity {

     DatabaseReference databaseReference;
    RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);

        databaseReference = FirebaseDatabase.getInstance().getReference().child("User");
        recyclerView = (RecyclerView) findViewById(R.id.recycler1);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

    }


    public static class UserInfoHolder extends RecyclerView.ViewHolder {

        View view;

        public UserInfoHolder(@NonNull View itemView) {
            super(itemView);

            view = itemView;
        }


        public void setName(String name) {

            TextView name1 = (TextView) view.findViewById(R.id.uname);
            name1.setText(name);

        }

        public void setAge(String age) {

            TextView age1 = (TextView) view.findViewById(R.id.uage);
            age1.setText(age);

        }

        public void setCity(String city) {

            TextView city1 = (TextView) view.findViewById(R.id.ucity);
            city1.setText(city);
        }


        public void setCollege(String college) {

            TextView college1 = (TextView) view.findViewById(R.id.ucollege);
            college1.setText(college);
        }
    }

    @Override
    protected void onStart() {
        super.onStart();

       FirebaseRecyclerAdapter<userhelper,UserInfoHolder> adapter =
               new FirebaseRecyclerAdapter<userhelper, UserInfoHolder>(
                       userhelper.class,
                       R.layout.custom_layout,
                       UserInfoHolder.class,
                       databaseReference
               ) {
                   @Override
                   protected void populateViewHolder(UserInfoHolder userInfoHolder, userhelper userhelper, int i) {

                       userInfoHolder.setName(userhelper.getName());
                       userInfoHolder.setAge(userhelper.getAge());
                       userInfoHolder.setCollege(userhelper.getCollege());
                       userInfoHolder.setCity(userhelper.getCity());


                   }
               };
       recyclerView.setAdapter(adapter);


    }




}
