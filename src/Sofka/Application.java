package Sofka;

public class Application
{
    public static  void main(String[] args){

        int numCarriles =3;
        int kilometros = 200;
        Juego juego = new Juego(numCarriles, kilometros, "Pista#Los Andes");

        Carro rojo = new Carro(Carro.Color.ROJO, "xx1");
        rojo.agregarConductor(new Conductor("C1", "Raul", "raul@gmail.com", "Raul"));
        Carro azul = new Carro(Carro.Color.AZUL, "xx2");
        azul.agregarConductor(new Conductor("C2", "Andres", "Andres@gmail.com", "Andres"));
        Carro blanco = new Carro(Carro.Color.BLANCO, "xx3");
        blanco.agregarConductor(new Conductor("C3", "Pedro", "Pedro@gmail.com", "Pedro"));
        Carro negro = new Carro(Carro.Color.NEGRO, "xx4");
        negro.agregarConductor(new Conductor("C4", "Ana", "ana@gmail.com", "Ana"));


        juego.agregarCarroAlCarril(1, rojo);
        juego.agregarCarroAlCarril(2, azul);
        juego.agregarCarroAlCarril(3, blanco);
        juego.agregarCarroAlCarril(4, negro);


        Podium podium = juego.iniciarJuego();
        System.out.println(podium);


    }
}