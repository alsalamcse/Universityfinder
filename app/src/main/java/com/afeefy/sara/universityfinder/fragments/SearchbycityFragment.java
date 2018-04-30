package com.afeefy.sara.universityfinder.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;

import com.afeefy.sara.universityfinder.Data.House;
import com.afeefy.sara.universityfinder.Data.HouseAdapter;
import com.afeefy.sara.universityfinder.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

/**
 * A simple {@link Fragment} subclass.
 */
public class SearchbycityFragment extends Fragment {


    private ImageButton IBSEARCH;
    private ListView LVHOUSES;
    private EditText ETSEARCH;
    private HouseAdapter houseAdapter;
    private FirebaseAuth auth;
    private FirebaseUser firebaseUser;

    public SearchbycityFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_searchbycity, container, false);
        IBSEARCH = (ImageButton) v.findViewById(R.id.IBSEARCH);
        LVHOUSES = (ListView) v.findViewById(R.id.LVHOUSES);
        ETSEARCH = (EditText) v.findViewById(R.id.ETSEARCH);

        IBSEARCH.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String st=ETSEARCH.getText().toString();
               readAndListen(st);
            }
        });
        houseAdapter = new HouseAdapter(getContext(), R.layout.item_house);
        LVHOUSES.setAdapter(houseAdapter);
        auth = FirebaseAuth.getInstance();
        firebaseUser = auth.getCurrentUser();
        readAndListen("");
        return v;


    }

    private void readAndListen(String st) {
        FirebaseAuth auth = FirebaseAuth.getInstance();
        FirebaseUser user = auth.getCurrentUser();
        String email = user.getEmail();
        email = email.replace('.', '*');
        DatabaseReference reference;
        reference = FirebaseDatabase.getInstance().getReference();

        reference.child("MyList").orderByChild("city").equalTo(st).addValueEventListener(new ValueEventListener() {
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
}
