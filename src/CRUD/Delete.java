package CRUD;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

public class Delete extends Album
{
  private String sql;
  private PreparedStatement pst = null;
  private ResultSet rs = null;
  private boolean sucesso;
    
  public boolean delete(Connection conexao, int id)
  {
    sucesso=false;
    
    String[] confirmacao = {"Sim", "Nao"};
    int confirma_exclusao = JOptionPane.showOptionDialog(null, "Tem certeza que deseja realizar a exclusão? ",null,JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, confirmacao, confirmacao[0]);
        
    if(confirma_exclusao==0)
    {
      sql="delete from Albuns where ID_Album=?";
      try
      {
        pst = conexao.prepareStatement(sql);
        pst.setInt(1, id);
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
    }
    return sucesso;
  }
  
    public boolean DeleteArtista(Connection conexao, String artista)
    {
        sucesso = false;
        
        String sql="select ID_Artista, Vezes_Escutado from Artista where Nome_Artista=?";
        try
        {
          pst = conexao.prepareStatement(sql);
          pst.setString(1, artista);
          rs = pst.executeQuery();
              
          if(rs.next())
          {       
              this.ID_artista = rs.getInt(1);
              int Vezes_Escutado = rs.getInt(2);
              
              if(Vezes_Escutado>1)
              {
                    sql = "update Artista set Vezes_Escutado=? where ID_Artista=?";
                    Vezes_Escutado = Vezes_Escutado-1;

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
                    sql="delete from Artista where ID_artista=?";
                    try
                    {
                      pst = conexao.prepareStatement(sql);
                      pst.setInt(1, this.ID_artista);
                      pst.executeUpdate();
                      sucesso=true;
                    }     
                    catch (Exception e)
                    { 
                        JOptionPane.showMessageDialog(null,e);
                        sucesso=false;
                    }
              }
          } 
        }
        catch (Exception e)
        { JOptionPane.showMessageDialog(null,e); }
        finally
        {
          try
          { 
            pst.close();
            rs.close();
          }
          catch (Exception e)
          { JOptionPane.showMessageDialog(null,e); }
        }
        return sucesso;
    }
    
    public boolean DeleteGenero(Connection conexao, String genero)
    {
        sucesso = false;
        
        String sql="select ID_Genero, Vezes_Escutado from Genero where Nome_Genero=?";
        try
        {
          pst = conexao.prepareStatement(sql);
          pst.setString(1, genero);
          rs = pst.executeQuery();
              
          if(rs.next())
          {       
              this.ID_genero = rs.getInt(1);
              int Vezes_Escutado = rs.getInt(2);
              
              if(Vezes_Escutado>1)
              {
                    sql = "update Genero set Vezes_Escutado=? where ID_Genero=?";
                    Vezes_Escutado = Vezes_Escutado-1;

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
                    sql="delete from Genero where ID_Genero=?";
                    try
                    {
                      pst = conexao.prepareStatement(sql);
                      pst.setInt(1, this.ID_genero);
                      pst.executeUpdate();
                      sucesso=true;
                    }     
                    catch (Exception e)
                    { 
                        JOptionPane.showMessageDialog(null,e);
                        sucesso=false;
                    }
              }
          } 
        }
        catch (Exception e)
        { JOptionPane.showMessageDialog(null,e); }
        finally
        {
          try
          { 
              pst.close();
              rs.close();
          }
          catch (Exception e)
          { JOptionPane.showMessageDialog(null,e); }
        }
        return sucesso;
    }
}
