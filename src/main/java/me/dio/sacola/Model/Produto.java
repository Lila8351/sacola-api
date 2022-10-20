package me.dio.sacola.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@AllArgsConstructor
@Builder
@Data
@Entity
@JsonIgnoreProperties
@NoArgsConstructor
public class Produto  {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nome;
    private double valorUnitario;
    @Builder.Default//significa que sempre que um produto é adicionado pelo restaurante o default dele é
    // true para disponivel.
    private boolean disponivel = true;
    @ManyToOne //many produtos para one restaurante
    @OneToMany //porque um produto pode corresponder a vários itens (quantidade)
    @JsonIgnore
    private Restaurante restaurante;
    private Item item;
}
