package com.stdzone.logoreg.Activities;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.Toast;

import com.stdzone.logoreg.R;
import com.stdzone.logoreg.utils.CheckInternetConnection;


public class Splash extends AppCompatActivity {

    private static final int SPLASH_TIMER =2500;
    ImageView iL,iR;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        if (!new CheckInternetConnection(Splash.this).isConnectedToInternet())
        {
            Toast.makeText(Splash.this,"Connect to Internet to get new feeds",Toast.LENGTH_LONG).show();
        }

        TimerStart();
    }

    private void TimerStart() {
        Thread thread = new Thread() {
            @Override
            public void run() {
                try {
                    sleep(SPLASH_TIMER);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                Intent intent = new Intent(Splash.this,Welcome.class);
                // iL.setoAnimation(AnimationUtils.makeOutAnimation(Splash.this,true));
                // iL.setAnimation(AnimationUtils.android.R.anim.slide_in_left);
                startActivity(intent);
                finish();
            }
        };
        thread.start();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_splash, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
