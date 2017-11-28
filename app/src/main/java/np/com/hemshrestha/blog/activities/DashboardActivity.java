package np.com.hemshrestha.blog.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

import np.com.hemshrestha.blog.R;


public class DashboardActivity extends AppCompatActivity {

    LinearLayout login;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        login = (LinearLayout) findViewById(R.id.ll_login);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(DashboardActivity.this, "login clicked", Toast.LENGTH_SHORT).show();

                startActivity(new Intent(DashboardActivity.this, MainActivity.class));
            }
        });

    }
}
