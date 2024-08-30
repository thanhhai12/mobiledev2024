package vn.edu.usth.weather;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class ForecastFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        LinearLayout linearLayout = new LinearLayout(getContext());
        linearLayout.setOrientation(LinearLayout.VERTICAL);


        TextView textView = new TextView(getContext());
        textView.setText("Thursday:");
        textView.setTextSize(35);
        textView.setTextColor(0xFF000000);
        textView.setPadding(16, 16, 16, 16);


        ImageView imageView = new ImageView(getContext());
        imageView.setPadding(100, 0, 0, 0);
        imageView.setImageResource(R.drawable.cloudy_1);

        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
        );
        imageView.setLayoutParams(layoutParams);

        linearLayout.addView(textView);
        linearLayout.addView(imageView);


        int backgroundColor = 0xFFFFC0CB;
        linearLayout.setBackgroundColor(backgroundColor);

        return linearLayout;
    }
}
