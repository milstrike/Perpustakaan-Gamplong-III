/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lib.pkg.perpustakaangamplong;

/**
 *
 * @author milstrike
 */
public class Bantuan extends javax.swing.JFrame {

    /**
     * Creates new form Bantuan
     */
    public Bantuan() {
        initComponents();
        init0();
    }
    
    public void init0(){
        setLocationRelativeTo(null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextField1 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList<>();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Bantuan Penggunaan Aplikasi");
        setAlwaysOnTop(true);
        setType(java.awt.Window.Type.UTILITY);

        jButton1.setText("Cari Bantuan!");

        jList1.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Bantuan 1", "Bantuan 2", "Bantuan 3", "Bantuan 4", "Bantuan 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(jList1);

        jLabel1.setText("Topik Bantuan:");

        jTextArea1.setColumns(20);
        jTextArea1.setLineWrap(true);
        jTextArea1.setRows(5);
        jTextArea1.setText("Lorem ipsum dolor sit amet, consectetur adipiscing elit. Etiam ligula lacus, vestibulum tempor nulla nec, placerat auctor nisl. Mauris sed dui tortor. Mauris pulvinar magna id pretium volutpat. Duis consectetur ipsum ut odio sodales posuere. Vestibulum nec lorem id sapien convallis auctor. Phasellus ac libero ac sapien placerat sollicitudin. Vestibulum sodales quam quis sapien consequat venenatis. Cras vestibulum orci eget tortor aliquam, non gravida lacus vulputate. Mauris vel bibendum diam. Duis ultrices, odio et elementum aliquet, leo felis luctus arcu, ut blandit nisi sapien elementum sem.\n\nNulla semper nisi nec mattis ornare. Donec luctus luctus turpis, sit amet tristique leo auctor id. Proin odio nulla, iaculis nec semper nec, scelerisque sed ligula. Nullam vitae blandit lorem. Aenean quam dolor, malesuada molestie dapibus vulputate, viverra in dolor. Mauris convallis, est ut iaculis fermentum, justo metus egestas massa, in tincidunt odio dolor sit amet neque. Proin luctus ut velit nec commodo. Etiam mollis tincidunt rhoncus. Ut eget ipsum nulla. Curabitur lacus neque, aliquam et magna a, porta rutrum nunc. Nam lobortis diam ut metus euismod ullamcorper. Integer ut massa dolor. Sed eu augue vitae lacus cursus tristique.\n\nDuis sodales ligula pellentesque, auctor sem nec, ullamcorper dui. Nullam vel tincidunt nisi, eu ornare quam. Duis tempor convallis pharetra. In posuere elit sit amet dui congue, sed cursus turpis pharetra. Donec et tempus metus. Aenean congue lacus vitae metus aliquet facilisis. Pellentesque vitae tempor enim. Quisque egestas sapien id metus vehicula, ut laoreet massa hendrerit. Quisque scelerisque urna a nulla malesuada, ut ornare eros egestas.\n\nDuis sed massa sed velit porta blandit. Duis at eleifend massa. Nam urna dolor, dictum eget lectus id, suscipit ullamcorper magna. Proin sollicitudin, turpis a sodales condimentum, lacus enim rhoncus dui, nec placerat sem dolor nec mauris. Proin eu dui sed metus viverra ultrices et et justo. In id mi tincidunt, feugiat metus nec, pulvinar mauris. Aenean facilisis risus interdum euismod tristique. Praesent eu mauris quam. Donec consequat eu mi ac dapibus. Sed luctus blandit sapien eget varius. Quisque lobortis orci sed sem scelerisque volutpat.\n\nDonec nec ligula eu felis auctor lacinia. Pellentesque sit amet tincidunt sem. Proin felis orci, feugiat id scelerisque eu, mollis pulvinar dui. Cras dapibus mauris sapien, sed tempor augue feugiat sit amet. Suspendisse convallis libero ac elit placerat lacinia. Donec mattis tortor in lorem ullamcorper fringilla. Nullam hendrerit nibh at erat auctor pellentesque. Curabitur non ex at orci lobortis mattis ac eu sem. Duis at felis nisl. Phasellus finibus, eros in laoreet faucibus, mauris turpis vestibulum ipsum, eu euismod quam ex quis erat. Vestibulum sit amet volutpat felis.");
        jScrollPane2.setViewportView(jTextArea1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jTextField1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 329, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 428, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 480, Short.MAX_VALUE))
                    .addComponent(jScrollPane2))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
                if (globalVariabel.activeTheme.equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Bantuan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Bantuan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Bantuan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Bantuan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Bantuan().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JList<String> jList1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}
