package il.ac.colman.cs.musichubandroid.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import il.ac.colman.cs.musichubandroid.R;

/**
 * Created by ostrovskyav on 08/08/2018.
 */

public class LoginPageActivity extends AppCompatActivity {
    EditText email;
    EditText password;
    Button registerButton;
    Button signinButton;
    private FirebaseAuth mAuth;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_page);
        mAuth = FirebaseAuth.getInstance();
        registerButton = (Button)findViewById(R.id.registerButton);
        signinButton=(Button)findViewById(R.id.loginButton);
        email=(EditText)findViewById(R.id.email);
        password=(EditText)findViewById(R.id.password);
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
                mAuth.signInWithEmailAndPassword(email.getText().toString(), password.getText().toString()).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
                            startActivity(new Intent(LoginPageActivity.this, FeedActivity.class));
                        }else{
                            Toast.makeText(LoginPageActivity.this, "Email or Password are incorrect", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            }
        });
    }
}
