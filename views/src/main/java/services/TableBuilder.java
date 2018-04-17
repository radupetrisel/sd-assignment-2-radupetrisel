package services;

import java.util.List;

import javafx.collections.FXCollections;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class TableBuilder<T> {

	private TableView<T> table;

	public TableBuilder() {

		table = new TableView<T>();
		table.setEditable(false);
	}

	public TableBuilder<T> editable(){
		table.setEditable(true);
		return this;
	}

	public TableBuilder<T> setItems(List<T> items) {

		table.setItems(FXCollections.observableArrayList(items));
		return this;
	}

	public TableBuilder<T> addColumn(TableColumn<T, ?> column){
		
		table.getColumns().add(column);
		return this;
	}

	public TableView<T> build() {
		return table;
	}

}
