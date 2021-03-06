package com.afeefy.sara.universityfinder;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;
import com.afeefy.sara.universityfinder.Data.House;
import com.afeefy.sara.universityfinder.Data.HouseAdapter;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Houses extends AppCompatActivity implements View.OnClickListener {
    private ImageButton IMGADD;
    private TextView ETNUMHOUSE;
    private TextView ETSUBJECT;
    private TextView ETYEAR, ETSPACE, ETPHONENUMBER,ETADDRESS,ETCITY,ETGENDER;
    private ListView LVHOUSES;
    private HouseAdapter houseAdapter;
    private Button BTNSAVE;
    private FirebaseAuth auth;
    private FirebaseUser firebaseUser;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_houses);
        IMGADD = (ImageButton) findViewById(R.id.IMGADD);
        LVHOUSES = (ListView) findViewById(R.id.LVHOUSES);







        BTNSAVE = (Button) findViewById(R.id.BTNSAVE);
        houseAdapter = new HouseAdapter(this, R.layout.item_house);
        LVHOUSES.setAdapter(houseAdapter);
        auth = FirebaseAuth.getInstance();
        firebaseUser = auth.getCurrentUser();
        readAndListen();

    }
    private void readAndListen() {
        FirebaseAuth auth = FirebaseAuth.getInstance();
        FirebaseUser user = auth.getCurrentUser();
        String email = user.getEmail();
        email = email.replace('.', '*');
        DatabaseReference reference;
        reference = FirebaseDatabase.getInstance().getReference();
        reference.child("MyList").orderByChild("email").equalTo(email).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                houseAdapter.clear();
                for (DataSnapshot ds : dataSnapshot.getChildren()) {
                    House h = ds.getValue(House.class);
                    Log.d("SL", h.toString());
                    houseAdapter.add(h);
                }
            }
            @Override
            public void onCancelled(DatabaseError databaseError)

            {
            }
        });
    }
    @Override
    public void onClick(View v)
    {
        if (IMGADD == v)
        {
            Intent i = new Intent(this, Addhouse.class);
            startActivity(i);
        }
    }
}













