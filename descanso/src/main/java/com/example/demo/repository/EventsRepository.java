package com.example.demo.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.domain.Events;

public interface EventsRepository extends JpaRepository<Events, Integer>  {

}
