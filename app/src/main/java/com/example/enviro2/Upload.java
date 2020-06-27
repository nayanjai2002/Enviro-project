package com.example.enviro2;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class Upload extends Fragment {

    public Upload() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_upload, container, false);
        TextView tf1 =  view.findViewById(R.id.instalink);

        if (tf1 != null) {
            tf1.setMovementMethod(LinkMovementMethod.getInstance());
            String text = "<a href=\"https://www.instagram.com/enviroslc?r=nametag\"</a>";
            tf1.setText(Html.fromHtml(text));
        }

        return view;
    }
}
