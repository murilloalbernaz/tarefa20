/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.manoelcampos.exportador;

import java.util.function.Function;


public abstract class AbstractColuna implements Coluna {

    private final Function<Produto,Object> obtemValorColuna;
    String titulo;

    public AbstractColuna(Function<Produto,Object> obtemValorColuna,String titulo) {
        this.obtemValorColuna = obtemValorColuna;
        this.titulo = titulo;
    }
    
    @Override
    public String getTitulo() {
        return titulo;
    }

    @Override
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    @Override
    public String exportaCabeçalho() {
        return abrir()+titulo+fechar();
    }

    @Override
    public String exportaDado(Produto produto) {
        Object retorno = obtemValorColuna.apply(produto);
        return abrir()+retorno.toString()+fechar();
    }
    
}
