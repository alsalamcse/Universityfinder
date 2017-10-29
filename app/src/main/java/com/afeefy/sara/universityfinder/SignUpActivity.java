package com.afeefy.sara.universityfinder;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class SignUpActivity extends AppCompatActivity implements View.OnClickListener
{
    private EditText ETNAME1;
    private EditText ETEMAIL1;
    private EditText ETPASSWORD1;
    private EditText ETREPASSWORD1;
    private Button BTNSAVE;
    private FirebaseAuth auth;
    private FirebaseUser firebaseUser;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        ETNAME1=(EditText) findViewById(R.id.ETNAME1);
        ETEMAIL1=(EditText) findViewById(R.id.ETEMAIL1);
        ETPASSWORD1=(EditText) findViewById(R.id.ETPASSWORD1);
        ETREPASSWORD1=(EditText) findViewById(R.id.ETREPASSWORD1);
        BTNSAVE=(Button) findViewById(R.id.BTNSAVE);
        auth = FirebaseAuth.getInstance();
        firebaseUser = auth.getCurrentUser();
    }

    @Override
    public void onClick(View v) {
        if (BTNSAVE==v)
        {
            Intent intent=new Intent(this,LoginActivity.class);
            startActivity(intent);
            dataHandler();
        }
    }
    private void dataHandler()
    {
        String STEMAIL=ETEMAIL1.getText().toString();
        String STNAME=ETNAME1.getText().toString();
        String STPASSWORD=ETPASSWORD1.getText().toString();
        String STREPASSWORD=ETREPASSWORD1.getText().toString();
        boolean isok=true;//to chrck if all feilds are filled correctly
        if (STEMAIL.length()==0 || STEMAIL.indexOf('@')<1){
            ETEMAIL1.setError("wrong Email");
            isok=false;
        }
        if (STPASSWORD.length()<8){
            ETPASSWORD1.setError("Bad Password");
            isok=false;
        }
        if(isok)
            creatAcount(STEMAIL,STPASSWORD);
    }
    private void creatAcount(String email, String passw) {
        auth.createUserWithEmailAndPassword(email,passw).addOnCompleteListener(SignUpActivity.this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful())
                {
                    Toast.makeText(SignUpActivity.this, "Authentication Successful.", Toast.LENGTH_SHORT).show();
                    //updateUserProfile(task.getResult().getUser());
                    finish();
                }
                else
                {
                    Toast.makeText(SignUpActivity.this, "Authentication failed."+task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                    task.getException().printStackTrace();
                }
            }
        });
    }
}


