package Sofka;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Jugador {
    private final String idJugador;
    private final String username;
    private String email;
    private List<Integer> puntos;



    public Jugador(String idJugador, String email, String username) {
        this.idJugador = idJugador;
        this.email = email;
        this.puntos = new ArrayList<>();
        this.username = username;
    }

    public void setEmail(String email){
        this.email = email;
    }

    public void agregarPunto(Integer punto){
        this.puntos.add(punto);
    }

    public List<Integer> puntos() {
        return Collections.singletonList(puntos.stream().reduce(Integer::sum).orElseThrow());
    }

    @Override
    public String toString() {
        return "Jugador{" +
                "idJugador='" + idJugador + '\'' +
                ", email='" + email + '\'' +
                ", puntos=" + puntos +
                ", username='" + username + '\'' +
                '}';
    }
}
