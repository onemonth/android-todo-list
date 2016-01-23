package com.onemonth.todolist;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;
import android.support.design.widget.FloatingActionButton;
import android.content.Intent;

public class MainActivity extends Activity
{
    private StringAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        mAdapter = new StringAdapter(this, R.id.list_item_textview);

        ListView listView = (ListView) findViewById(R.id.activity_main_listview);
        listView.setAdapter(mAdapter);

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
    public boolean onCreateOptionsMenu(Menu menu)
    {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings)
        {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
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
