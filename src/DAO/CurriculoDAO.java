package DAO;

import DTO.CurriculoDTO;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import java.sql.PreparedStatement;
import projetofinal.CurriculoEnviado;

public class CurriculoDAO {
    Connection conectar;
    
    public CurriculoDAO(){
        conectar = new ConexaoDAO().getConexao();
    }
    
    public void inserirCurriculo(CurriculoDTO objcurriculodto){        
        try {
            String mysqlQuery = "SELECT * FROM CURRICULO";
            PreparedStatement ps = conectar.prepareStatement(mysqlQuery);
            ResultSet rs = ps.executeQuery(mysqlQuery);

            while(rs.next()) {
                String cpf = rs.getString("CPF");
                if(cpf.equalsIgnoreCase(objcurriculodto.getCpf_curriculo())) {
                    int input = JOptionPane.showConfirmDialog(null, "Ja foi encontrado um currículo com esse CPF, deseja substituir?", "ERRO!",
				JOptionPane.YES_NO_OPTION, JOptionPane.ERROR_MESSAGE);
                    if(input==0) {
                        String mysqlDel = String.format("DELETE FROM CURRICULO WHERE CPF = \"%s\"", cpf);
                        PreparedStatement del = conectar.prepareStatement(mysqlDel);
                        JOptionPane.showMessageDialog(null, "Apagado com sucesso!");
                        del.executeUpdate();
                    } else {
                        int input2 = JOptionPane.showConfirmDialog(null, "Deseja ver o currículo associado?", "ERRO!",
				JOptionPane.YES_NO_OPTION, JOptionPane.ERROR_MESSAGE);
                        if(input2==0) {
                            CurriculoEnviado obj = new CurriculoEnviado();
                            obj.setVisible(true);
                            obj.alterarComponentes(rs.getString("NOME"), rs.getString("CPF"), rs.getString("TELEFONE"), rs.getString("EMAIL"), rs.getString("VAGA"), rs.getString("CEP"), rs.getString("EXPERIENCIA"), rs.getString("FORMACAO"));
                            return;
                        }
                    }
                }
            }
            
            String mysqlString = "INSERT INTO CURRICULO(NOME, CPF, TELEFONE, EMAIL, VAGA, CEP, EXPERIENCIA, FORMACAO) VALUES (?,?,?,?,?,?,?,?)";
            PreparedStatement prep = conectar.prepareStatement(mysqlString);
            prep.setString(1, objcurriculodto.getNome_curriculo());
            prep.setString(2, objcurriculodto.getCpf_curriculo());
            prep.setString(3, objcurriculodto.getTelefone_curriculo());
            prep.setString(4, objcurriculodto.getEmail_curriculo());
            prep.setString(5, objcurriculodto.getVaga_curriculo() );
            prep.setString(6, objcurriculodto.getCep_curriculo());
            prep.setString(7, objcurriculodto.getExperiencia_curriculo());
            prep.setString(8, objcurriculodto.getFormacao_curriculo());
            prep.executeUpdate();
            System.out.println("Curriculo enviado com sucesso!");     
            JOptionPane.showMessageDialog(null,"Currículo enviado com sucesso!");
            //olha eu adiantei uns bagui so pra testae mas se tu qsr apagar ou usar dboa
            
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null,"CurriculoDAO: " + erro);
        }
    }
}
  