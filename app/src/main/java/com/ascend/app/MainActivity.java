package com.ascend.app;

import android.Manifest;
import android.app.Activity;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.view.Gravity;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import java.util.Locale;

public class MainActivity extends Activity {
    @Override public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        createChannel();
        if (Build.VERSION.SDK_INT >= 33 && checkSelfPermission(Manifest.permission.POST_NOTIFICATIONS) != PackageManager.PERMISSION_GRANTED)
            requestPermissions(new String[]{Manifest.permission.POST_NOTIFICATIONS}, 701);

        LinearLayout root = new LinearLayout(this);
        root.setOrientation(LinearLayout.VERTICAL);
        root.setPadding(28, 28, 28, 28);
        root.setGravity(Gravity.CENTER_HORIZONTAL);
        root.setBackgroundColor(0xFF0A0A0C);

        TextView brand = new TextView(this);
        brand.setText("ASCEND"); brand.setTextSize(28); brand.setTextColor(0xFFFFFFFF);
        root.addView(brand);
        TextView sub = new TextView(this);
        sub.setText("DISCIPLINE • SCHEDULE • EXECUTION"); sub.setTextColor(0xFF9999A3);
        root.addView(sub);

        Button add = new Button(this); add.setText("+ ADD SCHEDULE");
        add.setOnClickListener(v -> ScheduleEngine.speakNow(this, "ASCEND schedule editor is ready."));
        root.addView(add);
        Button voice = new Button(this); voice.setText("TEST VOICE");
        voice.setOnClickListener(v -> ScheduleEngine.speakNow(this, "Yo! This is an ASCEND voice test. Lock in."));
        root.addView(voice);

        TextView status = new TextView(this);
        status.setText("v0.4.0 • Schedule + voice prototype"); status.setTextColor(0xFFB8B8C0);
        root.addView(status);
        setContentView(new ScrollView(this) {{ addView(root); }});
    }

    private void createChannel() {
        if (Build.VERSION.SDK_INT >= 26) {
            NotificationChannel c = new NotificationChannel("ascend_schedule", "ASCEND Schedule", NotificationManager.IMPORTANCE_HIGH);
            c.setDescription("Scheduled ASCEND alerts");
            ((NotificationManager)getSystemService(NOTIFICATION_SERVICE)).createNotificationChannel(c);
        }
    }
}
