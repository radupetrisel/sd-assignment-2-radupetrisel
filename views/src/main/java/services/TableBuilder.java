package services;

import java.util.List;
import java.util.Observable;

import javafx.collections.FXCollections;
import javafx.event.EventHandler;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellEditEvent;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;

public class TableBuilder<T extends Observable> {

	private TableView<T> table;

	public TableBuilder() {

		table = new TableView<T>();
	}

	public TableBuilder<T> setEditable(boolean isEditable) {
		table.setEditable(isEditable);

		return this;
	}

	public TableBuilder<T> setItems(List<T> items) {

		table.setItems(FXCollections.observableArrayList(items));
		return this;
	}

	public TableBuilder<T> addColumn(String columnName, String sourceFieldName, EventHandler<CellEditEvent<T, String>> editCommiter) {

		TableColumn<T, String> column = new TableColumn<T, String>(columnName);

		column.setCellValueFactory(new PropertyValueFactory<T, String>(sourceFieldName));

		table.getColumns().add(column);

		column.setCellFactory(TextFieldTableCell.forTableColumn());
		column.setOnEditCommit(editCommiter);

		return this;
	}

	public TableBuilder<T> addColumn(String columnName, String sourceFieldName, boolean isEditable) {

		TableColumn<T, String> column = new TableColumn<T, String>(columnName);

		column.setCellValueFactory(new PropertyValueFactory<T, String>(sourceFieldName));
		column.setEditable(false);

		table.getColumns().add(column);

		return this;
	}

	public TableView<T> build() {
		return table;
	}

}
