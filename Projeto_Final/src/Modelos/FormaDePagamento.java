package Modelos;

public class FormaDePagamento implements CadastroInterface {

    private int id;
    private String descricao;
    private boolean ativo;

    // <editor-fold defaultstate="collapsed" desc="GETTERS E SETTERS">  
    public int getId() {
        return id;
    }

    public String getDescricao() {
        return descricao;
    }

    public boolean getAtivo() {
        return ativo;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }

    // </editor-fold> 
    
    @Override
    public void inserir() {
    }

    @Override
    public void atualizar() {
    }

    @Override
    public void remover() {
    }

    @Override
    public void carregarPorId(int id) {
    }
}
