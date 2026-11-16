public class ArbolBinario {
    NodoVengador raiz;

    public ArbolBinario(){
        this.raiz = null;
    }

    /// Nivel 1 ///

    /*Ejercicio N° 1: El Árbol de Yggdrasil  */
    public void  ArbolYggdrasil(){
        raiz = new NodoVengador( "Asgard");
        raiz.izquierdo = new NodoVengador("Midgard");
        raiz.derecho = new NodoVengador("Vanaheim");
    }
    public void mostrarYggdrasil() {
        System.out.println("            " + raiz.nombre);
        System.out.println("           /       \\");
        System.out.println("        " + raiz.izquierdo.nombre + "      " + raiz.derecho.nombre);
    }

    /*Ejercicio N°2: Base de Datos de S.H.I.E.L.D */
    public void insertar (int nivelSeguridad){
        raiz = insertarRegistro(raiz, nivelSeguridad);
    }
    private NodoVengador insertarRegistro(NodoVengador actual, int valor){
        if (actual == null){
            return new NodoVengador(valor);
        }
        if (valor < actual.dato){
            actual.izquierdo = insertarRegistro(actual.izquierdo,valor);
        } else if (valor > actual.dato) {
            actual.derecho = insertarRegistro(actual.derecho, valor);
        }
        return actual;
    }
    public void dibujarLateral(NodoVengador actual, int nivel) {
        if (actual == null) {
            return;
        }
        dibujarLateral(actual.derecho, nivel + 1);
        for (int i = 0; i < nivel; i++) {
            System.out.print("      ");
        }
        System.out.println(actual.dato);
        dibujarLateral(actual.izquierdo, nivel + 1);
    }

    /*Ejercicio N°3: El Radar de Heimdall*/
    public boolean buscar(int amenaza){
        return buscarRegistro (raiz, amenaza);
    }
    private boolean buscarRegistro(NodoVengador actual, int valor) {
        if (actual == null) {
            return false;
        }
        if (valor == actual.dato) {
            return true;
        }
        if (valor < actual.dato) {
            return buscarRegistro(actual.izquierdo, valor);
        } else {
            return buscarRegistro(actual.derecho, valor);
        }
    }


    ////////       Nivel 2        /////////////////////////

    /*Ejercicio N°4: Protocolo InOrden de Stark */
    public void inOrden(NodoVengador actual) {
        if (actual == null) return;            //InOrden: imprime todos los valores del árbol de menor a mayor, usando el recorrido.
        inOrden(actual.izquierdo);
        System.out.print(actual.dato + " ");
        inOrden(actual.derecho);
    }

    /*Ejercicio N°5: Respaldo de Visión (PreOrden) */
    public void preOrden(NodoVengador actual) {
        if (actual == null) return;           //preOrden: imprime todos los valores Raíz → Izquierda → Derecha. El prefijo “Pre” significa que la raíz va antes de sus hijos.
        System.out.print(actual.dato + " ");
        preOrden(actual.izquierdo);
        preOrden(actual.derecho);
    }

    /*Ejercicio N°6: Explosión de Sokovia (PostOrden) */
    public void postOrden(NodoVengador actual) {
        if (actual == null) return;             //PostOrden: imprime los valores Izquierda → Derecha → Raíz. “Post” significa que la raíz va después de sus hijos.
        postOrden(actual.izquierdo);
        postOrden(actual.derecho);
        System.out.print(actual.dato + " ");
    }

    /*Ejercicio N°7: El Multiverso (Contar Nodos) */

    public int contarLineas(NodoVengador actual){
        if (actual == null){
            return 0;
        }
        return 1 + contarLineas(actual.izquierdo)+ contarLineas(actual.derecho);
    }



    /// /////  NIVEL 3 /////////


    /*Ejercicio N°8: Búsqueda de las Gemas (Min/Max) */
    public int encontrarMenor (){
        NodoVengador actual = raiz;
        while (actual.izquierdo != null){
            actual = actual.izquierdo;
        }
        return actual.dato;
    }
    public int encontrarMayor(){
        NodoVengador actual = raiz;
        while (actual.derecho != null){
            actual = actual.derecho;
        }
        return actual.dato;
    }

    /*Ejercicio N°9: Caída de la Torre Stark*/

    public int calcularAltura(NodoVengador actual){
        if (actual == null){
            return 0;
        }
        int alturaIzquierda = calcularAltura(actual.izquierdo);
        int alturaDerecha = calcularAltura(actual.derecho);
        return 1+ Math.max(alturaIzquierda,alturaDerecha);
    }

    /*Ejercicio N°10:El Chasquido (Eliminar Nodo) */

    public void eliminar (int valor) {
        raiz = eliminarRecorrido(raiz, valor);
    }
    private NodoVengador eliminarRecorrido(NodoVengador actual, int valor){
        if (actual == null){
            return null;
        }
        if (valor < actual.dato){
            actual.izquierdo = eliminarRecorrido(actual.izquierdo, valor);
        } else if (valor > actual.dato) {
            actual.derecho = eliminarRecorrido(actual.derecho, valor);
        }else {
            if (actual.izquierdo == null && actual.derecho == null) {
                return null;                   // Caso 1: hoja
            }
            if (actual.izquierdo == null) {
                return actual.derecho;         // Caso 2: solo hijo derecho
            }
            if (actual.derecho == null) {
                return actual.izquierdo;       // Caso 2: solo hijo izquierdo
            }
            // Caso 3: dos hijos
            NodoVengador sucesor = menorNodo(actual.derecho);
            actual.dato = sucesor.dato;
            actual.derecho = eliminarRecorrido(actual.derecho, sucesor.dato);
        }
        return actual;
    }
    private NodoVengador menorNodo(NodoVengador nodo) {
        while (nodo.izquierdo != null) {
            nodo = nodo.izquierdo;
        }
        return nodo;
    }

}
