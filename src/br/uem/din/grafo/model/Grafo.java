/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.uem.din.grafo.model;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Luiz Flávio
 */
public class Grafo {

    private int qtdeVertices;
    private int qtdeAgrupamentos;
    private List<Aresta> aresta;
    private List<Vertice> vertice;

    public Grafo() {

    }

    public Grafo(int qtdeVertices, int qtdeAgrupamentos, List<Aresta> aresta, List<Vertice> vertice) {
        this.qtdeVertices = qtdeVertices;
        this.qtdeAgrupamentos = qtdeAgrupamentos;
        this.aresta = aresta;
        this.vertice = vertice;
    }

    public List<Aresta> getAresta() {
        return aresta;
    }

    public void setAresta(List<Aresta> aresta) {
        this.aresta = aresta;
    }

    public List<Vertice> getVertice() {
        return vertice;
    }

    public void setVertice(List<Vertice> vertice) {
        this.vertice = vertice;
    }

    public int getQtdeVertices() {
        return qtdeVertices;
    }

    public void setQtdeVertices(int qtdeVertices) {
        this.qtdeVertices = qtdeVertices;
    }

    public int getQtdeAgrupamentos() {
        return qtdeAgrupamentos;
    }

    public void setQtdeAgrupamentos(int qtdeAgrupamentos) {
        this.qtdeAgrupamentos = qtdeAgrupamentos;
    }

    //apresenta todas as arestas detalhadamente
    public void imprimirArestas(Grafo G) {
        System.out.println("Este Grafo possui " + G.getQtdeVertices() + " vértices, " + G.getQtdeAgrupamentos() + " agrupamentos e " + G.getAresta().size() + " arestas.");
        System.out.println("----------------------------------------------------------------");

        for (int i = 0; i < G.getAresta().size(); i++) {
            System.out.println("Aresta nº" + (i + 1));
            System.out.println("--------------");
            System.out.println("1º Vértice: " + G.getAresta().get(i).getV1().getNumVertice());
            System.out.println("Cor.......: " + G.getAresta().get(i).getV1().getCor());
            System.out.println("Eixo X....: " + G.getAresta().get(i).getV1().getEixoX());
            System.out.println("Eixo Y....: " + G.getAresta().get(i).getV1().getEixoY());
            System.out.println("--------------");
            System.out.println("2º Vértice: " + G.getAresta().get(i).getV2().getNumVertice());
            System.out.println("Cor.......: " + G.getAresta().get(i).getV2().getCor());
            System.out.println("Eixo X....: " + G.getAresta().get(i).getV2().getEixoX());
            System.out.println("Eixo Y....: " + G.getAresta().get(i).getV2().getEixoY());
            System.out.println("--------------");
            System.out.println("Distância euclidiana entre os dois vértices: " + G.getAresta().get(i).getDistancia());
            System.out.println("----------------------------------------------------------------");
        }
    }

    //apresenta todos os vertices detalhadamente
    public void imprimirVertices(Grafo G) {
        System.out.println("Este Grafo possui " + G.getQtdeVertices() + " vértices, " + G.getQtdeAgrupamentos() + " agrupamentos e " + G.getAresta().size() + " arestas.");
        System.out.println("----------------------------------------------------------------");

        for (int i = 0; i < G.getQtdeVertices(); i++) {
            System.out.println("Vértice: " + G.getVertice().get(i).getNumVertice());
            System.out.println("Cor....: " + G.getVertice().get(i).getCor());
            System.out.println("Eixo X.: " + G.getVertice().get(i).getEixoX());
            System.out.println("Eixo Y.: " + G.getVertice().get(i).getEixoY());
            System.out.println("Adjacts: " + G.getVertice().get(i).getVertAdj());
            System.out.println("----------------------------------------------------------------");
        }
    }

    public void imprimirGrafo(Grafo G) {
        System.out.println("Este Grafo possui " + G.getQtdeVertices() + " vértices, " + G.getQtdeAgrupamentos() + " agrupamentos e " + G.getAresta().size() + " arestas.");
        System.out.println("----------------------------------------------------------------");

        //identifica os vertices e suas arestas para outros vertices
        for (int i = 0; i < G.getQtdeVertices(); i++) {
            System.out.print("(Vertice " + (i + 1) + ") ");
            for (int j = 0; j < G.getAresta().size(); j++) {
                if (G.getAresta().get(j).getV1().getNumVertice() == (i + 1)) {
                    System.out.print("--> (" + G.getAresta().get(j).getV2().getNumVertice() + ") ");
                } else {
                    if (G.getAresta().get(j).getV2().getNumVertice() == (i + 1)) {
                        System.out.print("--> (" + G.getAresta().get(j).getV1().getNumVertice() + ") ");
                    }
                }
            }
            System.out.print("\n");
        }
        System.out.println("----------------------------------------------------------------");
    }

