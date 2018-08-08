package il.ac.colman.cs.musichubandroid.view;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.provider.ContactsContract;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import il.ac.colman.cs.musichubandroid.R;

import static android.text.InputType.TYPE_TEXT_VARIATION_PASSWORD;
import static il.ac.colman.cs.musichubandroid.R.id.Email;

/**
 * Created by ostrovskyav on 08/08/2018.
 */

public class RegisterPageActivity extends AppCompatActivity {


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register_page);
        setTitle("Register page");
    }

    public boolean isPasswordValid()
    {
        EditText pass=(EditText)findViewById(R.id.password);
        EditText confirmPass=(EditText)findViewById(R.id.confirmPassword);

       if(pass.getText().toString().equals(confirmPass.getText().toString()))
       {
           return true;
       }
        Toast.makeText(this, "the password and  the password confirm field do not match " + pass.getText() + " and "+confirmPass.getText(),Toast.LENGTH_LONG).show();
        return  false;
    }

    public Boolean isEmailValid()
    {
        EditText emailField = (EditText) findViewById(R.id.Email);
        TextView emailErrorMessage=(TextView)findViewById(R.id.emailError);
        if(!TextUtils.isEmpty(emailField.getText()) && Patterns.EMAIL_ADDRESS.matcher(emailField.getText()).matches())
        {
            emailErrorMessage.setVisibility(View.INVISIBLE);// in case the massage already is visible we want to disable it;

            return true;
        }
        emailErrorMessage.setVisibility(View.VISIBLE);
        return false;
    }


    public void register(View view)
    {
        if (isEmailValid()&&isPasswordValid())
        {
            Toast.makeText(this, "Registered",Toast.LENGTH_LONG).show();
        }



    }

}
