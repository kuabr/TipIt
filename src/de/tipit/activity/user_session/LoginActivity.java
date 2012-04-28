package de.tipit.activity.user_session;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import de.tipit.R;
import de.tipit.R.id;
import de.tipit.activity.OverviewActivity;
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

    private static SessionTO doLogin(String userName, String password) throws GeneralError {
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

    private void inspireLoginButton() {
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
                            SessionContainer.setSession(LoginActivity.doLogin(userName, password));
                            if (SessionContainer.hasSession()) {
                                LoginActivity.this.runOnUiThread(new Runnable() {
                                    @Override
                                    public void run() {
                                        final String welcomeString = LoginActivity.this.getString(R.string.welcome);
                                        messenger.showInfo(welcomeString + " '" + SessionContainer.getSession().getUserName() + "' !!!");
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

    private void handleRegisterClick() {
        messenger.showFeatureNotImplementedError();
    }

    private void handleGuestClick() {
        messenger.showFeatureNotImplementedError();
    }

    private void handlePasswordForgottenClick() {
        messenger.showFeatureNotImplementedError();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        this.inspireLoginButton();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.login_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
        case R.id.registerItem:
            this.handleRegisterClick();
            return true;
        case R.id.guestItem:
            this.handleGuestClick();
            return true;
        case R.id.passwordForgottenItem:
            this.handlePasswordForgottenClick();
            return true;
        default:
            return super.onOptionsItemSelected(item);
        }
    }
}
