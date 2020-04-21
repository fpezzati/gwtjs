package edu.pezzati.gwtjs.client.provided;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import com.google.gwt.user.client.ui.IsWidget;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;

import edu.pezzati.gwtjs.client.provided.model.Activity;
import edu.pezzati.gwtjs.client.provided.model.Effort;

public class EffortTable implements IsWidget {

	private VerticalPanel basePanel;

	@Override
	public Widget asWidget() {
		basePanel = new VerticalPanel();
		return basePanel;
	}

	@SuppressWarnings("unchecked")
	public void refresh(Object model) {
		Iterator<Object> iterator = ((Collection<Object>)model).iterator();
		Collection<Activity> activities = (Collection<Activity>) iterator.next();
		Collection<Effort> efforts = (Collection<Effort>) iterator.next();
		efforts.forEach(effort -> {
			EffortRow effortRow = new EffortRow();
			Collection<Object> effortModel = new ArrayList<>();
			effortModel.add(activities);
			effortModel.add(effort);
			basePanel.add(effortRow);
			effortRow.refresh(effortModel);
		});
	}
}
