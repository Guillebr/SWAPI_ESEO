package com.brendan.projects.swapi.activities;

import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.View;
import android.widget.TextView;

import com.brendan.projects.swapi.R;

public class DetailActivity extends AppCompatActivity {

    View line1, line2, line3, line4, line5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        if (getSupportActionBar() != null){
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

        line1 = findViewById(R.id.line1);
        line2 = findViewById(R.id.line2);
        line3 = findViewById(R.id.line3);
        line4 = findViewById(R.id.line4);
        line5 = findViewById(R.id.line5);

        String[] array = getIntent().getStringArrayExtra("array");

        setTitle(array[0]);

        TextView subtitle = findViewById(R.id.subtitle);

        if (!array[1].equals("")) {
            subtitle.setText(array[1]);
        }

        TextView content1_1 = findViewById(R.id.content1_1);
        if (!array[2].equals("")) {
            content1_1.setText(array[2]);
        } else {
            content1_1.setVisibility(View.GONE);
            line1.setVisibility(View.GONE);
        }

        TextView content1_2 = findViewById(R.id.content1_2);
        if (!array[3].equals("")) {
            content1_2.setText(array[3]);
        } else {
            content1_2.setVisibility(View.GONE);
            line1.setVisibility(View.GONE);
        }

        if (getIntent().getExtras().getBoolean("isFilm")){
            content1_2.setGravity(Gravity.CENTER);
        }

        TextView content2_1 = findViewById(R.id.content2_1);
        if (!array[4].equals("")) {
            content2_1.setText(array[4]);
        } else {
            content2_1.setVisibility(View.GONE);
            line1.setVisibility(View.GONE);
            line2.setVisibility(View.GONE);
        }

        TextView content2_2 = findViewById(R.id.content2_2);
        if (!array[5].equals("")) {
            content2_2.setText(array[5]);
        } else {
            content2_2.setVisibility(View.GONE);
            line1.setVisibility(View.GONE);
            line2.setVisibility(View.GONE);
        }

        TextView content3_1 = findViewById(R.id.content3_1);
        if (!array[6].equals("")) {
            content3_1.setText(array[6]);
        } else {
            content3_1.setVisibility(View.GONE);
            line2.setVisibility(View.GONE);
            line3.setVisibility(View.GONE);
        }

        TextView content3_2 = findViewById(R.id.content3_2);
        if (!array[7].equals("")) {
            content3_2.setText(array[7]);
        } else {
            content3_2.setVisibility(View.GONE);
            line2.setVisibility(View.GONE);
            line3.setVisibility(View.GONE);
        }

        TextView content4_1 = findViewById(R.id.content4_1);
        if (!array[8].equals("")) {
            content4_1.setText(array[8]);
        } else {
            content4_1.setVisibility(View.GONE);
            line3.setVisibility(View.GONE);
            line4.setVisibility(View.GONE);
        }

        TextView content4_2 = findViewById(R.id.content4_2);
        if (!array[9].equals("")) {
            content4_2.setText(array[9]);
        } else {
            content4_2.setVisibility(View.GONE);
            line3.setVisibility(View.GONE);
            line4.setVisibility(View.GONE);
        }

        TextView content5_1 = findViewById(R.id.content5_1);
        if (!array[10].equals("")) {
            content5_1.setText(array[10]);
        } else {
            content5_1.setVisibility(View.GONE);
            line4.setVisibility(View.GONE);
            line5.setVisibility(View.GONE);
        }

        TextView content5_2 = findViewById(R.id.content5_2);
        if (!array[11].equals("")) {
            content5_2.setText(array[11]);
        } else {
            content5_2.setVisibility(View.GONE);
            line4.setVisibility(View.GONE);
            line5.setVisibility(View.GONE);
        }

        TextView content6_1 = findViewById(R.id.content6_1);
        if (!array[12].equals("")) {
            content6_1.setText(array[12]);
        } else {
            content6_1.setVisibility(View.GONE);
            line5.setVisibility(View.GONE);
        }

        TextView content6_2 = findViewById(R.id.content6_2);
        if (!array[13].equals("")) {
            content6_2.setText(array[13]);
        }else {
            content6_2.setVisibility(View.GONE);
            line5.setVisibility(View.GONE);
        }


        Typeface tf = Typeface.createFromAsset(getApplicationContext().getAssets(), "Roboto-Medium.ttf");
        subtitle.setTypeface(tf);
        content1_1.setTypeface(tf);
        content1_2.setTypeface(tf);
        content2_1.setTypeface(tf);
        content2_2.setTypeface(tf);
        content3_1.setTypeface(tf);
        content3_2.setTypeface(tf);
        content4_1.setTypeface(tf);
        content4_2.setTypeface(tf);
        content5_1.setTypeface(tf);
        content5_2.setTypeface(tf);
        content6_1.setTypeface(tf);
        content6_2.setTypeface(tf);

    }

    @Override
    public void onBackPressed() {
        ActivityCompat.finishAfterTransition(this);
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}
