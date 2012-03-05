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
import de.tipit.helper.Messenger;
import de.tipit.helper.SessionContainer;
import de.tipit.helper.Transfer;
import de.tipit.server.transfer.access.GeneralError;
import de.tipit.server.transfer.data.ContextTO;
import de.tipit.server.transfer.data.LoginParameterTO;
import de.tipit.server.transfer.data.SessionTO;
import de.tipit.server.transfer.data.UserAccountTO;

public class LoginActivity extends Activity {

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
        return Transfer.getInstance().getUserSessionTransfer().doLogin(context, userAccount, loginParameter);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
        Button loginButton = (Button) findViewById(+id.loginButton);
        loginButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View arg0) {
                final String userName = ((EditText) findViewById(+id.usernameInput)).getText().toString();
                final String password = ((EditText) findViewById(+id.passwordInput)).getText().toString();

                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            SessionContainer.setSession(LoginActivity.doLogin(LoginActivity.this.getApplicationContext(), userName, password));
                            if (SessionContainer.hasSession()) {
                                LoginActivity.this.runOnUiThread(new Runnable() {
                                    @Override
                                    public void run() {
                                        final String welcomeString = LoginActivity.this.getString(R.string.welcome);
                                        messenger.showInfo(welcomeString + " '" + SessionContainer.getSession().getUserName() + "' ...");
                                        startActivity(new Intent(LoginActivity.this, OverviewActivity.class));
                                    }
                                });
                            }
                        } catch (GeneralError error) {
                            LoginActivity.this.messenger.showError(error);
                        } catch (RuntimeException exc) {
                            LoginActivity.this.messenger.showError(exc);
                        }
                    }
                }).start();
            }
        });
    }
}
