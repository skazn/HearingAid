package com.activities.rloken.hearingaid;

import android.content.ComponentName;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class Home extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        Intent deviceDetectionIntent = new Intent(this, HardwareDetectionService.class);

        //String pkg = "com.hardware.rloken.hearingaid";
        //String cls = "com.activities.rloken.hearingaid.HardwareDetectionService";
        //deviceDetectionIntent.setComponent(new ComponentName(pkg, cls));
        CharSequence text = "app staring.";
        Toast.makeText(getApplicationContext(), text, Toast.LENGTH_SHORT).show();
        startService(deviceDetectionIntent);
    }
}
