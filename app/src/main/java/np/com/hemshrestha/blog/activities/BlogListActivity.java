package np.com.hemshrestha.blog.activities;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import np.com.hemshrestha.blog.R;
import np.com.hemshrestha.blog.handler.ServerRequest;
import np.com.hemshrestha.blog.model.Blog;

public class BlogListActivity extends AppCompatActivity {

    ListView lv;
    List<Blog> data = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_blog_list);

        lv = (ListView) findViewById(R.id.listview);

//
//        data = ;
//        data.add(new Blog("Title 1", "Description 1"));
//        data.add(new Blog("Title 2", "Description 2"));
//        data.add(new Blog("Title 3", "Description 3"));
//        data.add(new Blog("Title 4", "Description 4"));
//        data.add(new Blog("Title 5", "Description 5"));
//        Blog b = new Blog();
//        b.setTitle("Ttile6");
//        b.setDescription("Desc 6");
//        data.add(b);
//        setListView();
        asyncCall();
    }


    void asyncCall() {

        new AsyncTask<Void, Void, String>(){
            @Override
            protected String doInBackground(Void... params) {
                return  ServerRequest.httpGetData("http://hereshem.blogspot.com/feeds/posts/default?alt=json");
            }

            @Override
            protected void onPostExecute(String s) {
                super.onPostExecute(s);
                toast("Response = " + s);
                parseJSON(s);
                setListView();
            }

            @Override
            protected void onPreExecute() {
                super.onPreExecute();
                toast("Loading data. Please Wait...");
            }
        }.execute();
    }

    private void toast(String s) {
        Toast.makeText(this, s, Toast.LENGTH_SHORT).show();
    }

    private void parseJSON(String s) {
        toast("parse block");

        try {
            JSONObject main = new JSONObject(s);
            JSONObject feed = main.getJSONObject("feed");
            JSONArray entry = feed.getJSONArray("entry");
            for (int i = 0; i < entry.length(); i++) {
                JSONObject jObj = entry.getJSONObject(i);
                JSONObject t = jObj.getJSONObject("title");
                String title = t.getString("$t");
                String content = jObj.getJSONObject("content").getString("$t");
                data.add(new Blog(title, content));
            }





        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    private void setListView() {
        ArrayAdapter adapter = new ArrayAdapter(this, R.layout.row_blog_list, data){
            @NonNull
            @Override
            public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
                //return super.getView(position, convertView, parent);
                View view = getLayoutInflater().inflate(R.layout.row_blog_list, parent, false);
                TextView title = (TextView) view.findViewById(R.id.title);
                TextView desc = (TextView) view.findViewById(R.id.desc);
                Blog b = data.get(position);
                title.setText(b.getTitle());
                desc.setText(b.getDescription().substring(0, 100));
                view.findViewById(R.id.call).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(BlogListActivity.this, "Call clicked", Toast.LENGTH_SHORT).show();
                    }
                });
                return view;
            }
        };

        lv.setAdapter(adapter);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Blog b = data.get(position);
                Toast.makeText(BlogListActivity.this, "You clicked " + b.getTitle(), Toast.LENGTH_SHORT).show();
                Intent in = new Intent(getApplicationContext(), BlogDetailActivity.class);
                in.putExtra("title", b.getTitle());
                in.putExtra("desc", b.getDescription());
                startActivity(in);
            }
        });

    }
}
