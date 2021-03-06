package com.afeefy.sara.universityfinder;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
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
        auth=FirebaseAuth.getInstance();

    }
    @Override
    public void onClick(View v)
    {
        if (BTNSIGNUP==v)
        {
            Intent intent=new Intent(this,SignUpActivity.class);
            startActivity(intent);
        }
        if (BTNLOGIN==v)
        {
            dataHandler();
        }
    }
    private void dataHandler() {
        String email = ETEMAIL.getText().toString();
        String passw = ETPASSWORD.getText().toString();
        signIn(email, passw);
    }

    private void signIn(String email, String passw) {
        auth.signInWithEmailAndPassword(email,passw).addOnCompleteListener(LoginActivity.this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()) {
                    Toast.makeText(LoginActivity.this, "signIn Successful", Toast.LENGTH_SHORT).show();
                    Intent i = new Intent(getBaseContext(),MainActivity.class);
                    startActivity(i);
                    finish();
                }
                else
                    {
                    Toast.makeText(LoginActivity.this, "signIn failed" + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                    task.getException().printStackTrace();
                }
            }
        });
    }
}
