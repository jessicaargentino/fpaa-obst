package dicionario;

public class Dicionario {
    private String palavra;

    Dicionario(String dicionario) {
        this.palavra = dicionario;
    }

    public String getPalavra() {
        return palavra;
    }

    public void setPalavra(String palavra) {
        this.palavra = palavra;
    }

    public void print() {
        System.out.printf("Palavra: %s", this.palavra);
    }
}
