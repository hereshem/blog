package np.com.hemshrestha.blog.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import np.com.hemshrestha.blog.R;

public class MainActivity extends AppCompatActivity {

    Button b;
    EditText u, p;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // other task

        b = (Button) findViewById(R.id.button);
        u = (EditText) findViewById(R.id.username);
        p = (EditText) findViewById(R.id.password);

        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                toast("Button Clicked");

                toast("Username = " + u.getText().toString());

                toast("Password = " + p.getText().toString());

            }
        });

    }

    private void toast(String s) {
        Toast.makeText(MainActivity.this, s, Toast.LENGTH_SHORT).show();
    }


}
