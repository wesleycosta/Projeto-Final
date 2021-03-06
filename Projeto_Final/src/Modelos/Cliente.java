package Modelos;

import BaseDeDados.Banco;
import java.sql.SQLException;

public class Cliente extends Pessoa {

    // <editor-fold defaultstate="collapsed" desc="INSERIR, ATUALIZAR, REMOVER E CARREGAR POR ID">
    @Override
    public void inserir() {

        try {
            String query 
                    = "INSERT INTO clientes                                                                       "
                    + "    (id_endereco, nome, cpf, genero, data_de_nascimento, celular, telefone, email, ativo)  "
                    + "OUTPUT inserted.id_cliente                                                                 "
                    + "VALUES                                                                                     "
                    + "	    (?, ?, ?, ?, ?, ?, ?, ?, ?)";

            Banco.cmd = Banco.getConexao().prepareStatement(query);
            Banco.cmd.setInt(1, this.endereco.getId());
            Banco.cmd.setString(2, this.nome);
            Banco.cmd.setString(3, this.cpf);
            Banco.cmd.setString(4, this.genero);
            Banco.cmd.setDate(5, Validacoes.Funcoes.converterData(dataDeNascimento));
            Banco.cmd.setString(6, this.celular);
            Banco.cmd.setString(7, this.telefone);
            Banco.cmd.setString(8, this.email);
            Banco.cmd.setInt(9, this.ativo ? 1 : 0);

            Banco.leitor = Banco.cmd.executeQuery();

            if (Banco.leitor.next()) {
                this.id = Banco.leitor.getInt(1);
            }

            Banco.cmd.close();
        } catch (SQLException ex) {
            Validacoes.Mensagens.mostrarAviso(ex.toString());
        }
    }

    @Override
    public void atualizar() {
        try {
            String query
                    = "UPDATE clientes SET           "
                    + "     id_endereco         = ?, "
                    + "     nome                = ?, "
                    + "     cpf                 = ?, "
                    + "     genero              = ?, "
                    + "     data_de_nascimento  = ?, "
                    + "     celular             = ?, "
                    + "     telefone            = ?, "
                    + "     email               = ?, "
                    + "     ativo               = ?  "
                    + " WHERE                        "
                    + "     id_cliente = ?";

            Validacoes.Mensagens.mostrarAviso(this.endereco.getId() + "");
            Banco.cmd = Banco.getConexao().prepareStatement(query);
            Banco.cmd.setInt(1, this.endereco.getId());
            Banco.cmd.setString(2, this.nome);
            Banco.cmd.setString(3, this.cpf);
            Banco.cmd.setString(4, this.genero);
            Banco.cmd.setDate(5, Validacoes.Funcoes.converterData(dataDeNascimento));
            Banco.cmd.setString(6, this.celular);
            Banco.cmd.setString(7, this.telefone);
            Banco.cmd.setString(8, this.email);
            Banco.cmd.setInt(9, this.ativo ? 1 : 0);
            Banco.cmd.setInt(10, this.id);

            Banco.cmd.executeUpdate();
            Banco.cmd.close();
        } catch (SQLException ex) {
            Validacoes.Mensagens.mostrarAviso(ex.toString());
        }

    }

    @Override
    public void carregar() {
        carregarPorId(this.id);
    }

    @Override
    public void remover() {
        this.ativo = false;
        atualizar();
    }

    @Override
    public void carregarPorId(int id) {
        try {
            String query
                    = "SELECT                   "
                    + "     id_endereco,        "
                    + "     nome,               "
                    + "     cpf,                "
                    + "     genero,             "
                    + "     data_de_nascimento, "
                    + "     celular,            "
                    + "     telefone,           "
                    + "     email,              "
                    + "     ativo               "
                    + "FROM                     "
                    + "     clientes            "
                    + "WHERE                    "
                    + "     id_cliente = ?";

            Banco.cmd = Banco.getConexao().prepareStatement(query);
            Banco.cmd.setInt(1, id);
            Banco.leitor = Banco.cmd.executeQuery();

            if (Banco.leitor.next()) {
                this.id = id;
                this.endereco = new Endereco();

                this.endereco.setId(Banco.leitor.getInt("id_endereco"));
                this.nome = Banco.leitor.getString("nome");
                this.cpf = Banco.leitor.getString("cpf");
                this.genero = Banco.leitor.getString("genero");
                this.dataDeNascimento = Banco.leitor.getDate("data_de_nascimento");
                this.celular = Banco.leitor.getString("celular");
                this.telefone = Banco.leitor.getString("telefone");
                this.email = Banco.leitor.getString("email");
                this.ativo = Banco.leitor.getInt("ativo") == 1;
            }

            Banco.cmd.close();
        } catch (SQLException ex) {
            Validacoes.Mensagens.mostrarAviso(ex.toString());
        }

        this.endereco.carregar();
    }
    // </editor-fold>
}
