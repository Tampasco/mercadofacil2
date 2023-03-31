package com.ufcg.psoft.mercadofacil.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.ufcg.psoft.mercadofacil.model.Produto;

@SpringBootTest
@DisplayName("Testes para a alteração do Produto")
public class ProdutoAlterarServiceTest {
   @Autowired
   ProdutoAlterarService<Produto> driver;
   @MockBean
   ProdutoRepository<Produto, Long> produtoRepository;
   Produto produto;
   Produto resultado;
    
@BeforeEach
void setup() {
   Mockito.when(produtoRepository.find(10L))
           .thenReturn(Produto.builder()
                   .id(10L)
                   .codigoBarra("7899137500104")
                   .nome("Produto Dez")
                   .fabricante("Empresa Dez")
                   .preco(450.00)
                   .build()
           );
   produto = produtoRepository.find(10L);
   Mockito.when(produtoRepository.update(produto))
           .thenReturn(Produto.builder()
                   .id(10L)
                   .codigoBarra("7899137500104")
                   .nome("Nome Produto Alterado")
                   .fabricante("Nome Fabricante Alterado")
                   .preco(500.00)
                   .build()
           );
}

@Test
@DisplayName("Quando altero o nome do produto com dados válidos")
void alterarNomeDoProduto() {
   /* AAA Pattern */
   //Arrange
   produto.setNome("Nome Produto Alterado");
   //Act
   resultado = driver.alterar(produto);
   //Assert
   assertEquals("Nome Produto Alterado", resultado.getNome());
}

@Test
@DisplayName("Quando o preço é menor ou igual a zero")
void precoMenorIgualAZero() {
   //Arrange
   produto.setPreco(0.0);
   //Act
   RuntimeException thrown = assertThrows(
           RuntimeException.class,
           () -> driver.alterar(produto)
   );
   //Assert
   assertEquals("Preco invalido!", thrown.getMessage());
}

@Test
@DisplayName("Encontrar um produto com nome alterado")
void encontrarProdutoAlterado() {
        produto.setNome("Nome Produto Alterado");

        resultado = driver.alterar(produto);

        assertEquals("Nome Produto Alterado", resultado.getNome());
        assertEquals(produtoRepository.find(resultado.getId()).getNome(), resultado.getNome());


}


}
