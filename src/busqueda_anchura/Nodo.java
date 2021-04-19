package busqueda_anchura;

import java.util.LinkedList;

/**
 *
 * @author Suriel
 */
/* Clase Nodo, cada nodo tiene un tipo: muro(#), espacio libre(o), entrada(I), salida(S).
 * Un atributo booleano para saber si ya fue visitado.
 * Sus coordenadas x, y.
 * Y su lista de nodos adyacentes w.*/
public class Nodo {
    private char tipo;
    private boolean visitado;
    private int x;
    private int y;
    private LinkedList<Nodo> w;

    public Nodo(char tipo) {
        this.tipo = tipo;
        this.visitado = false;
        this.w = new LinkedList();
    } 

    public char getTipo() {
        return tipo;
    }

    public void setTipo(char tipo) {
        this.tipo = tipo;
    }

    public boolean isVisitado() {
        return visitado;
    }

    public void setVisitado(boolean visitado) {
        this.visitado = visitado;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public LinkedList<Nodo> getW() {
        return w;
    }
    
}
