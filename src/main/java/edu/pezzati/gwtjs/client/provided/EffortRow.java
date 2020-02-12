package edu.pezzati.gwtjs.client.provided;

import java.util.Collection;
import java.util.Date;
import java.util.Iterator;

import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.IntegerBox;
import com.google.gwt.user.client.ui.IsWidget;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.user.datepicker.client.DateBox;

import edu.pezzati.gwtjs.client.provided.model.Activity;
import edu.pezzati.gwtjs.client.provided.model.Effort;
import jsinterop.annotations.JsType;

@JsType
public class EffortRow implements IsWidget {
	
	private ListBox activity;
	private DateBox when;
	private IntegerBox hours;

	@Override
	public Widget asWidget() {
		HorizontalPanel basePanel = new HorizontalPanel();
		activity = new ListBox();
		when = new DateBox();
		hours = new IntegerBox();
		basePanel.add(activity);
		basePanel.add(hours);
		basePanel.add(when);
		return basePanel;
	}
	
	@SuppressWarnings("unchecked")
	public void refresh(Object model) {
		Iterator<Object> iterator = ((Collection<Object>)model).iterator();
		Collection<Activity> activities = (Collection<Activity>) iterator.next();
		Effort effort = (Effort) iterator.next();
		when.setValue(new Date(effort.when));
		hours.setValue(effort.effortHours);
		activities.forEach(actvy -> {
			activity.addItem(actvy.name, actvy.uuid);
		});
	}
}
