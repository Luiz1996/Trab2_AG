/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.uem.din.grafo.model;
/**
 *
 * @author Luiz Flávio
 */
public class Vertice {
    private int numVertice;
    private Integer eixoX;
    private Integer eixoY;
    private Cor cor;
    private String vertAdj;
    
    public Vertice(){
        
    }

    public Vertice(int numVertice, Integer eixoX, Integer eixoY, Cor cor, String vertAdj) {
        this.numVertice = numVertice;
        this.eixoX = eixoX;
        this.eixoY = eixoY;
        this.cor = cor;
        this.vertAdj = vertAdj;
    }

    public Vertice(int numVertice, Integer eixoX, Integer eixoY, Cor cor) {
        this.numVertice = numVertice;
        this.eixoX = eixoX;
        this.eixoY = eixoY;
        this.cor = cor;
    }

    public int getNumVertice() {
        return numVertice;
    }

    public void setNumVertice(int numVertice) {
        this.numVertice = numVertice;
    }

    public Integer getEixoX() {
        return eixoX;
    }

    public void setEixoX(Integer eixoX) {
        this.eixoX = eixoX;
    }

    public Integer getEixoY() {
        return eixoY;
    }

    public void setEixoY(Integer eixoY) {
        this.eixoY = eixoY;
    }

    public Cor getCor() {
        return cor;
    }

    public void setCor(Cor cor) {
        this.cor = cor;
    }

    public String getVertAdj() {
        return vertAdj;
    }

    public void setVertAdj(String vertAdj) {
        this.vertAdj = vertAdj;
    }
}
