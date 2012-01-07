package de.tipit;

import de.tipit.R.id;
import android.app.Activity;
import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.Spinner;

public class MatchTipActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.match_tipp);
		LinearLayout layout = (LinearLayout) findViewById(+id.MatchTipLayout);

		Spinner matchDays = (Spinner) findViewById(+id.MatchDay);
		matchDays.setAdapter(new MatchDaysAdapter(this));
		
		MatchViewList matchViewList = new MatchViewList(this);
		MatchesAdapter matchAdapter = new MatchesAdapter(this);
		matchViewList.setAdapter(matchAdapter);

		layout.addView(matchViewList);
		
	}
}