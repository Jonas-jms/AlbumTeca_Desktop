package Screens;

import CRUD.Delete;
import CRUD.Update;
import Class.Background_image;
import com.jtattoo.plaf.mint.MintLookAndFeel;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.UIManager;

public class UpdateAlbum extends javax.swing.JFrame
{
    public UpdateAlbum()
    {   
        try
        { UIManager.setLookAndFeel( new MintLookAndFeel()); }
        catch( Exception ex )
         { JOptionPane.showMessageDialog(null,"Não foi possível inicializar a Interface Gráfica Tatto" ); }
        initComponents();
        Background_image fundo = new Background_image
        ( new ImageIcon("src/imagens/fundo.jpeg").getImage() );
        this.getContentPane().add(fundo);
        
        txt_nome.setText(Historico.nome);
        txt_artista.setText(Historico.artista);
        txt_genero.setText(Historico.genero);
        
        if(Historico.album_nacional==true)
        nacional.setSelected(true);
        if(Historico.destaque==true)
        destaque_mes.setSelected(true);
        
        if(Historico.mes.equals("Janeiro"))
        lista_mes.setSelectedIndex(0);
        else if(Historico.mes.equals("Fevereiro"))
        lista_mes.setSelectedIndex(1);
        else if(Historico.mes.equals("Março"))
        lista_mes.setSelectedIndex(2);
        else if(Historico.mes.equals("Abril"))
        lista_mes.setSelectedIndex(3);
        else if(Historico.mes.equals("Maio"))
        lista_mes.setSelectedIndex(4);
        else if(Historico.mes.equals("Junho"))
        lista_mes.setSelectedIndex(5);
        else if(Historico.mes.equals("Julho"))
        lista_mes.setSelectedIndex(6);
        else if(Historico.mes.equals("Agosto"))
        lista_mes.setSelectedIndex(7);
        else if(Historico.mes.equals("Setembro"))
        lista_mes.setSelectedIndex(8);
        else if(Historico.mes.equals("Outubro"))
        lista_mes.setSelectedIndex(9);
        else if(Historico.mes.equals("Novembro"))
        lista_mes.setSelectedIndex(10);
        else
        lista_mes.setSelectedIndex(11);
        
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        label_nome = new javax.swing.JLabel();
        label_artista = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txt_artista = new javax.swing.JTextField();
        txt_nome = new javax.swing.JTextField();
        txt_genero = new javax.swing.JTextField();
        nacional = new javax.swing.JCheckBox();
        destaque_mes = new javax.swing.JCheckBox();
        lista_mes = new javax.swing.JComboBox();
        label_filtro = new javax.swing.JLabel();
        btn_atualizar = new javax.swing.JButton();
        btn_excluir = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Visualizar Álbum");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });

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

        lista_mes.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        lista_mes.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Janeiro", "Fevereiro", "Março", "Abril", "Maio", "Junho", "Julho", "Agosto", "Setembro", "Outubro", "Novembro", "Dezembro" }));
        lista_mes.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(189, 16, 224)));
        lista_mes.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                lista_mesItemStateChanged(evt);
            }
        });

        label_filtro.setFont(new java.awt.Font("Patrick Hand SC", 0, 30)); // NOI18N
        label_filtro.setForeground(new java.awt.Color(255, 46, 99));
        label_filtro.setText("   Mês:");

        btn_atualizar.setFont(new java.awt.Font("Patrick Hand SC", 0, 30)); // NOI18N
        btn_atualizar.setForeground(new java.awt.Color(255, 46, 99));
        btn_atualizar.setText("ATUALIZAR");
        btn_atualizar.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 46, 99), 1, true));
        btn_atualizar.setContentAreaFilled(false);
        btn_atualizar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_atualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_atualizarActionPerformed(evt);
            }
        });

        btn_excluir.setFont(new java.awt.Font("Patrick Hand SC", 0, 30)); // NOI18N
        btn_excluir.setForeground(new java.awt.Color(255, 46, 99));
        btn_excluir.setText("EXCLUIR");
        btn_excluir.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 46, 99), 1, true));
        btn_excluir.setContentAreaFilled(false);
        btn_excluir.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_excluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_excluirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(nacional)
                        .addGap(0, 0, 0)
                        .addComponent(destaque_mes))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(label_filtro)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lista_mes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(336, 408, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(label_artista)
                            .addComponent(label_nome))
                        .addGap(6, 6, 6)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txt_artista)
                            .addComponent(txt_genero)
                            .addComponent(txt_nome)))
                    .addComponent(jLabel4))
                .addGap(226, 226, 226))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btn_atualizar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btn_excluir)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_atualizar)
                    .addComponent(btn_excluir))
                .addGap(30, 30, 30)
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nacional)
                    .addComponent(destaque_mes))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(label_filtro)
                    .addComponent(lista_mes, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(373, 373, 373))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void destaque_mesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_destaque_mesActionPerformed
    }//GEN-LAST:event_destaque_mesActionPerformed

    private void lista_mesItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_lista_mesItemStateChanged
        
    }//GEN-LAST:event_lista_mesItemStateChanged

    private void btn_atualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_atualizarActionPerformed
        
        Update atu = new Update();
        Delete del = new Delete();
        
        if(!txt_nome.getText().equals(Historico.nome))
        {
            atu.setAlbum(txt_nome.getText());
            
            if(!atu.getAlbum().equals(""))
            {
                if(atu.update_album(Historico.conexao, Historico.id_album)==true)
                JOptionPane.showMessageDialog(null, "Nome do álbum atualizado com sucesso!");
                else
                JOptionPane.showMessageDialog(null, "Houve um problema ao atualizar o nome do álbum");
            }
            else
            JOptionPane.showMessageDialog(null, "Novo nome do álbum inválido!");
        }
        
        if(nacional.isSelected()!=Historico.album_nacional)
        {
            if(atu.update_nacionalidade(Historico.conexao, Historico.id_album, nacional.isSelected())==true)
            JOptionPane.showMessageDialog(null, "Nacionalidade do álbum atualizada com sucesso!");
            else
            JOptionPane.showMessageDialog(null, "Houve um erro ao atualizar a Nacionalidade do álbum");   
        }
     
        if(destaque_mes.isSelected()!=Historico.destaque)
        {
            if(atu.update_destaque(Historico.conexao, Historico.id_album, destaque_mes.isSelected())==true)
            JOptionPane.showMessageDialog(null, "Status de Destaque do Álbum atualizado com sucesso!");
            else
            JOptionPane.showMessageDialog(null, "Não foi possível atualizar o Status de Destaque do Álbum");   
        }
        
        if(!lista_mes.getSelectedItem().toString().equals(Historico.mes))
        {
            if(atu.update_mes(Historico.conexao, Historico.id_album, lista_mes.getSelectedItem().toString())==true)
            JOptionPane.showMessageDialog(null, "Mês em que o álbum foi escutado atualizado com sucesso!");
            else
            JOptionPane.showMessageDialog(null, "Houve um problema ao atualizar o mês em que o álbum foi escutado");
        }
        
        if(!txt_artista.getText().equals(Historico.artista))
        {
            atu.setArtista(txt_artista.getText());
            
            if(!atu.getArtista().equals(""))
            {
                if(del.DeleteArtista(Historico.conexao,Historico.artista)==true)
                {
                    if(atu.insertArtista(Historico.conexao)==true)
                    {
                        if(atu.update_artista(Historico.conexao, Historico.id_album)==true)
                        JOptionPane.showMessageDialog(null, "Artista do álbum atualizado com sucesso!");
                        else
                        JOptionPane.showMessageDialog(null, "Houve um erro ao atualizar o artista do álbum");
                    }
                    else
                    JOptionPane.showMessageDialog(null, "Houve um erro ao atualizar a contagem de Artistas nesta atualização de artista do álbum");
                }
                else
                JOptionPane.showMessageDialog(null, "Houve um erro ao remover o artista anterior do álbum!");
            }
            else
            JOptionPane.showMessageDialog(null, "Nome do Artista inválido");
        }
        
        if(!txt_genero.getText().equals(Historico.genero))
        {
            atu.setGenero(txt_genero.getText());
            
            if(!atu.getGenero().equals(""))
            {
                if(del.DeleteGenero(Historico.conexao,Historico.genero)==true)
                {
                    if(atu.insertGenero(Historico.conexao)==true)
                    {
                        if(atu.update_genero(Historico.conexao, Historico.id_album)==true)
                        JOptionPane.showMessageDialog(null, "Gênero do álbum atualizado com sucesso!");
                        else
                        JOptionPane.showMessageDialog(null, "Houve um erro ao atualizar o gênero do álbum");
                    }
                    else
                    JOptionPane.showMessageDialog(null, "Houve um erro ao atualizar a contagem de Gêneros nesta atualização de gênero do álbum");
                }
                else
                JOptionPane.showMessageDialog(null, "Houve um erro ao remover o gênero anterior do álbum!");
            }
            else
            JOptionPane.showMessageDialog(null, "Nome do Gênero inválido");
        }
        
        this.dispose();
    }//GEN-LAST:event_btn_atualizarActionPerformed

    private void btn_excluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_excluirActionPerformed
        
        Delete excluir = new Delete();
        
        if(excluir.delete(Historico.conexao, Historico.id_album)==true)
        {
           if(excluir.DeleteArtista(Historico.conexao, Historico.artista)==true)
           {
               if(excluir.DeleteGenero(Historico.conexao, Historico.genero)==true)
               {
                   JOptionPane.showMessageDialog(null, "Exclusão realizada com sucesso!");
                   this.dispose();
               }
               else
               JOptionPane.showMessageDialog(null, "Houve ao eliminar o gênero do álbum");
           }
           else
           JOptionPane.showMessageDialog(null, "Houve um erro ao eliminar o artista do álbum");
        }
        else
        JOptionPane.showMessageDialog(null, "Exclusão não realizada");
     
    }//GEN-LAST:event_btn_excluirActionPerformed

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        // TODO add your handling code here:
    }//GEN-LAST:event_formWindowClosed

    public static void main(String args[])
    {
        java.awt.EventQueue.invokeLater(new Runnable()
        {
            public void run()
            {   new UpdateAlbum().setVisible(true);    }
        });
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_atualizar;
    private javax.swing.JButton btn_excluir;
    private javax.swing.JCheckBox destaque_mes;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel label_artista;
    private javax.swing.JLabel label_filtro;
    private javax.swing.JLabel label_nome;
    private javax.swing.JComboBox lista_mes;
    private javax.swing.JCheckBox nacional;
    private javax.swing.JTextField txt_artista;
    private javax.swing.JTextField txt_genero;
    private javax.swing.JTextField txt_nome;
    // End of variables declaration//GEN-END:variables
}