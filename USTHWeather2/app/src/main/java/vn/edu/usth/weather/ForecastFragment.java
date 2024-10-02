package vn.edu.usth.weather;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class ForecastFragment extends Fragment {

    private ImageView logoImageView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_forecast, container, false);

        // Find the ImageView in the layout
        logoImageView = rootView.findViewById(R.id.logoImageView);

        // Execute AsyncTask to download and display the image
        new DownloadImageTask(logoImageView).execute("http://ict.usth.edu.vn/wp-content/uploads/usth/usthlogo.png");

        return rootView;
    }

    // AsyncTask to handle the downloading of the image
    private static class DownloadImageTask extends AsyncTask<String, Void, Bitmap> {
        private ImageView imageView;

        public DownloadImageTask(ImageView imageView) {
            this.imageView = imageView;
        }

        @Override
        protected Bitmap doInBackground(String... urls) {
            String url = urls[0];
            Bitmap bitmap = null;

            try {
                // Initialize URL and open a connection
                URL imageUrl = new URL(url);
                HttpURLConnection connection = (HttpURLConnection) imageUrl.openConnection();
                connection.setRequestMethod("GET");
                connection.setDoInput(true);
                connection.connect();

                // Check the response code
                int responseCode = connection.getResponseCode();
                Log.i("USTHWeather", "The response is: " + responseCode);
                if (responseCode == HttpURLConnection.HTTP_OK) {
                    InputStream inputStream = connection.getInputStream();
                    bitmap = BitmapFactory.decodeStream(inputStream);
                }

                // Close the connection
                connection.disconnect();

            } catch (Exception e) {
                e.printStackTrace();
            }

            return bitmap;
        }

        @Override
        protected void onPostExecute(Bitmap result) {
            // Update the ImageView with the downloaded image
            if (result != null) {
                imageView.setImageBitmap(result);
            } else {
                Log.e("USTHWeather", "Failed to download image");
            }
        }
    }
}
