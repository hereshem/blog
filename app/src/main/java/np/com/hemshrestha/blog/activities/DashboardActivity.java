package np.com.hemshrestha.blog.activities;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

import np.com.hemshrestha.blog.R;
import np.com.hemshrestha.blog.handler.ServerRequest;


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
        findViewById(R.id.ll_list_blog).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(DashboardActivity.this, "List clicked", Toast.LENGTH_SHORT).show();

                startActivity(new Intent(DashboardActivity.this, BlogListActivity.class));
            }
        });
        findViewById(R.id.ll_list_blog).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(DashboardActivity.this, "Server clicked", Toast.LENGTH_SHORT).show();

                //startActivity(new Intent(DashboardActivity.this, BlogListActivity.class));
                asyncCall();
                //String response = ServerRequest.httpGetData("http://google.com");

            }
        });
    }

    void asyncCall() {

        AsyncTask task = new AsyncTask<Void, Void, String>() {
            @Override
            protected String doInBackground(Void... params) {
                String response = ServerRequest.httpGetData("http://google.com");
                //Toast.makeText(DashboardActivity.this, "Reponse = " + response, Toast.LENGTH_SHORT).show();
                return response;
            }

            @Override
            protected void onPostExecute(String s) {
                super.onPostExecute(s);
                // render view
                Toast.makeText(DashboardActivity.this, "Reponse = " + s, Toast.LENGTH_SHORT).show();
            }

            @Override
            protected void onPreExecute() {
                super.onPreExecute();
            }
        };

        task.execute();
    }

}
