package vn.edu.usth.weather;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class ForecastFragment extends Fragment {

    private ListView forecastListView;
    private ForecastAdapter forecastAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_forecast, container, false);

        // Reference the ListView from XML
        forecastListView = (ListView) rootView.findViewById(R.id.forecast_list);

        // Sample data for forecast
        List<WeatherData> weatherDataList = new ArrayList<>();
        weatherDataList.add(new WeatherData("Mon", "Partly Cloudy", "24°C - 31°C", R.drawable.ic_sunny));
        weatherDataList.add(new WeatherData("Tue", "Showers", "26°C - 30°C", R.drawable.ic_rainy));
        weatherDataList.add(new WeatherData("Wed", "Rain", "22°C - 23°C", R.drawable.ic_rainy));
        // Add more weather data as needed...

        // Custom adapter to display forecast data
        ForecastAdapter adapter = new ForecastAdapter(getActivity(), weatherDataList);
        forecastListView.setAdapter(adapter);

        return rootView;
    }

    // Custom class to hold weather data
    public class WeatherData {
        public String day;
        public String condition;
        public String temperature;
        public int iconResId;

        public WeatherData(String day, String condition, String temperature, int iconResId) {
            this.day = day;
            this.condition = condition;
            this.temperature = temperature;
            this.iconResId = iconResId;
        }
    }

    // Custom adapter class to use custom list item layout
    private class ForecastAdapter extends ArrayAdapter<WeatherData> {
        public ForecastAdapter(Context context, List<WeatherData> forecastData) {
            super(context, 0, forecastData);
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            if (convertView == null) {
                convertView = LayoutInflater.from(getContext()).inflate(R.layout.list_item_forecast, parent, false);
            }

            // Get weather data for this position
            WeatherData weatherData = getItem(position);

            // Set weather icon
            ImageView weatherIcon = convertView.findViewById(R.id.weather_icon);
            weatherIcon.setImageResource(weatherData.iconResId);

            // Set day and condition
            TextView dayConditionText = convertView.findViewById(R.id.weather_day_condition);
            dayConditionText.setText(weatherData.day + " - " + weatherData.condition);

            // Set temperature
            TextView temperatureText = convertView.findViewById(R.id.weather_temperature);
            temperatureText.setText(weatherData.temperature);

            return convertView;
        }
    }
}
