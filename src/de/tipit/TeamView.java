package de.tipit;

import android.content.Context;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class TeamView extends LinearLayout {

	private TextView name;

	public TeamView(Context context) {
		super(context);
		this.setOrientation(VERTICAL);

		ImageView image = new ImageView(this.getContext());
		//image.setImageResource(R.drawable.deu);
		this.addView(image);

		this.name = new TextView(this.getContext());
		this.addView(this.name);
	}

	public void setTeamName(String name) {
		this.name.setText(name);
	}

}
