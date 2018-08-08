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

    }

    public Boolean isEmailValid(CharSequence target)
    {
        return !TextUtils.isEmpty(target) && Patterns.EMAIL_ADDRESS.matcher(target).matches();

    }

    public void emailErrorMassage(View view)
    {
        EditText EmailFieldContent=(EditText)findViewById(R.id.Email);
        if(isEmailValid((CharSequence) EmailFieldContent))
        {
            TextView emailErrorMassge= (TextView)findViewById(R.id.emailError);
            emailErrorMassge.setVisibility(View.VISIBLE);

        }
    }

    public void register(View view)
    {

    }

}
