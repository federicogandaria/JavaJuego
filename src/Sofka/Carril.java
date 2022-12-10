package Sofka;
import java.util.ArrayList;
import java.util.Objects;
import java.util.List;

public class Carril {
    private final Integer numero;
    private final Integer Kilometros;

    private final List<Carro> carros;

    public Carril(Integer numero, Integer Kilometros) {
        this.carros = new ArrayList<>();
        this.Kilometros =Kilometros = Objects.requireNonNull(Kilometros);
        this.numero = Objects.requireNonNull(numero);

        if (Kilometros <= 0 ) {
            throw  new IllegalArgumentException("Eso no es un kilometro valido");
        }

    }
    public  void agregarCarro(Carro carro){
        carros.add(carro);
    }

    public Integer Kilometros(){
        return  Kilometros;
    }

    public Integer numero(){
        return  numero;
    }

    public  List<Carro> carros() {return  carros;}

    public double progresoCarro(String placa){
        for (Carro carro: this.carros) {
            if (carro.placa().equalsIgnoreCase(placa)){
                int metros = Kilometros()*1000;
                return  (100* carro.metros())/metros;
            }
        }
        throw new IllegalArgumentException("No existe el carro");
    }

}