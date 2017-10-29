package com.afeefy.sara.universityfinder;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity {
    private Spinner spinner2;
    private Spinner spinner3;
    private EditText ETpsycho,ETbagrut;
    private Button BTcheck;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        spinner2= (Spinner) findViewById(R.id.spinner2);
        spinner3= (Spinner) findViewById(R.id.spinner3);
        ETpsycho=  (EditText) findViewById(R.id.ETpsycho);
        ETbagrut= (EditText) findViewById(R.id.ETbagrut);
        BTcheck= (Button) findViewById(R.id.BTcheck);
    }

}
