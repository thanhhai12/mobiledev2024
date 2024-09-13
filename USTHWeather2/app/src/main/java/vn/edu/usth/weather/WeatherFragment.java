package vn.edu.usth.weather;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class WeatherFragment extends Fragment {

    private int locationResId;
    private int weatherConditionResId;
    private int layoutResource;

    public static WeatherFragment newInstance(int locationResId, int weatherConditionResId, int layoutResource) {
        WeatherFragment fragment = new WeatherFragment();
        Bundle args = new Bundle();
        args.putInt("locationResId", locationResId);
        args.putInt("weatherConditionResId", weatherConditionResId);
        args.putInt("layoutResource", layoutResource);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        if (getArguments() != null) {
            locationResId = getArguments().getInt("locationResId");
            weatherConditionResId = getArguments().getInt("weatherConditionResId");
            layoutResource = getArguments().getInt("layoutResource");
        }

        View view = inflater.inflate(layoutResource, container, false);

        TextView locationTextView = view.findViewById(R.id.weather_location);
        TextView conditionTextView = view.findViewById(R.id.weather_condition);
        TextView temperatureTextView = view.findViewById(R.id.weather_temperature);

        locationTextView.setText(getString(locationResId));
        conditionTextView.setText(getString(weatherConditionResId));

        return view;
    }
}
