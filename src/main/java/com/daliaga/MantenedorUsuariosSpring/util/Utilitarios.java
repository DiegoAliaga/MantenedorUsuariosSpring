package com.daliaga.MantenedorUsuariosSpring.util;


import com.daliaga.MantenedorUsuariosSpring.dto.TelefonoDto;
import com.daliaga.MantenedorUsuariosSpring.model.Telefono;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Utilitarios {

    public static String obtenerFechaActual(){
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatoFecha = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");
        return now.format(formatoFecha);

    }

    public static List<Telefono> agregarTelefonos(List<TelefonoDto> phones){
        List<Telefono> telefonos = new ArrayList<>();
        for(int i=0;i<phones.size();i++){
            Telefono telefono = new Telefono();
            String numero = phones.get(i).getContryCode().concat("-")+phones.get(i).getCityCode().concat("-")+phones.get(i).getNumber();
            telefono.setNumber(numero);
            telefono.setCityCode(phones.get(i).getCityCode());
            telefono.setContryCode(phones.get(i).getContryCode());
            telefonos.add(telefono);
        }
        return telefonos;
    }

    public static List<TelefonoDto> agregarTelefonosDto(List<Telefono> phones){
        List<TelefonoDto> telefonos = new ArrayList<>();
        for(int i=0;i<phones.size();i++){
            TelefonoDto telefono = new TelefonoDto();
            String numero = phones.get(i).getContryCode().concat("-")+phones.get(i).getCityCode().concat("-")+phones.get(i).getNumber();
            telefono.setNumber(numero);
            telefono.setCityCode(phones.get(i).getCityCode());
            telefono.setContryCode(phones.get(i).getContryCode());
            telefonos.add(telefono);
        }
        return telefonos;
    }
}
