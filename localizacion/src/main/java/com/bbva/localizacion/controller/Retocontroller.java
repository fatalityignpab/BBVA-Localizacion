package com.bbva.localizacion.controller;

import java.util.Optional;

import com.bbva.localizacion.error.InvalidRetoException;
import com.bbva.localizacion.model.ResponseCode;
import com.bbva.localizacion.model.RetoDocument;
import com.bbva.localizacion.service.api.IRetoServ;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api")
public class Retocontroller {
    @Autowired
    IRetoServ torneoService;

    @PostMapping(path = "/registro", consumes = "application/json", produces = "application/json")
    public ResponseCode registrar(@RequestBody RetoDocument document) {
        if (torneoService.saveRegistro(document) == 200) {
            return new ResponseCode(200, "Registro");
        } else {
            return new ResponseCode(500, "Correo Existente");
        }
    }

    @GetMapping(path = "/buscar/loc/{localizacion}")
      public ResponseEntity<Optional<RetoDocument>> buscarPorEquipo(
                  @PathVariable(name = "localizacion") String equipo) {
            if (torneoService.findLocalizacion(equipo).isPresent())
                  return new ResponseEntity<Optional<RetoDocument>>(torneoService.findLocalizacion(equipo),
                              HttpStatus.OK);
            else
                  throw new InvalidRetoException("Equipo: " + equipo + " no existe.");
      }
    
}