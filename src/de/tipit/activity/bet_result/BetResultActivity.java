package de.tipit.activity.bet_result;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import de.tipit.R;
import de.tipit.R.id;
import de.tipit.activity.MenuActivity;
import de.tipit.activity.MenuHandler;
import de.tipit.helper.Messenger;

public class BetResultActivity extends MenuActivity {

    private final Messenger messenger = new Messenger(this);

    private final MenuHandler menuDelegate = new MenuHandler(this.messenger, this);

    private void inspireShowTournOverviewButton() {
        Button loginButton = (Button) findViewById(+id.showTournOverviewButton);
        loginButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View arg0) {
                messenger.showFeatureNotImplementedError();
            }
        });
    }

    private void inspireShowLastResultBetsButton() {
        Button loginButton = (Button) findViewById(+id.showLastResultBetsButton);
        loginButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View arg0) {
                messenger.showFeatureNotImplementedError();
            }
        });
    }

    private void inspireAddNextResultBetsButton() {
        Button loginButton = (Button) findViewById(+id.addNextResultBetsButton);
        loginButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View arg0) {
                messenger.showFeatureNotImplementedError();
            }
        });
    }

    private void inspireShowLastWinnerBetsButton() {
        Button loginButton = (Button) findViewById(+id.showLastWinnerBetsButton);
        loginButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View arg0) {
                messenger.showFeatureNotImplementedError();
            }
        });
    }

    private void inspireAddNextWinnerBetsButton() {
        Button loginButton = (Button) findViewById(+id.addNextWinnerBetsButton);
        loginButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View arg0) {
                messenger.showFeatureNotImplementedError();
            }
        });
    }

    private void inspireShowLastResultsButton() {
        Button loginButton = (Button) findViewById(+id.showLastResultsButton);
        loginButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View arg0) {
                messenger.showFeatureNotImplementedError();
            }
        });
    }

    private void inspireAddNextResultsButton() {
        Button loginButton = (Button) findViewById(+id.addNextResultsButton);
        loginButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View arg0) {
                messenger.showFeatureNotImplementedError();
            }
        });
    }

    private void inspireChangeResultsButton() {
        Button loginButton = (Button) findViewById(+id.changeResultsButton);
        loginButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View arg0) {
                messenger.showFeatureNotImplementedError();
            }
        });
    }

    private void inspireAddNextMatchesButton() {
        Button loginButton = (Button) findViewById(+id.addNextMatchesButton);
        loginButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View arg0) {
                messenger.showFeatureNotImplementedError();
            }
        });
    }

    private void inspireChangeMatchesButton() {
        Button loginButton = (Button) findViewById(+id.changeMatchesButton);
        loginButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View arg0) {
                messenger.showFeatureNotImplementedError();
            }
        });
    }

    private void inspireAddNextWinnersButton() {
        Button loginButton = (Button) findViewById(+id.addNextWinnersButton);
        loginButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View arg0) {
                messenger.showFeatureNotImplementedError();
            }
        });
    }

    private void inspireChangeWinnersButton() {
        Button loginButton = (Button) findViewById(+id.changeWinnersButton);
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
        setContentView(R.layout.bet_result);

        this.inspireShowTournOverviewButton();
        this.inspireShowLastResultBetsButton();
        this.inspireAddNextResultBetsButton();
        this.inspireShowLastWinnerBetsButton();
        this.inspireAddNextWinnerBetsButton();
        this.inspireShowLastResultsButton();
        this.inspireAddNextResultsButton();
        this.inspireChangeResultsButton();
        this.inspireAddNextMatchesButton();
        this.inspireChangeMatchesButton();
        this.inspireAddNextWinnersButton();
        this.inspireChangeWinnersButton();
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
