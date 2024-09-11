package vn.edu.usth.weather;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class WeatherAndForecastFragment extends Fragment {

    private String location;
    private String weatherCondition;

    public static WeatherAndForecastFragment newInstance(String location, String weatherCondition) {
        WeatherAndForecastFragment fragment = new WeatherAndForecastFragment();
        Bundle args = new Bundle();
        args.putString("location", location);
        args.putString("weatherCondition", weatherCondition);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_weather_and_forecast, container, false);


        if (getArguments() != null) {
            location = getArguments().getString("location");
            weatherCondition = getArguments().getString("weatherCondition");
        }


        FragmentManager fragmentManager = getChildFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();

        WeatherFragment weatherFragment = WeatherFragment.newInstance(location, weatherCondition);
        transaction.replace(R.id.weather_container, weatherFragment);

        transaction.replace(R.id.forecast_container, new ForecastFragment());

        transaction.commit();

        return view;
    }
}
