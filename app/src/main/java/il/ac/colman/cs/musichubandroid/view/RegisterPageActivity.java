package il.ac.colman.cs.musichubandroid.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import il.ac.colman.cs.musichubandroid.R;
import il.ac.colman.cs.musichubandroid.datatypes.Artist;
import il.ac.colman.cs.musichubandroid.model.ArtistsTable;



public class RegisterPageActivity extends AppCompatActivity {

    Button registerButton;
    private DatabaseReference reference;
    private FirebaseAuth mAuth;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register_page);
        mAuth = FirebaseAuth.getInstance();
        reference = FirebaseDatabase.getInstance().getReference("artists");
        setTitle("Register page");
        registerButton = (Button)findViewById(R.id.registerButton);
        HandlerRegister();
    }

    private boolean isPasswordValid()
    {
        EditText pass=(EditText)findViewById(R.id.password);
        EditText confirmPass=(EditText)findViewById(R.id.confirmPassword);

       if(pass.getText().toString().equals(confirmPass.getText().toString())&&pass.getText().toString().length()>=8)
       {
           return true;
       }
        Toast.makeText(this, "Passwords don't match or passwords shorter than 8", Toast.LENGTH_LONG).show();
        return  false;
    }

    private Boolean isEmailValid()
    {
        EditText emailField = (EditText) findViewById(R.id.email);
        TextView emailErrorMessage=(TextView)findViewById(R.id.emailError);
        if(!TextUtils.isEmpty(emailField.getText()) && Patterns.EMAIL_ADDRESS.matcher(emailField.getText()).matches())
        {
            emailErrorMessage.setVisibility(View.INVISIBLE);// in case the massage already is visible we want to disable it;

            return true;
        }
        emailErrorMessage.setVisibility(View.VISIBLE);
        return false;
    }


    public void HandlerRegister()
    {
        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isEmailValid() && isPasswordValid()) {
                    final EditText userName = (EditText) findViewById(R.id.userName);
                    final EditText Password = (EditText) findViewById(R.id.password);
                    final EditText Email = (EditText) findViewById(R.id.email);
                    mAuth.createUserWithEmailAndPassword(Email.getText().toString(), Password.getText().toString()).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if(task.isSuccessful()){
                                Artist artist = new Artist( userName.getText().toString(), "");
                                String id = mAuth.getUid();
                                artist.setArtistId(id);
                                reference.child(id).setValue(artist);
                                finish();
                                startActivity(new Intent(RegisterPageActivity.this, LoginPageActivity.class));
                            }else{
                                Toast.makeText(RegisterPageActivity.this, "Failed to create user", Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
                }
            }});
    }

}
