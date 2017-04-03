package test.victoryaxon.org.test;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.View;

import test.victoryaxon.org.test.Controllers.FootBallContoller;
import test.victoryaxon.org.test.Controllers.WeatherController;

public class MainActivity extends Activity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

    }

    public void btnWeather(View v) {
        Intent i = new Intent();
        i.setClass(MainActivity.this, WeatherController.class);
        startActivity(i);

    }

    public void btnFootBall(View v) {
        Intent i = new Intent();
        i.setClass(MainActivity.this, FootBallContoller.class);
        startActivity(i);

    }
}