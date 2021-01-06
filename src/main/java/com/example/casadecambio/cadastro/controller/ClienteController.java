package com.example.casadecambio.cadastro.controller;

import com.example.casadecambio.cadastro.model.Cliente;
import com.example.casadecambio.cadastro.model.dto.ClienteDTO;
import com.example.casadecambio.cadastro.service.ClienteService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/cliente")
public class ClienteController {

    @Autowired
    private ClienteService service;

    @PostMapping("/save")
    @ApiOperation("Salva o Cliente")
    public ResponseEntity<Cliente> save(@Valid @RequestBody ClienteDTO clienteDTO) {
        return ResponseEntity.ok().body(service.save(clienteDTO));
    }

    @GetMapping("{cpf}")
    @ApiOperation("Busca o cliente por CPF")
    public ResponseEntity<List<Cliente>> findByCpf(@PathVariable String cpf) {
        return ResponseEntity.ok().body(service.findByCpf(cpf));
    }
}
