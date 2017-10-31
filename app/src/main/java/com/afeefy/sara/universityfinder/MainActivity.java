package com.afeefy.sara.universityfinder;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity implements View.OnClickListener
{
    private Spinner spinner2;
    private EditText ETpsycho,ETbagrut;
    private Button BTcheck,BTCHECK1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        spinner2= (Spinner) findViewById(R.id.spinner2);
        ETpsycho=  (EditText) findViewById(R.id.ETpsycho);
        ETbagrut= (EditText) findViewById(R.id.ETbagrut);
        BTcheck= (Button) findViewById(R.id.BTcheck);
        BTCHECK1= (Button) findViewById(R.id.BTCHECK1);
    }

    @Override
    public void onClick(View v)
    {
        if (BTcheck==v)
        {
            Intent intent=new Intent(this,Universities.class);
            startActivity(intent);
        }
        if (BTCHECK1==v)
        {
            Intent intent=new Intent(this,Colleges.class);
            startActivity(intent);
        }
    }
}
