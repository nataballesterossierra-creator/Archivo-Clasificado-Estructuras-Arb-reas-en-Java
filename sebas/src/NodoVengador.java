public class NodoVengador {
    int dato;
    String nombre;
    NodoVengador izquierdo;
    NodoVengador derecho;

    // Nodo numérico (niveles de seguridad)
    public NodoVengador(int dato) {
        this.dato = dato;
        this.izquierdo = null;
        this.derecho = null;
    }

    // Nodo con nombre (reinos de Yggdrasil)
    public NodoVengador(String nombre) {
        this.nombre = nombre;
        this.izquierdo = null;
        this.derecho = null;
    }
}