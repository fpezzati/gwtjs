package edu.pezzati.gwtjs.client.provided;

import com.google.gwt.cell.client.Cell;
import com.google.gwt.user.cellview.client.CellList;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.IsWidget;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;

import edu.pezzati.gwtjs.client.provided.model.Activity;

public class Effort implements IsWidget {

	@Override
	public Widget asWidget() {
		HorizontalPanel basePanel = new HorizontalPanel();
		// attivita
		// ore
		// note
		TextBox hours = new TextBox();
		Cell<Activity> activityCell;
		CellList<Activity> activity = new CellList<Activity>(activityCell);
		TextBox notes = new TextBox();
		todoTable = new FlexTable();
		todoTable.setText(0, 0, "");
		TextBox mementoField = new TextBox();
		mementoField.addValueChangeHandler(getMementoFieldChangeHandler());
		Button removeButton = new Button("-");
		removeButton.addClickHandler(getRemoveButtonClickHandler());
		todoTable.setWidget(0, 0, mementoField);
		todoTable.setWidget(0, 1, removeButton);
		Button add = new Button("+");
		add.addClickHandler(getAddButtonClickHandler());
		Button clear = new Button("clear");
		clear.addClickHandler(getClearButtonClickHandler());
		VerticalPanel leftPanel = new VerticalPanel();
		leftPanel.add(todoTable);
		leftPanel.addStyleName("leftPanel");
		VerticalPanel rightPanel = new VerticalPanel();
		rightPanel.add(add);
		rightPanel.add(clear);
		rightPanel.addStyleName("rightPanel");
		basePanel.add(leftPanel);
		basePanel.add(rightPanel);
		return basePanel;
	}

}
