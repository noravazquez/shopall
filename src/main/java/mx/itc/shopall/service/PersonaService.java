package mx.itc.shopall.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mx.itc.shopall.model.Persona;
import mx.itc.shopall.repository.PersonaRepository;

@Service
public class PersonaService {
    @Autowired
    PersonaRepository personaRepository;
    
    public List<Persona> getAll(){
        List<Persona> personas = new ArrayList<>();
        for (Persona persona : personaRepository.findAll()) {
            personas.add(persona);
        }
        return personas;
    }
    
    public void add(Persona persona){
        personaRepository.save(persona);
    }
}
