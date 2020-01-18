package com.example.sqlliteexample;


import android.database.sqlite.SQLiteDatabase;
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
public class DeleteFragment extends Fragment {

    private EditText Id;
    private Button Btn_Delete;

    public DeleteFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_delete, container, false);

        Id = view.findViewById(R.id.txt_delete_id);
        Btn_Delete = view.findViewById(R.id.bn_delete);

        Btn_Delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                deleteContact();

            }
        });

        return view;
    }

    private void deleteContact() {

        int id = Integer.parseInt(Id.getText().toString());

        ContactDBHelper contactDBHelper = new ContactDBHelper(getActivity());
        SQLiteDatabase db = contactDBHelper.getWritableDatabase();

        contactDBHelper.deleteContact(id, db);
        contactDBHelper.close();

        Id.setText("");

        Toast.makeText(getActivity(),"Contact deleted", Toast.LENGTH_SHORT).show();

    }

}
