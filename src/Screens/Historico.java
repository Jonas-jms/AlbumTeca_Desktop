package Screens;

import Class.Background_image;
import Class.ModuloConexao;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.UIManager;
import net.proteanit.sql.DbUtils;
import com.jtattoo.plaf.mint.MintLookAndFeel;

public class Historico extends javax.swing.JFrame
{
    static Connection conexao = ModuloConexao.conector();
    private PreparedStatement pst = null;
    private ResultSet rs = null;
    private int orderN=0,orderNome=0,orderArtista=0,orderGenero=0;
    static int id_album;
    static String mes,nome,artista,genero;
    static boolean destaque,album_nacional;
    
    private String sql="SELECT Albuns.ID_Album as 'N', Albuns.Album as 'Álbum', Artista.Nome_Artista as 'Artista', Genero.Nome_Genero as 'Gênero'FROM Albuns INNER JOIN Artista on Albuns.ID_Artista = Artista.ID_Artista INNER JOIN Genero on Albuns.ID_Genero = Genero.ID_Genero;";
    private String sql_anterior=sql;
    public Historico()
    {
        try
        { UIManager.setLookAndFeel( new MintLookAndFeel()); }
        catch( Exception ex )
         { JOptionPane.showMessageDialog(null,"Não foi possível inicializar a Interface Gráfica Tatto" ); }
        
        initComponents();
        Background_image fundo = new Background_image
        ( new ImageIcon("src/imagens/fundo.jpeg").getImage() );
        this.getContentPane().add(fundo);
        
        listar_generos();
        show_albuns();
        
        tbl_albuns.addMouseListener(new MouseAdapter()
        {
          public void mouseClicked(MouseEvent me)
          {
            if (me.getClickCount() == 1)
            {    
              JTable target = (JTable)me.getSource();
              int row = target.getSelectedRow();
              int column = target.getSelectedColumn();
              
              id_album = (int) tbl_albuns.getValueAt(row, 0);
              nome = (String) tbl_albuns.getValueAt(row, 1);
              artista = (String) tbl_albuns.getValueAt(row, 2);
              genero = (String) tbl_albuns.getValueAt(row, 3);
              show_album();
            }
          }
        }
                                    );    
        
        tbl_albuns.getTableHeader().addMouseListener(new MouseAdapter()
        {
            @Override
            public void mouseClicked(MouseEvent e)
            {  
                int col = tbl_albuns.columnAtPoint(e.getPoint());
                click_order(col);
            }   
        }
                                                    );
    }
    
    private void click_order(int col)
    {
        sql = sql_anterior;
        
        int fim_sql;
        if(col==0)
        {
            if(orderN==0)
            {
               orderN=1;
               fim_sql=sql.indexOf(";");
               sql_anterior = sql;
               sql = sql.substring(0, fim_sql);
               sql = sql+" ORDER BY Albuns.ID_Album DESC;"; 
               show_albuns();
            }
            else
            {
               orderN=0;
               fim_sql=sql.indexOf(";");
               sql_anterior = sql;
               sql = sql.substring(0, fim_sql);
               sql = sql+" ORDER BY Albuns.ID_Album ASC;"; 
               show_albuns();
            }
        }
        else if(col==1)
        {
            if(orderNome==0)
            {
               orderNome=1;
               fim_sql=sql.indexOf(";");
               sql_anterior = sql;
               sql = sql.substring(0, fim_sql);
               sql = sql+" ORDER BY Albuns.Album DESC;"; 
               show_albuns();
            }
            else
            {
               orderNome=0;
               fim_sql=sql.indexOf(";");
               sql_anterior = sql;
               sql = sql.substring(0, fim_sql);
               sql = sql+" ORDER BY Albuns.Album ASC;"; 
               show_albuns();
            }
        }
        else if(col==2)
        {
            if(orderArtista==0)
            {
               orderArtista=1;
               fim_sql=sql.indexOf(";");
               sql_anterior = sql;
               sql = sql.substring(0, fim_sql);
               sql = sql+" ORDER BY Artista.Nome_Artista DESC;"; 
               show_albuns();
            }
            else
            {
               orderArtista=0;
               fim_sql=sql.indexOf(";");
               sql_anterior = sql;
               sql = sql.substring(0, fim_sql);
               sql = sql+" ORDER BY Artista.Nome_Artista ASC;"; 
               show_albuns();
            }
        }
        else if(col==3)
        {
            if(orderGenero==0)
            {
               orderGenero=1;
               fim_sql=sql.indexOf(";");
               sql_anterior = sql;
               sql = sql.substring(0, fim_sql);
               sql = sql+" ORDER BY Genero.Nome_Genero DESC;"; 
               show_albuns();
            }
            else
            {
               orderGenero=0;
               fim_sql=sql.indexOf(";");
               sql_anterior = sql;
               sql = sql.substring(0, fim_sql);
               sql = sql+" ORDER BY Genero.Nome_Genero ASC;"; 
               show_albuns();
            }
        }
    }
    
