package com.example.tapesh.fireproject1;

import android.os.Bundle;

import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TextView;

import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;

public class MainActivity extends AppCompatActivity {

    TextView textViewCondition;
    Button buttonsunny,button2foggy;
    Firebase mref;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }

    @Override
    protected void onStart()
    {
        super.onStart();

        textViewCondition=(TextView)findViewById(R.id.textViewCondition);

        buttonsunny=(Button)findViewById(R.id.buttonsunny);
        button2foggy=(Button)findViewById(R.id.button2foggy);
        mref=new Firebase("https://burning-torch-3199.firebaseio.com/condition");

        mref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
               String text=dataSnapshot.getValue(String.class);
                textViewCondition.setText(text);
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });

        button2foggy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mref.setValue("vipin");
            }
        });

        buttonsunny.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mref.setValue("hem");
            }
        });


    }

}
