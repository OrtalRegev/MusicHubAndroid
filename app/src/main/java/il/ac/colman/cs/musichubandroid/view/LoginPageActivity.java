package il.ac.colman.cs.musichubandroid.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import il.ac.colman.cs.musichubandroid.R;

/**
 * Created by ostrovskyav on 08/08/2018.
 */

public class LoginPageActivity extends AppCompatActivity {
    Button registerButton;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_page);
        registerButton = (Button)findViewById(R.id.registerButton);
        setTitle("Login screen");
        handleRegister();


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
    public void onClickLoginButton(View view)
    {

    }
}
