/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package poker.gameUI;

/**
 *
 * @author donal.davies
 */
public class CoreUI extends javax.swing.JFrame {

    /**
     * Creates new form CoreUI
     */
    public CoreUI() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        gameBoard = new javax.swing.JPanel();
        ai1 = new javax.swing.JLabel();
        ai2 = new javax.swing.JLabel();
        ai3 = new javax.swing.JLabel();
        ai4 = new javax.swing.JLabel();
        Player = new javax.swing.JLabel();
        ai5 = new javax.swing.JLabel();
        ai6 = new javax.swing.JLabel();
        ai7 = new javax.swing.JLabel();
        curPool = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        gameLog = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        gameBoard.setBackground(new java.awt.Color(0, 100, 0));
        gameBoard.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        ai1.setText("<Player>");

        ai2.setText("<Player>");

        ai3.setText("<Player>");

        ai4.setText("<Player>");

        Player.setText("\"You\"");

        ai5.setText("<Player>");

        ai6.setText("<Player>");

        ai7.setText("<Player>");

        curPool.setText("jLabel1");

        javax.swing.GroupLayout gameBoardLayout = new javax.swing.GroupLayout(gameBoard);
        gameBoard.setLayout(gameBoardLayout);
        gameBoardLayout.setHorizontalGroup(
            gameBoardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(gameBoardLayout.createSequentialGroup()
                .addGroup(gameBoardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(gameBoardLayout.createSequentialGroup()
                        .addGap(106, 106, 106)
                        .addGroup(gameBoardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(ai1)
                            .addGroup(gameBoardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(curPool)
                                .addComponent(Player))))
                    .addGroup(gameBoardLayout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addGroup(gameBoardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(ai5)
                            .addComponent(ai7))
                        .addGap(115, 115, 115)
                        .addGroup(gameBoardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(ai2)
                            .addComponent(ai4))))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, gameBoardLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(ai6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 184, Short.MAX_VALUE)
                .addComponent(ai3)
                .addGap(172, 172, 172))
        );
        gameBoardLayout.setVerticalGroup(
            gameBoardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(gameBoardLayout.createSequentialGroup()
                .addGroup(gameBoardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(gameBoardLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(ai1))
                    .addGroup(gameBoardLayout.createSequentialGroup()
                        .addGap(44, 44, 44)
                        .addGroup(gameBoardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(ai7)
                            .addComponent(ai2))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(gameBoardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ai3)
                    .addComponent(ai6)
                    .addComponent(curPool))
                .addGap(63, 63, 63)
                .addGroup(gameBoardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ai4)
                    .addComponent(ai5))
                .addGap(32, 32, 32)
                .addComponent(Player)
                .addGap(186, 186, 186))
        );

        gameLog.setBackground(new java.awt.Color(255, 255, 153));
        gameLog.setColumns(20);
        gameLog.setRows(5);
        jScrollPane1.setViewportView(gameLog);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(gameBoard, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 85, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(gameBoard, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 449, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /*
         * Set the Nimbus look and feel
         */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /*
         * If Nimbus (introduced in Java SE 6) is not available, stay with the
         * default look and feel. For details see
         * http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(CoreUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CoreUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CoreUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CoreUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /*
         * Create and display the form
         */
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new CoreUI().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Player;
    private javax.swing.JLabel ai1;
    private javax.swing.JLabel ai2;
    private javax.swing.JLabel ai3;
    private javax.swing.JLabel ai4;
    private javax.swing.JLabel ai5;
    private javax.swing.JLabel ai6;
    private javax.swing.JLabel ai7;
    private javax.swing.JLabel curPool;
    private javax.swing.JPanel gameBoard;
    private javax.swing.JTextArea gameLog;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}