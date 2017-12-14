package np.com.hemshrestha.blog.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import np.com.hemshrestha.blog.R;

public class FirebaseActivity extends AppCompatActivity {

    EditText ed;
    Button button;
    TextView tv;

    DatabaseReference mDatabase;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_firebase);

        ed = (EditText) findViewById(R.id.edittext);
        button = (Button) findViewById(R.id.button);
        tv = (TextView) findViewById(R.id.textview);

        mDatabase = FirebaseDatabase.getInstance().getReference();

        mDatabase.child("mydata").child("data").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String data = dataSnapshot.getValue(String.class);
                tv.setText(data);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String data = ed.getText().toString();
                mDatabase.child("mydata").child("data").setValue(data);
            }
        });
    }
}
