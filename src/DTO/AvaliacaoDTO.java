package DTO;
public class AvaliacaoDTO {
    private int estrelas;
    private String opiniao;

    public int getEstrelas() {
        return estrelas;
    }

    public void setEstrelas(int estrelas) {
        this.estrelas = estrelas;
    }

    public String getOpiniao() {
        return opiniao;
    }

    public void setOpiniao(String opiniao) {
        this.opiniao = opiniao;
    }

    public AvaliacaoDTO(int estrelas, String opiniao) {
        this.estrelas = estrelas;
        this.opiniao = opiniao;
    }
    
    
    
    
}
