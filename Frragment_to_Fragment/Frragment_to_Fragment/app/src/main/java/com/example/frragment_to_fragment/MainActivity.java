package com.example.frragment_to_fragment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity implements FirstFragment.SendDataInterface{

    FragmentManager fragmentManager=getSupportFragmentManager();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (findViewById(R.id.Container) !=null){
            if (savedInstanceState!=null){

                return;
            }
            fragmentManager.beginTransaction().add(R.id.Container,new FirstFragment(),null ).commit();

        }



    }

    @Override
    public void sendData(String a) {
        SecondFragment secondFragment=new SecondFragment();
        Bundle bundle=new Bundle();
        bundle.putString("key",a);
        secondFragment.setArguments(bundle);

        fragmentManager.beginTransaction().replace(R.id.Container,secondFragment,null).commit();

    }
}