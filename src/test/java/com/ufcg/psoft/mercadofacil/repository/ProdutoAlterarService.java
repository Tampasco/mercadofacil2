package com.ufcg.psoft.mercadofacil.repository;

import com.ufcg.psoft.mercadofacil.model.Produto;

public interface ProdutoAlterarService<T> {

    Produto alterar(T produto);


    
}
