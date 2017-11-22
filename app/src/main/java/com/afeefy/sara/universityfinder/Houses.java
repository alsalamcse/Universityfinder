package com.afeefy.sara.universityfinder;

import android.content.Intent;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ListView;

public class Houses extends AppCompatActivity implements View.OnClickListener {
    private ImageButton IMGADD;
    private ListView LVHOUSES;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_houses);
        IMGADD= (ImageButton) findViewById(R.id.IMGADD);
        LVHOUSES= (ListView) findViewById(R.id.LVHOUSES);
    }

    @Override
    public void onClick(View v)
    {
        if (IMGADD==v)
        {
            Intent i=new Intent(this,Addhouse.class);
            startActivity(i);
        }
    }
}
