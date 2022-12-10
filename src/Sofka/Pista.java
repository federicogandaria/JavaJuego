package Sofka;
import java.util.Map;
import java.util.Set;

public class Pista {
    private final Map<Integer, Carril> carriles;
    private final String id;
    private String nombre;


    public Pista(String id, Map<Integer, Carril> carriles, String nombre){
        this.id = id;
        this.carriles = carriles;
        this.nombre = nombre;
    }

    public  void  cambiarNombre(String nombre){
        this.nombre = nombre;
    }

    public String id (){
        return  id;
    }
    public  String nombre (){
        return id;

    }
    public  Map<Integer,Carril> carriles(){
        return carriles;
    }

    public  void agregarCarroACarril(Integer numeroCarril, Carro carro){
        carriles.get(numeroCarril).agregarCarro(carro);

    }
}