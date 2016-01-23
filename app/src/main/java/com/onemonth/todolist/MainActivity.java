package com.onemonth.todolist;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;
import android.support.design.widget.FloatingActionButton;


public class MainActivity extends Activity
{
    private ListView mListView;
    private StringAdapter mAdapter;
    private FloatingActionButton mFloatingActionButton;
    private View.OnClickListener mFabOnClickListener = new View.OnClickListener()
    {
        @Override
        public void onClick(View v) 
        {
            mAdapter.addItem("Walk the cat");
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        mListView = (ListView) findViewById(R.id.activity_main_listview);
        mAdapter = new StringAdapter(this, R.id.list_item_textview);
        mListView.setAdapter(mAdapter);

        mFloatingActionButton = (FloatingActionButton) findViewById(R.id.activity_main_floatingactionbutton);
        mFloatingActionButton.setOnClickListener(mFabOnClickListener);
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
}
