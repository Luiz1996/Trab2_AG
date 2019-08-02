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
public class Aresta {
    private Vertice v1;
    private Vertice v2;
    private Double distancia;
    
    public Aresta(){
        
    }

    public Aresta(Vertice v1, Vertice v2, Double distancia) {
        this.v1 = v1;
        this.v2 = v2;
        this.distancia = distancia;
    }

    public Vertice getV1() {
        return v1;
    }

    public void setV1(Vertice v1) {
        this.v1 = v1;
    }

    public Vertice getV2() {
        return v2;
    }

    public void setV2(Vertice v2) {
        this.v2 = v2;
    }

    public Double getDistancia() {
        return distancia;
    }

    public void setDistancia(Double distancia) {
        this.distancia = distancia;
    }
}
