package com.jedi.navigationdrawerwithfragments;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.graphics.Color;
import android.os.Build;
import android.provider.Settings;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.NotificationManagerCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.support.design.widget.TextInputLayout;

import io.realm.Realm;
import io.realm.RealmResults;


//import static com.jedi.navigationdrawerwithfragments.App.CHANNEL_1_ID;

public class RegisterActivity extends AppCompatActivity {

    private Realm realm;
    private RealmResults<User> userResults;
    private String usuari;
    private String contrasenya;
    Button reg;
    public static final String CHANNEL_1_ID = "channel1";
    private NotificationManagerCompat notificationManager;
    private NotificationManager mNotificationManager;
    private NotificationCompat.Builder mBuilder;
    public static final String NOTIFICATION_CHANNEL_ID = "10001";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        initRealm();
        loadRealmData();
        reg = (Button) findViewById(R.id.button7);
        final TextInputLayout usernameWrapper = (TextInputLayout) findViewById(R.id.usuariWrapper);
        final TextInputLayout passwordWrapper = (TextInputLayout) findViewById(R.id.passwordWrapper);



        reg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                usuari = usernameWrapper.getEditText().getText().toString();
                contrasenya = passwordWrapper.getEditText().getText().toString();
                User u = new User(usuari, contrasenya);
                saveUserToRealm(u);
                NotificationHelper n = new NotificationHelper(getApplicationContext());
                n.createNotification("", "Ususari registrat correctament");
            }
        });
    }

    private void initRealm() {
        Realm.init(getApplicationContext());
        realm = Realm.getDefaultInstance();
    }

    private void loadRealmData() {
        userResults = realm.where(User.class).findAll();
    }

    private void saveUserToRealm(User user) {
        realm.beginTransaction();
        final User person = realm.copyToRealm(user);
        realm.commitTransaction();
        //Log.v("realm", "commitTransaction");
    }
    /*public void sendOnChannel1(View v) {
        String title = "hola";
        String message = "hi";

        Notification notification = new NotificationCompat.Builder(this, CHANNEL_1_ID)
                .setContentTitle(title)
                .setContentText(message)
                .setPriority(NotificationCompat.PRIORITY_HIGH)
                .setCategory(NotificationCompat.CATEGORY_MESSAGE)
                .build();
        notificationManager.notify(1, notification);
    }*/
}
