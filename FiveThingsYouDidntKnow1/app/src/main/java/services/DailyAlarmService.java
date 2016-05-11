package services;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;

import java.util.Date;
import java.util.GregorianCalendar;

/**
 * Created by ליברמן on 11/05/2016.
 */
public class DailyAlarmService extends Service {
    private AlarmManager alarmManager;
    @Override
    public void onCreate() {
        super.onCreate();
        Log.d("starting service!!", "DailyAlarmService");
        Long time = new GregorianCalendar().getTimeInMillis() + 1 * 60 * 1000;
        Intent alarmIntent = new Intent(this, AlarmReceiver.class);
        AlarmManager alarmManager = (AlarmManager) getSystemService(Context.ALARM_SERVICE);
        alarmManager.setRepeating(AlarmManager.RTC_WAKEUP, new Date().getTime(), 60 *1000, PendingIntent.getBroadcast(this, 0, alarmIntent, 0));

    }


    @Nullable
    @Override
    public IBinder onBind(Intent intent) {

        return null;
    }
}
