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
=======
import android.util.Log;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

public class WeatherActivity extends AppCompatActivity {

    private static final String TAG = "WeatherActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weather);
        Log.i(TAG, "onCreate");


        ForecastFragment forecastFragment = new ForecastFragment();


        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();


        fragmentTransaction.add(R.id.container, forecastFragment);
        fragmentTransaction.commit();
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i(TAG, "onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i(TAG, "onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i(TAG, "onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i(TAG, "onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i(TAG, "onDestroy");
    }
}
>>>>>>> a6972c85b761624a9783cfe87c103d3c6f50b310
