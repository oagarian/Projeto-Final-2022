package DAO;

import DTO.CurriculoDTO;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import java.sql.PreparedStatement;

public class CurriculoDAO {
    Connection conectar;
    
    public ResultSet autenticarCurriculo(CurriculoDTO objcurriculodto){
        conectar = new ConexaoDAO().conectarBancodeDados();
        
        try {
            String mysql = "select * from curriculo where nome_curriculo = ? and cpf_curriculo = ? and telefone_curriculo = ? email_curriculo = ? and vaga_curriculo = ? and cep _curriculo = ? and experiencia_curriculo = ? and formacao_curriculo = ?";
            PreparedStatement prep = conectar.prepareStatement(mysql);
            prep.setString(1, objcurriculodto.getNome_curriculo());
            prep.setString(2, objcurriculodto.getCpf_curriculo());
            prep.setString(3, objcurriculodto.getTelefone_curriculo());
            prep.setString(4, objcurriculodto.getEmail_curriculo());
            prep.setString(5, objcurriculodto.getVaga_curriculo() );
            prep.setString(6, objcurriculodto.getCep_curriculo());
            prep.setString(7, objcurriculodto.getExperiencia_curriculo());
            prep.setString(8, objcurriculodto.getFormacao_curriculo());
            
            ResultSet results = prep.executeQuery();
            return results;
            
            //olha eu adiantei uns bagui so pra testae mas se tu qsr apagar ou usar dboa
            
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null,"CurriculoDAO: " + erro);
            return null;
        }
    }
}
  