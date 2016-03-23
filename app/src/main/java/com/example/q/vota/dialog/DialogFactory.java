package com.example.q.vota.dialog;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;

import com.example.q.vota.framework.ApplicationContext;

/**
 * Created by Q on 3/22/16.
 */
public class DialogFactory {

    public void showAlertDialog(Context context, String title, String message,
                                String positiveButtonName, final Runnable positiveClickListener,
                                String negativeButtonName, final Runnable negativeClickListener,
                                String neutralButtonName, final Runnable neutralClickListener){
        final AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(context);
        if (title != null){
            dialogBuilder.setTitle(title);
        }
        dialogBuilder.setMessage(message);

        if (positiveButtonName != null){
            dialogBuilder.setPositiveButton(positiveButtonName, new DialogInterface.OnClickListener(){
                public void onClick(DialogInterface dialog, int arg1) {
                    dialog.dismiss();
                    if (positiveClickListener != null) { positiveClickListener.run(); }
                }
            });
        }

        if (negativeButtonName != null){
            dialogBuilder.setNegativeButton(negativeButtonName, new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int arg1) {
                    dialog.dismiss();
                    if (negativeClickListener != null) {
                        negativeClickListener.run();
                    }
                }
            });
        }

        if (neutralButtonName != null){
            dialogBuilder.setNeutralButton(negativeButtonName, new DialogInterface.OnClickListener(){
                public void onClick(DialogInterface dialog, int arg1) {
                    dialog.dismiss();
                    if (neutralClickListener != null)  {  neutralClickListener.run(); }
                }
            });
        }

        dialogBuilder.show();
    }
}