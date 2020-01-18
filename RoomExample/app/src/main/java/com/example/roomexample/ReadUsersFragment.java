package com.example.roomexample;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class ReadUsersFragment extends Fragment {

    private TextView textInfo;

    public ReadUsersFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_read_users, container, false);

        textInfo = view.findViewById(R.id.txt_display_info);

        getUsers();

        return view;
    }

    private void getUsers() {

        List<User> users = MainActivity.myAppDatabase.myDao().getUsers();
        String info = "";

        for(User user : users) {

            int id= user.getId();
            String name = user.getName();
            String email = user.getEmail();

            info = "\n\n" + "id: " + id + "\nname: " + name + "\nemail: " + email;

        }

        textInfo.setText(info);

    }

}
