package me.dio.sacola.Model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

import me.dio.sacola.Model.Endereco;

//Como vamos usar banco de dados a qui também, precisaremos de:
//Identificacao (@Id), gerar essa identificação (@GeneratedValue), guardar essa identificacao (private long id)
//Construtor (@AllArgsConstructor)
//Construtor vazio (@NoArgsConstructor)
//E getters e seters, para ter acesso aos atributos private, e hashcode para fazer comparações (@Data)

@AllArgsConstructor
@Builder
@Data
@Entity //Indica que a classe Restaurante vai ser convertida para uma tabela no banco de dados.
@JsonIgnoreProperties
@NoArgsConstructor

public class Restaurante {

    //No restaurante temos:
    //Uma identificacao Id, porque se relacionada com outras classes num banco de dados.
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String nome;
    //Produtos
    private List<Produto> cardapio;
    //Itens, que são os produtos disponíveis e aos quais podem ser atribuídas quantidades.
    //Um restaurante pode receber/responder diversos pedidos:
    @OneToMany(cascade = CascadeType.ALL)
    //E ele tem um endereço para os entregadores pegarem os pedidos
    @Embedded
    private Endereco endereco;
}
