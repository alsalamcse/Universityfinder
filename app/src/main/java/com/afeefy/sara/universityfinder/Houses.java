package com.afeefy.sara.universityfinder;

import android.content.Intent;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;

import com.afeefy.sara.universityfinder.Data.House;

import java.util.List;

public class Houses extends AppCompatActivity implements View.OnClickListener {
    private ImageButton IMGADD;
    private TextView ETNUMHOUSE;
    private TextView ETSUBJECT;
    private TextView ETYEAR, ETSPACE, ETPHONENUMBER;
    private ListView LVHOUSES;
    private HouseAdapter houseAdapter;


    protected void onCreate(LayoutInflater inflater,ViewGroup container,Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        View view=inflater.inflate(R.layout.activity_houses,container,false);
        setContentView(R.layout.activity_houses);
        IMGADD= (ImageButton) findViewById(R.id.IMGADD);
        LVHOUSES= (ListView) findViewById(R.id.LVHOUSES);
        ETNUMHOUSE= (TextView) findViewById(R.id.ETNUMHOUSE);
        ETSUBJECT= (TextView) findViewById(R.id.ETSUBJECT);
        ETYEAR= (TextView) findViewById(R.id.ETYEAR);
        ETSPACE= (TextView) findViewById(R.id.ETSPACE);
        ETPHONENUMBER= (TextView) findViewById(R.id.ETPHONENUMBER);

        houseAdapter=new HouseAdapter(R.layout.item_house);
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







