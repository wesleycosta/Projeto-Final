
import Modelos.*;
import java.util.Date;
import javafx.scene.paint.Color;

public class Programa {

    public static void main(String[] args) {
//        new Telas.frmModeloConsultaPequeno().setVisible(true);

//      Cargo cargo = new Cargo();
//      cargo.setDescricao("FINNAZII");
//      cargo.inserir();
//      Cargo cargo = new Cargo();
//      cargo.carregarPorId(1);
//      cargo.remover();
//      Cargo cargo = new Cargo();
//      cargo.carregarPorId(11);
//      cargo.setDescricao("ALFA");
//      cargo.setAtivo(true);
//      cargo.atualizar();
//        Endereco end = new Endereco();
//        end.setCep("1246000");
//        end.setCidade("CAMPOS DO JORDÃO");
//        end.setBairro("VILA BRITANIA");
//        end.setLogradouro("RUA ANTORNIO FURTADO DE SOUZA");
//        end.setNumero("565");
//        end.setComplemento("COMPLEMENTO");
//        end.setUf("SP");
//        end.setAtivo(true);
//        end.inserir();
//        Consulta c = new Consulta();
//        c.setId(3);
//
//        Date dt = Validacoes.Funcoes.getData("30/10/2017");
//        FormaDePagamento f = new FormaDePagamento();
//        f.carregarPorId(1);
//
//        Pagamento pag = new Pagamento();
//        pag.setConsulta(c);
//        pag.setData(dt);
//        pag.setValor(100.00);
//        pag.setQtdParcela((byte) 1);
//        pag.setAtivo(true);
//        pag.setFormaDePagamento(f);
//
//        // pag.inserir();
//        pag.carregarPorId(3);
//        pag.setValor(666.00);
//        
//        for (Pagamento p : Pagamento.carregarPorIdConsulta(3)) {
//            Validacoes.Mensagens.mostrarAviso(p.getId() + "\n" + p.getData() + "\n" + p.getValor());
//        }

          Funcionario fun = new Funcionario();
          Endereco end = new Endereco();
          Cargo cargo = new Cargo();
          end.setId(1);
          cargo.setId(1);
          
//          fun.setId(1);
//          fun.setEndereco(end);
//          fun.setCargo(cargo);
//          fun.setNome("maria");
//          fun.setCpf("1234");
//          fun.setGenero("f");
//          fun.setDataDeNascimento(Validacoes.Funcoes.getData("08/06/2017"));
//          fun.setCelular("99736475");
//          fun.setTelefone("36645364");
//          fun.setEmail("joao@gmail.com");
//          fun.setSalario(1000.00);
//          fun.setDataDeAdmissao(Validacoes.Funcoes.getData("02/03/2017"));
//          fun.setAtivo(true);
          
          fun.carregarPorId(1);
          
          
          System.out.println("Nome funcionario: "+fun.getNome()+  "id:" +fun.getId());
          
          
          
          

    }
}
