package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import DTO.AgendarConsultaDTO;
import javax.swing.JOptionPane;

public class AgendarConsultaDAO {
    
    Connection conexao;
    PreparedStatement prepa;
    
    public void cadastrarConsulta(AgendarConsultaDTO objagendarconsultadto) {
        String sql = "insert into consulta (nome_consulta, cpf_consulta, telefone_consulta, email_consulta, membroBts_consulta, "
                + " nomeAnimal_consulta, bixinhoE_consulta, raca_consulta, tipoSanguineo_consulta, diaDisponivel_consulta,horario_consulta) values "
                + "(?,?,?,?,?,?,?,?,?,?,?)"; //
        
        conexao = new ConexaoDAO().conectarBancodeDados();
        
        try {
            
            prepa = conexao.prepareStatement(sql);
            prepa.setString(1, objagendarconsultadto.getNome_consulta());
            prepa.setString(2, objagendarconsultadto.getCpf_consulta());
            prepa.setString(3, objagendarconsultadto.getTelefone_consulta());
            prepa.setString(4, objagendarconsultadto.getEmail_consulta());
            prepa.setString(5, objagendarconsultadto.getMembroBts_consulta());
            prepa.setString(6, objagendarconsultadto.getNomeAnimal_consulta());
            prepa.setString(7, objagendarconsultadto.getBixinhoE_consulta());
            prepa.setString(8, objagendarconsultadto.getRaca_consulta());
            prepa.setString(9, objagendarconsultadto.getTipoSangue_consulta());
            prepa.setString(10, objagendarconsultadto.getDia_dispo_consulta());
            prepa.setString(11, objagendarconsultadto.getHorario_consulta());
            
            prepa.execute();
            prepa.close();
            
        } catch (Exception erro) {
            
            JOptionPane.showMessageDialog(null, "AgendarConsulta" +erro);
            
        }
        
    }

    public void AgendarConsulta(AgendarConsultaDTO objagendarconsultadto) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
