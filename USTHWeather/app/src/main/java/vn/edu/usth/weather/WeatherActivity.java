package vn.edu.usth.weather;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import android.util.Log;

public class WeatherActivity extends AppCompatActivity {
    public static final String on_command ="WeatherActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_weather);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        Log.i(on_command, "from onCreate");
        if (savedInstanceState == null) {
            ForecastFragment firstFragment = new ForecastFragment();

            // Add the fragment to the 'main' ConstraintLayout
            getSupportFragmentManager().beginTransaction().add(R.id.main, firstFragment).commit();
        }
    }
    @Override
    protected void onResume(){
        super.onResume();
        Log.i(on_command, "from onResume");
    }
    @Override
    protected void onStop(){
        super.onStop();
        Log.i(on_command, "from onStop");
    }
    @Override
    protected void onStart(){
        super.onStart();
        Log.i(on_command, "from onStart");
    }
    @Override
    protected void onDestroy(){
        super.onDestroy();
        Log.i(on_command, "from onDestroy");
    }
    @Override
    protected void onPause(){
        super.onPause();
        Log.i(on_command, "from onPause");
    }
}