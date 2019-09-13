package br.com.challengebackend.challengebackend.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.com.challengebackend.challengebackend.modelo.Itens;

public interface ItensRepository extends JpaRepository<Itens, Long>{

}
