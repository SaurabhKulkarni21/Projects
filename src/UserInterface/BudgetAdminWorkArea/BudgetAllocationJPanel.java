/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface.BudgetAdminWorkArea;

import Business.BudgetData.Budget;
import Business.BudgetData.BudgetDirectory;
import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Organization.Organization;
import Business.Organization.Organization.OrganizationType;
import Business.UserAccount.UserAccount;
import java.awt.CardLayout;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author amaha
 */
public class BudgetAllocationJPanel extends javax.swing.JPanel {

    /**
     * Creates new form BudgetAllocationJPanel
     */
    private JPanel userProcessContainer;
    private EcoSystem system;
    private Budget budget;
    private BudgetDirectory budgetDirectory;
    private Organization organization;
    private OrganizationType organisationType;
    private Enterprise enterprise;
    private UserAccount userAccount;
    private double totalBudget;
    private Boolean flag;
    private String regex = "\\d+";
    Pattern pattern = Pattern.compile(regex);

    BudgetAllocationJPanel(JPanel userProcessContainer, UserAccount userAccount, Enterprise enterprise, EcoSystem business) {
        initComponents();
        this.userProcessContainer = userProcessContainer;
        this.system = business;
        this.budgetDirectory = new BudgetDirectory();
        this.enterprise = enterprise;
        this.userAccount = userAccount;
        totalBudget = 0.00;
        flag = false;
        

    }

