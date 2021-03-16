package CRUD;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

public class Update extends Insert
{      
    boolean sucesso=false;
    private PreparedStatement pst = null;
    private ResultSet rs = null;
    
    public boolean update_album(Connection conexao, int id_album)
    {
              String sql = "update Albuns set Album=? where ID_Album=?";
              
              try
              {
                pst=conexao.prepareStatement(sql);
                pst.setString(1, album);
                pst.setInt(2, id_album);
                pst.executeUpdate();
                sucesso=true;
              }
              catch (Exception e)
              { 
                  JOptionPane.showMessageDialog(null,e);
                  sucesso=false;
              }
              finally
              {
                try
                { pst.close(); }
                catch (Exception e)
                { JOptionPane.showMessageDialog(null,e); }
              }
        return sucesso;
    }
    
    public boolean update_destaque(Connection conexao, int id_album, boolean destaque)
    {
              boolean sucesso;
    
              sucesso = false;
        
              String sql = "update Albuns set Destaque=? where ID_Album=?";
              
              try
              {
                pst=conexao.prepareStatement(sql);
                pst.setBoolean(1, destaque);
                pst.setInt(2, id_album);
                pst.executeUpdate();
                sucesso=true;
              }
              catch (Exception e)
              { 
                  JOptionPane.showMessageDialog(null,e);
                  sucesso=false;
              }
              finally
              {
                try
                { pst.close(); }
                catch (Exception e)
                { JOptionPane.showMessageDialog(null,"aqui"); }
              }
              
        return sucesso;
    }
    
    public boolean update_nacionalidade(Connection conexao, int id_album, boolean nacional)
    {
              boolean sucesso;
    
              sucesso = false;
        
              String sql = "update Albuns set Nacional=? where ID_Album=?";
              
              try
              {
                pst=conexao.prepareStatement(sql);
                pst.setBoolean(1, nacional);
                pst.setInt(2, id_album);
                pst.executeUpdate();
                sucesso=true;
              }
              catch (Exception e)
              { 
                  JOptionPane.showMessageDialog(null,e);
                  sucesso=false;
              }
              finally
              {
                try
                { pst.close(); }
                catch (Exception e)
                { JOptionPane.showMessageDialog(null,e); }
              }
              
        return sucesso;
    }
    
    public boolean update_mes(Connection conexao, int id_album, String novo_mes)
    {
              boolean sucesso;
    
              sucesso = false;

              String sql = "update Albuns set Mes=? where ID_Album=?";
              
              try
              {
                pst=conexao.prepareStatement(sql);
                pst.setString(1, novo_mes);
                pst.setInt(2, id_album);
                pst.executeUpdate();
                sucesso=true;
              }
              catch (Exception e)
              { 
                  JOptionPane.showMessageDialog(null,e);
                  sucesso=false;
              }
              finally
              {
                try
                { pst.close(); }
                catch (Exception e)
                { JOptionPane.showMessageDialog(null,e); }
              }
        return sucesso;
    }
    
    public boolean update_artista(Connection conexao, int id_album)
    {
              boolean sucesso;
    
              sucesso = false;

              String sql = "update Albuns set ID_Artista=? where ID_Album=?";
              
              try
              {
                pst=conexao.prepareStatement(sql);
                pst.setInt(1, ID_artista);
                pst.setInt(2, id_album);
                pst.executeUpdate();
                sucesso=true;
              }
              catch (Exception e)
              { 
                  JOptionPane.showMessageDialog(null,e);
                  sucesso=false;
              }
              finally
              {
                try
                { pst.close(); }
                catch (Exception e)
                { JOptionPane.showMessageDialog(null,e); }
              }
        return sucesso;
    }
    
    public boolean update_genero(Connection conexao, int id_album)
    {
              boolean sucesso;
    
              sucesso = false;

              String sql = "update Albuns set ID_Genero=? where ID_Album=?";
              
              try
              {
                pst=conexao.prepareStatement(sql);
                pst.setInt(1, ID_genero);
                pst.setInt(2, id_album);
                pst.executeUpdate();
                sucesso=true;
              }
              catch (Exception e)
              { 
                  JOptionPane.showMessageDialog(null,e);
                  sucesso=false;
              }
              finally
              {
                try
                { pst.close(); }
                catch (Exception e)
                { JOptionPane.showMessageDialog(null,e); }
              }
        return sucesso;
    }
}
