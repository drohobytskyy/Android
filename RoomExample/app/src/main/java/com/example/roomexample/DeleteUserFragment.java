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
public class DeleteUserFragment extends Fragment {

    EditText UserId;
    Button DeleteUserBtn;

    public DeleteUserFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_delete_user, container, false);

        UserId = view.findViewById(R.id.txt_delete_id);

        DeleteUserBtn = view.findViewById(R.id.bn_delete);

        DeleteUserBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                deleteUser();

            }
        });

        return view;
    }

    private void deleteUser() {

        int id = Integer.parseInt(UserId.getText().toString());

        User user = new User();
        user.setId(id);

        MainActivity.myAppDatabase.myDao().deleteUser(user);

    }

}
