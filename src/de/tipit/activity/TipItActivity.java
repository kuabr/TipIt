package de.tipit.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import de.tipit.R;
import de.tipit.R.id;
import de.tipit.activity.session.LoginActivity;
import de.tipit.helper.Messenger;
import de.tipit.helper.Transfer;

public class TipItActivity extends Activity {

    private final Messenger messenger = new Messenger(this);

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.start);
        Button startButton = (Button) findViewById(+id.startButton);
        startButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View arg0) {
                final String addressStr = ((EditText) findViewById(+id.addressInput)).getText().toString();
                final String portStr = ((EditText) findViewById(+id.portInput)).getText().toString();

                try {
                    Transfer.setInstance(addressStr.trim(), Integer.parseInt(portStr));
                    startActivity(new Intent(TipItActivity.this, LoginActivity.class));
                } catch (NumberFormatException exc) {
                    TipItActivity.this.messenger.showError(getString(R.string.portError));
                }
            }
        });
    }
}
