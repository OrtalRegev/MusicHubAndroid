package il.ac.colman.cs.musichubandroid;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.FrameLayout;

import il.ac.colman.cs.musichubandroid.view.FragmentFeed;
import il.ac.colman.cs.musichubandroid.view.FragmentProfile;

public class MainActivity extends AppCompatActivity {
    BottomNavigationView navigationView;
    FrameLayout mMainFrame;
    FragmentProfile fragmentProfile;
    FragmentFeed fragmentFeed;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mMainFrame=(FrameLayout)findViewById(R.id.mainFrame);
        navigationView=(BottomNavigationView)findViewById(R.id.mainNav);

        fragmentFeed = new FragmentFeed();
        fragmentProfile= new FragmentProfile();
        setFragment(fragmentFeed);

        navigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId())
                {
                    case  R.id.navHome:
                        setFragment(fragmentFeed);
                        return true;

                    case R.id.navMyProfile:
                        setFragment(fragmentProfile);

                        return true;

                    default:
                        return false;
                }
            }
        });
    }
    private  void setFragment(Fragment fragment)
    {
       FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.mainFrame,fragment);
        fragmentTransaction.commit();

    }
}
