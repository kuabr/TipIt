package de.tipit;

import android.content.Context;
import android.database.DataSetObserver;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.SpinnerAdapter;
import android.widget.TextView;

public class MatchDaysAdapter extends BaseAdapter {

	private Context context;

	private String[] days = {"Tag 1", "Tag 2", "Tag 3"};
	
	public MatchDaysAdapter(Context c) {
		this.context = c;
	}
	
	@Override
	public int getCount() {
		return days.length;
	}

	@Override
	public Object getItem(int position) {
		return days[position];
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
        TextView textView;
        if (convertView == null) {  // if it's not recycled, initialize some attributes
            textView = new TextView(this.context);
        } else {
            textView = (TextView) convertView;
        }
        textView.setText(days[position]);
        textView.setPadding(20, 20, 20, 20);
        return textView;
	}

}
