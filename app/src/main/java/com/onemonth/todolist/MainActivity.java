package com.onemonth.todolist;

import android.app.Activity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;
import android.support.design.widget.FloatingActionButton;
import android.content.Intent;
import android.view.MenuInflater;
import android.widget.AdapterView;

public class MainActivity extends Activity
{
    /*

    Add edit functionality to the long press menu
    Add check boxes
    Add plus icon to FAB
    App icon

     */
    private StringAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        mAdapter = new StringAdapter(this, R.id.list_item_textview);

        ListView listView = (ListView) findViewById(R.id.activity_main_listview);
        listView.setAdapter(mAdapter);
        registerForContextMenu(listView);

        FloatingActionButton floatingActionButton = (FloatingActionButton) findViewById(R.id.activity_main_floatingactionbutton);
        View.OnClickListener fabOnClickListener = new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                startAddItemActivity();
            }
        };
        floatingActionButton.setOnClickListener(fabOnClickListener);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo)
    {
        super.onCreateContextMenu(menu, v, menuInfo);

        if (v.getId() == R.id.activity_main_listview)
        {
            MenuInflater inflater = getMenuInflater();
            inflater.inflate(R.menu.menu_main, menu);
        }
    }

    @Override
    public boolean onContextItemSelected(MenuItem item)
    {
        AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo)item.getMenuInfo();
        int position = info.position;
        mAdapter.removeItem(position);

        return true;
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data)
    {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == Constants.ADD_ITEM_REQUEST_CODE)
        {
            if (resultCode == RESULT_OK)
            {
                String item = data.getStringExtra(Constants.ADD_ITEM_RESULT_KEY);
                mAdapter.addItem(item);
            }
        }
    }

    private void startAddItemActivity()
    {
        Intent intent = new Intent(this, AddItemActivity.class);
        startActivityForResult(intent, Constants.ADD_ITEM_REQUEST_CODE);
    }
}
