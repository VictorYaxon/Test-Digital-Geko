package test.victoryaxon.org.test;
import android.graphics.Color;
import android.os.Bundle;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import test.victoryaxon.org.test.Controllers.FootBallContoller;
import test.victoryaxon.org.test.Controllers.WeatherController;

public class MainActivity extends AppCompatActivity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        setTitle("Test Digital Geko");
        Toolbar topToolBar = (Toolbar)findViewById(R.id.toolbar);
        topToolBar.setTitleTextColor(Color.WHITE);
        setSupportActionBar(topToolBar);
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