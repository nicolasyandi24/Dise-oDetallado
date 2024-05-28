# DisenoDetallado
Tarea semana 13, patrones de sieño
- Para desarrollar la tarea se implemento lo siguiente

1. Declaración de la clase Unico:
""""""
public class Unico implements Serializable {
    private static final long serialVersionUID = 1L;

"""""
La clase Unico implementa Serializable para permitir que su instancia sea serializada. La constante serialVersionUID se utiliza para verificar la compatibilidad de la versión durante la deserialización.

2. Clase interna SingletonHolder:

****
    private static class SingletonHolder {
        private static final Unico INSTANCE = new Unico();
    }
****
La clase interna estática SingletonHolder contiene una única instancia estática de Unico. Esta clase no se cargará en memoria hasta que se invoque getUnico(), implementando así el patrón de inicialización bajo demanda (Lazy Initialization). 

3. Constructor privado:

*****
    private Unico() {
        if (SingletonHolder.INSTANCE != null) {
            throw new IllegalStateException("Ya existe una instancia de Unico");
        }
    }
******
El constructor de la clase es privado para evitar que se creen nuevas instancias de Unico desde fuera de la clase. Además, verifica si ya existe una instancia (a través de SingletonHolder.INSTANCE), y lanza una excepción si alguien intenta crear una nueva instancia mediante técnicas de reflexión.

4. Método getUnico():

*****
    public static Unico getUnico() {
        return SingletonHolder.INSTANCE;
    }
*****

Este método público y estático proporciona un punto de acceso global a la instancia única de Unico. Devuelve la instancia desde SingletonHolder.

5. Método readResolve():

*****
    private Object readResolve() throws ObjectStreamException {
        return getUnico();
    }
*****
Este método se llama durante la deserialización del objeto. Garantiza que la deserialización no rompa el patrón Singleton al devolver siempre la instancia única de Unico.

6. Método main():

*****
    public static void main(String[] args) {
        Unico instance1 = Unico.getUnico();
        Unico instance2 = Unico.getUnico();
        System.out.println("Las instancias son iguales: " + (instance1 == instance2));
    }
*****
Este es el punto de entrada del programa. En el método main, se obtienen dos referencias a la instancia de Unico y se compara si ambas referencias son iguales. Si el patrón Singleton está implementado correctamente, ambas referencias apuntarán a la misma instancia, y el programa imprimirá "Las instancias son iguales: true".
