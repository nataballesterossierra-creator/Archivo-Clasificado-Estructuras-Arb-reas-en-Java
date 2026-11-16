public class NodoVengador {
    int dato;
    String nombre;
    NodoVengador izquierdo;
    NodoVengador derecho;

    public NodoVengador(int dato) {
        this.dato = dato;
        this.izquierdo = null;
        this.derecho = null;
    }
    public NodoVengador (String nombre){
        this.nombre = nombre;
        this.izquierdo = null;
        this.derecho = null;
    }
    public NodoVengador(int dato, String nombre) {
        this(dato);
        this.nombre = nombre;
    }
}


