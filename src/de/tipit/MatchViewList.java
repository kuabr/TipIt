package de.tipit;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MatchViewList extends LinearLayout {

	private BaseAdapter adapter;

	public MatchViewList(Context context) {
		super(context);
		this.setOrientation(VERTICAL);
	}

	public void setAdapter(BaseAdapter matchAdapter) {
		this.adapter = matchAdapter;
	}

	public void setNewMatchDay(int day) {
		this.removeAllViews();
		this.addView(this.adapter.getView(day, null, this));
	}

}
