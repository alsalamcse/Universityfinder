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

public class LoginActivity extends AppCompatActivity implements View.OnClickListener
{
    private EditText ETNAME;
    private EditText ETEMAIL;
    private EditText ETPASSWORD;
    private Button BTNLOGIN;
    private Button BTNSIGNUP;
    private Button BTNFORGET;
    private FirebaseAuth auth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ETNAME=(EditText) findViewById(R.id.ETNAME);
        ETEMAIL=(EditText) findViewById(R.id.ETEMAIL);
        ETPASSWORD=(EditText) findViewById(R.id.ETPASSWORD);
        BTNLOGIN=(Button) findViewById(R.id.BTNLOGIN);
        BTNSIGNUP=(Button) findViewById(R.id.BTNSIGNUP);
        BTNFORGET=(Button) findViewById(R.id.BTNFORGET);
    }
    @Override
    public void onClick(View v)
    {
        if (BTNSIGNUP==v)
        {
            Intent intent=new Intent(this,SignUpActivity.class);
            startActivity(intent);
        }
    }
    private void signIn(String email, String passw) {
        auth.signInWithEmailAndPassword(email, passw).addOnCompleteListener(LoginActivity.this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()) {
                    Toast.makeText(LoginActivity.this, "signIn Successful.", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(LoginActivity.this, Mainlist.class);
                    startActivity(intent);
                    finish();
                } else {
                    Toast.makeText(LoginActivity.this, "signIn failed." + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                    task.getException().printStackTrace();
                }
            }
        });
    }

    private void dataHandler() {
        String stEmail = ETEMAIL.getText().toString();
        String stPass = ETPASSWORD.getText().toString();
        boolean isok = true;//to chrck if all feilds are filled correctly
        if (stEmail.length() == 0 || stEmail.indexOf('@') < 1) {
            ETEMAIL.setError("wrong Email");
            isok = false;
        }
        signIn(stEmail, stPass);

    }
}
