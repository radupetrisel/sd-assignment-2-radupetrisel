package services;

import javafx.event.EventHandler;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellEditEvent;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.util.Callback;
import javafx.util.StringConverter;

public class ColumnBuilder<T, R> {

	private TableColumn<T, R> column;

	public ColumnBuilder() {
		column = new TableColumn<T, R>();
		column.setEditable(false);
	}

	public ColumnBuilder<T, R> name(String name) {
		column.setText(name);
		return this;
	}

	public ColumnBuilder<T, R> addColumn(TableColumn<T, ?> nestedColumn) {
		column.getColumns().add(nestedColumn);
		return this;
	}

	public ColumnBuilder<T, R> editable(StringConverter<R> converter) {

		column.setEditable(true);
		column.setCellFactory(TextFieldTableCell.<T, R>forTableColumn(converter));
		return this;
	}

	public ColumnBuilder<T, R> onEditCommit(EventHandler<CellEditEvent<T, R>> eventHandler) {

		column.setOnEditCommit(eventHandler);
		return this;
	}

	public ColumnBuilder<T, R> cellValueFactory(String factoryName) {
		column.setCellValueFactory(new PropertyValueFactory<T, R>(factoryName));
		return this;
	}

	public ColumnBuilder<T, R> unsortable() {
		column.setSortable(false);
		return this;
	}

	public TableColumn<T, R> build() {
		return column;
	}

}
