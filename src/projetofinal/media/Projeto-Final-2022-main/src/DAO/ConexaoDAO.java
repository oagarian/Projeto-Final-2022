package DAO;


import java.sql.Connection;
import javax.swing.JOptionPane;


public class ConexaoDAO {
    public Connection conectarBancodeDados(){
        
        Connection conectar = null;
        
        try{
            
            
            
        } catch (Exception erroDoCod){
            JOptionPane.showMessageDialog(null, "Ocorreu um erro interno, por favor tente novamente rodar o código, se não o PC explode :/ ");
        }
        
        return conectar;
        
    }
}
  