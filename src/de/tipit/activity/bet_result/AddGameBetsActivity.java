package de.tipit.activity.bet_result;

import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ListView;
import de.tipit.R;
import de.tipit.R.id;
import de.tipit.helper.IntentData;
import de.tipit.helper.Messenger;
import de.tipit.server.transfer.data.GameDataResultTO;

public class AddGameBetsActivity extends Activity { // doesn't have a menu

    private final Messenger messenger = new Messenger(this);

    private void inspireGameBetsButton() {
        Button gameBetsButton = (Button) findViewById(+id.gameBetsButton);
        gameBetsButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View arg0) {
                messenger.showFeatureNotImplementedError();
            }
        });
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_game_bets);

        @SuppressWarnings("unchecked")
        final List<GameDataResultTO> data = (List<GameDataResultTO>) IntentData.getInstance().getLastData();
        final AddGameBetsMatchDayListAdapter listAdapter = new AddGameBetsMatchDayListAdapter(this, data);

        ListView gameBetMatchDayListView = (ListView) findViewById(+id.gameBets);
        gameBetMatchDayListView.setAdapter(listAdapter);

        this.inspireGameBetsButton();
    }
}
