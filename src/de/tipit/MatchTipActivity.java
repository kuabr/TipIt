package de.tipit;

import de.tipit.R.id;
import android.app.Activity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.Spinner;

public class MatchTipActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.match_tipp);
		Spinner matchDays = (Spinner) findViewById(+id.MatchDay);
		matchDays.setAdapter(new MatchDaysAdapter(this));
		
		GridView matches = (GridView) findViewById(+id.Matches);
		
	}

}
