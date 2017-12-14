package np.com.hemshrestha.blog.activities;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import np.com.hemshrestha.blog.R;

/**
 * Created by hereshem on 12/14/17.
 */

public class MyFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //return super.onCreateView(inflater, container, savedInstanceState);
        View view = inflater.inflate(R.layout.fragment_tab, container, false);

        TextView textView = (TextView) view.findViewById(R.id.section_label);
        textView.setText("HELLO THIS");
        return view;
    }
}
