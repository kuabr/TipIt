package de.tipit;

import android.content.Context;
import android.text.InputType;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MatchView extends LinearLayout{

	private TeamView firstTeamLayout;
	private TeamView secondTeamLayout;
	private EditText firstScore;
	private EditText secondScore;

	public MatchView(Context context) {
		super(context);
		this.setOrientation(HORIZONTAL);
	
		this.firstTeamLayout = new TeamView(this.getContext());
		this.addView(this.firstTeamLayout);
		
		TextView divider = new TextView(this.getContext());
		divider.setText(" : ");
		this.addView(divider);
		
		this.secondTeamLayout = new TeamView(this.getContext());
		this.addView(this.secondTeamLayout);
		
		this.firstScore = new EditText(this.getContext());
		this.firstScore.setInputType(InputType.TYPE_CLASS_NUMBER);
		this.addView(this.firstScore);
		
		this.secondScore = new EditText(this.getContext());
		this.secondScore.setInputType(InputType.TYPE_CLASS_NUMBER);
		this.addView(this.secondScore);
	}
	
	public void setFirstTeamName(String teamName) {
		this.firstTeamLayout.setTeamName(teamName);
	}
	
	public void setSecondTeamName(String teamName) {
		this.secondTeamLayout.setTeamName(teamName);
	}
	
	

}
