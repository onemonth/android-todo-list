package com.onemonth.todolist;

import android.os.Bundle;
import android.content.Intent;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.app.Activity;


/**
 * Created by alfredhanssen on 1/23/16.
 */
public class AddItemActivity extends Activity
{
    private EditText mEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_add_item);

        mEditText = (EditText) findViewById(R.id.activity_add_item_edittext);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_add_item, menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        int id = item.getItemId();
        if (id == R.id.action_save)
        {
            saveItem();

            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed()
    {
        finish();

        super.onBackPressed();
    }

    private void saveItem()
    {
        Intent intent = new Intent();
        String item = mEditText.getText().toString();

        if (item.length() == 0)
        {
            setResult(RESULT_CANCELED, intent);
        }
        else
        {
            intent.putExtra(Constants.ADD_ITEM_RESULT_KEY, item);
            setResult(RESULT_OK, intent);
        }

        finish();
    }
}