    public List<Aresta> ordenarArestas(Grafo G) {
        Aresta arestaAux = new Aresta();

        //utilizando BubleSort APRIMORADO visto em PAA com Profº. Calvo
        //Melhor caso: O(n) e Pior caso: O(n²), valida se ocorreu ao menos 1 mudança para cada iteração completa do laço interno, caso contrário já está ordenado...
        for (int i = 0; i < G.getAresta().size(); i++) {
            int flag = 0;
            for (int j = 0; j < (G.getAresta().size() - 1 - i); j++) {
                if (G.getAresta().get(j).getDistancia() > G.getAresta().get((j + 1)).getDistancia()) {
                    arestaAux = G.getAresta().get(j);
                    G.getAresta().set(j, G.getAresta().get(j + 1));
                    G.getAresta().set((j + 1), arestaAux);
                    flag = 1;
                }
            }
            if (flag == 0) {
                return G.getAresta();
            }
        }
        return G.getAresta();
    }

    public int buscar(int subSet[], int v) {
        if (subSet[v] == -1) {
            return v;
        } else {
            return buscar(subSet, subSet[v]);
        }
    }

    public void unir(int subSet[], int v1, int v2) {
        int v1_set = buscar(subSet, v1);
        int v2_set = buscar(subSet, v2);

        subSet[v1_set] = v2_set;
    }

    public List<Aresta> criarMstKruskall(Grafo G) {
        //primeiramente, devemos ter certeza que todas as arestas estão com suas distancias ordenadas de forma crescente
        G.setAresta(G.ordenarArestas(G));

        //instanciando vetor auxiliar e inicializando todas as posições com -1
        int[] vector = new int[G.getAresta().size()];
        for (int i = 0; i < vector.length; i++) {
            vector[i] = -1;
        }

        //criando Mst através do union - find
        List<Aresta> arestasMst = new ArrayList<>();
        for (int i = 0; i < G.getAresta().size(); i++) {
            int v1 = buscar(vector, G.getAresta().get(i).getV1().getNumVertice());
            int v2 = buscar(vector, G.getAresta().get(i).getV2().getNumVertice());
            if (v1 != v2) {
                arestasMst.add(G.getAresta().get(i));
                unir(vector, v1, v2);
            }
        }
        return arestasMst;
    }

    public List<Integer> removeArestasMaiores(Grafo G) {
        List<Integer> lAuxDst = new ArrayList<>();   
        int qtdeArestas = G.getAresta().size();
        Comparator<? super Integer> c = null;
        
        //neste for é identificado as maiores arestas a serem removidas e qual vertice deve ser armazenado no lAuxDst (lista auxiliar de distancia)
        for (int i = (qtdeArestas - 1); i > (qtdeArestas - G.getQtdeAgrupamentos()); i--) {    
            lAuxDst.sort(c);
            if(!existeNoLAux(lAuxDst, G.getAresta().get(i).getV1().getNumVertice())){
                lAuxDst.add(G.getAresta().get(i).getV1().getNumVertice());     
            }else{
                if(!existeNoLAux(lAuxDst, G.getAresta().get(i).getV2().getNumVertice())){
                    lAuxDst.add(G.getAresta().get(i).getV2().getNumVertice());     
                }
            } 
            G.getAresta().remove(i);
        }
        //ordenando lista e apresentando vertices obtidos após remoção das arestas
        lAuxDst.sort(c);
        System.out.println("Vértice das Arestas Removidas: " + lAuxDst + "\n----------------------------------------------------------------");

        System.gc();
        return lAuxDst;
    }

