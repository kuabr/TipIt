package de.tipit;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;

public class MatchesAdapter extends BaseAdapter {

	private Context context;

	private Map<Integer, MatchDay> matches = new HashMap<Integer, MatchDay>();

	public MatchesAdapter(Context context) {
		this.context = context;

		List<Match> mDay1 = new ArrayList<Match>();
		mDay1.add(new Match("Deutschland", "Polen"));
		mDay1.add(new Match("Frankreich", "Niederlande"));
		this.matches.put(1, new MatchDay(1, mDay1));

		List<Match> mDay2 = new ArrayList<Match>();
		mDay2.add(new Match("Spanien", "Portugal"));
		mDay2.add(new Match("Italien", "Kroatien"));
		this.matches.put(2, new MatchDay(2, mDay2));

		List<Match> mDay3 = new ArrayList<Match>();
		mDay3.add(new Match("Schottland", "England"));
		mDay3.add(new Match("Schweden", "Dänemark"));
		this.matches.put(3, new MatchDay(3, mDay3));
	}

	@Override
	public int getCount() {
		return this.matches.get(1).getMatches().size();
	}

	@Override
	public Object getItem(int arg0) {
		return null;
	}

	@Override
	public long getItemId(int arg0) {
		return 0;
	}

	@Override
	public View getView(int day, View convertView, ViewGroup parent) {
		LinearLayout list = new LinearLayout(this.context);
		list.setOrientation(LinearLayout.VERTICAL);
		for (Match match : this.matches.get(day).getMatches()) {
			MatchView matchView = new MatchView(this.context);
			matchView.setFirstTeamName(match.getFirstTeam());
			matchView.setSecondTeamName(match.getSecondTeam());
			list.addView(matchView);
		}
		return list;
	}

}
