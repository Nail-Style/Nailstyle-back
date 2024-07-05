package com.example.AgendaNailstyle.controllers;

import com.example.AgendaNailstyle.models.Usuario;
import com.example.AgendaNailstyle.repositorys.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("api/nailstyle")
public class UsuarioController {

    @Autowired
    UsuarioRepository usuarioRepository;

    // Metodo Post: Salvando novo usuario no banco de dados
    @PostMapping("/cadastrarUsuario")
    @ResponseStatus(code = HttpStatus.CREATED)
    public Usuario cadastrarUsuario (@RequestBody Usuario usuario){
        return usuarioRepository.save(usuario);
    }

    // Metodo Get: Listando todos os usuarios cadastrados no meu banco de dados
    @GetMapping("/listarUsuario")
    public List<Usuario> listarUsuario (){
        return usuarioRepository.findAll();
    }

    // Metodo Get por Id: Buscando um unico usuario pelo seu id
    @GetMapping("/{id}")
    public Usuario buscarPorId (@PathVariable Long id) {
        var clientePuxado = usuarioRepository.findById(id);
        if (clientePuxado.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        return clientePuxado.get();
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public void excluirPorId (@PathVariable Long id) {
        var clienteDeletado = usuarioRepository.findById(id);
        if (clienteDeletado.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        usuarioRepository.delete(usuarioRepository.getById(id));
    }

    @PutMapping("/{id}")
    public Usuario atualizarPorId (@PathVariable Long id, @RequestBody Usuario usuario) {
        var usuarioAtualizado = usuarioRepository.findById(id);
        if (usuarioAtualizado.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        usuario.setIdUsuario(id);
        return usuarioRepository.save(usuario);
    }

}
