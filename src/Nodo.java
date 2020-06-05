/**
 *
 * @author JuanGalvis
 * @author SantiagoRestrepo
 */
public class Nodo {

    private char dato;
    private Nodo LD;
    private Nodo LI;
    private Nodo padre;

    public Nodo(char dato) {
        this.dato = dato;
        this.LD = null;
        this.LI = null;
    }

    public char getDato() {
        return dato;
    }

    public void setDato(char dato) {
        this.dato = dato;
    }

    public Nodo getLD() {
        return LD;
    }

    public void setLD(Nodo LD) {
        this.LD = LD;
    }

    public Nodo getLI() {
        return LI;
    }

    public Nodo getPadre() {
        return padre;
    }

    public void setPadre(Nodo padre) {
        this.padre = padre;
    }

    public void setLI(Nodo LI) {
        this.LI = LI;
    }


}
