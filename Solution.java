import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

import javax.crypto.spec.IvParameterSpec;

public class Solution {
  Servidores servidores = new Servidores(4);

  public void solution2() {
    this.servidores.adicionaConexao2(0, 1);
    this.servidores.adicionaConexao2(1, 2);
    this.servidores.adicionaConexao2(2, 0);
    this.servidores.adicionaConexao2(1, 3);
    this.dfs(servidores.conexoes, 1, 3);
    System.out.println(servidores.conexoes);
  }

  public void solution1() {
    this.servidores.adicionaConexao1(0, 1);
    this.servidores.adicionaConexao1(1, 2);
    this.servidores.adicionaConexao1(2, 0);
    this.servidores.adicionaConexao1(1, 3);
    this.servidores.adicionaConexao1(1, 4);

    System.out.println(servidores.conexoes);
  }

  private void dfs(ArrayList<List<Integer>> graph, Integer start, Integer end) {
    boolean[] visited = new boolean[servidores.qServidores];
    ArrayList<Integer> pathList = new ArrayList<>();
    pathList.add(start);
    dfsUtil(graph, visited, start, end, pathList);
    System.out.println();
  }

  void dfsUtil(ArrayList<List<Integer>> graph, boolean[] visited, Integer start, Integer end,
      List<Integer> localPathList) {
    if (start.equals(end)) {
      System.out.println(localPathList);
      // if match found then no need to traverse more till depth
      return;
    }
    visited[start] = true;
    System.out.print(start + " ");
    for (Integer i : graph.get(start)) {
      if (!visited[i]) {
        localPathList.add(i);
        dfsUtil(graph, visited, i, end, localPathList);
        localPathList.remove(i);
      }
    }
    visited[end] = false;
  }

  private List<List<Integer>> criticalConnections(List<List<Integer>> connections) {
    HashSet<Integer> apareceu = new HashSet<>();
    HashSet<Integer> apareceu1vez = new HashSet<>();
    List<List<Integer>> criticalConnections = new ArrayList<>();

    for (var connectionsOfServer : servidores.conexoes) {
      for (Integer node : connectionsOfServer) {
        if (apareceu1vez.contains(node)) {
          apareceu1vez.remove(node);
          apareceu.add(node);
        }
        if (!apareceu1vez.contains(node) && !apareceu.contains(node)) {
          apareceu1vez.add(node);
        }
      }
    }
    for (Integer num : apareceu1vez) {
      for (var connection : connections) {
        if (connection.contains(num)) {
          criticalConnections.add(connection);
        }
      }
    }
    System.out.println(apareceu);
    System.out.println(apareceu1vez);
    return criticalConnections;
  }

}
