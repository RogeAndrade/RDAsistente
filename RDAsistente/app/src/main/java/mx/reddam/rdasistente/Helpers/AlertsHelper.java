package mx.reddam.rdasistente.Helpers;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Build;
import android.support.v7.app.AlertDialog;
import android.util.Log;
import android.view.ContextThemeWrapper;

import mx.reddam.rdasistente.Interfaces.IAlertAccept;
import mx.reddam.rdasistente.R;

/**
 * Created by Rogelio Andrade on 07/09/2018.
 */

public class AlertsHelper {

    public static void showSimpleAlert(Context activity, int message){
        try{
            AlertDialog.Builder builder = new AlertDialog.Builder(activity);
            builder.setMessage(message);
            builder.setPositiveButton(R.string.acceptar, new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int id) {
                    // User clicked OK button
                }
            });
            AlertDialog dialog = builder.create();
            dialog.show();
        }catch (Exception ex){
            Log.e("AlertsHelper", "Error en showSimpleAlert: "+ex.getMessage());
        }
    }

    public static void showAlertWithAction(Context activity, String message, String title, final IAlertAccept listener){
        try{
            AlertDialog.Builder builder; //= new AlertDialog.Builder(new ContextThemeWrapper(activity, R.style.AlertDialogCustom));
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                builder = new AlertDialog.Builder(activity, R.style.ThemeDialog);
            } else {
                builder = new AlertDialog.Builder(activity, R.style.ThemeDialog);
            }
            builder.setMessage(message);
            builder.setCancelable(false);
            builder.setTitle(title);
            builder.setPositiveButton(R.string.acceptar, new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int id) {
                    listener.acceptAlert();
                }
            });
            AlertDialog dialog = builder.create();
            dialog.show();
        }catch (Exception ex){
            Log.e("AlertsHelper", "Error en showSimpleAlert: "+ex.getMessage());
        }
    }
}
