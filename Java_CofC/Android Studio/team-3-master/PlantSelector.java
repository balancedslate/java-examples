package com.example.notificationtest;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.Spinner;
import android.widget.Toast;

public class PlantSelector extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_plant_selector);

        long untilWater;
        long untilHarvest;
        final String plantName;
        int selectedPlant = 0;
        int daysToMS = 86400000;

        final long[] dateHarvested = new long[1];

        PlantArray plantChoice = new PlantArray();

        plantName = plantChoice.getDefaultArray().get(selectedPlant).getName();
        untilHarvest = plantChoice.getDefaultArray().get(selectedPlant).getUntilHarvest();
        untilWater = plantChoice.getDefaultArray().get(selectedPlant).getUntilWater();

        final long untilH = untilHarvest * daysToMS;
        final long untilW = untilWater * daysToMS;

        NotificationHelper notificationHelper = new NotificationHelper(PlantSelector.this);
        notificationHelper.createNotificationChannel();

        Spinner spinner = (Spinner) findViewById(R.id.spinner);
        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.plants_array, android.R.layout.simple_spinner_item);
        // Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner
        spinner.setAdapter(adapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                //
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                //
            }
        });

        CalendarView calender = findViewById(R.id.calendarView);
        calender.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView calendarView, int i, int i1, int i2) {
                dateHarvested[0] = calender.getDate();
                long until_harvest = dateHarvested[0] + untilH;
                long until_water = dateHarvested[0] + untilW;
                // Take out immediate notification
                Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    public void run() {
                        harvestNotification(plantName, notificationHelper, until_harvest);
                    }
                }, 3000);
                waterNotification(plantName, notificationHelper, until_water);
            }
        });

        Button gardenButton = findViewById(R.id.garden);
        gardenButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent nextActivity = new Intent(PlantSelector.this, MainActivity.class);
                startActivity(nextActivity);
            }
        });
    }

    public void waterNotification(String plantName, NotificationHelper notificationHelper, long until_water){
        Intent intent = new Intent(PlantSelector.this, NotificationHelper.class);
        intent.putExtra("Title", "Water!");
        intent.putExtra("Description", "Friendly reminder to water your " + plantName + " :)");
        intent.putExtra("id", System.currentTimeMillis());

        PendingIntent pendingIntent = PendingIntent.getBroadcast(PlantSelector.this, 0, intent, 0);

        notificationHelper.createAlarmManager(until_water, pendingIntent);

        Toast toast = Toast.makeText(PlantSelector.this, "Time to water your " + plantName + "s in " + until_water + " milliseconds", Toast.LENGTH_LONG);
        toast.show();
    }

    public void harvestNotification(String plantName, NotificationHelper notificationHelper, long until_harvest){
        Intent intent = new Intent(PlantSelector.this, NotificationHelper.class);
        intent.putExtra("Title", "Harvest!");
        intent.putExtra("Description", "Time to harvest your " + plantName + "! :)");
        intent.putExtra("id", System.currentTimeMillis());

        PendingIntent pendingIntent = PendingIntent.getBroadcast(PlantSelector.this, 0, intent, 0);

        notificationHelper.createAlarmManager(until_harvest, pendingIntent);

        Toast toast = Toast.makeText(PlantSelector.this, "Time to harvest your " + plantName + "s in " + until_harvest + " milliseconds!", Toast.LENGTH_LONG);
        toast.show();

    }
}