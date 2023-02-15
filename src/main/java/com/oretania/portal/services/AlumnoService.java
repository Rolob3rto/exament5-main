package com.oretania.portal.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.oretania.portal.models.Alumno;
import com.oretania.portal.models.Asignatura;
import com.oretania.portal.repositories.AlumnoRepository;

@Service
public class AlumnoService {
    

    @Autowired
    AlumnoRepository repository;

    public List<Alumno> findAll(){
        return null;
    }
    
    public UserDetails loadUserByUserName(String username) throws UsernameNotFoundException{

        Alumno alumno = repository.findByUserName(username);

        List<Asignatura> asignaturas = alumno.getAsignaturas();
        List<GrantedAuthority> asignaturasCodigo = new ArrayList<>();

        for (Asignatura asignatura : asignaturas) {
            asignaturasCodigo.add(new SimpleGrantedAuthority(asignatura.getCodigo()));
        }
        UserDetails user = User.builder()
            .username(alumno.getUserName())
            .password(alumno.getPassword())
            .authorities(asignaturasCodigo)
            .build();
        return user;
    }

}
