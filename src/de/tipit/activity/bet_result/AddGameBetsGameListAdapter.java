package de.tipit.activity.bet_result;

import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import de.tipit.R;
import de.tipit.R.id;
import de.tipit.server.transfer.data.GameDataResultTO;

public class AddGameBetsGameListAdapter extends BaseAdapter {

    private final Context context;

    private final List<GameDataResultTO> data;

    public AddGameBetsGameListAdapter(final Context context, final List<GameDataResultTO> data) {
        this.context = context;
        this.data = data;
    }

    @Override
    public int getCount() {
        return this.data.size();
    }

    @Override
    public Object getItem(int position) {
        return this.data.get(position);
    }

    @Override
    public long getItemId(int position) {
        return this.data.get(position).getTechId();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.add_game_bets_game, null);
        }

        TextView gameBetGameNrText = (TextView) convertView.findViewById(+id.gameBetGameNr);
        TextView gameBetGameMatchPointText = (TextView) convertView.findViewById(+id.gameBetGameMatchPoint);
        TextView gameBetHomeTeamText = (TextView) convertView.findViewById(+id.gameBetHomeTeam);
        TextView gameBetAwayTeamText = (TextView) convertView.findViewById(+id.gameBetAwayTeam);

        GameDataResultTO item = this.data.get(position);
        gameBetGameNrText.setText(String.valueOf(item.getGameNumber()));
        gameBetGameMatchPointText.setText(item.getMatchPoint().toLocaleString());
        gameBetHomeTeamText.setText(item.getHomeTeamName().getDisplayName());
        gameBetAwayTeamText.setText(item.getAwayTeamName().getDisplayName());

        return convertView;
    }
}
