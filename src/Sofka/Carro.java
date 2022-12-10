package Sofka;
import java.util.Objects;

public class Carro {

    private final Color color;
    private  final String placa;
    private Conductor conductor;
    private Integer metros;
    private boolean estaEnMarcha;

    public Carro(Color color,  String placa  , Integer metros) {
        this.color = Objects.requireNonNull(color);
        this.placa = Objects.requireNonNull(placa);
        this.metros = Objects.requireNonNull(metros);
        if (metros < 0) {
            throw new IllegalArgumentException("no se puede tener metros negativos");
        }
    }

    public Carro(Color color,  String placa ) {
        this (color, placa, 0);

    }
    public  void  agregarConductor(Conductor conductor) {
        this.conductor = Objects.requireNonNull(conductor);
    }



    public double metros() {
        return metros;
    }

    public  Conductor conductor(){
        return  conductor;
    }

    public  Color color(){
        return  color;
    }

    public  String placa(){
        return  placa;
    }


    public enum Color {

        ROJO, BLANCO, NEGRO, AZUL
    }

    public void iniciar(){
        this.estaEnMarcha = true;
    }
    public void aumentarMetro(){
        if  (this.estaEnMarcha){
            this.metros = metros +1;
        }
    }
    public void pararMarcha(){
        this.estaEnMarcha = false;
    }

    public boolean EstaEnMarcha() {
        return estaEnMarcha;
    }

    public double kilometros() {
        return Math.ceil((double)metros/1000);
    }
    @Override
    public  String toString(){
        return "Carro{"+
                "color=" +color+
                ",placa='" + placa +'\'' +
                ",conductor =" + conductor +
                ", metros=" + metros +
                '}';
    }
}

