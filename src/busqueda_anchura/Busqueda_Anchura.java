package busqueda_anchura;

import java.util.LinkedList;

/**
 *
 * @author Suriel
 */
public class Busqueda_Anchura {

    /**
     * @param args the command line arguments
     */ 
    public static void main(String[] args) {
        Nodo matriz[][] = new Nodo[5][7];//Creamos una matriz tipo Nodo para representar el laberinto.
        //Asignamos los nodos a la matriz como espacios libres(o) primeramente y
        // le asignamos su posición x,y.
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                matriz[i][j]=new Nodo('o');
                matriz[i][j].setX(i);
                matriz[i][j].setY(j);
            }
        }
        // Ahora solo cambiamos el tipo a los nodos de la matriz
        // que serán un muro(#), así como la entrada(I) y salida(S)
        // del laberinto.
        matriz[0][0].setTipo('I');        
        matriz[0][3].setTipo('#');        
        matriz[1][1].setTipo('#');        
        matriz[1][5].setTipo('#');        
        matriz[2][1].setTipo('#');        
        matriz[3][2].setTipo('#');
        matriz[3][3].setTipo('#');        
        matriz[4][0].setTipo('#');        
        matriz[4][2].setTipo('#');
        matriz[4][3].setTipo('s');        
        matriz[4][5].setTipo('#');
        
        // Imprimimos la matriz de entrada.
        System.out.println("Matriz de entrada");
        imprimirMatriz2(matriz);
        System.out.println("");
        // Creamos una instancia de la clase BFS, a la cual le enviamos
        // la matriz y el nodo de entrada y nodo de salida.
        BFS bfs=new BFS(matriz,matriz[0][0],matriz[4][3]);
        // Ejecutamos el algoritmo BFS y obtenemos la ruta en una lista de Nodos.
        LinkedList<Nodo> ruta=bfs.busquedaAmplitud();
        // Imprimimos la matriz después de ejecutar el algoritmo
        System.out.println("Matriz después del recorrido");
        imprimirMatriz(matriz);
        // Imprimimos la lista de adyacentes.
        System.out.println("\nLista de adyacentes\n  v\t  w");
        imprimirAdyacentes(bfs.getV());
        // Imprimimos la ruta obtenida.
        System.out.println("\nRuta obtenida");
        Nodo aux=ruta.getFirst();
        System.out.print("("+aux.getX()+","+aux.getY()+")");
        for (int i = 1; i < ruta.size(); i++) {
            aux=ruta.get(i);
            System.out.print("-("+aux.getX()+","+aux.getY()+")");
        }
        System.out.println("");
    }
    
    public static void imprimirMatriz(Nodo matriz[][]){
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                Nodo n=matriz[i][j];
                System.out.print("("+n.getX()+","+n.getY()+")"+"|"+n.getTipo()+"|"+n.isVisitado()+"\t");
            }
            System.out.println();
        }
    }
    
    public static void imprimirMatriz2(Nodo matriz[][]){
        for (int i = 0; i < matriz.length; i++) {
            int tam=matriz[i].length;
            for (int j = 0; j < tam; j++) {
                Nodo n=matriz[i][j];
                System.out.print(" ("+n.getX()+","+n.getY()+")");
                if(j<tam-1)
                    System.out.print(" |");
            }
            System.out.println("");
            for (int j = 0; j < tam; j++) {
                Nodo n=matriz[i][j];
                System.out.print("   "+n.getTipo()+"  ");
                if(j<tam-1)
                    System.out.print(" |");
            }
            System.out.println("");
            for (int j = 0; j < tam; j++) {
                Nodo n=matriz[i][j];
                System.out.print(" "+n.isVisitado()+"");
                if(j<tam-1)
                    System.out.print(" |");
            }
            System.out.println("");
            if(i<matriz.length-1){
                for (int j = 0; j < tam; j++) {
                    System.out.print("--------");
                }
            }
            System.out.println();
        }
    }
    
    public static void imprimirAdyacentes(LinkedList<Nodo> v){
        for (int i = 0; i < v.size(); i++) {
            System.out.print("("+v.get(i).getX()+","+v.get(i).getY()+")"+"\t");        
            for (int j = 0; j < v.get(i).getW().size(); j++) {
                System.out.print("("+v.get(i).getW().get(j).getX()+","+v.get(i).getW().get(j).getY()+")  ");
            }
            System.out.println("");
        }
    }
    
}
