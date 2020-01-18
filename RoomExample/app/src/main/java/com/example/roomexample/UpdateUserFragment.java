package com.example.roomexample;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;


/**
 * A simple {@link Fragment} subclass.
 */
public class UpdateUserFragment extends Fragment {

    EditText UserID, UserName, UserEmail;
    Button UpdateUserBtn;

    public UpdateUserFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_update_user, container, false);

        UserID = view.findViewById(R.id.txt_update_id);
        UserName = view.findViewById(R.id.txt_update_name);
        UserEmail = view.findViewById(R.id.txt_update_email);

        UpdateUserBtn = view.findViewById(R.id.bn_update);

        UpdateUserBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                updateUser();

            }
        });

        return view;
    }

    private void updateUser() {

        int id = Integer.parseInt(UserID.getText().toString());
        String name = UserName.getText().toString();
        String email = UserEmail.getText().toString();

        User user = new User();
        user.setId(id);
        user.setName(name);
        user.setEmail(email);

        MainActivity.myAppDatabase.myDao().updateUser(user) ;

    }

}
