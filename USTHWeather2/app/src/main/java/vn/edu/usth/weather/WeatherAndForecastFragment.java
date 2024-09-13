package vn.edu.usth.weather;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class WeatherAndForecastFragment extends Fragment {

    private int locationResId;
    private int weatherConditionResId;
    private int weatherLayoutResource;


    public static WeatherAndForecastFragment newInstance(int locationResId, int weatherConditionResId, int layoutResource) {
        WeatherAndForecastFragment fragment = new WeatherAndForecastFragment();
        Bundle args = new Bundle();
        args.putInt("locationResId", locationResId);
        args.putInt("weatherConditionResId", weatherConditionResId);
        args.putInt("layoutResource", layoutResource);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_weather_and_forecast, container, false);

        if (getArguments() != null) {
            locationResId = getArguments().getInt("locationResId");
            weatherConditionResId = getArguments().getInt("weatherConditionResId");
            weatherLayoutResource = getArguments().getInt("layoutResource");
        }

        FragmentManager fragmentManager = getChildFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();


        WeatherFragment weatherFragment = WeatherFragment.newInstance(locationResId, weatherConditionResId, weatherLayoutResource);
        transaction.replace(R.id.weather_container, weatherFragment);

        transaction.replace(R.id.forecast_container, new ForecastFragment());

        transaction.commit();

        return view;
    }
}
