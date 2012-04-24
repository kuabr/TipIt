package de.tipit.activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import de.tipit.R;
import de.tipit.R.id;
import de.tipit.helper.Messenger;

public class OverviewActivity extends Activity {

    private final Messenger messenger = new Messenger(this);

    private void inspireBetResultButton() {
        Button loginButton = (Button) findViewById(+id.betResultButton);
        loginButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View arg0) {
                messenger.showFeatureNotImplementedError();
            }
        });
    }

    private void inspireAnalysisButton() {
        Button loginButton = (Button) findViewById(+id.analysisButton);
        loginButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View arg0) {
                messenger.showFeatureNotImplementedError();
            }
        });
    }

    private void inspireTournamentAdminButton() {
        Button loginButton = (Button) findViewById(+id.tournamentAdminButton);
        loginButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View arg0) {
                messenger.showFeatureNotImplementedError();
            }
        });
    }

    private void inspireCommunityAdminButton() {
        Button loginButton = (Button) findViewById(+id.communityAdminButton);
        loginButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View arg0) {
                messenger.showFeatureNotImplementedError();
            }
        });
    }

    private void inspireUserSessionButton() {
        Button loginButton = (Button) findViewById(+id.userSessionButton);
        loginButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View arg0) {
                messenger.showFeatureNotImplementedError();
            }
        });
    }

    private void inspireRulesAdminButton() {
        Button loginButton = (Button) findViewById(+id.rulesAdminButton);
        loginButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View arg0) {
                messenger.showFeatureNotImplementedError();
            }
        });
    }

    private void inspireMetaDataAdminButton() {
        Button loginButton = (Button) findViewById(+id.metaDataAdminButton);
        loginButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View arg0) {
                messenger.showFeatureNotImplementedError();
            }
        });
    }

    private void evaluatePropertiesClick() {
        messenger.showFeatureNotImplementedError();
    }

    private void evaluateHelpClick() {
        messenger.showFeatureNotImplementedError();
    }

    private void evaluateLogoutClick() {
        messenger.showFeatureNotImplementedError();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.overview);
        this.inspireBetResultButton();
        this.inspireAnalysisButton();
        this.inspireTournamentAdminButton();
        this.inspireCommunityAdminButton();
        this.inspireUserSessionButton();
        this.inspireRulesAdminButton();
        this.inspireMetaDataAdminButton();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.overview_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
        case R.id.propertiesItem:
            this.evaluatePropertiesClick();
            return true;
        case R.id.helpItem:
            this.evaluateHelpClick();
            return true;
        case R.id.logoutItem:
            this.evaluateLogoutClick();
            return true;
        default:
            return super.onOptionsItemSelected(item);
        }
    }
}
