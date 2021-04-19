package busqueda_anchura;

import java.util.LinkedList;

/**
 *
 * @author Suriel
 */
/* Clase BFS, la cual ejecutará el algoritmo de búsqueda en anchura.
 * En ella tenemos como atributo a la matriz, el nodo de entrada y salida
 * y a la lista v donde cada nodo de dicha lista,
 * contiene a su vez una lista de adyacentes.*/
public class BFS {
    private Nodo matriz[][];
    private Nodo entrada, salida;
    private LinkedList<Nodo> v;

    public BFS(Nodo matriz[][], Nodo origen, Nodo destino) {
        this.matriz = matriz;
        this.entrada = origen;
        this.salida = destino;
        //v=new LinkedList();
    }

    public LinkedList<Nodo> getV() {
        return v;
    }
    
    // Implementación del algoritmo búsqueda en amplitud. 
    public LinkedList<Nodo> busquedaAmplitud(){
        // Usamos las variables r y c para guardar la posición en la que estamos.
        int r=entrada.getX();// Obtenemos la posición r del nodo de entrada.
        int c=entrada.getY();// Obtenemos la posición c del nodo de entrada.
        int i,j;
        v.add(entrada);// Añadimos el nodo de entrada a la lista v.
        entrada.setVisitado(true);// Marcamos el nodo de entrada como visitado.
        // Nos movemos hacia arriba usando los operadores, y asignamos la
        // posición en las variables i,j.
        i=r-1;
        j=c;
        // Comparamos que las variables i,j no se salgan fuera del rango de la matriz.
        if((i>-1 && i<matriz.length) && (j>-1 && j<matriz[0].length)){
            // Comprobamos si el nodo en la posición i,j ha sido visitado y si es distinto de una pared.
            if(!matriz[i][j].isVisitado() && matriz[i][j].getTipo()!='#'){
                matriz[i][j].setVisitado(true);// Marcamos el nodo como visitado.
                // Añadimos el nodo en la posición i,j
                // a la lista de adyacentes(w) del nodo en la posición r,c.
                matriz[r][c].getW().add(matriz[i][j]);
            }
        }
        // Ahora nos movemos hacia la derecha.
        i=r;
        j=c+1;
        if((i>-1 && i<matriz.length) && (j>-1 && j<matriz[0].length)){
            if(!matriz[i][j].isVisitado() && matriz[i][j].getTipo()!='#'){
                matriz[i][j].setVisitado(true);
                matriz[r][c].getW().add(matriz[i][j]);
            }
        }
        // Ahora hacia abajo.
        i=r+1;
        j=c;
        if((i>-1 && i<matriz.length) && (j>-1 && j<matriz[0].length)){
            if(!matriz[i][j].isVisitado() && matriz[i][j].getTipo()!='#'){
                matriz[i][j].setVisitado(true);
                matriz[r][c].getW().add(matriz[i][j]);
            }
        }
        // Ahora nos movemos hacia la izquierda.
        i=r;
        j=c-1;
        if((i>-1 && i<matriz.length) && (j>-1 && j<matriz[0].length)){
            if(!matriz[i][j].isVisitado() && matriz[i][j].getTipo()!='#'){
                matriz[i][j].setVisitado(true);
                matriz[r][c].getW().add(matriz[i][j]);
            }
        }
        
        // Ahora procedemos a realizar un ciclo que irá agregando los nodos a la lista v
        // e irá asignando los nodos adyacentes para cada nodo.
        
        // Declaramos una variable auxiliar, que nos indicará si ya llegamos al nodo de salida.
        int aux=0;
        for (int k = 0; aux==0; k++) {// Este primer ciclo llevará el control de la lista v.
            /* Este segundo ciclo, llevará el control de los adyacentes de cada nodo en v. */
            for (int l = 0; l < v.get(k).getW().size(); l++) {
                v.add(v.get(k).getW().get(l));// Añadimos a la lista v cada nodo adyacente de v(k).
                r=v.get(k).getW().get(l).getX();// Obtenemos la posición r de cada nodo adyacente en v(k).
                c=v.get(k).getW().get(l).getY();// Obtenemos la posición c de cada nodo adyacente en v(k).
                // Nos movemos hacia arriba.
                i=r-1;
                j=c;
                // Comparamos que las variables i,j no se salgan fuera del rango de la matriz.
                if((i>-1 && i<matriz.length) && (j>-1 && j<matriz[0].length)){
                    // Comprobamos si el nodo en la posición i,j ha sido visitado y si es distinto de una pared.
                    if(!matriz[i][j].isVisitado() && matriz[i][j].getTipo()!='#'){
                        matriz[i][j].setVisitado(true);
                        // Añadimos el nodo en la posición i,j
                        // a la lista de adyacentes(w) del nodo en la posición r,c.
                        matriz[r][c].getW().add(matriz[i][j]);
                        // Comprobamos si el nodo visitado es el nodo de salida.
                        // Si es así marcamos el auxiliar con 1.
                        if(matriz[i][j] == salida){
                            aux=1;
                            break;
                        }
                    }
                }
                // Nos movemos a la derecha.
                i=r;
                j=c+1;
                if((i>-1 && i<matriz.length) && (j>-1 && j<matriz[0].length)){
                    if(!matriz[i][j].isVisitado() && matriz[i][j].getTipo()!='#'){
                        matriz[i][j].setVisitado(true);
                        matriz[r][c].getW().add(matriz[i][j]);
                        if(matriz[i][j] == salida){
                            aux=1;
                            break;
                        }
                    }
                }
                // Nos movemos hacia abajo.
                i=r+1;
                j=c;
                if((i>-1 && i<matriz.length) && (j>-1 && j<matriz[0].length)){
                    if(!matriz[i][j].isVisitado() && matriz[i][j].getTipo()!='#'){
                        matriz[i][j].setVisitado(true);
                        matriz[r][c].getW().add(matriz[i][j]);
                        if(matriz[i][j] == salida){
                            aux=1;
                            break;
                        }
                    }
                }
                // Nos movemos hacia la izquierda.
                i=r;
                j=c-1;
                if((i>-1 && i<matriz.length) && (j>-1 && j<matriz[0].length)){
                    if(!matriz[i][j].isVisitado() && matriz[i][j].getTipo()!='#'){
                        matriz[i][j].setVisitado(true);
                        matriz[r][c].getW().add(matriz[i][j]);
                        if(matriz[i][j] == salida){
                            aux=1;
                            break;
                        }
                    }
                }
            }
        }
        // Ejecutamos el backtracking para obtener la ruta y la retornamos en forma de lista.
        return backTracking();
    }
    
    // Implementación del backtracking para obtener la ruta.
    public LinkedList<Nodo> backTracking(){
        // Creamos una lista (ruta) donde guardaremos la ruta obtenida.
        LinkedList<Nodo> ruta=new LinkedList();
        // Añadimos a la lista el último nodo adyacente en w, del último nodo
        // en la lista v, ya que en esa posición siempre quedará el nodo de salida.
        ruta.add(v.getLast().getW().getLast());
        // Ejecutamos un ciclo que recorrerá la lista v de fin a inicio.
        for (int i = v.size()-1; i > -1; i--) {
            // Verificamos si la lista de adyacente w en cada nodo v(i),
            // contiene al último nodo ingresado a la ruta.            
            if(v.get(i).getW().contains(ruta.getLast())){
                // Añadimos a la ruta el nodo v(i).
                ruta.add(v.get(i));
            }
        }
        // Retornamos la ruta obtenida.
        return ruta;
    }
    
}