    private void listar_generos()
    {
        lista_generos.addItem("Todos");
        try
        {
              pst = conexao.prepareStatement("SELECT Genero.Nome_Genero FROM Genero ORDER BY Genero.Nome_Genero ASC");
              rs = pst.executeQuery();
              
              while(rs.next())
              lista_generos.addItem(rs.getString(1));
        }
        catch (Exception e)
        { JOptionPane.showMessageDialog(null, e); }   
        finally
        {
            try
            { 
              rs.close();
              pst.close();
            }
            catch (Exception e)
            { JOptionPane.showMessageDialog(null,e); }
        }  
    }
    
    private void show_albuns()
    {
        try
        {
          pst=conexao.prepareStatement(sql);
          rs=pst.executeQuery();
          this.tbl_albuns.setModel(DbUtils.resultSetToTableModel(rs));
        }
        catch(Exception e)
        { JOptionPane.showMessageDialog(null, e); }
        finally
        {
            try
            { 
              rs.close();
              pst.close();
            }
            catch (Exception e)
            { JOptionPane.showMessageDialog(null,e); }
        }
        label_filtro3.setText(tbl_albuns.getModel().getRowCount()+" álbuns");    
    }
    
    private void busca()
    {  
        try
        {
           pst=conexao.prepareStatement(sql);
           pst.setString(1, this.txt_busca.getText() + "%");
           rs=pst.executeQuery();
           this.tbl_albuns.setModel(DbUtils.resultSetToTableModel(rs));
        }
        catch(Exception e)
        { JOptionPane.showMessageDialog(null, e); }
        finally
        {
              try
              { 
                rs.close();
                pst.close();
              }
              catch (Exception e)
              { JOptionPane.showMessageDialog(null,e); }
        }
        label_filtro3.setText(tbl_albuns.getModel().getRowCount()+" álbuns");
    }
    
    private void filtros()
    {
        boolean and = false;
        int fim_sql;
        sql="SELECT Albuns.ID_Album as 'N', Albuns.Album as 'Álbum', Artista.Nome_Artista as 'Artista', Genero.Nome_Genero as 'Gênero'FROM Albuns INNER JOIN Artista on Albuns.ID_Artista = Artista.ID_Artista INNER JOIN Genero on Albuns.ID_Genero = Genero.ID_Genero;";
        
        if(!lista_mes.getSelectedItem().toString().equals("Todos"))
        {
            fim_sql=sql.indexOf(";");
            sql = sql.substring(0, fim_sql);
            sql = sql+" WHERE Albuns.Mes="+"'"+lista_mes.getSelectedItem().toString()+"';";
            and=true;
        }
        else
        sql_anterior=sql;
        
        if(!lista_generos.getSelectedItem().toString().equals("Todos"))
        {
            fim_sql=sql.indexOf(";");
            sql = sql.substring(0, fim_sql);
            
            if(and==false)
            sql = sql+" WHERE Genero.Nome_Genero="+"'"+lista_generos.getSelectedItem().toString()+"';"; 
            else
            sql = sql+" AND Genero.Nome_Genero="+"'"+lista_generos.getSelectedItem().toString()+"';"; 
            
            and=true;
        }
        else
        sql_anterior=sql;
        
        if(nacional.isSelected()==true)
        {
            fim_sql=sql.indexOf(";");
            sql = sql.substring(0, fim_sql);
            
            if(and==false)
            sql = sql+" WHERE Albuns.Nacional=1;"; 
            else
            sql = sql+" AND Albuns.Nacional=1;"; 
            
            and=true;
        }
        else
        sql_anterior=sql;
        
        if(destaque_mes.isSelected()==true)
        {
            fim_sql=sql.indexOf(";");
            sql = sql.substring(0, fim_sql);
            
            if(and==false)
            sql = sql+" WHERE Albuns.Destaque=1;"; 
            else
            sql = sql+" AND Albuns.Destaque=1;"; 
            
            and=true;
        }
        else
        sql_anterior=sql;
        
        if(!txt_busca.getText().equals(""))
        {
            fim_sql=sql.indexOf(";");
            sql = sql.substring(0, fim_sql);
            
            if(pesquisa.getSelectedItem().toString().equals("Pesquisar por Álbum:"))
            {
                if(and==false)
                sql = sql+" WHERE Albuns.Album like ?;";
                else
                sql = sql+" AND Albuns.Album like ?;";
            }
            else
            {
                if(and==false)
                sql = sql+" WHERE Artista.Nome_Artista like ?;";
                else
                sql = sql+" AND Artista.Nome_Artista like ?;";
            }
            
            busca();
        }
        else
        show_albuns();

    }
    
