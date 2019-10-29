package com.bbva.localizacion.service;

import java.util.Optional;

import com.bbva.localizacion.error.InvalidRetoException;
import com.bbva.localizacion.model.RetoDocument;
import com.bbva.localizacion.repo.RetoRepo;
import com.bbva.localizacion.service.api.IRetoServ;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
//import org.springframework.mail.SimpleMailMessage;
//import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class RetoServ implements IRetoServ{

    @Autowired
    RetoRepo torneoRepo;

/*     @Autowired
    private JavaMailSender email; */

    String equipo, personaje, clase;

    @Override
    public int saveRegistro(RetoDocument document) {
        try {
            // String correo = document.getLocalizacion();
            torneoRepo.save(document);
            return 200;
/*             if (!torneoRepo.findByCorreo(document.getCorreo()).isPresent()) {
                equipo = document.getEquipo();
                personaje = document.getPersonaje();
                clase = document.getClase();
                enviarCorreo(correo, "Registro correcto", 
                "Listo para el torneo!\nTú escogiste el equipo de "+equipo+
                ":\n- "+personaje+"\n- Clase "+clase+"\n\nBuena Suerte!");
                torneoRepo.save(document);
                return 200;
            } else {
                enviarCorreo(correo, "Registro existente", 
                "Perdon! pero su correo ya ha sido registrado\nTú escogiste el equipo de "+equipo+
                ":\n- "+personaje+"\n- Clase "+clase+"\n\n");
                return 500;
            } */
        } catch (MailException e) {
            throw new InvalidRetoException("Error en el Services, desconecte su Antivirus");
        }
    }

/*     @Override
    public void enviarCorreo(String correo, String asunto, String texto) throws MailException{
        SimpleMailMessage mensaje = new SimpleMailMessage();
        mensaje.setTo(correo);
        mensaje.setSubject(asunto);
        mensaje.setText(texto);
        email.send(mensaje);
    } */

    @Override
    public Optional<RetoDocument> findLocalizacion(String equipo) {
      return torneoRepo.findByLocalizacion(equipo);
    }

    /*
     * @Override public Optional<TorneoDocument> saveRegistro(TorneoDocument
     * document) { torneoRepo.save(document); return
     * torneoRepo.findById(document.getId()); }
     */
}