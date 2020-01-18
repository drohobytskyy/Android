package com.example.roomexample;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class AddUserFragment extends Fragment {

    private EditText UserId, UserName, UserEmail;
    private Button BnSaveUser;

    public AddUserFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_add_user, container, false);

        UserId = view.findViewById(R.id.txt_user_id);
        UserName = view.findViewById(R.id.txt_user_name);
        UserEmail = view.findViewById(R.id.txt_user_email);

        BnSaveUser = view.findViewById(R.id.bn_save);

        BnSaveUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                addUser();

            }
        });

        return view;
    }

    private void addUser() {

        int user_id = Integer.parseInt(UserId.getText().toString());
        String user_name = UserName.getText().toString();
        String user_email = UserEmail.getText().toString();

        User user = new User();
        user.setId(user_id);
        user.setName(user_name);
        user.setEmail(user_email);

        MainActivity.myAppDatabase.myDao().addUser(user);
        Toast.makeText(getActivity(), "User added", Toast.LENGTH_SHORT).show();

        UserId.setText("");
        UserName.setText("");
        UserEmail.setText("");

    }

}
