package com.bbva.localizacion.service.api;

import java.util.Optional;

import com.bbva.localizacion.model.RetoDocument;

/**
 * IRetoServ
 */
public interface IRetoServ {

    int saveRegistro(RetoDocument document);
    //void enviarCorreo(String correo, String asunto, String texto) throws MailException;
    Optional<RetoDocument> findLocalizacion(String equipo);
    
    
}