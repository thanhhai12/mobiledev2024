package vn.edu.usth.weather;

import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.google.android.material.tabs.TabLayout;

public class WeatherActivity extends AppCompatActivity {

    private ViewPager viewPager;
    private TabLayout tabLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weather);

        viewPager = findViewById(R.id.viewPager);
        tabLayout = findViewById(R.id.tabLayout);

        WeatherPagerAdapter adapter = new WeatherPagerAdapter(getSupportFragmentManager());
        viewPager.setAdapter(adapter);

        tabLayout.setupWithViewPager(viewPager);

        setupTabTitles();
    }

    private void setupTabTitles() {

        tabLayout.getTabAt(0).setText(getString(R.string.paris_france));
        tabLayout.getTabAt(1).setText(getString(R.string.new_york_usa));
        tabLayout.getTabAt(2).setText(getString(R.string.tokyo_japan));
    }

    private class WeatherPagerAdapter extends FragmentPagerAdapter {

        public WeatherPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            switch (position) {
                case 0:

                    return WeatherAndForecastFragment.newInstance(
                            R.string.paris_france,
                            R.string.cloudy,
                            R.layout.paris_fragment_weather
                    );
                case 1:
                    return WeatherAndForecastFragment.newInstance(
                            R.string.new_york_usa,
                            R.string.sunny,
                            R.layout.newyork_fragment_weather
                    );
                case 2:
                    return WeatherAndForecastFragment.newInstance(
                            R.string.tokyo_japan,
                            R.string.rainy,
                            R.layout.tokyo_fragment_weather
                    );
                default:
                    return null;
            }
        }

        @Override
        public int getCount() {
            return 3;
        }

        @Nullable
        @Override
        public CharSequence getPageTitle(int position) {
            return null;
        }
    }
}
