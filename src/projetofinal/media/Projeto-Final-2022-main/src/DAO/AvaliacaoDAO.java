package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import DTO.AvaliacaoDTO;
import javax.swing.JOptionPane;

public class AvaliacaoDAO {
    
    Connection conexao;
    PreparedStatement prepa;
    
    public void realizarAvaliacao (AvaliacaoDTO objavaliacaodto){
        String sql = "insert into avaliacao (estrelas_avaliacao, opniao_avaliacao) values (?,?)";
        
        conexao = new ConexaoDAO().conectarBancodeDados();
        
        try {
            
            prepa = conexao.prepareStatement(sql);
            prepa.setString(1,objavaliacaodto.getEstrela_avaliacao());
            prepa.setString(2,objavaliacaodto.getOpniao_avaliacao());
                        
        } catch (Exception erro) {
            JOptionPane.showMessageDialog(null, "Avaliacao" +erro);
        }
        
    }

    public void Avaliacao(AvaliacaoDTO objavaliacaodto) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
