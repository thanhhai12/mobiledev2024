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
    private int layoutResource;


    public static WeatherFragment newInstance(String location, String weatherCondition, int layoutResource) {
        WeatherFragment fragment = new WeatherFragment();
        Bundle args = new Bundle();
        args.putString("location", location);
        args.putString("weatherCondition", weatherCondition);
        args.putInt("layoutResource", layoutResource);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        if (getArguments() != null) {
            location = getArguments().getString("location");
            weatherCondition = getArguments().getString("weatherCondition");
            layoutResource = getArguments().getInt("layoutResource");
        }


        View view = inflater.inflate(layoutResource, container, false);

        TextView locationTextView = view.findViewById(R.id.weather_location);
        TextView conditionTextView = view.findViewById(R.id.weather_condition);
        TextView temperatureTextView = view.findViewById(R.id.weather_temperature);

        locationTextView.setText(location);
        conditionTextView.setText(weatherCondition);

        return view;
    }
}
