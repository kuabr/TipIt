package de.tipit;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MatchViewList extends LinearLayout {

	public MatchViewList(Context context) {
		super(context);
		this.setOrientation(VERTICAL);
	}

	public void setAdapter(BaseAdapter matchAdapter) {
		for (int i = 0; i < matchAdapter.getCount(); i++) {
			this.addView(matchAdapter.getView(i, null, this));
		}
	}

}
