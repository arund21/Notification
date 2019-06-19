package com.myapplication;

import android.app.Notification;
import android.os.Build;
import android.view.View;
import android.widget.Button;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import createchannel.CreateChannel;

public class MainActivity extends AppCompatActivity{
    private NotificationManagerCompat notificationManagerCompat;

    private Button notification1, notification2;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        notification1 = findViewById(R.id.notification1);
        notification2 = findViewById(R.id.notification2);
        notificationManagerCompat = NotificationManagerCompat.from(this);
        CreateChannel channel = new CreateChannel(this);
        channel.createChannel();

        notification1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DisplayNotification();
            }

        });

        notification2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DisplayNotification2();
            }
        });
    }
    int id=1;
    private void DisplayNotification(){
        Notification notification = new NotificationCompat.Builder(this,CreateChannel.CHANNEL_1)

                .setSmallIcon(R.drawable.ic_notifications_active_black_24dp)
                .setContentTitle("First Message")
                .setContentText("First Message Body")
                .setCategory(NotificationCompat.CATEGORY_MESSAGE)
                .build();
        notificationManagerCompat.notify(id,notification);
        id++;
    }

    private void DisplayNotification2(){
        Notification notification = new NotificationCompat.Builder(this,CreateChannel.CHANNEL_2)
                .setSmallIcon(R.drawable.ic_notifications_active_black_24dp)
                .setContentTitle("Second Message")
                .setContentText("Second Message Body")
                .setCategory(NotificationCompat.CATEGORY_MESSAGE)
                .build();
        notificationManagerCompat.notify(id,notification);
        id++;
    }
}
