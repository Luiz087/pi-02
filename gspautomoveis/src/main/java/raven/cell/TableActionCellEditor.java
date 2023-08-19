package raven.cell;

import java.awt.Component;

import javax.swing.DefaultCellEditor;
import javax.swing.JCheckBox;
import javax.swing.JTable;

public class TableActionCellEditor extends DefaultCellEditor {
		private  TableActionEvent event;
	public TableActionCellEditor(JCheckBox checkBox, TableActionEvent event) {
		super(checkBox);
		this.event = event;
	}

	@Override
	public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
		// TODO Auto-generated method stub
		PanelAction action = new PanelAction();
		action.initEvent(event, row);
		action.setBackground(table.getSelectionBackground());
		return action;
		}
}