    public double calculateBudget(double[] x, double[] y, int n) {

        double sumx = 0.0, sumy = 0.0;
        for (int i = 0; i <= n; i++) {
            sumx += x[n];
            sumy += y[n];

        }
        System.out.println("n: " + n);
        double xxbar = 0.0, yybar = 0.0, xybar = 0.0;
        double xbar = sumx / n;
        double ybar = sumy / n;
        for (int i = 0; i < n; i++) {
            xxbar += (x[i] - xbar) * (x[i] - xbar);
            yybar += (y[i] - ybar) * (y[i] - ybar);
            xybar += (x[i] - xbar) * (y[i] - ybar);
        }

        double beta1 = xybar / xxbar;
        double beta0 = ybar - beta1 * xbar;
        double totalSum = 0.0;
        double hc_yi = 0.0;
        double edu_yi = 0.0;
        double tour_yi = 0.0;
        double ind_yi = 0.0;
        double infra_yi = 0.0;
        double auto_yi = 0.0;
        int hc1 = 0;
        int hc2 = 0;
        int hc3 = 0;
        int hc4 = 0;
        int edu1 = 0;
        int edu2 = 0;
        int edu3 = 0;
        int infra1 = 0;
        int infra2 = 0;
        int auto1 = 0;
        int auto2 = 0;
        int ind1 = 0;
        int ind2 = 0;
        int ind3 = 0;
        int ind4 = 0;
        int tour1 = 0;
        int tour2 = 0;
        try {
            if (chkbHealthOption1.isSelected()) {
                hc1 = Integer.parseInt(txtHCoption1.getText());
              //  if (String.valueOf(hc1).matches(regex)) {
//              if(!pattern.matcher(String.valueOf(hc1)).matches()){
//                    JOptionPane.showMessageDialog(null, "Please a numeric value");
//                } else {
//                    JOptionPane.showMessageDialog(null, "Pass");
//                }
            }
            if (chkbHealthOption2.isSelected()) {
                hc2 = Integer.parseInt(txtHCoption2.getText());
            }
            if (chkbHealthOption3.isSelected()) {
                hc3 = Integer.parseInt(txtHCoption3.getText());
            }
            if (chkbHealthOption4.isSelected()) {
                hc4 = Integer.parseInt(txtHCoption4.getText());
            }
            if (chkbEduOption1.isSelected()) {
                edu1 = Integer.parseInt(txtEduoption1.getText());
            }
            if (chkbEduOption2.isSelected()) {
                edu2 = Integer.parseInt(txtEduoption2.getText());
            }
            if (chkbEduOption3.isSelected()) {
                edu3 = Integer.parseInt(txtEduoption3.getText());
            }

            if (chkbTourOption1.isSelected()) {
                tour1 = Integer.parseInt(txtTourOption1.getText());
            }
            if (chkbTourOption2.isSelected()) {
                tour2 = Integer.parseInt(txtTourOption2.getText());
            }

            if (chkbAutoOption1.isSelected()) {
                auto1 = Integer.parseInt(txtAutoOption1.getText());
            }
            if (chkbAutoOption2.isSelected()) {
                auto2 = Integer.parseInt(txtAutoOption2.getText());
            }

            if (chkbInfraOption1.isSelected()) {
                infra1 = Integer.parseInt(txtInfraoption1.getText());
            }
            if (chkbInfraOption2.isSelected()) {
                infra2 = Integer.parseInt(txtInfraoption2.getText());
            }
            if (chkbIndOption1.isSelected()) {
                ind1 = Integer.parseInt(txtIndoption1.getText());
            }
            if (chkbIndOption2.isSelected()) {
                ind2 = Integer.parseInt(txtIndoption2.getText());
            }
            if (chkbIndOption3.isSelected()) {
                ind3 = Integer.parseInt(txtIndoption3.getText());
            }
            if (chkbIndOption4.isSelected()) {
                ind4 = Integer.parseInt(txtIndOption4.getText());
            }
        } catch (NumberFormatException e) {

        }

        for (Budget b : system.getCsvUtil().getPreviousBudgetlist()) {
            if (b.getOrgName().equalsIgnoreCase("Health")) {

                hc_yi = hc1 * 1000 + hc2 * 2000 + hc3 * 30000 + hc4 * 60000;
                totalSum = beta1 * hc_yi + beta0;
            }
            if (b.getOrgName().equalsIgnoreCase("Education")) {

                edu_yi = edu1 * 10000 + edu2 * 80000 + edu3 * 3000;
                totalSum = beta1 * edu_yi + beta0;
            }
            if (b.getOrgName().equalsIgnoreCase("Tourism")) {

                tour_yi = tour1 * 1000 + tour2 * 2000;
                totalSum = beta1 * tour_yi + beta0;
            }
            if (b.getOrgName().equalsIgnoreCase("Industries")) {

                ind_yi = infra1 * 1000 + infra2 * 2000;
                totalSum = beta1 * ind_yi + beta0;
            }
            if (b.getOrgName().equalsIgnoreCase("Infratructure")) {

                infra_yi = ind1 * 1000 + ind2 * 2000 + ind3 * 3000 + ind4 * 4000;
                totalSum = beta1 * infra_yi + beta0;
            }
            if (b.getOrgName().equalsIgnoreCase("Automobiles")) {

                auto_yi = auto1 * 1000 + auto2 * 2000;
                totalSum = beta1 * auto_yi + beta0;
            }

        }

        // yi = hc1 + hc2 + hc3 + hc4 + edu1 + edu2 + edu3 + tour1 + tour2 + auto1 + auto2 + infra1 + infra2 + ind1 + ind2 + ind3 + ind4;
//        double hc_sum = beta1 * hc_yi + beta0;
//        double edu_sum = beta1 * edu_yi + beta0;
//        double tour_sum = beta1 * tour_yi + beta0;
//        double ind_sum = beta1 * ind_yi + beta0;
//        double infra_sum = beta1 * infra_yi + beta0;
//        double auto_sum = beta1 * auto_yi + beta0;
        System.out.println("sum now" + totalSum + "beta1" + beta1 + "beta0" + beta0);
        return totalSum;
    }

