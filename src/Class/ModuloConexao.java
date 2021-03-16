package Class;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class ModuloConexao
{
    public static Connection conector()
    {
      Connection conexao = null;
      try
      {
        String url = "jdbc:sqlite:banco/albuns.db";
        conexao = DriverManager.getConnection(url);
        return conexao;
      }
      catch(SQLException e)
      { 
        JOptionPane.showMessageDialog(null, e.getMessage());
        return null;
      }
   }
}