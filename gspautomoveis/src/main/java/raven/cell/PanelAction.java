package raven.cell;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.GroupLayout.Alignment;
import javax.swing.GroupLayout;
import javax.swing.LayoutStyle.ComponentPlacement;

public class PanelAction extends  javax.swing.JPanel {

	   /**
     * Creates new form PanelAction
     */
    public PanelAction() {
        initComponents();
    }

    public void initEvent(TableActionEvent event, int row) {
        cmdEdit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                event.onEdit(row);
            }
        });
        cmdDelete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                event.onDelete(row);
            }
        });
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        cmdEdit = new raven.cell.ActionButton();
        cmdDelete = new raven.cell.ActionButton();

        cmdEdit.setIcon(new ImageIcon("C:\\Users\\Admin\\Downloads\\edit.png")); // NOI18N

        cmdDelete.setIcon(new ImageIcon("C:\\Users\\Admin\\Downloads\\delete.png"));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        layout.setHorizontalGroup(
        	layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(Alignment.TRAILING, layout.createSequentialGroup()
        			.addContainerGap(148, Short.MAX_VALUE)
        			.addComponent(cmdEdit, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
        			.addGap(18)
        			.addComponent(cmdDelete, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
        			.addGap(210))
        );
        layout.setVerticalGroup(
        	layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(layout.createSequentialGroup()
        			.addContainerGap(146, Short.MAX_VALUE)
        			.addGroup(layout.createParallelGroup(Alignment.TRAILING, false)
        				.addComponent(cmdEdit, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        				.addComponent(cmdDelete, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 20, Short.MAX_VALUE))
        			.addContainerGap(134, Short.MAX_VALUE))
        );
        this.setLayout(layout);
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private raven.cell.ActionButton cmdDelete;
    private raven.cell.ActionButton cmdEdit;
    // End of variables declaration//GEN-END:variables
}