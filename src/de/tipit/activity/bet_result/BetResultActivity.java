package de.tipit.activity.bet_result;

import java.util.Date;
import java.util.List;

import android.content.Intent;
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
import de.tipit.helper.DateTimeCalc;
import de.tipit.helper.IntentData;
import de.tipit.helper.Messenger;
import de.tipit.helper.SessionContainer;
import de.tipit.helper.Transfer;
import de.tipit.server.transfer.access.GeneralError;
import de.tipit.server.transfer.data.ContextTO;
import de.tipit.server.transfer.data.GameDataResultTO;
import de.tipit.server.transfer.data.PeriodTO;

public class BetResultActivity extends MenuActivity {

    private static final long NR_OF_DAYS_FOR_BET_PERIOD = 7L;

    private final Messenger messenger = new Messenger(this);

    private final MenuHandler menuDelegate = new MenuHandler(this.messenger, this);

    private static List<GameDataResultTO> getGamesWithMissingBetForPeriod(long nrOfDaysForBetPeriod) throws GeneralError {
        // create transfer objects
        ContextTO context = new ContextTO();
        context.setLanguage(ContextTO.Language.DE);
        PeriodTO period = new PeriodTO();
        Date currentDate = new Date();
        period.setFirst(currentDate);
        period.setLast(DateTimeCalc.addDaysToDate(currentDate, nrOfDaysForBetPeriod));

        // do invocation
        return Transfer.getInstance().getBetResultTransfer().getGamesWithMissingBetForPeriod(context, SessionContainer.getSession(), period);
    }

    private void inspireShowTournOverviewButton() {
        Button loginButton = (Button) findViewById(+id.showTournOverviewButton);
        loginButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View arg0) {
                messenger.showFeatureNotImplementedError();
            }
        });
    }

    private void inspireShowGameBetsButton() {
        Button loginButton = (Button) findViewById(+id.showGameBetsButton);
        loginButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View arg0) {
                messenger.showFeatureNotImplementedError();
            }
        });
    }

    private void inspireAddGameBetsButton() {
        Button loginButton = (Button) findViewById(+id.addGameBetsButton);
        loginButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View arg0) {
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            final List<GameDataResultTO> data = BetResultActivity.getGamesWithMissingBetForPeriod(NR_OF_DAYS_FOR_BET_PERIOD);
                            BetResultActivity.this.runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    IntentData.getInstance().setNextData(data);
                                    startActivity(new Intent(BetResultActivity.this, AddGameBetsActivity.class));
                                }
                            });
                        } catch (GeneralError error) {
                            BetResultActivity.this.messenger.showError(error);
                        } catch (RuntimeException exc) {
                            BetResultActivity.this.messenger.showError(exc);
                        }
                    }
                }).start();
            }
        });
    }

    private void inspireShowWinnerBetsButton() {
        Button loginButton = (Button) findViewById(+id.showWinnerBetsButton);
        loginButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View arg0) {
                messenger.showFeatureNotImplementedError();
            }
        });
    }

    private void inspireAddWinnerBetsButton() {
        Button loginButton = (Button) findViewById(+id.addWinnerBetsButton);
        loginButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View arg0) {
                messenger.showFeatureNotImplementedError();
            }
        });
    }

    private void inspireShowResultsButton() {
        Button loginButton = (Button) findViewById(+id.showResultsButton);
        loginButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View arg0) {
                messenger.showFeatureNotImplementedError();
            }
        });
    }

    private void inspireAddResultsButton() {
        Button loginButton = (Button) findViewById(+id.addResultsButton);
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

    private void inspireAddMatchesButton() {
        Button loginButton = (Button) findViewById(+id.addMatchesButton);
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

    private void inspireAddWinnersButton() {
        Button loginButton = (Button) findViewById(+id.addWinnersButton);
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
        this.inspireShowGameBetsButton();
        this.inspireAddGameBetsButton();
        this.inspireShowWinnerBetsButton();
        this.inspireAddWinnerBetsButton();
        this.inspireShowResultsButton();
        this.inspireAddResultsButton();
        this.inspireChangeResultsButton();
        this.inspireAddMatchesButton();
        this.inspireChangeMatchesButton();
        this.inspireAddWinnersButton();
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
