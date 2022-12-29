package DAO;

import DTO.AgendarConsultaDTO;
import java.sql.*;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import java.sql.PreparedStatement;
import java.util.ArrayList;

public class AgendarConsultaDAO {
    Connection conectar;
    
    public AgendarConsultaDAO(){
        conectar = new ConexaoDAO().getConexao();
    }
    
    public void agendarConsulta(AgendarConsultaDTO objagendarconsultadto){        
        try {
            String mysqlQuery = "SELECT * FROM CONSULTA";
            PreparedStatement ps = conectar.prepareStatement(mysqlQuery);
            ResultSet rs = ps.executeQuery(mysqlQuery);

            while(rs.next()) {
                String dia = rs.getString("DIA_DISPONIVEL");
                ArrayList<String> dias = new ArrayList<>();
                if(dia.equalsIgnoreCase(objagendarconsultadto.getDia_dispo_consulta())) {
                    JOptionPane.showMessageDialog(null, "Já existe uma consulta para esse horário e dia!");
                    return;
                    
                } 
            }
            String mysqlString = "INSERT INTO CONSULTA(NOME, CPF, TELEFONE, EMAIL, MEMBRO_BTS, NOME_ANIMAL, ANIMAL, RACA, TIPO_SANGUE, DIA_DISPONIVEL, HORARIO) VALUES (?,?,?,?,?,?,?,?,?,?,?)";
            PreparedStatement prepa = conectar.prepareStatement(mysqlString);
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

            prepa.executeUpdate();
            System.out.println("Consulta agendada com sucesso!"); 
            JOptionPane.showMessageDialog(null, "Agendado com sucesso para o dia: " + objagendarconsultadto.getDia_dispo_consulta() + ", no horário: " + objagendarconsultadto.getHorario_consulta());
            //olha eu adiantei uns bagui so pra testae mas se tu qsr apagar ou usar dboa
            
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null,"CurriculoDAO: " + erro);
        }
    }
}
  