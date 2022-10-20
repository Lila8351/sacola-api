package me.dio.sacola.Model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;

@AllArgsConstructor
@Builder
@Data
@Embeddable //complementar ao @Embedded, que salva essas informações de serem registradas no banco de dados.
//Isso torna possível o reaproveitamento de código, já que o endereço do cliente é um dado privado,
//embora o do restaurante não seja necessariamente.
@NoArgsConstructor
public class Endereco {
    private String cep;
    private String complemento;
}
