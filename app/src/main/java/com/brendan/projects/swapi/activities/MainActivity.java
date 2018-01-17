package com.brendan.projects.swapi.activities;

import android.app.ActionBar;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.brendan.projects.swapi.R;

public class MainActivity extends AppCompatActivity {

    TextView title;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        title = findViewById(R.id.title);
        Typeface tf = Typeface.createFromAsset(getApplicationContext().getAssets(),"Starjhol.ttf");
        title.setTypeface(tf);

        final TextView actionBarTextView = new TextView(getApplicationContext());
        RelativeLayout.LayoutParams lp = new RelativeLayout.LayoutParams(ActionBar.LayoutParams.MATCH_PARENT, ActionBar.LayoutParams.WRAP_CONTENT);
        actionBarTextView.setLayoutParams(lp);
        actionBarTextView.setText(R.string.appbar_name_main_activity);
        actionBarTextView.setTextSize(20);
        actionBarTextView.setGravity(Gravity.CENTER);
        actionBarTextView.setTextColor(getResources().getColor(R.color.colorAccent));
        actionBarTextView.setTypeface(tf);
        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setCustomView(actionBarTextView);

        actionBarTextView.setVisibility(View.INVISIBLE);

        Animation slideUp = AnimationUtils.loadAnimation(this, R.anim.slide_up);
        title.startAnimation(slideUp);



        new CountDownTimer(3000, 1000) {

            public void onTick(long millisUntilFinished) {
            }

            public void onFinish() {
                Animation fadeIn = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.fade_in);
                Animation fadeOut = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.fade_out);
                actionBarTextView.setVisibility(View.VISIBLE);
                actionBarTextView.startAnimation(fadeIn);
                title.startAnimation(fadeOut);
            }
        }.start();

        new CountDownTimer(4350, 1000) {

            public void onTick(long millisUntilFinished) {
            }

            public void onFinish() {
                Intent categoryActivity = new Intent(getApplicationContext(),CategoryActivity.class);
                Bundle bundle = ActivityOptionsCompat.makeCustomAnimation(getApplicationContext(),
                        android.R.anim.fade_in, android.R.anim.fade_out).toBundle();
                startActivity(categoryActivity, bundle);
            }
        }.start();
    }
}
