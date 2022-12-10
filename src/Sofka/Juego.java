package Sofka;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.UUID;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.stream.IntStream;

public class Juego {

    private final Podium podium;
    private final  Pista pista;
    private Estado estado;
    private Carril Carril;


    public Juego(Integer numCarriles, Integer kilometros, String nombreDePista) {
        Map<Integer, Carril> carriles = generarCarriles( numCarriles, kilometros);
        pista = new Pista(UUID.randomUUID().toString(), carriles, nombreDePista);
        this.podium = new Podium();
        estado = Estado.NO_INICIADO;

    }

    public  Podium iniciarJuego(){
        validarCarriles();
        iniciarCarros();
        do {
            estado = Estado.INICIADO;
            pista.carriles().forEach(moverEnCarril());
        } while ( estado.equals(Estado.INICIADO));
        return  podium;
    }

    public  void agregarCarroAlCarril(Integer carril, Carro carro){
        if (Objects.isNull(carro.conductor())){
            throw  new IllegalArgumentException("El carro no tiene conductor");
        }
        pista.agregarCarroACarril(carril,carro);

    }

    private Map <Integer, Carril> generarCarriles(Integer numCarriles, Integer kilometros){
        Map<Integer, Carril> carriles = new HashMap<>();
        for (int i =1;   numCarriles >= i; i++){
            carriles.put(i, new Carril(i, kilometros));

        }
        return  carriles;

    }

    private Consumer <Carro> moverCarro (Carril carril)
    {
        return carro -> {
            int dado = carro.conductor().lanzarDado();
            IntStream.range(0, dado*100).forEach(value -> carro.aumentarMetro());
            determinarGanador(Carril, carro);
        };
    }



    private void validarCarriles(){
        int cantidaddeCarros = 0;
        for (Carril carril: pista.carriles().values()){
            cantidaddeCarros = carril.carros().size() + cantidaddeCarros;
        }
        if (cantidaddeCarros <= 2) {
            throw  new IllegalArgumentException("No tiene la cantidad de carros suficientes");
        }
    }

    private void iniciarCarros(){
        pista.carriles().values().forEach(carril -> carril.carros().forEach(Carro::iniciar));
    }

    private BiConsumer<Integer, Carril> moverEnCarril(){
        return  (id, carril) -> carril.carros().forEach(moverCarro(carril));
    }

    private void determinarGanador(Carril carril, Carro carro){
        if (carro.EstaEnMarcha()){
            double progreso = carril.progresoCarro(carro.placa());
            if (progreso>=100){
                determinarPodium(carro);
            }
        }
    }

    private  void determinarPodium (Carro carro){
        if (Objects.isNull((podium.primero()))){
            podium.setPrimero(carro.conductor());
            carro.pararMarcha();
        }
        else  if (Objects.isNull((podium.segundo()))){
            podium.setSegundo(carro.conductor());
            carro.pararMarcha();
        }
        if (Objects.isNull((podium.tercero()))){
            podium.setTercero(carro.conductor());
            carro.pararMarcha();
            finDelJuego();
        }
    }


    private  void finDelJuego(){
        estado = Estado.FINALIZADO;
    }


    public  enum  Estado{
        INICIADO, FINALIZADO, NO_INICIADO
    }


}