package ravenU.cell;

import java.awt.Component;
import javax.swing.DefaultCellEditor;
import javax.swing.JCheckBox;
import javax.swing.JTable;

import raven.cell.TableActionEvent;

/**
 *
 * @author RAVEN
 */
public class TableActionCellEditorU extends DefaultCellEditor {

    private TableActionEventU eventU;

    public TableActionCellEditorU(TableActionEventU eventU) {
        super(new JCheckBox());
        this.eventU = eventU;
    }

    @Override
    public Component getTableCellEditorComponent(JTable jtable, Object o, boolean bln, int row, int column) {
        PanelActionU action = new PanelActionU();
        action.initEvent(eventU, row);
        action.setBackground(jtable.getSelectionBackground());
        return action;
    }
}