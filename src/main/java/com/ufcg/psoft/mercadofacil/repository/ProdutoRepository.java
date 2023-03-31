package com.ufcg.psoft.mercadofacil.repository;

import java.util.HashMap;

import com.ufcg.psoft.mercadofacil.model.Produto;

public class ProdutoRepository<P,L> {

    HashMap<Long,P> produtos = new HashMap<>();

    public P update(P produtoAlterado) {
       Long id = ((Produto) produtoAlterado).getId();
       this.produtos.clear();
       this.produtos.put(id, produtoAlterado);
       
       return produtoAlterado;
    }

    public P find(long l) {
        return produtos.get(l);
    }

    
}
