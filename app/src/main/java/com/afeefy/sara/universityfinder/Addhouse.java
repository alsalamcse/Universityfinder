package com.afeefy.sara.universityfinder;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
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
    private EditText ETYEAR,ETSPACE,ETPHONENUMBER,ETADDRESS;
    private Button BTNSAVE;
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
        //2. todo Validate fields input
        //isok=true;......
        //3. data manipulation
        double space=Double.parseDouble(STSPACE);
        //4. building data object
        House house=new House();
        house.setNumberinhouse(STNUMHOUSE);
        house.setRoomspace(space);
        house.setCompleted(false);
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
        //7.saving data on the firebase database
        reference.child(email).child("MyList").push().setValue(house).addOnCompleteListener(this, new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                if (task.isSuccessful())
                {
                    Toast.makeText(Addhouse.this,"Add Product Succesful",Toast.LENGTH_SHORT);
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


