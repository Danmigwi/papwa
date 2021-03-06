
import java.awt.Image;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
public class SigningForm extends javax.swing.JFrame {

    String gender;
    String knowledge = "";
    String filename=null;
    byte[] imgbyt=null;
    
    public SigningForm() {
        initComponents();
        showUser();
    }

    public ArrayList<User> userlist() {
        ArrayList<User> userlist = new ArrayList<>();
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/testjdbc", "root", "");
            String query1 = "SELECT * FROM sfjava";
            Statement stm = con.createStatement();
            ResultSet rs = stm.executeQuery(query1);
            User user;
            while (rs.next()) {
                user = new User(rs.getInt("id"), rs.getString("name"), rs.getString("address"), rs.getString("gender"), rs.getString("knowledge"), rs.getString("subject"),rs.getBytes("myimage"));
                userlist.add(user);
            }
        } catch (ClassNotFoundException | SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return userlist;
    }

    public void showUser() {
        ArrayList<User> list = userlist();
        DefaultTableModel defaultTableModel = (DefaultTableModel) jTableContent.getModel();
        Object[] row = new Object[6];
        for (int i = 0; i < list.size(); i++) {
            row[0] = list.get(i).getSno();
            row[1] = list.get(i).getName();
            row[2] = list.get(i).getAdderss();
            row[3] = list.get(i).getGender();
            row[4] = list.get(i).getKnowledge();
            row[5] = list.get(i).getSubject();

           defaultTableModel.addRow(row);
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

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        Contentpanel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtUsername = new javax.swing.JTextField();
        txtAddress = new javax.swing.JTextField();
        rdmale = new javax.swing.JRadioButton();
        rdfemale = new javax.swing.JRadioButton();
        chkjava = new javax.swing.JCheckBox();
        chkpython = new javax.swing.JCheckBox();
        combsubject = new javax.swing.JComboBox<>();
        btnsave = new javax.swing.JButton();
        btnreset = new javax.swing.JButton();
        btnupdate = new javax.swing.JButton();
        btndelete = new javax.swing.JButton();
        TablePanel = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableContent = new javax.swing.JTable();
        jLabeimage = new javax.swing.JLabel();
        btnImage = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Name");

        jLabel2.setText("Address");

        jLabel3.setText("Gender");

        jLabel4.setText("Knowledge");

        jLabel5.setText("Subject");

        buttonGroup1.add(rdmale);
        rdmale.setText("Male");

        buttonGroup1.add(rdfemale);
        rdfemale.setText("Female");

        chkjava.setText("Java");

        chkpython.setText("Python");

        combsubject.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Computer Science", "Computer Management", "Information Technology", "Business IT", "Arts", "Education", "Nursing" }));

        btnsave.setText("Save");
        btnsave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsaveActionPerformed(evt);
            }
        });

        btnreset.setText("Reset");
        btnreset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnresetActionPerformed(evt);
            }
        });

        btnupdate.setText("Update");
        btnupdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnupdateActionPerformed(evt);
            }
        });

        btndelete.setText("Delete");
        btndelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btndeleteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout ContentpanelLayout = new javax.swing.GroupLayout(Contentpanel);
        Contentpanel.setLayout(ContentpanelLayout);
        ContentpanelLayout.setHorizontalGroup(
            ContentpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ContentpanelLayout.createSequentialGroup()
                .addGroup(ContentpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(ContentpanelLayout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addGroup(ContentpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(ContentpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 63, Short.MAX_VALUE)
                                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(ContentpanelLayout.createSequentialGroup()
                        .addGap(7, 7, 7)
                        .addComponent(btnsave)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnupdate)))
                .addGroup(ContentpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(ContentpanelLayout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addGroup(ContentpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(ContentpanelLayout.createSequentialGroup()
                                .addComponent(chkjava)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(chkpython))
                            .addComponent(txtAddress, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtUsername, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(ContentpanelLayout.createSequentialGroup()
                                .addComponent(rdmale)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(rdfemale))
                            .addComponent(combsubject, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(ContentpanelLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btndelete)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 91, Short.MAX_VALUE)
                        .addComponent(btnreset)))
                .addContainerGap(16, Short.MAX_VALUE))
        );
        ContentpanelLayout.setVerticalGroup(
            ContentpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ContentpanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(ContentpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtUsername, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(ContentpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtAddress, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(ContentpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addGroup(ContentpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(rdmale)
                        .addComponent(rdfemale)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(ContentpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addGroup(ContentpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(chkjava)
                        .addComponent(chkpython)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(ContentpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(combsubject, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 261, Short.MAX_VALUE)
                .addGroup(ContentpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnsave)
                    .addComponent(btnupdate)
                    .addComponent(btnreset)
                    .addComponent(btndelete))
                .addGap(33, 33, 33))
        );

        jTableContent.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Name", "Address", "Gender", "Knowledge", "Subject"
            }
        ));
        jTableContent.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableContentMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTableContent);

        btnImage.setText("Choose Image");
        btnImage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnImageActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout TablePanelLayout = new javax.swing.GroupLayout(TablePanel);
        TablePanel.setLayout(TablePanelLayout);
        TablePanelLayout.setHorizontalGroup(
            TablePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(TablePanelLayout.createSequentialGroup()
                .addComponent(jLabeimage, javax.swing.GroupLayout.PREFERRED_SIZE, 257, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnImage)
                .addGap(0, 172, Short.MAX_VALUE))
            .addGroup(TablePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 558, Short.MAX_VALUE))
        );
        TablePanelLayout.setVerticalGroup(
            TablePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(TablePanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(TablePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, TablePanelLayout.createSequentialGroup()
                        .addComponent(btnImage)
                        .addGap(110, 110, 110))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, TablePanelLayout.createSequentialGroup()
                        .addComponent(jLabeimage, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
            .addGroup(TablePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(TablePanelLayout.createSequentialGroup()
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 270, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(Contentpanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(TablePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Contentpanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(TablePanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnsaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsaveActionPerformed
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/testjdbc", "root", "");
            String query = "insert into sfjava(name, address, gender, knowledge, subject,myimage)values(?,?,?,?,?,?)";
            PreparedStatement pst = con.prepareStatement(query);
            pst.setString(1, txtUsername.getText());
            pst.setString(2, txtAddress.getText());
            //RADIOBOX CONFIGERATION
            if (rdmale.isSelected()) {
                gender = "Male";
            }
            if (rdfemale.isSelected()) {
                gender = "Female";
            }
            pst.setString(3, gender);

            //CHECKBOX CONFIGURETION
            if (chkjava.isSelected()) {
                knowledge = chkjava.getText() + " ";
            }
            if (chkpython.isSelected()) {
                knowledge = chkpython.getText() + " ";
            }
            pst.setString(4, knowledge);
            //COMBO CONFIGURATION
            String course;
            course = combsubject.getSelectedItem().toString();
            pst.setString(5, course);
            pst.setBytes(6,imgbyt);
            pst.executeUpdate();

            //REFERSHING THE TABLE
            DefaultTableModel defaultTableModel = (DefaultTableModel) jTableContent.getModel();
            defaultTableModel.setRowCount(0);
            showUser();
            JOptionPane.showMessageDialog(null, "Insertion successful");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }//GEN-LAST:event_btnsaveActionPerformed

    private void btnresetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnresetActionPerformed
        txtAddress.setText("");
        txtUsername.setText("");
        buttonGroup1.clearSelection();
        chkjava.setSelected(false);
        chkpython.setSelected(false);
        combsubject.setSelectedIndex(0);
        jLabeimage.setIcon(null);
    }//GEN-LAST:event_btnresetActionPerformed

    private void jTableContentMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableContentMouseClicked
        int i = jTableContent.getSelectedRow();
        TableModel model = jTableContent.getModel();
        txtUsername.setText(model.getValueAt(i, 1).toString());
        txtAddress.setText(model.getValueAt(i, 2).toString());

        String sex = model.getValueAt(i, 3).toString();
        if (sex.equals("Male")) {
            rdmale.setSelected(true);
        } else {
            rdfemale.setSelected(true);
        }
        String knowledge = model.getValueAt(i, 4).toString();
        switch (knowledge) {
            case "Java ":
                chkjava.setSelected(true);
                chkpython.setSelected(false);
                break;
            case "Python ":
                chkpython.setSelected(true);
                chkjava.setSelected(false);
                break;
            default:
                chkjava.setSelected(true);
                chkpython.setSelected(true);
                break;
        }
        String subject1 = model.getValueAt(i, 5).toString();
        switch (subject1) {
            case "Computer Science":
                combsubject.setSelectedIndex(0);
                break;
            case "Computer Management":
                combsubject.setSelectedIndex(1);
                break;
            case "Information Tecnology":
                combsubject.setSelectedIndex(2);
                break;
            case "Business IT":
                combsubject.setSelectedIndex(3);
                break;
            case "Arts":
                combsubject.setSelectedIndex(4);
                break;
            case "Education":
                combsubject.setSelectedIndex(5);
                break;
            case "Nursing":
                combsubject.setSelectedIndex(6);
                break;

        }
       byte[] img =(userlist().get(i).getPicture());
        ImageIcon imageicon;
        imageicon=new ImageIcon(new ImageIcon(img).getImage().getScaledInstance(jLabeimage.getWidth(), jLabeimage.getHeight(), Image.SCALE_SMOOTH));
        jLabeimage.setIcon(imageicon);
        //ImageIcon imageicon=new ImageIcon(new ImageIcon(img).getImage().getScaledInstance(jLabeimage.getWidth(),jLabeimage.getHeight(),Image.SCALE_SMOOTH));
        //jLabeimage.setIcon(imageicon);
    }//GEN-LAST:event_jTableContentMouseClicked

    private void btnupdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnupdateActionPerformed
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/testjdbc", "root", "");
            int row = jTableContent.getSelectedRow();
            String value = (jTableContent.getModel().getValueAt(row, 0).toString());
            String query = "UPDATE sfjava SET name=?,address=?,gender=?,knowledge=?,subject=? WHERE id=" + value;
            PreparedStatement pst = con.prepareStatement(query);
            pst.setString(1, txtUsername.getText());
            pst.setString(2, txtAddress.getText());
            //RADIOBOX CONFIGERATION
            if (rdmale.isSelected()) {
                gender = "Male";
            }
            if (rdfemale.isSelected()) {
                gender = "Female";
            }
            pst.setString(3, gender);

            //CHECKBOX CONFIGURETION 
            if (chkjava.isSelected()) {
                knowledge += chkjava.getText() + " ";
            }
            if (chkpython.isSelected()) {
                knowledge += chkpython.getText() + " ";
            }
            pst.setString(4, knowledge);
            //COMBO CONFIGURATION
            String course;
            course = combsubject.getSelectedItem().toString();
            pst.setString(5, course);

            pst.executeUpdate();

            DefaultTableModel defaultTableModel = (DefaultTableModel) jTableContent.getModel();
            defaultTableModel.setRowCount(0);
            showUser();
            JOptionPane.showMessageDialog(null, "Updating successful");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
            System.out.println(e);
        }
    }//GEN-LAST:event_btnupdateActionPerformed

    private void btndeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btndeleteActionPerformed
       int delOpt=JOptionPane.showConfirmDialog(null,"Do you realy want to Delete this data", "Delete", JOptionPane.YES_NO_OPTION);
        if (delOpt==0) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/testjdbc", "root", "");
            int row = jTableContent.getSelectedRow();
            String value = (jTableContent.getModel().getValueAt(row, 0).toString());
            String query = "DELETE FROM sfjava WHERE id=" + value;
            PreparedStatement pst = con.prepareStatement(query);
            pst.executeUpdate();
            DefaultTableModel defaultTableModel = (DefaultTableModel) jTableContent.getModel();
            defaultTableModel.setRowCount(0);

            showUser();
            JOptionPane.showMessageDialog(null, "Deletion successful");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
            System.out.println(e);
        }
        }
    }//GEN-LAST:event_btndeleteActionPerformed

    private void btnImageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnImageActionPerformed
        JFileChooser chooser=new JFileChooser();
        chooser.showOpenDialog(null);
        File f=chooser.getSelectedFile();
        filename=f.getAbsolutePath();
        ImageIcon imageicon;
        imageicon=new ImageIcon(new ImageIcon(filename).getImage().getScaledInstance(jLabeimage.getWidth(), jLabeimage.getHeight(), Image.SCALE_SMOOTH));
        jLabeimage.setIcon(imageicon);
        try{
            File file=new File(filename);
            FileInputStream fin=new FileInputStream(file);
            ByteArrayOutputStream bos=new ByteArrayOutputStream();
            byte[] byt=new byte[1024];
            for(int readNum;(readNum=fin.read(byt))!=-1;){
                bos.write(byt,0,readNum);
            }
            imgbyt=bos.toByteArray();
            
        }  catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
            System.out.println(e);
        }
    }//GEN-LAST:event_btnImageActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(SigningForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SigningForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SigningForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SigningForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SigningForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Contentpanel;
    private javax.swing.JPanel TablePanel;
    private javax.swing.JButton btnImage;
    private javax.swing.JButton btndelete;
    private javax.swing.JButton btnreset;
    private javax.swing.JButton btnsave;
    private javax.swing.JButton btnupdate;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JCheckBox chkjava;
    private javax.swing.JCheckBox chkpython;
    private javax.swing.JComboBox<String> combsubject;
    private javax.swing.JLabel jLabeimage;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableContent;
    private javax.swing.JRadioButton rdfemale;
    private javax.swing.JRadioButton rdmale;
    private javax.swing.JTextField txtAddress;
    private javax.swing.JTextField txtUsername;
    // End of variables declaration//GEN-END:variables
}
