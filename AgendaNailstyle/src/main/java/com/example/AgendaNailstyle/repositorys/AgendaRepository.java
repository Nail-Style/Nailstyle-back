package com.example.AgendaNailstyle.repositorys;

import com.example.AgendaNailstyle.models.Agenda;
import org.springframework.data.jpa.repository.JpaRepository;



public interface AgendaRepository extends JpaRepository<Agenda, Long> {

}
