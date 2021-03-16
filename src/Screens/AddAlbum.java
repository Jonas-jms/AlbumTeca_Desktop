package Screens;

import Class.Background_image;
import CRUD.Insert;
import Class.ModuloConexao;
import com.jtattoo.plaf.mint.MintLookAndFeel;
import java.sql.Connection;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.UIManager;

public class AddAlbum extends javax.swing.JFrame
{
    private Connection conexao;
    public AddAlbum()
    {   
        try
        { UIManager.setLookAndFeel( new MintLookAndFeel()); }
        catch( Exception ex )
         { JOptionPane.showMessageDialog(null,"Não foi possível inicializar a Interface Gráfica Tatto" ); }
        initComponents();
        Background_image fundo = new Background_image
        ( new ImageIcon("src/imagens/fundo.jpeg").getImage() );
        this.getContentPane().add(fundo);
    }
    
    public void Cadastrar_Album()
    {
        try
        {   conexao.close();   }
        catch(Exception e)
        {   conexao = ModuloConexao.conector();   }
        
        Insert novo_album = new Insert();
        
        novo_album.setArtista(txt_artista.getText());
        
        if(novo_album.getArtista().equals(""))
        JOptionPane.showMessageDialog(null, "Informe o nome do artista do álbum!");
        else
        {
            novo_album.setGenero(txt_genero.getText());
            
            if(novo_album.getGenero().equals(""))
            JOptionPane.showMessageDialog(null, "Informe ao menos um gênero para o álbum!");
            else
            {
                novo_album.setAlbum(txt_nome.getText());
                
                if(novo_album.getAlbum().equals(""))
                JOptionPane.showMessageDialog(null, "Informe o nome do álbum!");
                else
                {
                    if(novo_album.insertArtista(conexao)==false)
                    JOptionPane.showMessageDialog(null, "Não foi possível cadastrar este Artista no Banco de Dados!");
                    else
                    {             
                        if(novo_album.insertGenero(conexao)==false)
                        JOptionPane.showMessageDialog(null, "Não foi possível cadastrar este Gênero no Banco de Dados!");
                        else
                        {
                            long offline_time = System.currentTimeMillis();
                            Date time = new Date(offline_time);

                            DateFormat mes = new SimpleDateFormat ("MMMMM", new Locale ("pt", "BR"));

                            if(novo_album.insert_album(conexao,nacional.isSelected(),destaque_mes.isSelected(),mes.format(time))==false)
                            JOptionPane.showMessageDialog(null, "Não foi possível cadastrar esse álbum no Banco de Dados!");
                            else
                            {
                                JOptionPane.showMessageDialog(null,"Álbum cadastrado com sucesso!");
                                txt_nome.setText("");
                                txt_artista.setText("");
                                txt_genero.setText("");
                            }
                        }
                    }
                }
            }
        }
        
        try 
        { conexao.close(); }
        catch (SQLException ex)
        { Logger.getLogger(AddAlbum.class.getName()).log(Level.SEVERE, null, ex); }
    }
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        label_nome = new javax.swing.JLabel();
        label_artista = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txt_artista = new javax.swing.JTextField();
        txt_nome = new javax.swing.JTextField();
        txt_genero = new javax.swing.JTextField();
        bt_addAlbum = new javax.swing.JButton();
        nacional = new javax.swing.JCheckBox();
        destaque_mes = new javax.swing.JCheckBox();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Adicionar Novo Álbum");
        setPreferredSize(new java.awt.Dimension(650, 725));

        label_nome.setFont(new java.awt.Font("Patrick Hand SC", 0, 30)); // NOI18N
        label_nome.setForeground(new java.awt.Color(255, 46, 99));
        label_nome.setText("   Nome:");

        label_artista.setFont(new java.awt.Font("Patrick Hand SC", 0, 30)); // NOI18N
        label_artista.setForeground(new java.awt.Color(255, 46, 99));
        label_artista.setText("   Artista:");

        jLabel4.setFont(new java.awt.Font("Patrick Hand SC", 0, 30)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 46, 99));
        jLabel4.setText("   Gênero:");

        txt_artista.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        txt_artista.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(189, 16, 224)));

        txt_nome.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        txt_nome.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(189, 16, 224)));

        txt_genero.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        txt_genero.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(189, 16, 224)));

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

        nacional.setFont(new java.awt.Font("Patrick Hand SC", 0, 30)); // NOI18N
        nacional.setForeground(new java.awt.Color(255, 46, 99));
        nacional.setText("NACIONAL");
        nacional.setOpaque(false);

        destaque_mes.setFont(new java.awt.Font("Patrick Hand SC", 0, 30)); // NOI18N
        destaque_mes.setForeground(new java.awt.Color(255, 46, 99));
        destaque_mes.setText("MELHOR DO MÊS");
        destaque_mes.setOpaque(false);
        destaque_mes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                destaque_mesActionPerformed(evt);
            }
        });

        jButton1.setFont(new java.awt.Font("Patrick Hand SC", 0, 30)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 46, 99));
        jButton1.setText(" VOLTAR ");
        jButton1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 46, 99), 1, true));
        jButton1.setContentAreaFilled(false);
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(label_artista)
                        .addComponent(jLabel4)
                        .addComponent(label_nome)
                        .addComponent(nacional))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addGap(56, 56, 56)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txt_nome, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_genero, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_artista, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(bt_addAlbum)
                        .addComponent(destaque_mes)))
                .addContainerGap(380, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(jButton1)
                .addGap(50, 50, 50)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(label_nome)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(label_artista)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel4))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addComponent(txt_nome, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txt_artista, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txt_genero, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 0, 0)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nacional)
                    .addComponent(destaque_mes))
                .addGap(18, 18, 18)
                .addComponent(bt_addAlbum)
                .addContainerGap(341, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void destaque_mesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_destaque_mesActionPerformed
    }//GEN-LAST:event_destaque_mesActionPerformed

    private void bt_addAlbumActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_addAlbumActionPerformed
        Cadastrar_Album();
    }//GEN-LAST:event_bt_addAlbumActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        Tela_Inicial call = new Tela_Inicial();
        call.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    public static void main(String args[])
    {
        java.awt.EventQueue.invokeLater(new Runnable()
        {
            public void run()
            {   new AddAlbum().setVisible(true);    }
        });
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bt_addAlbum;
    private javax.swing.JCheckBox destaque_mes;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel label_artista;
    private javax.swing.JLabel label_nome;
    private javax.swing.JCheckBox nacional;
    private javax.swing.JTextField txt_artista;
    private javax.swing.JTextField txt_genero;
    private javax.swing.JTextField txt_nome;
    // End of variables declaration//GEN-END:variables
}