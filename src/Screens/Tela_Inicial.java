package Screens;

import Class.Background_image;
import com.jtattoo.plaf.mint.MintLookAndFeel;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.UIManager;

public class Tela_Inicial extends javax.swing.JFrame
{
    public Tela_Inicial()
    {   
        try
        { UIManager.setLookAndFeel( new MintLookAndFeel()); }
        catch( Exception ex )
        { JOptionPane.showMessageDialog(null,"Não foi possível inicializar a Interface Grafica Tatto" ); }
        initComponents();
        Background_image fundo = new Background_image
        ( new ImageIcon("src/imagens/fundo.jpeg").getImage() );
        this.getContentPane().add(fundo);
    }
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        bt_addAlbum = new javax.swing.JButton();
        bt_Historico = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("AlbumTeca");
        setName("AlbumTeca"); // NOI18N
        setPreferredSize(new java.awt.Dimension(650, 725));

        jLabel1.setFont(new java.awt.Font("Amatic SC", 0, 95)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 46, 99));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("ÁlbumTeca");
        jLabel1.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        bt_addAlbum.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/Bt_Adiconar Álbum.png"))); // NOI18N
        bt_addAlbum.setBorder(null);
        bt_addAlbum.setBorderPainted(false);
        bt_addAlbum.setContentAreaFilled(false);
        bt_addAlbum.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        bt_addAlbum.setFocusPainted(false);
        bt_addAlbum.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_addAlbumActionPerformed(evt);
            }
        });

        bt_Historico.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/Bt_Historico.png"))); // NOI18N
        bt_Historico.setBorder(null);
        bt_Historico.setBorderPainted(false);
        bt_Historico.setContentAreaFilled(false);
        bt_Historico.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        bt_Historico.setFocusPainted(false);
        bt_Historico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_HistoricoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(225, 225, 225)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(bt_Historico, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(bt_addAlbum, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(230, 230, 230))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(68, 68, 68)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addComponent(bt_addAlbum)
                .addGap(18, 18, 18)
                .addComponent(bt_Historico)
                .addContainerGap(384, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void bt_addAlbumActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_addAlbumActionPerformed
        AddAlbum call = new AddAlbum();
        this.dispose();
        call.setVisible(true);
    }//GEN-LAST:event_bt_addAlbumActionPerformed

    private void bt_HistoricoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_HistoricoActionPerformed
        Historico call = new Historico();
        this.dispose();
        call.setVisible(true);// TODO add your handling code here:
    }//GEN-LAST:event_bt_HistoricoActionPerformed

    public static void main(String args[])
    {
        java.awt.EventQueue.invokeLater(new Runnable()
        {
            public void run()
            {   new Tela_Inicial().setVisible(true);    }
        });
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bt_Historico;
    private javax.swing.JButton bt_addAlbum;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}