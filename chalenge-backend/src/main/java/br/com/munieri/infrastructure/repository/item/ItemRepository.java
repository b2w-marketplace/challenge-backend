package br.com.munieri.infrastructure.repository.item;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<ItemEntity, Long>, ItemRepositoryCuston{
}
