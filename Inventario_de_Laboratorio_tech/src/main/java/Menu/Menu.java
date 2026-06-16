package Menu;

import Computador.Computador;

public class Menu {


    public void menuUsuario () {
        Computador comput = new Computador();
        System.out.println("Lendo o doc");
        comput.leitorTXT();
    }
}
