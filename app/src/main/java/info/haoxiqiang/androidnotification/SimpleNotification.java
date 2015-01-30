package info.haoxiqiang.androidnotification;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.TaskStackBuilder;

/**
 * Created by haoxiqiang on 15/1/30.
 */
public class SimpleNotification {

    public static void showNotification(Context context,int mNotificationId){
        NotificationCompat.Builder mBuilder =
                new NotificationCompat.Builder(context)
                        .setSmallIcon(R.mipmap.ic_launcher)
                        .setContentTitle("SimpleNotification")
                        .setAutoCancel(true)
                        .setContentText("Hello World!This is the first notification.");
        NotificationManager mNotifyMgr =
                (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
        mNotifyMgr.notify(mNotificationId, mBuilder.build());
    }

    public static void showNotificationWithBehaviour(Context context,int mNotificationId){

        Intent resultIntent = new Intent(context, ResultActivity.class);
        // Because clicking the notification opens a new ("special") activity, there's
        // no need to create an artificial back stack.
        PendingIntent resultPendingIntent =
                PendingIntent.getActivity(
                        context,
                        0,
                        resultIntent,
                        PendingIntent.FLAG_UPDATE_CURRENT
                );

        notify(context,mNotificationId,resultPendingIntent);
    }

    public static void showNotificationWithParentBehaviour(Context context,int mNotificationId){

        Intent resultIntent = new Intent(context, ParentActivity.class);

        TaskStackBuilder stackBuilder = TaskStackBuilder.create(context);
        // Adds the back stack
        stackBuilder.addParentStack(ParentActivity.class);
        // Adds the Intent to the top of the stack
        stackBuilder.addNextIntent(resultIntent);
        // Gets a PendingIntent containing the entire back stack
        PendingIntent resultPendingIntent =
                stackBuilder.getPendingIntent(0, PendingIntent.FLAG_UPDATE_CURRENT);

        notify(context,mNotificationId,resultPendingIntent);
    }

    public static void showNotificationWithNewTask(Context context,int mNotificationId){
        // Creates an Intent for the Activity
        Intent notifyIntent = new Intent();
        notifyIntent.setComponent(new ComponentName(context,NewTaskActivity.class));
        // Sets the Activity to start in a new, empty task
        notifyIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK |
                Intent.FLAG_ACTIVITY_CLEAR_TASK);
        // Creates the PendingIntent
        PendingIntent notifyPendingIntent =
                PendingIntent.getActivity(
                        context,
                        0,
                        notifyIntent,
                        PendingIntent.FLAG_UPDATE_CURRENT
                );

        notify(context,mNotificationId,notifyPendingIntent);
    }


    public static void showNotificationWithBigViews(Context context,int mNotificationId){

        // Creates an Intent for the Activity
        Intent notifyIntent = new Intent();
        notifyIntent.setComponent(new ComponentName(context,NewTaskActivity.class));
        // Sets the Activity to start in a new, empty task
        notifyIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK |
                Intent.FLAG_ACTIVITY_CLEAR_TASK);
        // Creates the PendingIntent
        PendingIntent notifyPendingIntent =
                PendingIntent.getActivity(
                        context,
                        0,
                        notifyIntent,
                        PendingIntent.FLAG_UPDATE_CURRENT
                );

        // Constructs the Builder object.
        NotificationCompat.Builder mBuilder =
                new NotificationCompat.Builder(context)
                        .setSmallIcon(R.mipmap.ic_launcher)
                        .setContentTitle("Title")
                        .setContentText("Content")
                        .setContentIntent(notifyPendingIntent)
                        .setAutoCancel(true)
                        .setDefaults(Notification.DEFAULT_ALL) // requires VIBRATE permission
                        .setStyle(new NotificationCompat.BigTextStyle().setBigContentTitle("BigContentTitle").setSummaryText("SummaryTextSummaryText")
                                .bigText("I'm a big text message"))
                        .addAction (R.drawable.ic_stat_dismiss,"dismiss",notifyPendingIntent)
                        .addAction (R.drawable.ic_stat_snooze,
                                "snooze", notifyPendingIntent);
        NotificationManager mNotifyMgr =
                (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
        mNotifyMgr.notify(mNotificationId, mBuilder.build());
    }
    public static void showNotificationWithBigPictureStyle(Context context,int mNotificationId){

        // Creates an Intent for the Activity
        Intent notifyIntent = new Intent();
        notifyIntent.setComponent(new ComponentName(context,NewTaskActivity.class));
        // Sets the Activity to start in a new, empty task
        notifyIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK |
                Intent.FLAG_ACTIVITY_CLEAR_TASK);
        // Creates the PendingIntent
        PendingIntent notifyPendingIntent =
                PendingIntent.getActivity(
                        context,
                        0,
                        notifyIntent,
                        PendingIntent.FLAG_UPDATE_CURRENT
                );