    public double linearRegression() {
        int MAXN = 1000;
        int hcn = 0;
        int edun = 0;
        int infran = 0;
        int indn = 0;
        int tourn = 0;
        int auton = 0;
        double[] hcx = new double[MAXN];
        double[] hcy = new double[MAXN];
        double[] edux = new double[MAXN];
        double[] eduy = new double[MAXN];
        double[] tourx = new double[MAXN];
        double[] toury = new double[MAXN];
        double[] infrax = new double[MAXN];
        double[] infray = new double[MAXN];
        double[] indx = new double[MAXN];
        double[] indy = new double[MAXN];
        double[] autox = new double[MAXN];
        double[] autoy = new double[MAXN];

        int currenthealthbudget;
        int currentedubudget;
        int currenttourbudget;
        int currentinfrabudget;
        int currentindbudget;
        int currentautobudget;

        for (Budget b : system.getCsvUtil().getPreviousBudgetlist()) {
            if (b.getOrgName().equalsIgnoreCase("Health")) {

                hcx[hcn] = b.getBudgetYear();
                hcy[hcn] = b.getBudgetUsed();
                hcn++;
            }
            if (b.getOrgName().equalsIgnoreCase("Education")) {

                edux[edun] = b.getBudgetYear();
                eduy[edun] = b.getBudgetUsed();
                edun++;
            }
            if (b.getOrgName().equalsIgnoreCase("Tourism")) {

                tourx[tourn] = b.getBudgetYear();
                toury[tourn] = b.getBudgetUsed();
                tourn++;
            }
            if (b.getOrgName().equalsIgnoreCase("Industries")) {

                indx[indn] = b.getBudgetYear();
                indy[indn] = b.getBudgetUsed();
                indn++;
            }
            if (b.getOrgName().equalsIgnoreCase("Infrastructure")) {

                infrax[infran] = b.getBudgetYear();
                infray[infran] = b.getBudgetUsed();
                infran++;
            }
            if (b.getOrgName().equalsIgnoreCase("Automobiles")) {

                autox[auton] = b.getBudgetYear();
                autoy[auton] = b.getBudgetUsed();
                auton++;
            }

        }

//            }
        // Budget budget = new Budget();
        currenthealthbudget = (int) calculateBudget(hcx, hcy, hcn);
        Budget budh = budgetDirectory.addBudget();
        budh.setOrgName(OrganizationType.HealthCare.toString());
        budh.setBudgetUsed(600);
        budh.setOrgAdditionalBudget(50);
        budh.setBudgetYear(2017);
        budh.setOrgBudget(currenthealthbudget);

        currentedubudget = (int) calculateBudget(edux, eduy, edun);
        Budget bude = budgetDirectory.addBudget();
        bude.setOrgName(OrganizationType.Education.toString());
        bude.setBudgetUsed(600);
        bude.setOrgAdditionalBudget(50);
        bude.setBudgetYear(2017);
        bude.setOrgBudget(currentedubudget);

        currenttourbudget = (int) calculateBudget(tourx, toury, tourn);
        Budget budt = budgetDirectory.addBudget();
        budt.setOrgName(OrganizationType.Tourism.toString());
        budt.setBudgetUsed(600);
        budt.setOrgAdditionalBudget(50);
        budt.setBudgetYear(2017);
        budt.setOrgBudget(currenttourbudget);

        currentinfrabudget = (int) calculateBudget(infrax, infray, infran);
        Budget budif = budgetDirectory.addBudget();
        budif.setOrgName(OrganizationType.Infrastructure.toString());
        budif.setBudgetUsed(600);
        budif.setOrgAdditionalBudget(50);
        budif.setBudgetYear(2017);
        budif.setOrgBudget(currentinfrabudget);

        currentautobudget = (int) calculateBudget(autox, autoy, auton);
        Budget buda = budgetDirectory.addBudget();
        buda.setOrgName(OrganizationType.Automobile.toString());
        buda.setBudgetUsed(600);
        buda.setOrgAdditionalBudget(50);
        buda.setBudgetYear(2017);
        buda.setOrgBudget(currentautobudget);

        currentindbudget = (int) calculateBudget(indx, indy, indn);
        Budget budid = budgetDirectory.addBudget();
        budid.setOrgName(OrganizationType.Industries.toString());
        budid.setBudgetUsed(600);
        budid.setOrgAdditionalBudget(50);
        budid.setBudgetYear(2017);
        budid.setOrgBudget(currentindbudget);

        System.out.println("list size: " + budgetDirectory.getBudgetList().size() + " budget" + (currenthealthbudget));
        double currentBudget = currenthealthbudget + currentedubudget + currenttourbudget + currentindbudget + currentautobudget + currentinfrabudget;
        System.out.println("Current Budget =" + currentBudget);
        return currentBudget;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panel1 = new java.awt.Panel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        txtIndoption3 = new javax.swing.JTextField();
        txtIndoption1 = new javax.swing.JTextField();
        txtIndoption2 = new javax.swing.JTextField();
        txtIndOption4 = new javax.swing.JTextField();
        chkbIndOption1 = new javax.swing.JCheckBox();
        chkbIndOption2 = new javax.swing.JCheckBox();
        chkbIndOption3 = new javax.swing.JCheckBox();
        chkbIndOption4 = new javax.swing.JCheckBox();
        jLabel8 = new javax.swing.JLabel();
        btnCalculate = new javax.swing.JButton();
        backJButton = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        chkbTourOption1 = new javax.swing.JCheckBox();
        txtTourOption1 = new javax.swing.JTextField();
        chkbTourOption2 = new javax.swing.JCheckBox();
        txtTourOption2 = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        chkbInfraOption1 = new javax.swing.JCheckBox();
        chkbInfraOption2 = new javax.swing.JCheckBox();
        txtInfraoption1 = new javax.swing.JTextField();
        txtInfraoption2 = new javax.swing.JTextField();
        jPanel5 = new javax.swing.JPanel();
        chkbEduOption1 = new javax.swing.JCheckBox();
        chkbEduOption2 = new javax.swing.JCheckBox();
        chkbEduOption3 = new javax.swing.JCheckBox();
        txtEduoption1 = new javax.swing.JTextField();
        txtEduoption2 = new javax.swing.JTextField();
        txtEduoption3 = new javax.swing.JTextField();
        jPanel6 = new javax.swing.JPanel();
        chkbHealthOption1 = new javax.swing.JCheckBox();
        chkbHealthOption2 = new javax.swing.JCheckBox();
        chkbHealthOption3 = new javax.swing.JCheckBox();
        chkbHealthOption4 = new javax.swing.JCheckBox();
        txtHCoption4 = new javax.swing.JTextField();
        txtHCoption3 = new javax.swing.JTextField();
        txtHCoption2 = new javax.swing.JTextField();
        txtHCoption1 = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        chkbAutoOption1 = new javax.swing.JCheckBox();
        chkbAutoOption2 = new javax.swing.JCheckBox();
        txtAutoOption1 = new javax.swing.JTextField();
        txtAutoOption2 = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();

        javax.swing.GroupLayout panel1Layout = new javax.swing.GroupLayout(panel1);
        panel1.setLayout(panel1Layout);
        panel1Layout.setHorizontalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        panel1Layout.setVerticalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Rockwell", 1, 24)); // NOI18N
        jLabel1.setText("Budget Allocation for Fiscal 2017");

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Industries"));

        txtIndoption3.setToolTipText("");

        txtIndoption1.setToolTipText("");
        txtIndoption1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIndoption1ActionPerformed(evt);
            }
        });

        txtIndoption2.setToolTipText("");
        txtIndoption2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIndoption2ActionPerformed(evt);
            }
        });

        txtIndOption4.setToolTipText("");
        txtIndOption4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIndOption4ActionPerformed(evt);
            }
        });

        chkbIndOption1.setBackground(new java.awt.Color(255, 255, 255));
        chkbIndOption1.setText("Building new Plants");

        chkbIndOption2.setBackground(new java.awt.Color(255, 255, 255));
        chkbIndOption2.setText("Waste Management");
        chkbIndOption2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chkbIndOption2ActionPerformed(evt);
            }
        });

        chkbIndOption3.setBackground(new java.awt.Color(255, 255, 255));
        chkbIndOption3.setText("Salary Allocation");

        chkbIndOption4.setBackground(new java.awt.Color(255, 255, 255));
        chkbIndOption4.setText("Renewable Technologies");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(chkbIndOption4)
                            .addComponent(chkbIndOption1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 37, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtIndoption1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtIndOption4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(chkbIndOption3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtIndoption3, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(chkbIndOption2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtIndoption2, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(5, 5, 5))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtIndoption1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(chkbIndOption1))
                .addGap(15, 15, 15)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(chkbIndOption2)
                    .addComponent(txtIndoption2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtIndoption3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(chkbIndOption3))
                .addGap(13, 13, 13)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtIndOption4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(chkbIndOption4))
                .addContainerGap(24, Short.MAX_VALUE))
        );

        jLabel8.setText("Calculate current allocated budget:");

        btnCalculate.setBackground(new java.awt.Color(255, 255, 255));
        btnCalculate.setText("Calculate");
        btnCalculate.setToolTipText("");
        btnCalculate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCalculateActionPerformed(evt);
            }
        });

        backJButton.setBackground(new java.awt.Color(255, 255, 255));
        backJButton.setText("<< Back");
        backJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backJButtonActionPerformed(evt);
            }
        });

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Tourism"));

        chkbTourOption1.setBackground(new java.awt.Color(255, 255, 255));
        chkbTourOption1.setText("Eco-Tourism");

        txtTourOption1.setToolTipText("");
        txtTourOption1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTourOption1ActionPerformed(evt);
            }
        });

        chkbTourOption2.setBackground(new java.awt.Color(255, 255, 255));
        chkbTourOption2.setText("Salary Allocation");

        txtTourOption2.setToolTipText("");
        txtTourOption2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTourOption2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(chkbTourOption1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtTourOption1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(chkbTourOption2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtTourOption2, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(chkbTourOption1)
                    .addComponent(txtTourOption1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(chkbTourOption2)
                    .addComponent(txtTourOption2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder("Infrastructure"));

        chkbInfraOption1.setBackground(new java.awt.Color(255, 255, 255));
        chkbInfraOption1.setText("Construction Projects");

        chkbInfraOption2.setBackground(new java.awt.Color(255, 255, 255));
        chkbInfraOption2.setText("Salary Allocation");

        txtInfraoption1.setToolTipText("");
        txtInfraoption1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtInfraoption1ActionPerformed(evt);
            }
        });

        txtInfraoption2.setToolTipText("");
        txtInfraoption2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtInfraoption2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(chkbInfraOption1)
                    .addComponent(chkbInfraOption2))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtInfraoption2, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtInfraoption1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(26, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(chkbInfraOption1)
                    .addComponent(txtInfraoption1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(chkbInfraOption2)
                    .addComponent(txtInfraoption2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder("Education"));

        chkbEduOption1.setBackground(new java.awt.Color(255, 255, 255));
        chkbEduOption1.setText("Build New Colleges");

        chkbEduOption2.setBackground(new java.awt.Color(255, 255, 255));
        chkbEduOption2.setText("Research Funds");
        chkbEduOption2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chkbEduOption2ActionPerformed(evt);
            }
        });

        chkbEduOption3.setBackground(new java.awt.Color(255, 255, 255));
        chkbEduOption3.setText("Salary Allocation");

        txtEduoption1.setToolTipText("");
        txtEduoption1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtEduoption1ActionPerformed(evt);
            }
        });

        txtEduoption2.setToolTipText("");
        txtEduoption2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtEduoption2ActionPerformed(evt);
            }
        });

        txtEduoption3.setToolTipText("");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(chkbEduOption3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtEduoption3, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                        .addComponent(chkbEduOption2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtEduoption2, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                        .addComponent(chkbEduOption1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtEduoption1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(34, 34, 34))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(chkbEduOption1)
                    .addComponent(txtEduoption1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(chkbEduOption2, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtEduoption2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(chkbEduOption3)
                    .addComponent(txtEduoption3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));
        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder("Health Care"));
        jPanel6.setForeground(javax.swing.UIManager.getDefaults().getColor("Button.darkShadow"));

        chkbHealthOption1.setBackground(new java.awt.Color(255, 255, 255));
        chkbHealthOption1.setText("Build Hospitals");

        chkbHealthOption2.setBackground(new java.awt.Color(255, 255, 255));
        chkbHealthOption2.setText("Salary Allocation");
        chkbHealthOption2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chkbHealthOption2ActionPerformed(evt);
            }
        });

        chkbHealthOption3.setBackground(new java.awt.Color(255, 255, 255));
        chkbHealthOption3.setText("Healthy Diet Plans");
        chkbHealthOption3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chkbHealthOption3ActionPerformed(evt);
            }
        });

        chkbHealthOption4.setBackground(new java.awt.Color(255, 255, 255));
        chkbHealthOption4.setText("New Eqipment");
        chkbHealthOption4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chkbHealthOption4ActionPerformed(evt);
            }
        });

        txtHCoption4.setToolTipText("");
        txtHCoption4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtHCoption4ActionPerformed(evt);
            }
        });

        txtHCoption3.setToolTipText("");

        txtHCoption2.setToolTipText("");
        txtHCoption2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtHCoption2ActionPerformed(evt);
            }
        });

        txtHCoption1.setToolTipText("");
        txtHCoption1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtHCoption1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                        .addComponent(chkbHealthOption2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtHCoption2, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(chkbHealthOption1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtHCoption1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(chkbHealthOption3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 70, Short.MAX_VALUE)
                        .addComponent(txtHCoption3, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(chkbHealthOption4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtHCoption4, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtHCoption1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(chkbHealthOption1))
                .addGap(19, 19, 19)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(chkbHealthOption2)
                    .addComponent(txtHCoption2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(chkbHealthOption3)
                    .addComponent(txtHCoption3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(chkbHealthOption4)
                    .addComponent(txtHCoption4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(17, Short.MAX_VALUE))
        );

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Automobile"));

        chkbAutoOption1.setBackground(new java.awt.Color(255, 255, 255));
        chkbAutoOption1.setText("Greener Fuels");
        chkbAutoOption1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chkbAutoOption1ActionPerformed(evt);
            }
        });

        chkbAutoOption2.setBackground(new java.awt.Color(255, 255, 255));
        chkbAutoOption2.setText("Salary Allocation");
        chkbAutoOption2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chkbAutoOption2ActionPerformed(evt);
            }
        });

        txtAutoOption1.setToolTipText("");
        txtAutoOption1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtAutoOption1ActionPerformed(evt);
            }
        });

        txtAutoOption2.setToolTipText("");
        txtAutoOption2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtAutoOption2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(chkbAutoOption1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtAutoOption1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(chkbAutoOption2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtAutoOption2, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(chkbAutoOption1)
                    .addComponent(txtAutoOption1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(chkbAutoOption2)
                    .addComponent(txtAutoOption2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(106, Short.MAX_VALUE))
        );

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8_Budget_48px_1.png"))); // NOI18N

        jLabel4.setBackground(new java.awt.Color(255, 255, 255));
        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8_Tax_48px.png"))); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(82, 82, 82)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 416, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(201, 201, 201)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(143, 143, 143)
                                .addComponent(backJButton, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(143, 143, 143)
                                .addComponent(btnCalculate, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(277, 277, 277))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 63, Short.MAX_VALUE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(56, 56, 56)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(btnCalculate))
                .addGap(9, 9, 9)
                .addComponent(backJButton)
                .addContainerGap(56, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void txtHCoption4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtHCoption4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtHCoption4ActionPerformed

    private void txtEduoption2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtEduoption2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtEduoption2ActionPerformed

    private void chkbHealthOption2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chkbHealthOption2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_chkbHealthOption2ActionPerformed

    private void btnCalculateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCalculateActionPerformed
        // TODO add your handling code here:

        if (!chkbHealthOption1.isSelected() && !chkbHealthOption2.isSelected()
                && !chkbHealthOption3.isSelected() && !chkbHealthOption4.isSelected()) {
            flag = true;
            JOptionPane.showMessageDialog(null, "Please select atleast a fund option for Health Department");

        } else if (!chkbEduOption1.isSelected() && !chkbEduOption2.isSelected()
                && !chkbEduOption3.isSelected()) {
            flag = true;
            JOptionPane.showMessageDialog(null, "Please select atleast a fund option for Education Department");
        } else if (!chkbTourOption1.isSelected() && !chkbTourOption2.isSelected()) {
            flag = true;
            JOptionPane.showMessageDialog(null, "Please select atleast a fund option for Tourism Department");
        } else if (!chkbAutoOption1.isSelected() && !chkbAutoOption2.isSelected()) {
            flag = true;
            JOptionPane.showMessageDialog(null, "Please select atleast a fund option for Automobile Department");
        } else if (!chkbInfraOption1.isSelected() && !chkbInfraOption2.isSelected()) {
            flag = true;
            JOptionPane.showMessageDialog(null, "Please select atleast a fund option for Infrastructure Department");
        } else if (!chkbIndOption1.isSelected() && !chkbIndOption2.isSelected() && !chkbIndOption3.isSelected() && !chkbIndOption4.isSelected()) {
            flag = true;
            JOptionPane.showMessageDialog(null, "Please select atleast a fund option for Industries Department");
        }
        
        boolean flag1 = txtHCoption1.getText().matches("/^(?=.*\\d)[\\d ]+$/");
        boolean flag2 = txtHCoption2.getText().matches("/^(?=.*\\d)[\\d ]+$/");
        boolean flag3 = txtHCoption3.getText().matches("/^(?=.*\\d)[\\d ]+$/");
        boolean flag4 = txtHCoption4.getText().matches("/^(?=.*\\d)[\\d ]+$/");
        boolean flag5 = txtEduoption1.getText().matches("/^(?=.*\\d)[\\d ]+$/");
        boolean flag6 = txtEduoption2.getText().matches("/^(?=.*\\d)[\\d ]+$/");
        boolean flag7 = txtEduoption3.getText().matches("/^(?=.*\\d)[\\d ]+$/");
        boolean flag8 = txtTourOption1.getText().matches("/^(?=.*\\d)[\\d ]+$/");
        boolean flag9 = txtTourOption2.getText().matches("/^(?=.*\\d)[\\d ]+$/");
        boolean flag10 = txtAutoOption1.getText().matches("/^(?=.*\\d)[\\d ]+$/");
        boolean flag11 = txtAutoOption2.getText().matches("/^(?=.*\\d)[\\d ]+$/");
        boolean flag12 = txtInfraoption1.getText().matches("/^(?=.*\\d)[\\d ]+$/");
        boolean flag13 = txtInfraoption2.getText().matches("/^(?=.*\\d)[\\d ]+$/");
        boolean flag14 = txtIndoption1.getText().matches("/^(?=.*\\d)[\\d ]+$/");
        boolean flag15 = txtIndoption2.getText().matches("/^(?=.*\\d)[\\d ]+$/");
        boolean flag16 = txtIndoption3.getText().matches("/^(?=.*\\d)[\\d ]+$/");
        boolean flag17 = txtIndOption4.getText().matches("/^(?=.*\\d)[\\d ]+$/");
        if(flag1 == true && flag2 == true && flag3 == true && flag4 ==true || flag5 == true &&
                flag6 == true && flag7 == true || flag8 == true && flag9 == true || flag10 == true && flag11 == true ||
                flag12 == true && flag13 == true || flag14 == true && flag15 == true && flag16 == true && flag17 == true )
        {
            JOptionPane.showMessageDialog(null,"Enter a valid number!");
        }
        
        
        
        
        totalBudget = linearRegression();
        
     
        if(totalBudget == 0 )
        {
            JOptionPane.showMessageDialog(null, "Please give funds to organizations");
        }
        else{
            if (totalBudget < 300000 ) {
                
                //txtPredictInfra.setText(String.valueOf(totalBudget));
                BudgetAdminWorkAreaJPanel budgetAdminWorkAreaJPanel = new BudgetAdminWorkAreaJPanel(userProcessContainer, enterprise, system, budgetDirectory, userAccount);
                userProcessContainer.add("BudgetAdminWorkAreaJPanel", budgetAdminWorkAreaJPanel);
                CardLayout layout = (CardLayout) userProcessContainer.getLayout();
                layout.next(userProcessContainer);
            } 
            else 
            {
                JOptionPane.showMessageDialog(null, "Budget calculated has exceeded the total allocated budget for this financial year");
            }
        }
    }//GEN-LAST:event_btnCalculateActionPerformed

    private void backJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backJButtonActionPerformed
        userProcessContainer.remove(this);

        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
    }//GEN-LAST:event_backJButtonActionPerformed

    private void chkbHealthOption4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chkbHealthOption4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_chkbHealthOption4ActionPerformed

    private void txtEduoption1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtEduoption1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtEduoption1ActionPerformed

    private void chkbEduOption2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chkbEduOption2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_chkbEduOption2ActionPerformed

    private void txtIndoption1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIndoption1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIndoption1ActionPerformed

    private void txtIndOption4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIndOption4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIndOption4ActionPerformed

    private void txtIndoption2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIndoption2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIndoption2ActionPerformed

    private void txtInfraoption1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtInfraoption1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtInfraoption1ActionPerformed

    private void txtTourOption1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTourOption1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTourOption1ActionPerformed

    private void txtHCoption2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtHCoption2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtHCoption2ActionPerformed

    private void txtHCoption1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtHCoption1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtHCoption1ActionPerformed

    private void txtAutoOption2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtAutoOption2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtAutoOption2ActionPerformed

    private void txtAutoOption1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtAutoOption1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtAutoOption1ActionPerformed

    private void txtInfraoption2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtInfraoption2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtInfraoption2ActionPerformed

    private void txtTourOption2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTourOption2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTourOption2ActionPerformed

    private void chkbIndOption2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chkbIndOption2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_chkbIndOption2ActionPerformed

    private void chkbAutoOption1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chkbAutoOption1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_chkbAutoOption1ActionPerformed

    private void chkbHealthOption3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chkbHealthOption3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_chkbHealthOption3ActionPerformed

    private void chkbAutoOption2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chkbAutoOption2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_chkbAutoOption2ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backJButton;
    private javax.swing.JButton btnCalculate;
    private javax.swing.JCheckBox chkbAutoOption1;
    private javax.swing.JCheckBox chkbAutoOption2;
    private javax.swing.JCheckBox chkbEduOption1;
    private javax.swing.JCheckBox chkbEduOption2;
    private javax.swing.JCheckBox chkbEduOption3;
    private javax.swing.JCheckBox chkbHealthOption1;
    private javax.swing.JCheckBox chkbHealthOption2;
    private javax.swing.JCheckBox chkbHealthOption3;
    private javax.swing.JCheckBox chkbHealthOption4;
    private javax.swing.JCheckBox chkbIndOption1;
    private javax.swing.JCheckBox chkbIndOption2;
    private javax.swing.JCheckBox chkbIndOption3;
    private javax.swing.JCheckBox chkbIndOption4;
    private javax.swing.JCheckBox chkbInfraOption1;
    private javax.swing.JCheckBox chkbInfraOption2;
    private javax.swing.JCheckBox chkbTourOption1;
    private javax.swing.JCheckBox chkbTourOption2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private java.awt.Panel panel1;
    private javax.swing.JTextField txtAutoOption1;
    private javax.swing.JTextField txtAutoOption2;
    private javax.swing.JTextField txtEduoption1;
    private javax.swing.JTextField txtEduoption2;
    private javax.swing.JTextField txtEduoption3;
    private javax.swing.JTextField txtHCoption1;
    private javax.swing.JTextField txtHCoption2;
    private javax.swing.JTextField txtHCoption3;
    private javax.swing.JTextField txtHCoption4;
    private javax.swing.JTextField txtIndOption4;
    private javax.swing.JTextField txtIndoption1;
    private javax.swing.JTextField txtIndoption2;
    private javax.swing.JTextField txtIndoption3;
    private javax.swing.JTextField txtInfraoption1;
    private javax.swing.JTextField txtInfraoption2;
    private javax.swing.JTextField txtTourOption1;
    private javax.swing.JTextField txtTourOption2;
    // End of variables declaration//GEN-END:variables
}
