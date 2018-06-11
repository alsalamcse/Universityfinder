package com.afeefy.sara.universityfinder;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.afeefy.sara.universityfinder.Data.House;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
public class Addhouse extends AppCompatActivity implements View.OnClickListener {
    private EditText ETNUMHOUSE;
    private EditText ETSUBJECT;
    private EditText ETYEAR,ETSPACE,ETPHONENUMBER,ETADDRESS,ETCITY;
    private RadioGroup RGGENDER;
    private RadioButton RBMALE,RBFEMALE;
    private Button BTNSAVE;
    private boolean isok;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addhouse);
        ETNUMHOUSE = (EditText) findViewById(R.id.ETNUMHOUSE);
        ETSUBJECT = (EditText) findViewById(R.id.ETSUBJECT);
        ETYEAR = (EditText) findViewById(R.id.ETYEAR);
        ETSPACE = (EditText) findViewById(R.id.ETSPACE);
        ETPHONENUMBER = (EditText) findViewById(R.id.ETPHONENUMBER);
        ETADDRESS= (EditText) findViewById(R.id.ETADDRESS);
        ETCITY= (EditText) findViewById(R.id.ETCITY);
        RGGENDER= (RadioGroup) findViewById(R.id.RGGENDER);
        RBMALE= (RadioButton) findViewById(R.id.RBMALE);
        RBFEMALE= (RadioButton) findViewById(R.id.RBFEMALE);
        BTNSAVE = (Button) findViewById(R.id.BTNSAVE);
        BTNSAVE.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dataHandler();
            }
        });
    }
    public void dataHandler()
    {
        //1.get data from the fields
        String STNUMHOUSE=ETNUMHOUSE.getText().toString();
        String STSUBJECT=ETSUBJECT.getText().toString();
        String STYEAR=ETYEAR.getText().toString();
        String STSPACE=ETSPACE.getText().toString();
        String STPHONENUMBER=ETPHONENUMBER.getText().toString();
        String STADDRESS=ETADDRESS.getText().toString();
        String STCITY=ETCITY.getText().toString();
        isok=true;





        //2. todo Validate fields input
        //isok=true;......
        //3. data manipulation
        double space=Double.parseDouble(STSPACE);
        boolean isok=true;
        if (STNUMHOUSE.length()>6&& STNUMHOUSE.length()<1) {
            isok = false;
            ETNUMHOUSE.setError("At least 1 room");
        }
        if (STYEAR.length() < 1 && STYEAR.length()>10)
        {
          isok = false;
            ETYEAR.setError( "At least in year 1");
        }
        if (STSPACE.length() < 5 && STSPACE.length()>40)
        {
            isok = false;
            ETSPACE.setError( "more than 5 and less than 40");
        }
        if (STPHONENUMBER.() < 5 && STPHONENUMBER.length()>40)
        {
            isok = false;
            ETPHONENUMBER.setError( "more than 5 and less than 40");
        }
        if (STADDRESS.length()>3)
        {
            isok = false;
            ETADDRESS.setError( "At least 3 letters");
        }
        if (STCITY.length() < 5 && STCITY.length()>40)
        {
            isok = false;
            ETCITY.setError( "more than 5 and less than 40");
        }



        //4. building data object
        House house=new House();
        house.setNumberinhouse(STNUMHOUSE);
        house.setRoomspace(space);
        house.setCompleted(false);
        house.setCity(STCITY);
        house.setAddress(STADDRESS);
        house.setPhonenumber(STPHONENUMBER);
        house.setSubject(STSUBJECT);
        house.setYearsubject(Integer.parseInt(STYEAR));

        if (RBMALE.isChecked())
        house.setGender("male");
        else
            house.setGender("female" );

        //gps lat lang

        //5.to get user email
        FirebaseAuth auth=FirebaseAuth.getInstance();
        FirebaseUser user=auth.getCurrentUser();
        String email=user.getEmail();
        email=email.replace('.','*');
        //6.building data reference= data path=data address
        DatabaseReference reference;
        //todo לקבלת קישור למסד הניתונים שלנו
        //todo קישור הינו לשורש של המסד שלנו
        reference= FirebaseDatabase.getInstance().getReference();
        house.setEmail(email);
        String key=reference.child("MyList").push().getKey();
        house.setKeyId(key);
        //7.saving data on the firebase database
        reference.child("MyList").child(key).setValue(house).addOnCompleteListener(this, new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                if (task.isSuccessful())
                {
                    Toast.makeText(Addhouse.this,"Add Product Succesful",Toast.LENGTH_SHORT);
                    finish();;
                }
                else
                {
                    Toast.makeText(Addhouse.this,"Add Product Failed",Toast.LENGTH_LONG);
                }
            }
        });
        //todo Testing
        //reference.child("list").setPriority(STNAME);
    }
    @Override
    public void onClick(View v) {
        if (BTNSAVE==v)
        {
            Intent i = new Intent(this, Houses.class);
            startActivity(i);
        }
    }

}


