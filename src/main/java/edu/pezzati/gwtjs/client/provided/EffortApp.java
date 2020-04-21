package edu.pezzati.gwtjs.client.provided;

import com.google.gwt.user.client.ui.RootPanel;

import jsinterop.annotations.JsType;

@JsType
public class EffortApp {

	private EffortTable effortTable;

	public EffortApp() {
		effortTable = new EffortTable();
		RootPanel.get().add(effortTable);
	}
	
	public EffortApp setModel(Object model) {
		effortTable.refresh(model);
		return this;
	}
}