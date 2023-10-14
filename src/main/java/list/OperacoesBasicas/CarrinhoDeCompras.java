package main.java.list.OperacoesBasicas;

import java.util.ArrayList;
import java.util.List;

public class CarrinhoDeCompras {
  
  private List<Item> carrinhoCompra;

  public CarrinhoDeCompras() {
    this.carrinhoCompra = new ArrayList<>();
  }

  public void adicionarItem(String nome, double preco, int quantidade){
    carrinhoCompra.add(new Item(nome, preco, quantidade));
  }

  public void removerItems(String nome){
    List<Item> ItemsParaRemover = new ArrayList<>();
    for(Item i: carrinhoCompra){
      if(i.getNome().equalsIgnoreCase(nome)){
        ItemsParaRemover.add(i);
      }
    }
    carrinhoCompra.removeAll(ItemsParaRemover);
  }

  public double calcularValorTotal(){
    
    double valorTotal = 0d;
    if (!carrinhoCompra.isEmpty()) {
      for (Item item : carrinhoCompra) {
        double valorItem = item.getPreco() * item.getQuantidade();
        valorTotal += valorItem; //valorTotal = valorTotal + valorItem;
      }
      return valorTotal;
    } else {
      throw new RuntimeException("A lista está vazia!");
    }
  }

  public void exibirItens(){
    System.out.println(carrinhoCompra);
  }

  public static void main(String[] args) {
    CarrinhoDeCompras carrinhoCompra = new CarrinhoDeCompras();

    //carrinhoCompra.exibirItens();

    carrinhoCompra.adicionarItem("Xbox 360", 700.00, 1);
    carrinhoCompra.adicionarItem("Xbox one", 2200.00, 1);
    carrinhoCompra.adicionarItem("Play 5", 3500.00, 1);
    carrinhoCompra.adicionarItem("Pc gamer", 5000.00, 1);
  
    System.out.println("Valor total " + carrinhoCompra.calcularValorTotal());
    carrinhoCompra.exibirItens();

    }
  }