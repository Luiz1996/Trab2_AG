/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.uem.din.grafo.app;

import br.uem.din.grafo.model.Aresta;
import static br.uem.din.grafo.model.Cor.Branco;
import br.uem.din.grafo.model.Grafo;
import br.uem.din.grafo.model.Vertice;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

/**
 *
 * @author luiz.pereira
 */
public class CriarGrafo {
    public Grafo realizarLeituraTxt() throws FileNotFoundException, IOException {
        Grafo graph = new Grafo();
        
        System.out.print("Selecione o arquivo de importação!");
        String nomeArq = selecionarArquivo();
        
        //chamando garbage collector
        System.gc();
        
        //realizando limpeza do console
        Console.limparConsole();
        
        //validando se algum arquivo foi selecionado
        if(nomeArq == null){
            System.exit(0);
        }

        //abrindo arquivo para leitura
        try (
                BufferedReader br = new BufferedReader(new FileReader(nomeArq))){

            //obtendo dados do cabeçalho do arquivo texto
            String linha = br.readLine();
            String[] cabecalhoArq = linha.split(" ");
            graph.setQtdeVertices(Integer.parseInt(cabecalhoArq[0]));
            graph.setQtdeAgrupamentos(Integer.parseInt(cabecalhoArq[1]));

            List<Vertice> lVertice = new ArrayList<>();
            
            //realizando leitura do arquivo
            for (int i = 0; i < graph.getQtdeVertices(); i++) {
                linha = br.readLine();
                String[] leituraDividida = linha.split(" ");

                Vertice v = new Vertice((i + 1), Integer.parseInt(leituraDividida[0]), Integer.parseInt(leituraDividida[1]), Branco) {};
                lVertice.add(v);
            }

            graph.setVertice(lVertice);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Falha ao ler arquivo!\nPrograma Abortado\nErro: ".concat(e.getMessage().trim()), "Falha ao ler arquivo", JOptionPane.ERROR_MESSAGE);
            System.exit(0);
        }
        
        //realizando a criação dos adjacentes
        criarVerticesAdjacentes(graph);
        
        //criando todas as arestas do grafo
        graph.setAresta(criarArestas(graph));
        
        return graph;
    }
    
    public String selecionarArquivo(){
        JFileChooser file = new JFileChooser();
        file.showDialog(file, "Abrir arquivo texto");
        try{
            return file.getSelectedFile().toString().trim();
        }catch (Exception e){
            JOptionPane.showMessageDialog(null, "Nenhum arquivo foi selecionado ou arquivo inválido.\nPrograma abortado!", "Falha ao abrir arquivo texto", JOptionPane.ERROR_MESSAGE);
        }
        return null;
    }

    private void criarVerticesAdjacentes(Grafo G) { 
        for(Integer i = 0; i < G.getQtdeVertices(); i++){
            String adjacentes = "";
            for(Integer j = 0; j < G.getQtdeVertices(); j++){
                if(Objects.equals(i, j)){
                    continue;
                }else{
                    Integer maisUm = j + 1; 
                    adjacentes = adjacentes.concat(maisUm.toString().concat(","));
                }
                G.getVertice().get(i).setVertAdj(adjacentes);
            }
        }
    }

    private List<Aresta> criarArestas(Grafo G) {
        List<Aresta> arestas = new ArrayList<>();
        for(Integer i = 0; i < G.getQtdeVertices(); i++){          
            for(Integer j = 0; j < G.getQtdeVertices(); j++){  
                Aresta arestaTemp = new Aresta();   
                if(!Objects.equals(i, j) && !identificarArestaRepetida(arestas, (i+1), (j+1))){
                    arestaTemp.setV1(G.getVertice().get(i));
                    arestaTemp.setV2(G.getVertice().get(j));
                    arestaTemp.setDistancia(calcularDistancia(G.getVertice().get(i).getEixoX(), G.getVertice().get(i).getEixoY(), G.getVertice().get(j).getEixoX(), G.getVertice().get(j).getEixoY()));
                    arestas.add(arestaTemp);
                }
            } 
        }
        return arestas;
    }
    
    private boolean identificarArestaRepetida(List<Aresta> arestas, int v1, int v2){
        for(int i = 0; i < arestas.size(); i++){
            if(
                    (arestas.get(i).getV2().getNumVertice() == v2 && arestas.get(i).getV1().getNumVertice() == v1) ||
                    (arestas.get(i).getV2().getNumVertice() == v1 && arestas.get(i).getV1().getNumVertice() == v2)
              ){
                return true;
            }
        }
        return false;
    }
    
    private Double calcularDistancia(Integer xV1, Integer yV1, Integer xV2, Integer yV2){
        return (Math.sqrt((Math.pow(xV2.doubleValue() - xV1.doubleValue(), 2.0) + Math.pow(yV2.doubleValue() - yV1.doubleValue(), 2.0))));
    }
}
