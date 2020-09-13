package com.example.firebasecrud;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;

public class MainActivity extends AppCompatActivity {

    EditText name,age,city,college;
    DatabaseReference databaseReference;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        databaseReference = FirebaseDatabase.getInstance().getReference().child("User");


        name = (EditText) findViewById(R.id.name);
        age = (EditText) findViewById(R.id.age);
        city = (EditText) findViewById(R.id.city);
        college = (EditText) findViewById(R.id.college);



    }

    public void Submit(View view) {

        HashMap<String,String> map = new HashMap<>();
        map.put("Name",name.getText().toString().trim());
        map.put("Age",age.getText().toString().trim());
        map.put("City",city.getText().toString().trim());
        map.put("College",college.getText().toString().trim());
        databaseReference.push().setValue(map);
        Toast.makeText(this, "Data Uploaded", Toast.LENGTH_SHORT).show();

    }

    public void ReadData(View view) {
        Intent intent = new Intent(MainActivity.this,User.class);
        startActivity(intent);

    }
}
