package de.tipit;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import de.tipit.R.id;
import de.tipit.client.transfer.HttpTransferHandler;
import de.tipit.client.transfer.UserSessionTransfer;
import de.tipit.helper.Messenger;
import de.tipit.server.transfer.access.GeneralError;
import de.tipit.server.transfer.data.ContextTO;
import de.tipit.server.transfer.data.LoginParameterTO;
import de.tipit.server.transfer.data.SessionTO;
import de.tipit.server.transfer.data.UserAccountTO;

public class TipItActivity extends Activity {

    private static String serverAddress = "192.168.0.100"; // TODO: Auslagern in
                                                           // andere View!

    private static int serverPort = 8080; // TODO: Auslagern in andere View!

    private static SessionTO session = new SessionTO(); // TODO: Auslagern in
                                                        // andere Klasse!

    private final Messenger messenger = new Messenger(this);

    private static SessionTO doLogin(Context ac, String userName, String password) throws GeneralError {
        // create transfer objects
        ContextTO context = new ContextTO();
        context.setLanguage(ContextTO.Language.DE);
        UserAccountTO userAccount = new UserAccountTO();
        userAccount.setUserName(userName);
        userAccount.setPassword(password);
        LoginParameterTO loginParameter = new LoginParameterTO();
        loginParameter.setSessionDuration(LoginParameterTO.SessionDuration.DAY);
        loginParameter.setKillOldSessions(false);

        // do invocation
        UserSessionTransfer transfer = new UserSessionTransfer(new HttpTransferHandler(serverAddress, serverPort)); // TODO:
                                                                                                                    // auslagern
        return transfer.doLogin(context, userAccount, loginParameter);
    }

    private static synchronized void setSession(SessionTO session) { // TODO:
                                                                     // Wieder
                                                                     // entfernen!
        TipItActivity.session = session;
    }

    public static synchronized SessionTO getSession() { // TODO: Wieder
                                                        // entfernen!
        return TipItActivity.session;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        Button loginButton = (Button) findViewById(+id.buttonLogin);
        loginButton.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View arg0) {
                final String userName = ((EditText) findViewById(+id.editText1)).getText().toString();
                final String password = ((EditText) findViewById(+id.editText2)).getText().toString();

                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            SessionTO newSession = TipItActivity.doLogin(TipItActivity.this.getApplicationContext(), userName, password);
                            TipItActivity.setSession(newSession);
                            if (session != null) {
                                TipItActivity.this.runOnUiThread(new Runnable() {
                                    @Override
                                    public void run() {
                                        final String welcomeString = TipItActivity.this.getString(R.string.welcome);
                                        messenger.showInfo(welcomeString + " '" + session.getUserName() + "' ...");
                                        startActivity(new Intent(TipItActivity.this, OverviewActivity.class));
                                    }
                                });
                            }
                        } catch (GeneralError error) {
                            TipItActivity.this.messenger.showError(error);
                        } catch (RuntimeException exc) {
                            TipItActivity.this.messenger.showError(exc);
                        }
                    }
                }).start();
            }
        });
    }
}
