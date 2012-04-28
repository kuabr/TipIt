package de.tipit.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import de.tipit.R;
import de.tipit.R.id;
import de.tipit.activity.bet_result.BetResultActivity;
import de.tipit.helper.Messenger;

public class OverviewActivity extends MenuActivity {

    private final Messenger messenger = new Messenger(this);

    private final MenuHandler menuDelegate = new MenuHandler(this.messenger, this);

    private void inspireBetResultButton() {
        Button loginButton = (Button) findViewById(+id.betResultButton);
        loginButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View arg0) {
                startActivity(new Intent(OverviewActivity.this, BetResultActivity.class));
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

    @Override
    public void showPropertiesDialog() {
        messenger.showFeatureNotImplementedError();
    }

    @Override
    public void showHelp() {
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
        return this.menuDelegate.doCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return this.menuDelegate.onOptionsItemSelected(item);
    }
}
