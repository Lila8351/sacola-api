package me.dio.sacola.Repository;

import me.dio.sacola.Model.Sacola;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository //conecta a interface com banco de dados
public interface SacolaRepository extends JpaRepository<Sacola, Long> {
}
