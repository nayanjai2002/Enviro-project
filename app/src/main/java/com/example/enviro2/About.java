package com.example.enviro2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Toast;

import java.util.Calendar;

import mehdi.sakout.aboutpage.AboutPage;
import mehdi.sakout.aboutpage.Element;

public class About extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getSupportActionBar().setTitle("About Us");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        Element adsElement = new Element();
        adsElement.setTitle("Contact here");

        View aboutpage = new AboutPage(this)
                .isRTL(false)
                .setImage(R.drawable.ic_info_outline_black_24dp)
                .setDescription("WELLCOME")
                .addItem(new Element().setTitle("Version 1.0.0"))
                .addItem(adsElement)
                .addEmail("enviroslc@gmail.com")
                .addWebsite("www.slc.du.ac.in")
                .addInstagram("https://www.instagram.com/enviroslc?r=nametag")
                .addItem(createCopyright())
                .create();
        setContentView(aboutpage);
    }

    private Element createCopyright() {
        Element copyright = new Element();
        final String copyrightString = String.format( "©ENVIRO. All Rights Reserved", Calendar.getInstance().get(Calendar.YEAR));
        copyright.setTitle(copyrightString);
        copyright.setGravity(Gravity.CENTER);
        copyright.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(About.this,copyrightString, Toast.LENGTH_SHORT).show();
            }
        });
                return  copyright;


    }
}
