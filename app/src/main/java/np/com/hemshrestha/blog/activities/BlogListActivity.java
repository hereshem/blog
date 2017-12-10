package np.com.hemshrestha.blog.activities;

import android.content.Intent;
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

import java.util.ArrayList;
import java.util.List;

import np.com.hemshrestha.blog.R;
import np.com.hemshrestha.blog.model.Blog;

public class BlogListActivity extends AppCompatActivity {

    ListView lv;
    List<Blog> data;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_blog_list);

        lv = (ListView) findViewById(R.id.listview);

        data = new ArrayList<>();
        data.add(new Blog("Title 1", "Description 1"));
        data.add(new Blog("Title 2", "Description 2"));
        data.add(new Blog("Title 3", "Description 3"));
        data.add(new Blog("Title 4", "Description 4"));
        data.add(new Blog("Title 5", "Description 5"));
        Blog b = new Blog();
        b.setTitle("Ttile6");
        b.setDescription("Desc 6");
        data.add(b);

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
                desc.setText(b.getDescription());
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