    public void listarAgrupamentos(Grafo Mst) {
        if (Mst.getAresta().size() > 0) {
            //validando se a quantidade de agrupamentos é inválida    
            if(Mst.getQtdeVertices() < Mst.getQtdeAgrupamentos()){
                JOptionPane.showMessageDialog(null, "Existem mais agrupamentos que vértices, corrigir arquivo de importação!", "Agrupamento inválido", JOptionPane.ERROR_MESSAGE);
                return;
            }
            
            //declaração de variáveis 
            List<Integer> lAux = new ArrayList<>(); //essa lista nos auxiliará em não permitir a repetição de elementos nos agrupamentos
            List<Integer> lImprimir = new ArrayList<>(); //essa lista é a que deve conter os agrupamentos corretamente e ordenados
            List<Integer> lAuxDst = new ArrayList<>(); //essa lista contera os vertices V1 das arestas com maior distancia/removidas
            boolean verificaProximo = false; //esse boolean nos ajuda a validar qual será o proximo elemento a ir para o lImprimir
            int qtdeArestas = Mst.getAresta().size(); //essa variavel contem a qtde inicial de arestas, nos auxiliará no for()
            Comparator<? super Integer> c = null;
            
            //removendo as arestas de maior distancia
            lAuxDst = removeArestasMaiores(Mst);
            
            //imprimindo cabeçalho
            System.out.println("Este Grafo possui " + Mst.getQtdeVertices() + " vértices, " + Mst.getQtdeAgrupamentos() + " agrupamentos e " + qtdeArestas + " arestas.");
            System.out.println("----------------------------------------------------------------");
            
            //setando valor por onde iniciaremos a impressão
            lImprimir.add(1);
            lAux.add(1);

            //este for executa até que todos agrupamentos sejam listados
            for (int numAgrup = 1; numAgrup <= Mst.getQtdeAgrupamentos(); numAgrup++) {
                //este for carrega a lista lImprimir com todos os vértices do agrupamento
                for (int i = 0; i < lImprimir.size() && lAux.size() <= qtdeArestas; i++) {
                    //este for procura arestas/vértices que possuem uma 'relação' com o vertice da lImprimir.get(i)
                    for (int j = 0; j < Mst.getAresta().size(); j++) {
                        //carregando listas auxiliares
                        if (Mst.getAresta().get(j).getV1().getNumVertice() == lImprimir.get(i) && !existeNoLAux(lAux, Mst.getAresta().get(j).getV2().getNumVertice())) {
                            lImprimir.add(Mst.getAresta().get(j).getV2().getNumVertice());
                            lAux.add(Mst.getAresta().get(j).getV2().getNumVertice());
                        } else {
                            if (Mst.getAresta().get(j).getV2().getNumVertice() == lImprimir.get(i) && !existeNoLAux(lAux, Mst.getAresta().get(j).getV1().getNumVertice())) {
                                lImprimir.add(Mst.getAresta().get(j).getV1().getNumVertice());
                                lAux.add(Mst.getAresta().get(j).getV1().getNumVertice());
                            }
                        }
                    }
                }
                
                //ordenando e imprimindo agrupamento obtido
                lImprimir.sort(c);
                System.out.println("Agrupamento " + numAgrup + ": " + lImprimir);
                lImprimir = new ArrayList<>(); 
                verificaProximo = false;
                        
                //obtendo proximo a continuar na listagem de agrupamentosa partir da lista de arestas removidas
                for(int i = 0; i < lAuxDst.size(); i++){
                    if(!existeNoLAux(lAux, lAuxDst.get(i))){
                        lImprimir.add(lAuxDst.get(i));
                        lAux.add(lAuxDst.get(i));
                        verificaProximo = true;
                        break;
                    }
                } 

                //caso na lista de arestas removidas não tenha nada de interessante, então continuamos o agrupamento a partir do ultimo valor do lAux (como ele sempre estará ordenado, então não corremos risco de repetição de elementos)
                lAux.sort(c);
                if(!verificaProximo){
                    lImprimir.add(lAux.get(lAux.size()-1) + 1);
                    lAux.add(lAux.get(lAux.size()-1) + 1);
                } 
                lAux.sort(c);
            }
        }
        System.out.println("----------------------------------------------------------------");
        System.gc();
    }

    //verifica se um determinado valor está contido em um conjunto de dados(lista dinâmica)
    private boolean existeNoLAux(List<Integer> lAux, int numVertice) {
        for (int i = 0; i < lAux.size(); i++) {
            if (lAux.get(i) == numVertice) {
                return true;
            }
        }
        return false;
    }
}
