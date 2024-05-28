import java.io.ObjectStreamException;
import java.io.Serializable;

public class Unico implements Serializable {
    private static final long serialVersionUID = 1L;

    // Instancia única de la clase, utilizando el patrón de inicialización bajo demanda
    private static class SingletonHolder {
        private static final Unico INSTANCE = new Unico();
    }

    // Constructor privado para evitar la instanciación directa
    private Unico() {
        // Prevenir la creación de otra instancia mediante reflexión
        if (SingletonHolder.INSTANCE != null) {
            throw new IllegalStateException("Ya existe una instancia de Unico");
        }
    }

    // Método para obtener la instancia única
    public static Unico getUnico() {
        return SingletonHolder.INSTANCE;
    }

    // Manejo de la serialización para mantener el Singleton
    private Object readResolve() throws ObjectStreamException {
        return getUnico();
    }

    // Método main para ejecutar el programa
    public static void main(String[] args) {
        // Obtener la instancia del Singleton
        Unico instance1 = Unico.getUnico();
        Unico instance2 = Unico.getUnico();

        // Verificar si ambas instancias son iguales
        System.out.println("Las instancias son iguales: " + (instance1 == instance2));
    }
}
