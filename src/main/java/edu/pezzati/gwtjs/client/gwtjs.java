package edu.pezzati.gwtjs.client;

import java.util.ArrayList;
import java.util.List;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.ui.RootPanel;

import edu.pezzati.gwtjs.client.provided.EffortTable;
import edu.pezzati.gwtjs.client.provided.model.Activity;
import edu.pezzati.gwtjs.client.provided.model.Effort;

public class gwtjs implements EntryPoint {

	public void onModuleLoad() {
		EffortTable effortTable = new EffortTable();
		List<Object> model = new ArrayList<Object>();
		model.add(getActivities());
		model.add(getEfforts());
		RootPanel.get().add(effortTable);
		effortTable.refresh(model);
	}

	private List<Activity> getActivities() {
		Activity activity1 = new Activity();
		activity1.uuid = "1";
		activity1.name = "name1";
		activity1.description = "descr1";
		Activity activity2 = new Activity();
		activity2.uuid = "2";
		activity2.name = "name2";
		activity2.description = "descr2";
		Activity activity3 = new Activity();
		activity3.uuid = "3";
		activity3.name = "name3";
		activity3.description = "descr3";
		Activity activity4 = new Activity();
		activity4.uuid = "4";
		activity4.name = "name4";
		activity4.description = "descr4";
		List<Activity> activities = new ArrayList<Activity>();
		activities.add(activity1);
		activities.add(activity2);
		activities.add(activity3);
		activities.add(activity4);
		return activities;
	}
	
	private List<Effort> getEfforts() {
		Effort effort1 = new Effort();
		effort1.uuid = "1";
		effort1.effortHours = 11;
		effort1.when = 11000L;
		Effort effort2 = new Effort();
		effort2.uuid = "2";
		effort2.effortHours = 12;
		effort2.when = 12000L;
		Effort effort3 = new Effort();
		effort3.uuid = "3";
		effort3.effortHours = 13;
		effort3.when = 13000L;
		Effort effort4 = new Effort();
		effort4.uuid = "4";
		effort4.effortHours = 14;
		effort4.when = 14000L;
		List<Effort> efforts = new ArrayList<Effort>();
		efforts.add(effort1);
		efforts.add(effort2);
		efforts.add(effort3);
		efforts.add(effort4);
		return efforts;
	}
}
