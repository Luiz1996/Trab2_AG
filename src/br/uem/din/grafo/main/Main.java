/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.uem.din.grafo.main;

import br.uem.din.grafo.model.Grafo;
import br.uem.din.grafo.app.CriarGrafo;
import br.uem.din.grafo.app.Console;
import java.io.FileNotFoundException;
import java.io.IOException;
import javax.swing.JOptionPane;

/**
 *
 * @author luiz.pereira
 */
public class Main {
    public static void main(String[] args) throws FileNotFoundException, IOException {
        CriarGrafo criarG = new CriarGrafo();
        Grafo G = new Grafo();
        Grafo arvGM =  new Grafo();
        
        G = null;

        int opcao = Console.showMenu();
        while (opcao != 0) {
            Console.limparConsole();
            switch (opcao) {
                case 1:
                    G = criarG.realizarLeituraTxt();
                    JOptionPane.showMessageDialog(null, "Grafo G foi inicializado com sucesso!", "Criando grafo", JOptionPane.INFORMATION_MESSAGE);
                    break;
                case 2:
                    if(G == null) {
                        JOptionPane.showMessageDialog(null, "Nenhum grafo G foi encontrado.", "Grafo vazio", JOptionPane.ERROR_MESSAGE);
                    } else {
                        G.imprimirGrafo(G);
                    }              
                    break;
                case 3:
                    if(G == null) {
                        JOptionPane.showMessageDialog(null, "Nenhum grafo G foi encontrado.", "Grafo vazio", JOptionPane.ERROR_MESSAGE);
                    } else {
                        G.imprimirArestas(G);
                    }             
                    break;
                case 4:
                    if(G == null) {
                        JOptionPane.showMessageDialog(null, "Nenhum grafo G foi encontrado.", "Grafo vazio", JOptionPane.ERROR_MESSAGE);
                    } else {
                        G.imprimirVertices(G);
                    }               
                    break; 
                case 5:
                    if(G == null) {
                        JOptionPane.showMessageDialog(null, "Nenhum grafo G foi encontrado.", "Grafo vazio", JOptionPane.ERROR_MESSAGE);
                    } else {
                        G.setAresta(G.ordenarArestas(G));
                        JOptionPane.showMessageDialog(null, "As arestas do grafo G foram ordenadas com sucesso!", "Ordenar arestas", JOptionPane.INFORMATION_MESSAGE);    
                    }  
                    break;
                case 6:
                    G = null;
                    System.gc();
                    JOptionPane.showMessageDialog(null, "Grafo G foi resetado com sucesso!", "Resetar grafo", JOptionPane.INFORMATION_MESSAGE);
                    break;
                case 7:
                    if(G == null) {
                        JOptionPane.showMessageDialog(null, "Nenhum grafo G foi encontrado para a criação da MST.", "Grafo vazio", JOptionPane.ERROR_MESSAGE);
                    } else {
                        arvGM = constroiMST(G);
                        JOptionPane.showMessageDialog(null, "Sucesso ao criar a MST!", "Criar MST", JOptionPane.INFORMATION_MESSAGE);    
                    } 
                    break;
                case 8:
                    if(arvGM.getQtdeVertices() == 0) {
                        JOptionPane.showMessageDialog(null, "Nenhuma MST foi encontrado.", "MST vazia", JOptionPane.ERROR_MESSAGE);
                    } else {
                        arvGM = constroiMST(G);
                        arvGM.imprimirGrafo(arvGM);   
                    } 
                    break; 
                case 9:
                    if(arvGM.getQtdeVertices() == 0) {
                        JOptionPane.showMessageDialog(null, "Nenhuma MST foi encontrado.", "MST vazia", JOptionPane.ERROR_MESSAGE);
                    } else {
                        arvGM = constroiMST(G);
                        arvGM.imprimirArestas(arvGM);
                    } 
                    break;
                case 10:
                    arvGM = new Grafo();
                    System.gc();
                    JOptionPane.showMessageDialog(null, "MST foi resetada com sucesso!", "Resetar MST", JOptionPane.INFORMATION_MESSAGE);
                    break;
                case 11:
                    if(arvGM.getQtdeVertices() == 0){
                        JOptionPane.showMessageDialog(null, "Nenhuma MST foi encontrada, falha na listagem!", "Listar Agrupamentos", JOptionPane.ERROR_MESSAGE);
                    }else{
                        arvGM = constroiMST(G);
                        arvGM.listarAgrupamentos(arvGM); 
                    }
                    break;    
                default:
                    System.out.println("Opção inválida!");
                    break;
            }
            System.gc();
            opcao = Console.showMenu();
        }
    }
    
    public static Grafo constroiMST(Grafo G){
        Grafo arvGM = new Grafo();
        arvGM.setQtdeVertices(G.getQtdeVertices());
        arvGM.setQtdeAgrupamentos(G.getQtdeAgrupamentos());
        arvGM.setAresta(G.criarMstKruskall(G));
        
        return arvGM;
    }
}
