package vn.edu.usth.weather;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

public class WeatherActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weather);

        ViewPager viewPager = findViewById(R.id.viewPager);
        WeatherPagerAdapter adapter = new WeatherPagerAdapter(getSupportFragmentManager());
        viewPager.setAdapter(adapter);
    }

    private class WeatherPagerAdapter extends FragmentPagerAdapter {

        public WeatherPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            switch (position) {
                case 0:
                    // First fragment for Paris
                    return WeatherAndForecastFragment.newInstance("Paris", "Cloudy");
                case 1:
                    // Second fragment for New York
                    return WeatherAndForecastFragment.newInstance("New York", "Sunny");
                case 2:
                    // Third fragment for Tokyo
                    return WeatherAndForecastFragment.newInstance("Tokyo", "Rainy");
                default:
                    return null;
            }
        }

        @Override
        public int getCount() {
            return 3; // 3 WeatherAndForecastFragments
        }
    }
}
