package DAO;

import DTO.AgendarConsultaDTO;
import DTO.AvaliacaoDTO;
import java.sql.Connection;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import java.sql.PreparedStatement;

public class AvaliacaoDAO {
    Connection conectar;
    
    public AvaliacaoDAO(){
        conectar = new ConexaoDAO().getConexao();
    }
    
    public void avaliar(AvaliacaoDTO objavaliacaodto){        
        try {
            String mysqlString = "INSERT INTO AVALIACAO(ESTRELAS, OPINIAO) VALUES (?,?)";
            PreparedStatement prepa = conectar.prepareStatement(mysqlString);
            prepa.setInt(1, objavaliacaodto.getEstrelas());
            prepa.setString(2, objavaliacaodto.getOpiniao());

            prepa.executeUpdate();
            System.out.println("Avaliação enviada com sucesso!"); 
            
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null,"AvaliacaoDAO: " + erro);
        }
    }
}
  