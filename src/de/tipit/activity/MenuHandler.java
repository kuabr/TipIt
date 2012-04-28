package de.tipit.activity;

import android.content.Intent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import de.tipit.R;
import de.tipit.activity.user_session.LoginActivity;
import de.tipit.helper.Messenger;
import de.tipit.helper.SessionContainer;
import de.tipit.helper.Transfer;
import de.tipit.server.transfer.access.GeneralError;
import de.tipit.server.transfer.data.ContextTO;
import de.tipit.server.transfer.data.SessionTO;

public class MenuHandler {

    private final Messenger messenger;

    private final MenuActivity activity;

    private static void doLogout(SessionTO session) throws GeneralError {
        if (session != null && session.getSessionId() != null) {
            // create transfer objects
            ContextTO context = new ContextTO();
            context.setLanguage(ContextTO.Language.DE);

            // do invocation
            Transfer.getInstance().getUserSessionTransfer().doLogout(context, session);
        }
    }

    private void handlePropertiesClick() {
        this.activity.showPropertiesDialog();
    }

    private void handleHelpClick() {
        this.activity.showHelp();
    }

    private void handleLogoutClick() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    if (SessionContainer.hasSession()) {
                        MenuHandler.doLogout(SessionContainer.getSession());
                        SessionContainer.setSession(null);
                    }

                    MenuHandler.this.activity.runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            messenger.showInfo(MenuHandler.this.activity.getString(R.string.byebye));
                            MenuHandler.this.activity.startActivity(new Intent(MenuHandler.this.activity, LoginActivity.class));
                        }
                    });
                } catch (GeneralError error) {
                    MenuHandler.this.messenger.showError(error);
                } catch (RuntimeException exc) {
                    MenuHandler.this.messenger.showError(exc);
                }
            }
        }).start();
    }

    public MenuHandler(final Messenger messenger, final MenuActivity activity) {
        this.messenger = messenger;
        this.activity = activity;
    }

    public boolean doCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = this.activity.getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
        case R.id.propertiesItem:
            this.handlePropertiesClick();
            return true;
        case R.id.helpItem:
            this.handleHelpClick();
            return true;
        case R.id.logoutItem:
            this.handleLogoutClick();
            return true;
        default:
            return this.activity.onOptionsItemSelected(item);
        }
    }
}
