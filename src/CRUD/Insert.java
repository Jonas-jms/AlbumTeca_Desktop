package CRUD;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

public class Insert extends Album
{
    private boolean sucesso;
    private PreparedStatement pst = null;
    private ResultSet rs = null;
    
    public boolean insertArtista(Connection conexao)
    {
        sucesso = false;
        
        String sql="select * from Artista where Nome_Artista=?";
        try
        {
          pst = conexao.prepareStatement(sql);
          pst.setString(1, this.artista);
          rs = pst.executeQuery();
              
          if(rs.next())
          {       
              this.ID_artista = rs.getInt(1);
              int Vezes_Escutado = rs.getInt(3);
              
              sql = "update Artista set Vezes_Escutado=? where ID_Artista=?";
              Vezes_Escutado = Vezes_Escutado+1;
              
              try
              {
                pst=conexao.prepareStatement(sql);
                pst.setInt(1, Vezes_Escutado);
                pst.setInt(2, this.ID_artista);
                pst.executeUpdate();
                sucesso=true;
              }
              catch (Exception e)
              { 
                  JOptionPane.showMessageDialog(null,e);
                  sucesso=false;
              } 
          }
          else
          { 
                sql = "insert into Artista(Nome_Artista,Vezes_Escutado) values(?,?)";
                try
                {
                  pst=conexao.prepareStatement(sql);
                  pst.setString(1, this.artista);
                  pst.setInt(2, 1);
                  pst.executeUpdate();
                  
                  ResultSet rs = pst.getGeneratedKeys();
                  if(rs.next())
                  this.ID_artista = rs.getInt(1); 
			
                  sucesso=true;
                }
                catch (Exception e)
                { 
                    JOptionPane.showMessageDialog(null,e);
                    sucesso=false;
                }
          }
        }
        catch (Exception e)
        { JOptionPane.showMessageDialog(null,e); }
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
        return sucesso;
    } 
    
    public boolean insertGenero(Connection conexao)
    {
        sucesso=false;
        
        String sql="select * from Genero where Nome_Genero=?";
        try
        {
          pst = conexao.prepareStatement(sql);
          pst.setString(1, this.genero);
          rs = pst.executeQuery();
              
          if(rs.next())
          {       
              this.ID_genero = rs.getInt(1);
              int Vezes_Escutado = rs.getInt(3);
              
              sql = "update Genero set Vezes_Escutado=? where ID_Genero=?";
              Vezes_Escutado = Vezes_Escutado+1;
              
              try
              {
                pst=conexao.prepareStatement(sql);
                pst.setInt(1, Vezes_Escutado);
                pst.setInt(2, this.ID_genero);
                pst.executeUpdate(); 
                sucesso=true;
              }
              catch (Exception e)
              { 
                  JOptionPane.showMessageDialog(null,e);
                  sucesso=false;
              } 
          }
          else
          { 
                sql = "insert into Genero(Nome_Genero,Vezes_Escutado) values(?,?)";
                try
                {
                  pst=conexao.prepareStatement(sql);
                  pst.setString(1, this.genero);
                  pst.setInt(2, 1);
                  pst.executeUpdate();
                  
                  ResultSet rs = pst.getGeneratedKeys();
                  if(rs.next())
                  this.ID_genero = rs.getInt(1);
                  
                  sucesso=true;
                }
                catch (Exception e)
                { 
                    JOptionPane.showMessageDialog(null,e);
                    sucesso=false;
                }
          }
        }
        catch (Exception e)
        { JOptionPane.showMessageDialog(null,e); }
        finally
        {
          try
          { pst.close(); }
          catch (Exception e)
          { JOptionPane.showMessageDialog(null,e); }
        }
        return sucesso;
    }
    
    public boolean insert_album(Connection conexao,boolean nacional,boolean destaque,String mes)
    {
        sucesso=false;
        
        String sql = "insert into Albuns(Album,ID_Artista,ID_Genero,Nacional,Destaque,Mes) values(?,?,?,?,?,?)";
        try
        {
           pst=conexao.prepareStatement(sql);
           pst.setString(1, this.album);
           pst.setInt(2, this.ID_artista);
           pst.setInt(3, this.ID_genero);
           pst.setBoolean(4,nacional);
           pst.setBoolean(5,destaque);
           pst.setString(6,mes);
           pst.executeUpdate();
                  
           sucesso=true;
        }
        catch (Exception e)
        { 
            JOptionPane.showMessageDialog(null,e);
            sucesso=false;
        }
        return sucesso;
    }
}
