package ravenD.cell;

import java.awt.Component;
import javax.swing.DefaultCellEditor;
import javax.swing.JCheckBox;
import javax.swing.JTable;

import raven.cell.TableActionEvent;

/**
 *
 * @author RAVEN
 */
public class TableActionCellEditorD extends DefaultCellEditor {

    private TableActionEventD eventD;

    public TableActionCellEditorD(TableActionEventD eventD) {
        super(new JCheckBox());
        this.eventD = eventD;
    }

    @Override
    public Component getTableCellEditorComponent(JTable jtable, Object o, boolean bln, int row, int column) {
        PanelActionD action = new PanelActionD();
        action.initEvent(eventD, row);
        action.setBackground(jtable.getSelectionBackground());
        return action;
    }
}