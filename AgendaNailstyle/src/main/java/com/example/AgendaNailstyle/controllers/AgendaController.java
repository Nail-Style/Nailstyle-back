package com.example.AgendaNailstyle.controllers;

import com.example.AgendaNailstyle.models.Agenda;
import com.example.AgendaNailstyle.repositorys.AgendaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/nailstyle")

public class AgendaController {

    @Autowired
    AgendaRepository agendaRepository;

    // Metodo Post: Salvando uma nova agenda no banco de dados
    @PostMapping("/cadastrarHorarioAgendado")
    @ResponseStatus(code = HttpStatus.CREATED)
    public Agenda cadastrarHorarioAgendado (@RequestBody Agenda agenda) {
        return agendaRepository.save(agenda);
    }

    // Metodo Get: Listando todas as agendas cadastradas
    @GetMapping("/listarAgenda")
    public List<Agenda> listarAgenda () {
        return agendaRepository.findAll();
    }

    // Metodo Get por Id: Buscando uma unica agenda pelo id



}
