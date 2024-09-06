package vn.edu.usth.weather;


import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

public class WeatherActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weather);

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        header header = new header();
        fragmentTransaction.replace(R.id.fragment_container_header, header);

        ForecastFragment forecastFragment = new ForecastFragment();
        fragmentTransaction.replace(R.id.fragment_container_forecast, forecastFragment);

        WeatherFragment weatherFragment = new WeatherFragment();
        fragmentTransaction.replace(R.id.fragment_container_weather, weatherFragment);

        fragmentTransaction.commit();
    }
}