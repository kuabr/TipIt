package de.tipit;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.Spinner;
import de.tipit.R.id;

public class MatchTipActivity extends Activity {

	private Spinner matchDays;
	private MatchViewList matchViewList;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.match_tipp);
		LinearLayout layout = (LinearLayout) findViewById(+id.MatchTipLayout);

		this.matchDays = (Spinner) findViewById(+id.MatchDay);
		/*
		ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
				this, R.array.match_day_array,
				android.R.layout.simple_spinner_item);
		adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		matchDays.setAdapter(adapter);
		*/

		this.matchViewList = new MatchViewList(this);
		//MatchesAdapter matchAdapter = new MatchesAdapter(this);
		//matchViewList.setAdapter(matchAdapter);

		layout.addView(matchViewList);

		this.bind();

	}

	private void bind() {
		matchDays.setOnItemSelectedListener(new OnItemSelectedListener() {

			@Override
			public void onItemSelected(AdapterView<?> parent, View view,
					int position, long id) {
				MatchTipActivity.this.matchViewList
						.setNewMatchDay(position + 1);
			}

			@Override
			public void onNothingSelected(AdapterView<?> parent) {
				// TODO Auto-generated method stub
			}
		});

	}
}