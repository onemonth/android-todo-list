package com.onemonth.todolist;

import android.app.Activity;
import android.os.Bundle;
import android.content.Intent;
import android.widget.EditText;


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
    public void onBackPressed()
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

        super.onBackPressed();
    }
}
