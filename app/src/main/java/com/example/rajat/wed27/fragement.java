package com.example.rajat.wed27;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;

public class fragement extends AppCompatActivity {

    Button a,b,d,all;
    FrameLayout fl1,fl2;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragement);

        a = findViewById(R.id.a);
        b = findViewById(R.id.b);
        d = findViewById(R.id.d);
        all = findViewById(R.id.all);
        fl1 = findViewById(R.id.fl1);
        fl2 = findViewById(R.id.fl2);

        a.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment i = new A();
                FragmentManager fm = getSupportFragmentManager();
                FragmentTransaction ft = fm.beginTransaction();
                ft.addToBackStack(null);
                ft.add(R.id.fl1,i);
                ft.commit();
            }
        });

        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment i = new B();
                FragmentManager fm = getSupportFragmentManager();
                FragmentTransaction ft = fm.beginTransaction();
                ft.addToBackStack(null);
                ft.add(R.id.fl2,i);
                ft.commit();
            }
        });

        d.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment i = new D();
                FragmentManager fm = getSupportFragmentManager();
                FragmentTransaction ft = fm.beginTransaction();
                ft.replace(R.id.fl1,i);
                ft.addToBackStack(null);
                ft.commit();
            }
        });

        all.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment j = new B();
                Fragment i = new A();
                FragmentManager fm = getSupportFragmentManager();
                FragmentTransaction ft = fm.beginTransaction();
                ft.replace(R.id.fl1,i);
                ft.addToBackStack(null);
                ft.add(R.id.fl2,j);
                ft.commit();
            }
        });



    }
}
