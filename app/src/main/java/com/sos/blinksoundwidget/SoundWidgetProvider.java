package com.sos.blinksoundwidget;

import android.app.PendingIntent;
import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.widget.RemoteViews;

public class SoundWidgetProvider extends AppWidgetProvider {
    public static final String ACTION_PLAY_SOUND = "com.sos.blinksoundwidget.PLAY_SOUND";

    @Override
    public void onReceive(Context context, Intent intent) {
        super.onReceive(context, intent);
        if (intent != null && ACTION_PLAY_SOUND.equals(intent.getAction())) {
            SoundPlayer.play(context);
        }
    }

    @Override
    public void onUpdate(Context context, AppWidgetManager appWidgetManager, int[] appWidgetIds) {
        for (int appWidgetId : appWidgetIds) {
            updateWidget(context, appWidgetManager, appWidgetId);
        }
    }

    private static void updateWidget(Context context, AppWidgetManager appWidgetManager, int appWidgetId) {
        RemoteViews views = new RemoteViews(context.getPackageName(), R.layout.widget_sound_button);

        Intent intent = new Intent(context, SoundWidgetProvider.class);
        intent.setAction(ACTION_PLAY_SOUND);

        int flags = PendingIntent.FLAG_UPDATE_CURRENT;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            flags |= PendingIntent.FLAG_IMMUTABLE;
        }

        PendingIntent pendingIntent = PendingIntent.getBroadcast(context, appWidgetId, intent, flags);
        views.setOnClickPendingIntent(R.id.play_button, pendingIntent);

        appWidgetManager.updateAppWidget(appWidgetId, views);
    }
}
