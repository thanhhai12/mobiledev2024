package vn.edu.usth.weather;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


public class WeatherFragment extends Fragment {

    private String location;
    private String weatherCondition;

    // Static method to create a new instance with parameters
    public static WeatherFragment newInstance(String location, String weatherCondition) {
        WeatherFragment fragment = new WeatherFragment();
        Bundle args = new Bundle();
        args.putString("location", location);
        args.putString("weatherCondition", weatherCondition);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_weather, container, false);

        // Get arguments
        if (getArguments() != null) {
            location = getArguments().getString("location");
            weatherCondition = getArguments().getString("weatherCondition");
        }

        // Set the location and weather condition in the views
        TextView locationTextView = view.findViewById(R.id.weather_location);
        TextView conditionTextView = view.findViewById(R.id.weather_condition);

        locationTextView.setText(location);
        conditionTextView.setText(weatherCondition);

        return view;
    }
}
