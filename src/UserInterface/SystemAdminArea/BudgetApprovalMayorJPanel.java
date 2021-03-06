/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface.SystemAdminArea;

import Business.BudgetData.Budget;
import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Events.Event;
import Business.Network.Network;
import Business.Role.Role;
import Business.WorkRequest.WorkRequest;
import java.awt.CardLayout;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;
import java.util.Properties;
import javax.mail.Session;
import javax.mail.Message;
import javax.mail.Transport;
import javax.mail.Authenticator;
import javax.mail.MessagingException;
import javax.mail.internet.InternetAddress;
import javax.mail.PasswordAuthentication;
import javax.mail.internet.MimeMessage;

/**
 *
 * @author Abhinav
 */
public class BudgetApprovalMayorJPanel extends javax.swing.JPanel {

    /**
     * Creates new form BudgetApprovalMayor
     */
    JPanel userProcessContainer;
    EcoSystem system;
    ArrayList<Budget> tempBudgetList;
    ArrayList<Event> tempEvevntList;

    /**
     * Creates new form AdminWorkAreaJPanel
     */
    public BudgetApprovalMayorJPanel(JPanel userProcessContainer, EcoSystem system) {
        initComponents();

        this.userProcessContainer = userProcessContainer;
        this.system = system;
        this.tempBudgetList = new ArrayList<>();
        this.tempEvevntList = new ArrayList<Event>();

        initBudgetList();
        populateBudgetTable();
    }


    public void initBudgetList() {
        for (Network net : system.getNetworkList()) {
            for (Enterprise ent : net.getEnterpriseDirectory().getEnterpriseList()) {
                if (ent.getEnterpriseType() == Enterprise.EnterpriseType.GoGreenEnterprise) {
                    for (WorkRequest request : ent.getWorkQueue().getWorkRequestlist()) {
                        for (Budget budget : request.getBudgetList()) {
                            tempBudgetList.add(budget);
                            for (Event event : budget.getEventList()) {
                                tempEvevntList.add(event);
                            }
                        }
                    }
                }
            }
        }
        System.out.println("tempBudgetList: " + tempBudgetList.size());
    }

    public void populateBudgetTable() {
        DefaultTableModel model = (DefaultTableModel) tblAllottedBudget1.getModel();
        model.setRowCount(0);
        for (Budget budget : tempBudgetList) {
            Object[] row = new Object[4];
            row[0] = budget.getOrgName();
            row[1] = budget.getOrgBudget();
            row[2] = budget.getEventList().size();
            row[3] = budget.getOrgAdditionalBudget();
            model.addRow(row);
        }
    }

