public class ArbolBinario {
    NodoVengador raiz;

    public ArbolBinario() {
        this.raiz = null;
    }

    public boolean estaVacio() {
        return raiz == null;
    }

    // ===================== NIVEL 1 =====================

    /* Ejercicio 1: El Árbol de Yggdrasil */
    public void crearYggdrasil() {
        raiz = new NodoVengador("Asgard");
        raiz.izquierdo = new NodoVengador("Midgard");
        raiz.derecho = new NodoVengador("Vanaheim");
    }

    public void mostrarYggdrasil() {
        if (raiz == null || raiz.nombre == null) {
            System.out.println("El árbol de Yggdrasil no ha sido creado.");
            return;
        }
        System.out.println("            " + raiz.nombre);
        System.out.println("           /       \\");
        System.out.println("      " + raiz.izquierdo.nombre + "       " + raiz.derecho.nombre);
    }

    /* Ejercicio 2: Base de Datos de S.H.I.E.L.D. (inserción BST recursiva) */
    public void insertar(int nivelSeguridad) {
        raiz = insertarRecursivo(raiz, nivelSeguridad);
    }

    private NodoVengador insertarRecursivo(NodoVengador actual, int valor) {
        if (actual == null) {
            return new NodoVengador(valor);
        }
        if (valor < actual.dato) {
            actual.izquierdo = insertarRecursivo(actual.izquierdo, valor);
        } else if (valor > actual.dato) {
            actual.derecho = insertarRecursivo(actual.derecho, valor);
        }
        // si es igual, no se inserta (sin duplicados)
        return actual;
    }

    // Dibuja el árbol de lado: la raíz a la izquierda, derecha arriba, izquierda abajo
    public void dibujarLateral(NodoVengador actual, int nivel) {
        if (actual == null) return;
        dibujarLateral(actual.derecho, nivel + 1);
        for (int i = 0; i < nivel; i++) {
            System.out.print("      ");
        }
        System.out.println(actual.dato);
        dibujarLateral(actual.izquierdo, nivel + 1);
    }

    /* Ejercicio 3: El Radar de Heimdall */
    public boolean buscar(int amenaza) {
        return buscarRecursivo(raiz, amenaza);
    }

    private boolean buscarRecursivo(NodoVengador actual, int valor) {
        if (actual == null) return false;
        if (valor == actual.dato) return true;
        if (valor < actual.dato) {
            return buscarRecursivo(actual.izquierdo, valor);
        }
        return buscarRecursivo(actual.derecho, valor);
    }

    // ===================== NIVEL 2 =====================

    /* Ejercicio 4: InOrden (Izq -> Raíz -> Der) */
    public void inOrden(NodoVengador actual) {
        if (actual == null) return;
        inOrden(actual.izquierdo);
        System.out.print(actual.dato + " ");
        inOrden(actual.derecho);
    }

    /* Ejercicio 5: PreOrden (Raíz -> Izq -> Der) */
    public void preOrden(NodoVengador actual) {
        if (actual == null) return;
        System.out.print(actual.dato + " ");
        preOrden(actual.izquierdo);
        preOrden(actual.derecho);
    }

    /* Ejercicio 6: PostOrden (Izq -> Der -> Raíz) */
    public void postOrden(NodoVengador actual) {
        if (actual == null) return;
        postOrden(actual.izquierdo);
        postOrden(actual.derecho);
        System.out.print(actual.dato + " ");
    }

    /* Ejercicio 7: El Multiverso (contar nodos) */
    public int contarLineas() {
        return contarLineas(raiz);
    }

    private int contarLineas(NodoVengador actual) {
        if (actual == null) return 0;
        return 1 + contarLineas(actual.izquierdo) + contarLineas(actual.derecho);
    }

    // ===================== NIVEL 3 =====================

    /* Ejercicio 8: Búsqueda de las Gemas (Min/Max) */
    public int encontrarMenor() {
        NodoVengador actual = raiz;
        while (actual.izquierdo != null) {
            actual = actual.izquierdo;
        }
        return actual.dato;
    }

    public int encontrarMayor() {
        NodoVengador actual = raiz;
        while (actual.derecho != null) {
            actual = actual.derecho;
        }
        return actual.dato;
    }

    /* Ejercicio 9: Caída de la Torre Stark (altura) */
    public int calcularAltura() {
        return calcularAltura(raiz);
    }

    private int calcularAltura(NodoVengador actual) {
        if (actual == null) return 0;
        int alturaIzq = calcularAltura(actual.izquierdo);
        int alturaDer = calcularAltura(actual.derecho);
        return 1 + Math.max(alturaIzq, alturaDer);
    }

    /* Ejercicio 10: El Chasquido (eliminar nodo) */
    public void eliminar(int valor) {
        raiz = eliminarRecursivo(raiz, valor);
    }

    private NodoVengador eliminarRecursivo(NodoVengador actual, int valor) {
        if (actual == null) return null;

        if (valor < actual.dato) {
            actual.izquierdo = eliminarRecursivo(actual.izquierdo, valor);
        } else if (valor > actual.dato) {
            actual.derecho = eliminarRecursivo(actual.derecho, valor);
        } else {
            // Caso 1: hoja
            if (actual.izquierdo == null && actual.derecho == null) {
                return null;
            }
            // Caso 2: un solo hijo
            if (actual.izquierdo == null) return actual.derecho;
            if (actual.derecho == null) return actual.izquierdo;

            // Caso 3: dos hijos -> sucesor inorden (menor del subárbol derecho)
            NodoVengador sucesor = menorNodo(actual.derecho);
            actual.dato = sucesor.dato;
            actual.derecho = eliminarRecursivo(actual.derecho, sucesor.dato);
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