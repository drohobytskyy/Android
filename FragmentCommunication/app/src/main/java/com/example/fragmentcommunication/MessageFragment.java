package com.example.fragmentcommunication;


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


/**
 * A simple {@link Fragment} subclass.
 */
public class MessageFragment extends Fragment {

    OnMessageSendListenr messageSendListenr;

    Button button;
    EditText editText;

    public interface OnMessageSendListenr {
        public void onMessageSend(String message);
    }

    public MessageFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_message, container, false);

        button = view.findViewById(R.id.bn);

        editText = view.findViewById((R.id.txt_message));

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String message = editText.getText().toString();
                messageSendListenr.onMessageSend(message);

            }
        });

        return view;
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);

        Activity activity = (Activity) context;

        try {
            messageSendListenr = (OnMessageSendListenr) context;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString() + "");
        }


    }
}
