package Enums;

public enum Execoes {
    CONFIRMACAO ("Escrita confirmada !!!"),
    ERRO ("Escrita errada... tente novamente");

    private final String mensagemUsuarioFinal;

    Execoes (String mensagemUsuarioFinal){
        this.mensagemUsuarioFinal = mensagemUsuarioFinal;
    }

    public String getMensagemUsuarioFinal() {
        return mensagemUsuarioFinal;
    }
}
