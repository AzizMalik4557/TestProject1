package com.example.aziz.testapplication;


import android.content.Context;
import android.content.DialogInterface;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.ConnectivityManager;
import android.os.Build;
import android.support.v7.app.AlertDialog;
import android.util.Base64;
import android.util.Log;
import android.widget.ImageView;



import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class Util {


    public static AlertDialog.Builder makeAlertBuilder(Context context) {
        AlertDialog.Builder dialog = new AlertDialog.Builder(context);
        dialog.setCancelable(false)
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
        return dialog;
    }

    public static AlertDialog makeAlert(Context context, String title, String message) {
        AlertDialog.Builder dialog = makeAlertBuilder(context);
        if (title != null)
            dialog.setTitle(title);
        dialog.setMessage(message);
        return dialog.create();
    }

    public static AlertDialog makeAlert(Context context, int titleId, int messageId) {
        AlertDialog.Builder dialog = makeAlertBuilder(context);
        if (titleId != 0)
            dialog.setTitle(titleId);
        dialog.setMessage(messageId);
        return dialog.create();
    }

    public static AlertDialog makeAlert(Context context, String title, int messageId) {
        AlertDialog.Builder dialog = makeAlertBuilder(context);
        if (title != null)
            dialog.setTitle(title);
        dialog.setMessage(messageId);
        return dialog.create();
    }

    public static AlertDialog makeAlert(Context context, int titleId, String message) {
        AlertDialog.Builder dialog = makeAlertBuilder(context);
        if (titleId != 0)
            dialog.setTitle(titleId);
        dialog.setMessage(message);
        return dialog.create();
    }

    public static AlertDialog makeAlert(Context context, String message) {
        return makeAlert(context, null, message);
    }

    public static AlertDialog makeAlert(Context context, int messageId) {
        return makeAlert(context, 0, messageId);
    }


    public static boolean isConnected(Context context) {
        try {
            ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
            return cm.getActiveNetworkInfo() != null && cm.getActiveNetworkInfo().isAvailable() && cm.getActiveNetworkInfo().isConnected();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }



}