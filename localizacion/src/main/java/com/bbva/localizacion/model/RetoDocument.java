package com.bbva.localizacion.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Document(collection = "reto")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class RetoDocument {

    @Id
    String id;

    @Field("localizacion")
    String localizacion;

    @Field("lat")
    String lat;

    @Field("lon")
    String lon;
    
}