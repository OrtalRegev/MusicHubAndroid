package il.ac.colman.cs.musichubandroid.view;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import il.ac.colman.cs.musichubandroid.R;
import il.ac.colman.cs.musichubandroid.model.SingeltonLookedAt;

/**
 * Created by regevor on 11/08/2018.
 */

public class FragmentSearch extends Fragment {
    Button searchButton;
    EditText searchText;
    FragmentOthersProfile fragment;
    FirebaseDatabase mDatabase;
    SingeltonLookedAt lookedAt;
    String userIdFound;
    public FragmentSearch()
    {

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_search,container,false);
    }

    @Override
    public void onViewCreated(final View view, @Nullable Bundle savedInstanceState) {
        fragment =new FragmentOthersProfile();
        searchButton=(Button) view.findViewById(R.id.searchButton);
        searchText=(EditText)view.findViewById(R.id.searchEditText);
        mDatabase = FirebaseDatabase.getInstance();
         lookedAt= SingeltonLookedAt.getInstance();
        searchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatabaseReference artists = mDatabase.getReference("artists");
                artists.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        for (DataSnapshot artist1 : dataSnapshot.getChildren()) {
                             String email = (String)artist1.child("email").getValue();
                             if(searchText.getText().toString().equals(email)) {
                                 userIdFound = (String) artist1.child("artistId").getValue();
                                 lookedAt.setUserId(userIdFound);

                                 FragmentTransaction fragmentTransaction =getFragmentManager().beginTransaction();
                                 fragmentTransaction.replace(R.id.mainFrame,fragment);
                                 fragmentTransaction.commit();

                                 return;
                             }
                        }
                        Toast.makeText(view.getContext(), "Artist not found", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });
            }
        });

    }
}
