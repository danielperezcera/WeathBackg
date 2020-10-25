package com.example.weathbackg;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class ForecastListAdapter extends ArrayAdapter<WeatherForecastItem> {

    private Context mContext;
    int mResource;

    public ForecastListAdapter(@NonNull Context context, int resource, @NonNull List<WeatherForecastItem> objects) {
        super(context, resource, objects);
        this.mContext = context;
        mResource = resource;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        //get the forecast information
        String date = getItem(position).getDateText();
        String measurements = getItem(position).getMeasurements().toString();
        String description = getItem(position).getDescriptions().get(0).getDescription();

        //set the inflater
        LayoutInflater inflater = LayoutInflater.from(mContext);
        convertView = inflater.inflate(mResource, parent, false);

        //get the information to set in the textviews
        TextView tvDate = (TextView) convertView.findViewById(R.id.textView1);
        TextView tvMeasurements = (TextView) convertView.findViewById(R.id.textView2);
        TextView tvDescription = (TextView) convertView.findViewById(R.id.textView3);

        //set the textviews
        tvDate.setText(date);
        tvMeasurements.setText(measurements);
        tvDescription.setText(description);

        return convertView;
    }
}
