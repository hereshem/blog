package np.com.hemshrestha.blog.activities;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import np.com.hemshrestha.blog.R;

public class LoginFragment extends Fragment {

    Button b;
    EditText u, p;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.activity_main, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        b = (Button) getView().findViewById(R.id.button);
        u = (EditText) getView().findViewById(R.id.username);
        p = (EditText) getView().findViewById(R.id.password);

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
        Toast.makeText(getActivity(), s, Toast.LENGTH_SHORT).show();
    }


}
