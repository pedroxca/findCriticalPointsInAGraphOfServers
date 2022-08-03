import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Servidores {

  ArrayList<List<Integer>> conexoes = new ArrayList<>();
  Integer qServidores;
  Integer[] servidores;

  Servidores(Integer qServidores) {
    this.qServidores = qServidores;
    this.servidores = new Integer[qServidores];
    for (int i = 0; i < qServidores; i++) {
      this.servidores[i] = i;
    }
    for (int i = 0; i < qServidores; i++) {
      conexoes.add(new ArrayList<>());
    }
  }
  void adicionaConexao1(Integer servidor, Integer conexao) {
    conexoes.add(Arrays.asList(servidor, conexao));
  }
  void adicionaConexao2(Integer servidor, Integer conexao){
    conexoes.get(servidor).add(conexao);
    conexoes.get(conexao).add(servidor);
  }
}
