
import java.util.Scanner;

public class Main {
    static boolean hayArbol(ArbolBinario arbol) {
        if (arbol.raiz == null) {
            System.out.println("El árbol está vacío. Primero ejecuta la Misión 2 (Nivel 1).");
            return false;
        }
        return true;
    }
    public static void main(String[] args) {

        Scanner teclado = new Scanner(System.in);
        ArbolBinario yggdrasil = new ArbolBinario();
        ArbolBinario shield = new ArbolBinario();
        int opc, op;

        do{
            System.out.println(" \n ===== INICIATIVA VENGADORES =======");
            System.out.println("0. Salir");
            System.out.println("1. Nivel 1: \n        *El Árbol de Yggdrasil. \n        *Base de Datos de S.H.I.E.L.D. \n        *El Radar de Heimdall. ");
            System.out.println("2. Nivel 2: \n        *Protocolo InOrden de Stark, \n        *Respaldo de Visión (PreOrden), \n        *Explosión de Sokovia (PostOrden),\n        *El Multiverso (Contar Nodos) ");
            System.out.println("3. Nivel 3: \n        *Búsqueda de las Gemas (Min/Max). \n        *Caída de la Torre Stark. \n        *El Chasquido (Eliminar Nodo).");
            System.out.println("\n Selecciona una opción: ");

            opc = teclado.nextInt();

            switch (opc) {

                case 1:
                    do {
                        System.out.println("\n===== NIVEL 1 =====");
                        System.out.println("1. El Árbol de Yggdrasil ");
                        System.out.println("2. Base de Datos de S.H.I.E.L.D.");
                        System.out.println("3. El Radar de Heimdall");
                        System.out.println("0. Regresar al menú principal");
                        System.out.print("Seleccione una misión: ");
                        op = teclado.nextInt();
                        System.out.println("\n");
                        switch (op) {
                            case 1:
                                System.out.println( "");
                                yggdrasil.ArbolYggdrasil();
                                yggdrasil.mostrarYggdrasil();
                                System.out.println("");
                                break;
                            case 2:
                                int[] niveles = {50, 30, 70, 40,60, 90, 20};
                                for (int n : niveles) shield.insertar(n);
                                System.out.println("Niveles de seguridad registrados:"  );
                                shield.dibujarLateral(shield.raiz, 0);
                                break;
                            case 3:
                                if (hayArbol(shield)) {
                                    System.out.print("Ingresa la amenaza a buscar: ");
                                    int amenaza = teclado.nextInt();
                                    System.out.println("¿La amenza N° " + amenaza + " en verdad existe? " + shield.buscar(amenaza));
                                }

                                break;
                            case 0:
                                System.out.println("Redirigiendo al menú principal...");
                                break;
                            default:
                                System.out.println("Error.");
                        }
                    } while (op != 0);
                    break;
                case 2:
                    do {
                        System.out.println("\n===== NIVEL 2 =====");
                        System.out.println("4. Protocolo InOrden de Stark ");
                        System.out.println("5. Respaldo de Visión (PreOrden)");
                        System.out.println("6. Explosión de Sokovia (PostOrden)");
                        System.out.println("7. El Multiverso (Contar Nodos)");
                        System.out.println("0. Regresar al menú principal");
                        System.out.print("Seleccione una misión:  ");
                        op = teclado.nextInt();
                        System.out.println("\n");

                        switch (op) {
                            case 4:
                                if (hayArbol(shield)) {
                                    System.out.print("InOrden: ");
                                    shield.inOrden(shield.raiz);
                                    System.out.println();
                                }
                                break;
                            case 5:
                                if (hayArbol(shield)) {
                                    System.out.print("PreOrden: ");
                                    shield.preOrden(shield.raiz);
                                    System.out.println();
                                }
                                break;
                            case 6:
                                if (hayArbol(shield)) {
                                    System.out.print("PostOrden: ");
                                    shield.postOrden(shield.raiz);
                                    System.out.println();

                                }
                                break;
                            case 7:
                                if (hayArbol(shield)) {
                                    System.out.println("Lineas temporales exploradas: " + shield.contarLineas(shield.raiz));
                                }
                                break;
                            case 0:
                                System.out.println("Redirigiendo al menú principal...");
                                break;
                            default:
                                System.out.println("Error.");
                        }
                    } while (op != 0);
                    break;
                case 3:
                    do {
                        System.out.println("\n===== NIVEL 3 =====");
                        System.out.println("8. Búsqueda de las Gemas (Min/Max) ");
                        System.out.println("9. Caída de la Torre Stark");
                        System.out.println("10. El Chasquido (Eliminar Nodo)");
                        System.out.println("0. Regresar al menú principal");
                        System.out.print("Seleccione una misión: ");
                        op = teclado.nextInt();
                        System.out.println("\n");
                        switch (op) {
                            case 8:
                                if (hayArbol(shield)) {
                                    System.out.println("Rango de nuestras gemas: ");
                                    System.out.println("Gema de menor poder: " + shield.encontrarMenor());
                                    System.out.println("Gema de mayor poder: " + shield.encontrarMayor());
                                }
                                break;
                            case 9:
                                if (hayArbol(shield)) {
                                    System.out.println("Altura del árbol: " + shield.calcularAltura(shield.raiz));
                                }
                                break;
                            case 10:
                                if (hayArbol(shield)) {
                                    System.out.print("Antes:   ");
                                    System.out.println();
                                    shield.dibujarLateral(shield.raiz, 0);
                                    System.out.println();

                                    System.out.print("Valor a eliminar: ");
                                    int valor = teclado.nextInt();
                                    if (shield.buscar(valor)) {
                                        shield.eliminar(valor);
                                        System.out.println("El " + valor + " fue eliminado.");
                                    } else {
                                        System.out.println("El " + valor + " no existe en el árbol.");
                                    }

                                    System.out.print("Después: ");
                                    System.out.println();
                                    shield.dibujarLateral(shield.raiz, 0);
                                    System.out.println();
                                }
                                break;
                            case 0:
                                System.out.println("Redirigiendo al menú principal...");
                                break;
                            default:
                                System.out.println("Error.");
                        }
                    } while (op != 0);
                    break;

                case 0:
                    System.out.println("");
                    System.out.println( " <<<<<<<<<<<<<<<<<<<<<<<<=========>>>>>>>>>>>>>>>>>>>>>>>>>><");
                    System.out.println(" ARCHIVO CLASIFICADO: ESTRUCTURAS ARBÓREAS ");
                    System.out.println("Estado: MISIONES COMPLETADAS (10/10) ");
                    System.out.println(" MISION FINALIZADA. S.H.I.E.L.D ha optimizado sus bases de datos jerarquicas. ");
                    System.out.println("\n Fin de la transimisión. Cerrando sistema......");


                    break;

                default:
                    System.out.println("Opción inválida Recluta....");

            }
        } while (opc != 0);
    }
}