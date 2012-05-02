package de.tipit.activity.bet_result;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;
import de.tipit.R;
import de.tipit.R.id;
import de.tipit.server.transfer.data.GameDataResultTO;

public class AddGameBetsMatchDayListAdapter extends BaseAdapter {

    private final Context context;

    private final List<List<GameDataResultTO>> data = new ArrayList<List<GameDataResultTO>>();

    private void setData(List<GameDataResultTO> originalData) {
        GameDataResultTO last = null;
        for (GameDataResultTO next : originalData) {
            if (last == null || last.getMatchDayDescr().getTechId() != next.getMatchDayDescr().getTechId()) {
                this.data.add(new ArrayList<GameDataResultTO>());
            }

            this.data.get(this.data.size() - 1).add(next);
            last = next;
        }
    }

    public AddGameBetsMatchDayListAdapter(final Context context, final List<GameDataResultTO> data) {
        this.context = context;
        this.setData(data);
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
        return this.data.get(position).get(0).getMatchDayDescr().getTechId();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.add_game_bets_match_day, null);
        }

        TextView gameBetMatchDayDescrText = (TextView) convertView.findViewById(+id.gameBetsMatchDayDescr);
        ListView gameBetMatchDayListView = (ListView) convertView.findViewById(+id.gameBetsMatchDayList);

        List<GameDataResultTO> item = this.data.get(position);
        gameBetMatchDayDescrText.setText(item.get(0).getMatchDayDescr().getDisplayDescr());
        gameBetMatchDayListView.setAdapter(new AddGameBetsGameListAdapter(context, item));

        return convertView;
    }
}