    private void show_album()
    {   
        try
        {
            pst = conexao.prepareStatement("SELECT Albuns.Destaque, Albuns.Nacional, Albuns.Mes FROM Albuns where ID_Album=?");
            pst.setInt(1, id_album);
            rs = pst.executeQuery();
              
            if(rs.next())
            {
                destaque=rs.getBoolean(1);
                album_nacional=rs.getBoolean(2);
                mes=rs.getString(3);
                
                UpdateAlbum show = new UpdateAlbum();
                show.setVisible(true);
            }
        }
        catch (Exception e)
        { JOptionPane.showMessageDialog(null, e); }   
        finally
        {
            try
            { 
              rs.close();
              pst.close();
            }
            catch (Exception e)
            { JOptionPane.showMessageDialog(null,e); }
        } 
    }
    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txt_busca = new javax.swing.JTextField();
        nacional = new javax.swing.JCheckBox();
        destaque_mes = new javax.swing.JCheckBox();
        label_filtro = new javax.swing.JLabel();
        lista_mes = new javax.swing.JComboBox();
        pesquisa = new javax.swing.JComboBox();
        label_filtro1 = new javax.swing.JLabel();
        label_filtro2 = new javax.swing.JLabel();
        lista_generos = new javax.swing.JComboBox();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_albuns = new javax.swing.JTable();
        btn_voltar = new javax.swing.JButton();
        label_filtro3 = new javax.swing.JLabel();
        btn_estatisticas = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Histórico de Álbuns");
        addWindowFocusListener(new java.awt.event.WindowFocusListener() {
            public void windowGainedFocus(java.awt.event.WindowEvent evt) {
                formWindowGainedFocus(evt);
            }
            public void windowLostFocus(java.awt.event.WindowEvent evt) {
            }
        });

