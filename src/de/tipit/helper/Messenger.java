package de.tipit.helper;

import android.app.Activity;
import android.widget.Toast;
import de.tipit.R;
import de.tipit.server.transfer.access.GeneralError;

public class Messenger {

    protected final Activity activity;

    public Messenger(final Activity activity) {
        this.activity = activity;
    }

    public void showError(final GeneralError error) {
        final String errorString = activity.getString(R.string.error);

        activity.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                Toast toast = Toast.makeText(activity.getApplicationContext(), errorString + ": " + error.getMessage(), Toast.LENGTH_LONG);
                toast.show();
            }
        });
    }

    public void showError(final RuntimeException exc) {
        activity.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                Toast toast = Toast.makeText(activity.getApplicationContext(), exc.getClass().getName() + " => " + exc.getMessage(), Toast.LENGTH_LONG);
                toast.show();
            }
        });
    }

    public void showInfo(final String message) {
        activity.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                Toast toast = Toast.makeText(activity.getApplicationContext(), message, Toast.LENGTH_LONG);
                toast.show();
            }
        });
    }
}
