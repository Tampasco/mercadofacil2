package com.ufcg.psoft.mercadofacil.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ufcg.psoft.mercadofacil.model.Produto;

@Service
public class ProdutoAlterarImplService<T> implements ProdutoAlterarService<T> {
  
   @Autowired
   ProdutoRepository<Produto, Long> produtoRepository;
   @Override
   public Produto alterar(T produtoAlterado) {
    if(((Produto) produtoAlterado).getPreco()<=0) {
        throw new RuntimeException("Preco invalido!");
      }
      return produtoRepository.update((Produto) produtoAlterado);
  }

}




