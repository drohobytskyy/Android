package com.example.listviewactionmode;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.AbsListView;
import android.widget.ListView;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ListView listView;
    private ListViewAdapter adapter;
    private List<String> fruits;

    public static List<String> userSelection = new ArrayList<String>();
    public static boolean isActiveMode = false;
    public static ActionMode actionMode = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getFruits();

        listView = findViewById(R.id.listView);
        listView.setChoiceMode(AbsListView.CHOICE_MODE_MULTIPLE_MODAL);
        listView.setMultiChoiceModeListener(modeListener);
        adapter = new ListViewAdapter(this, 0, fruits);
        listView.setAdapter(adapter);

    }

    private void getFruits() {
        String []items = getResources().getStringArray(R.array.fruits);
        fruits = Arrays.asList(items);
    }

    AbsListView.MultiChoiceModeListener modeListener = new AbsListView.MultiChoiceModeListener() {
        @Override
        public void onItemCheckedStateChanged(ActionMode mode, int position, long id, boolean checked) {

            // Action is now set in the adapter using checkbox
            /*if(userSelection.contains(fruits.get(position))){
                userSelection.remove(fruits.get(position));
            } else {
                userSelection.add(fruits.get(position));
            }

            mode.setTitle(userSelection.size() + " items selected");*/

        }

        @Override
        public boolean onCreateActionMode(ActionMode mode, Menu menu) {

            MenuInflater menuInflater = mode.getMenuInflater();
            menuInflater.inflate(R.menu.context_menu, menu);

            isActiveMode = true;
            actionMode = mode;

            return true;

        }

        @Override
        public boolean onPrepareActionMode(ActionMode mode, Menu menu) {
            return false;
        }

        @Override
        public boolean onActionItemClicked(ActionMode mode, MenuItem item) {

            switch (item.getItemId()) {
                case R.id.delete_action:
                    adapter.removeItems(userSelection);
                    mode.finish();
                    return true;

                    default:
                        return false;
            }
        }

        @Override
        public void onDestroyActionMode(ActionMode mode) {
            userSelection.clear();
            isActiveMode = false;
            actionMode = null;
        }
    };
}