        BitmapDrawable bitmapDrawable= (BitmapDrawable) context.getDrawable(R.drawable.hashmap01);

        // Constructs the Builder object.
        NotificationCompat.Builder mBuilder =
                new NotificationCompat.Builder(context)
                        .setSmallIcon(R.mipmap.ic_launcher)
                        .setContentTitle("Title")
                        .setContentText("Content")
                        .setContentIntent(notifyPendingIntent)
                        .setAutoCancel(true)
                        .setDefaults(Notification.DEFAULT_ALL) // requires VIBRATE permission
                        .setLargeIcon(bitmapDrawable.getBitmap())
                        .setStyle(new NotificationCompat.BigPictureStyle()
                                .setBigContentTitle("BigContentTitle")
                                .setSummaryText("SummaryTextSummaryText")
                                .bigPicture(bitmapDrawable.getBitmap()))
                        .addAction (R.drawable.ic_stat_dismiss,"dismiss",notifyPendingIntent)
                        .addAction (R.drawable.ic_stat_snooze,
                                "snooze", notifyPendingIntent);
        NotificationManager mNotifyMgr =
                (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
        mNotifyMgr.notify(mNotificationId, mBuilder.build());
    }
    public static void showNotificationWithInboxStyle(Context context,int mNotificationId){

        // Creates an Intent for the Activity
        Intent notifyIntent = new Intent();
        notifyIntent.setComponent(new ComponentName(context,NewTaskActivity.class));
        // Sets the Activity to start in a new, empty task
        notifyIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK |
                Intent.FLAG_ACTIVITY_CLEAR_TASK);
        // Creates the PendingIntent
        PendingIntent notifyPendingIntent =
                PendingIntent.getActivity(
                        context,
                        0,
                        notifyIntent,
                        PendingIntent.FLAG_UPDATE_CURRENT
                );

        BitmapDrawable bitmapDrawable= (BitmapDrawable) context.getDrawable(R.drawable.hashmap01);

        // Constructs the Builder object.
        NotificationCompat.Builder mBuilder =
                new NotificationCompat.Builder(context)
                        .setSmallIcon(R.mipmap.ic_launcher)
                        .setContentTitle("Title")
                        .setContentText("Content")
                        .setContentIntent(notifyPendingIntent)
                        .setAutoCancel(true)
                        .setDefaults(Notification.DEFAULT_ALL) // requires VIBRATE permission
                        .setStyle(new NotificationCompat.InboxStyle()
                                .setBigContentTitle("BigContentTitle")
                                .setSummaryText("SummaryTextSummaryText")
                                .addLine("aaaaaaaaaaaaaaaaa")
                                .addLine("bbbbbbbbbbbbbbbbb")
                                .addLine("ccccccccccccccccc")
                                .addLine("ddddddddddddddddd")
                        )
                        .addAction (R.drawable.ic_stat_dismiss,"dismiss",notifyPendingIntent)
                        .addAction (R.drawable.ic_stat_snooze,
                                "snooze", notifyPendingIntent);
        NotificationManager mNotifyMgr =
                (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
        mNotifyMgr.notify(mNotificationId, mBuilder.build());
    }

    private static void notify(Context context, int mNotificationId, PendingIntent resultPendingIntent) {
        NotificationCompat.Builder mBuilder =
                new NotificationCompat.Builder(context)
                        .setSmallIcon(R.mipmap.ic_launcher)
                        .setContentTitle("SimpleNotification")
                        .setContentText("Hello World!This is the first notification.")
                        .setNumber(20)
                        .setAutoCancel(true)
                        .setContentIntent(resultPendingIntent);
        NotificationManager mNotifyMgr =
                (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
        mNotifyMgr.notify(mNotificationId, mBuilder.build());
    }
}
