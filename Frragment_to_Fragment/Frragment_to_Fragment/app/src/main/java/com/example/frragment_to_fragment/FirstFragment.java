package com.example.frragment_to_fragment;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;


public class FirstFragment extends Fragment {

    private Button btnSend;
    private EditText input;
SendDataInterface sendDataInterface;



    public FirstFragment() {
        // Required empty public constructor
    }
public interface SendDataInterface
{
   public void sendData(String a);
}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_first, container, false);
        btnSend=view.findViewById(R.id.btnSend);
        input=view.findViewById(R.id.input);



        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String data=input.getText().toString();
                sendDataInterface.sendData(data);

            }
        });

        return view;


    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);

        Activity activity=(Activity)context;
        try {
            sendDataInterface=(SendDataInterface) activity;

        }catch (RuntimeException a)
        {
            throw new RuntimeException(activity.toString()+"Must implement method.");
        }
    }
}