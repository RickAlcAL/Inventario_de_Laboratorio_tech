package Equipamentos;


import java.util.List;

public class Equipamentos {
    protected String idPeca;
    protected String marcaPeca;


    public Equipamentos (String idPeca, String marcaPeca){
        this.idPeca = idPeca;
        this.marcaPeca = marcaPeca;
    }

    public Equipamentos() {

    }

    public Equipamentos(String[] dados) {
    }
}
