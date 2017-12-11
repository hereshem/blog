package np.com.hemshrestha.blog.activities;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

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
                toast("login clicked");
                startActivity(new Intent(DashboardActivity.this, MainActivity.class));
            }
        });
        findViewById(R.id.ll_list_blog).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toast("List clicked");
                startActivity(new Intent(DashboardActivity.this, BlogListActivity.class));
            }
        });
        findViewById(R.id.ll_server).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toast("Server clicked");

                asyncCall();
//                String response = ServerRequest.httpGetData("http://google.com");
//                toast("Response = " + response);

            }
        });
    }

    private void toast(String s) {
        Toast.makeText(this, s, Toast.LENGTH_SHORT).show();
    }

    void asyncCall() {

        new AsyncTask<Void, Void, String>(){
            @Override
            protected String doInBackground(Void... params) {
                return  ServerRequest.httpGetData("http://gdg.hem.info.np/index.php?action=api");
            }

            @Override
            protected void onPostExecute(String s) {
                super.onPostExecute(s);
                toast("Response = " + s);
                parseJSON(s);
            }

        }.execute();
    }

    private void parseJSON(String s) {
        toast("parse block");

        try {
            JSONObject main = new JSONObject(s);
            String name = main.getString("name");
            toast("Name is " + name);
            JSONArray data = main.getJSONArray("data");

            for (int i = 0; i < data.length(); i++) {
                JSONObject jObj = data.getJSONObject(i);
                String n = jObj.getString("name");
                toast("Internal Name = "+ n);
            }






        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

}
