package me.dio.sacola.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@AllArgsConstructor  //Essa anotação cria construtor com todos os atributos.
@Builder //Desing Pattern
@Data //Faz os getters@setters
@Entity //Coloca/mapeia os objetos construídos a partir dessa classe num banco de dados.
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"}) //Ignora erros de Json na execução do código.
@NoArgsConstructor //Cria o objeto vazio/sem parâmetros para conseguir usar o Hibernate.
public class Sacola {
    @Id
    //necessário para identificar a sacola,
    //pois estamos trabalhando com um banco de dados relacional.
    @GeneratedValue(strategy = GenerationType.AUTO)
    //Atribui alor padrão para as chaves, o provedor de persistência escolhe a estratégia mais adequada de acordo com o banco de dados.
    //Outras opções são:
    //Identity:
    //Sequence:
    //Table:
    private Long id;
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JsonIgnore
    private Cliente cliente;
    @OneToMany(cascade = CascadeType.ALL)
    private List<Item> itens;
    private Double valorTotal;

    @Enumerated
    private me.dio.sacola.Enumeration.FormaPagamento FormaPagamento;
    private boolean fechada;

}