        txt_busca.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        txt_busca.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(189, 16, 224)));
        txt_busca.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_buscaKeyReleased(evt);
            }
        });

        nacional.setFont(new java.awt.Font("Patrick Hand SC", 0, 30)); // NOI18N
        nacional.setForeground(new java.awt.Color(255, 46, 99));
        nacional.setText("NACIONAL");
        nacional.setFocusPainted(false);
        nacional.setOpaque(false);
        nacional.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                nacionalItemStateChanged(evt);
            }
        });
        nacional.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nacionalActionPerformed(evt);
            }
        });

        destaque_mes.setFont(new java.awt.Font("Patrick Hand SC", 0, 30)); // NOI18N
        destaque_mes.setForeground(new java.awt.Color(255, 46, 99));
        destaque_mes.setText("MELHOR DO MÊS");
        destaque_mes.setFocusPainted(false);
        destaque_mes.setOpaque(false);
        destaque_mes.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                destaque_mesItemStateChanged(evt);
            }
        });
        destaque_mes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                destaque_mesActionPerformed(evt);
            }
        });

        label_filtro.setFont(new java.awt.Font("Patrick Hand SC", 0, 30)); // NOI18N
        label_filtro.setForeground(new java.awt.Color(255, 46, 99));
        label_filtro.setText("Mês:");

        lista_mes.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        lista_mes.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Todos", "Janeiro", "Fevereiro", "Março", "Abril", "Maio", "Junho", "Julho", "Agosto", "Setembro", "Outubro", "Novembro", "Dezembro" }));
        lista_mes.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(189, 16, 224)));
        lista_mes.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                lista_mesItemStateChanged(evt);
            }
        });

        pesquisa.setFont(new java.awt.Font("Patrick Hand SC", 0, 30)); // NOI18N
        pesquisa.setForeground(new java.awt.Color(255, 46, 99));
        pesquisa.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Pesquisar por Álbum:", "Pesquisar por Artista:" }));
        pesquisa.setToolTipText("");
        pesquisa.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(189, 16, 224)));
        pesquisa.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                pesquisaItemStateChanged(evt);
            }
        });

        label_filtro1.setFont(new java.awt.Font("Patrick Hand SC", 0, 30)); // NOI18N
        label_filtro1.setForeground(new java.awt.Color(255, 46, 99));
        label_filtro1.setText("Filtrar por:");

        label_filtro2.setFont(new java.awt.Font("Patrick Hand SC", 0, 30)); // NOI18N
        label_filtro2.setForeground(new java.awt.Color(255, 46, 99));
        label_filtro2.setText("Gênero:");

        lista_generos.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        lista_generos.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(189, 16, 224)));
        lista_generos.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                lista_generosItemStateChanged(evt);
            }
        });

        tbl_albuns.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        tbl_albuns.setToolTipText("");
        tbl_albuns.setGridColor(new java.awt.Color(111, 223, 207));
        tbl_albuns.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tbl_albuns.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_albunsMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tbl_albunsMousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(tbl_albuns);

        btn_voltar.setFont(new java.awt.Font("Patrick Hand SC", 0, 30)); // NOI18N
        btn_voltar.setForeground(new java.awt.Color(255, 46, 99));
        btn_voltar.setText(" VOLTAR ");
        btn_voltar.setToolTipText("Voltar pro Menu Inicial");
        btn_voltar.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 46, 99), 1, true));
        btn_voltar.setContentAreaFilled(false);
        btn_voltar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_voltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_voltarActionPerformed(evt);
            }
        });

        label_filtro3.setFont(new java.awt.Font("Patrick Hand SC", 0, 30)); // NOI18N
        label_filtro3.setForeground(new java.awt.Color(255, 46, 99));
        label_filtro3.setText("-");

        btn_estatisticas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/2278983.png"))); // NOI18N
        btn_estatisticas.setToolTipText("Mostrar Estatísticas");
        btn_estatisticas.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 46, 99)));
        btn_estatisticas.setContentAreaFilled(false);
        btn_estatisticas.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_estatisticas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_estatisticasActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(label_filtro)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lista_mes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(104, 104, 104)
                        .addComponent(label_filtro2)
                        .addGap(3, 3, 3)
                        .addComponent(lista_generos, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(label_filtro1)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(nacional))
                                    .addComponent(pesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, 292, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(destaque_mes)
                                    .addComponent(txt_busca, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btn_voltar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btn_estatisticas)
                                .addGap(79, 79, 79)
                                .addComponent(label_filtro3)))
                        .addGap(0, 298, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(19, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btn_estatisticas, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btn_voltar, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addGap(26, 26, 26))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(label_filtro3, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(35, 35, 35)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_busca, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(label_filtro2)
                        .addComponent(lista_generos, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(label_filtro)
                        .addComponent(lista_mes, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(nacional)
                        .addComponent(destaque_mes))
                    .addComponent(label_filtro1))
                .addGap(6, 6, 6)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 423, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(99, 99, 99))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void destaque_mesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_destaque_mesActionPerformed

    }//GEN-LAST:event_destaque_mesActionPerformed

    private void btn_voltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_voltarActionPerformed
        Tela_Inicial call = new Tela_Inicial();
        call.setVisible(true);
        this.dispose();        // TODO add your handling code here:
    }//GEN-LAST:event_btn_voltarActionPerformed

    private void lista_mesItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_lista_mesItemStateChanged
        filtros();
    }//GEN-LAST:event_lista_mesItemStateChanged

    private void lista_generosItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_lista_generosItemStateChanged
        filtros();
    }//GEN-LAST:event_lista_generosItemStateChanged

    private void nacionalItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_nacionalItemStateChanged
        filtros();            
    }//GEN-LAST:event_nacionalItemStateChanged

    private void destaque_mesItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_destaque_mesItemStateChanged
        filtros();
    }//GEN-LAST:event_destaque_mesItemStateChanged

    private void txt_buscaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_buscaKeyReleased
        filtros();
    }//GEN-LAST:event_txt_buscaKeyReleased

    private void pesquisaItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_pesquisaItemStateChanged
        filtros();
    }//GEN-LAST:event_pesquisaItemStateChanged

    private void nacionalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nacionalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nacionalActionPerformed

    private void btn_estatisticasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_estatisticasActionPerformed
        int opcao_escolhida=0;
            
        String[] opcoes_top = {"Exibir Top Artistas mais escutados", "Exibir Top Gêneros mais escutados", "Exibir Nº de Artistas escutados"};
             
        opcao_escolhida = JOptionPane.showOptionDialog(null, "Informe a estatística que quer conhecer:",null,JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, opcoes_top, opcoes_top[0]);
            
        if(opcao_escolhida==1)
        {
            String top_generos = "";
            int contador=1;
            try
            {
                  pst = conexao.prepareStatement("SELECT Genero.Nome_Genero, Genero.Vezes_Escutado FROM Genero ORDER BY Genero.Vezes_Escutado DESC");
                  rs = pst.executeQuery();

                  while(rs.next())
                  {
                      if(rs.getInt(2)>1)
                      {
                        top_generos += contador+"º - "+rs.getString(1) + " - "+ rs.getInt(2)+" Álbuns"+"\n";
                        contador++;
                      }
                      if(contador==16)
                      break;
                  }
                  JOptionPane.showMessageDialog(null, top_generos);    
            }
            catch (Exception e)
            { JOptionPane.showMessageDialog(null, e); }   
            finally
            {
                try
                { 
                  rs.close();
                  pst.close();
                }
                catch (Exception e)
                { JOptionPane.showMessageDialog(null,e); }
            }  
        }
        else if(opcao_escolhida==0)
        {
            String top_artistas = "";
            int contador=1;
            try
            {
                  pst = conexao.prepareStatement("SELECT Artista.Nome_Artista, Artista.Vezes_Escutado FROM Artista ORDER BY Artista.Vezes_Escutado DESC");
                  rs = pst.executeQuery();

                  while(rs.next())
                  {
                      
                      if(rs.getInt(2)>1)
                      {
                        top_artistas += contador+"º - "+rs.getString(1) + " - "+ rs.getInt(2)+" Álbuns"+"\n";
                        contador++;
                      }
                      if(contador==16)
                      break;
                  }
                  JOptionPane.showMessageDialog(null, top_artistas);    
            }
            catch (Exception e)
            { JOptionPane.showMessageDialog(null, e); }   
            finally
            {
                try
                { 
                  rs.close();
                  pst.close();
                }
                catch (Exception e)
                { JOptionPane.showMessageDialog(null,e); }
            }  
        }
        else if(opcao_escolhida==2)
        {
            try
            {
                  pst = conexao.prepareStatement("SELECT COUNT(ID_Artista) FROM Artista");
                  rs = pst.executeQuery();

                  if(rs.next())
                  JOptionPane.showMessageDialog(null, rs.getInt(1)+" artistas escutados no ano"); 
            }
            catch (Exception e)
            { JOptionPane.showMessageDialog(null, e); }   
            finally
            {
                try
                { 
                  rs.close();
                  pst.close();
                }
                catch (Exception e)
                { JOptionPane.showMessageDialog(null,e); }
            }
        }
    }//GEN-LAST:event_btn_estatisticasActionPerformed

    private void tbl_albunsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_albunsMouseClicked
    }//GEN-LAST:event_tbl_albunsMouseClicked

    private void tbl_albunsMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_albunsMousePressed
    }//GEN-LAST:event_tbl_albunsMousePressed

    private void formWindowGainedFocus(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowGainedFocus
        show_albuns();        // TODO add your handling code here:
    }//GEN-LAST:event_formWindowGainedFocus

    public static void main(String args[])
    {
        java.awt.EventQueue.invokeLater(new Runnable()
        {
            public void run()
            {   new Historico().setVisible(true);    }
        });
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_estatisticas;
    private javax.swing.JButton btn_voltar;
    private javax.swing.JCheckBox destaque_mes;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel label_filtro;
    private javax.swing.JLabel label_filtro1;
    private javax.swing.JLabel label_filtro2;
    private javax.swing.JLabel label_filtro3;
    private javax.swing.JComboBox lista_generos;
    private javax.swing.JComboBox lista_mes;
    private javax.swing.JCheckBox nacional;
    private javax.swing.JComboBox pesquisa;
    private javax.swing.JTable tbl_albuns;
    private javax.swing.JTextField txt_busca;
    // End of variables declaration//GEN-END:variables
}