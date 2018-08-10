package il.ac.colman.cs.musichubandroid.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;

import il.ac.colman.cs.musichubandroid.R;
import il.ac.colman.cs.musichubandroid.datatypes.Artist;
import il.ac.colman.cs.musichubandroid.model.ArtistsTable;

/**
 * Created by ostrovskyav on 08/08/2018.
 */

public class LoginPageActivity extends AppCompatActivity {
    EditText email;
    EditText passsword;
    Button registerButton;
    Button signinButton;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_page);
        registerButton = (Button)findViewById(R.id.registerButton);
        signinButton=(Button)findViewById(R.id.loginButton);
        email=(EditText)findViewById(R.id.email);
        passsword=(EditText)findViewById(R.id.password);
        setTitle("Login screen");
        handleRegister();
        handlerLogin();
    }

    public void handleRegister()
    {
        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                startActivity(new Intent(LoginPageActivity.this,RegisterPageActivity.class));
            }
        });
    }
    public void handlerLogin()
    {
        signinButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               ArtistsTable artistsTable= new ArtistsTable();
               artistsTable.login(email.getText().toString(),passsword.getText().toString());
            }
        });
    }
}