    public void populateEventTable(String orgName) {
        DefaultTableModel model = (DefaultTableModel) tblAllottedEventBudget.getModel();
        model.setRowCount(0);
        for (Event event : tempEvevntList) {
            if (orgName.equalsIgnoreCase(event.getOrganisationOfEvent())) {
                Object[] row = new Object[4];
                row[0] = event.getOrganisationOfEvent();
                row[1] = event.getEventName();
                row[2] = event.getEventBudget();
                row[3] = event.getEventOutcome();
                model.addRow(row);
            }
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tblAllottedEventBudget = new javax.swing.JTable();
        btnApprove = new javax.swing.JButton();
        btnReject = new javax.swing.JButton();
        backJButton = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblAllottedBudget1 = new javax.swing.JTable();

        setBackground(new java.awt.Color(255, 255, 255));

        tblAllottedEventBudget.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null}
            },
            new String [] {
                "Organisation Name", "Event", "Event budget", "Event outcome"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblAllottedEventBudget.setColumnSelectionAllowed(true);
        jScrollPane1.setViewportView(tblAllottedEventBudget);
        tblAllottedEventBudget.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        if (tblAllottedEventBudget.getColumnModel().getColumnCount() > 0) {
            tblAllottedEventBudget.getColumnModel().getColumn(0).setPreferredWidth(150);
            tblAllottedEventBudget.getColumnModel().getColumn(0).setMaxWidth(150);
            tblAllottedEventBudget.getColumnModel().getColumn(1).setMaxWidth(75);
            tblAllottedEventBudget.getColumnModel().getColumn(2).setPreferredWidth(125);
            tblAllottedEventBudget.getColumnModel().getColumn(2).setMaxWidth(125);
            tblAllottedEventBudget.getColumnModel().getColumn(3).setPreferredWidth(300);
        }

        btnApprove.setBackground(new java.awt.Color(255, 255, 255));
        btnApprove.setText("Approve");
        btnApprove.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnApproveActionPerformed(evt);
            }
        });

        btnReject.setBackground(new java.awt.Color(255, 255, 255));
        btnReject.setText("Reject Events");
        btnReject.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRejectActionPerformed(evt);
            }
        });

        backJButton.setBackground(new java.awt.Color(255, 255, 255));
        backJButton.setText("<<Back");
        backJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backJButtonActionPerformed(evt);
            }
        });

        tblAllottedBudget1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Organisation Name", "Allotted budget", "Number of events", "Total event budget"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblAllottedBudget1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblAllottedBudget1MouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblAllottedBudget1);
        tblAllottedBudget1.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(backJButton, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnReject, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(675, 675, 675)
                            .addComponent(btnApprove))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addContainerGap()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 912, Short.MAX_VALUE)
                                .addComponent(jScrollPane1)))))
                .addContainerGap(160, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 85, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(45, 45, 45)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(backJButton)
                    .addComponent(btnReject))
                .addGap(35, 35, 35)
                .addComponent(btnApprove)
                .addGap(52, 52, 52))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnRejectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRejectActionPerformed
        int selectedRow = tblAllottedEventBudget.getSelectedRow();
        Event event1 = new Event();
        boolean matchFound = false;
        int totalEventBudget = 0;
        if (selectedRow < 0) {
            JOptionPane.showMessageDialog(null, "Please select a row from table", "Warning", JOptionPane.WARNING_MESSAGE);
        }
        String eventName = tblAllottedEventBudget.getValueAt(selectedRow, 1).toString();
        String orgName = tblAllottedEventBudget.getValueAt(selectedRow, 0).toString();
        Event event2 = new Event();
        for (Event event : tempEvevntList) {
            if (eventName.equalsIgnoreCase(event.getEventName())) {
                event2 = event;
                break;
            }
        }
        tempEvevntList.remove(event2);

        for (Budget budget : tempBudgetList) {
            for (Event event : budget.getEventList()) {
                if (eventName.equalsIgnoreCase(event.getEventName())) {
                    event1 = event;
                    break;
                }
            }
            if (orgName.equalsIgnoreCase(budget.getOrgName())) {
                budget.getEventList().remove(event1);
                totalEventBudget = budget.getOrgAdditionalBudget() - (int) event1.getEventBudget();
                budget.setOrgAdditionalBudget(totalEventBudget);
            }
        }
        populateBudgetTable();
        populateEventTable(orgName);


	}//GEN-LAST:event_btnRejectActionPerformed

    private void backJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backJButtonActionPerformed

        userProcessContainer.remove(this);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
    }//GEN-LAST:event_backJButtonActionPerformed

    private void btnApproveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnApproveActionPerformed
        for (Network net : system.getNetworkList()) {
            for (Enterprise ent : net.getEnterpriseDirectory().getEnterpriseList()) {
                if (ent.getEnterpriseType() == Enterprise.EnterpriseType.GoGreenEnterprise) {
                    for (WorkRequest request : ent.getWorkQueue().getWorkRequestlist()) {
                        request.setApprovalStatus("APPROVED");
                        request.setStatus("APPROVED");
                        request.setBudgetList(tempBudgetList);
                        request.setMessage("Budget has been approved by Mayor");
                        request.setReceiver(Role.RoleType.BudgetAdmin);

                    }
                }
            }
        }

        JOptionPane.showMessageDialog(null, "Mayor has approved the budget");
        btnApprove.setEnabled(false);
        btnReject.setEnabled(false);
    }//GEN-LAST:event_btnApproveActionPerformed

    private void tblAllottedBudget1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblAllottedBudget1MouseClicked
        tblAllottedBudget1.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                int selectedRow = tblAllottedBudget1.getSelectedRow();
                String orgName = tblAllottedBudget1.getValueAt(selectedRow, 0).toString();
                //System.out.println(orgName+" :--: "+selectedRow);
                populateEventTable(orgName);

            }
        });
    }//GEN-LAST:event_tblAllottedBudget1MouseClicked
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backJButton;
    private javax.swing.JButton btnApprove;
    private javax.swing.JButton btnReject;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tblAllottedBudget1;
    private javax.swing.JTable tblAllottedEventBudget;
    // End of variables declaration//GEN-END:variables
}
