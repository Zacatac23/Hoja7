package org.example;

/**
 * Clase para representar una asociación genérica entre dos objetos, donde
 * el primer objeto es la clave y el segundo es el valor. Esta clase es
 * comparable basándose en la clave.
 *
 * @param <K> Tipo de la clave, debe ser comparable.
 * @param <V> Tipo del valor asociado a la clave.
 */
public class Association<K extends Comparable<K>, V> implements Comparable<Association<K, V>> {
    private K key;
    private V value;

    /**
     * Compara esta asociación con otra basada en las claves.
     *
     * @param other La otra asociación con la que comparar.
     * @return un entero negativo, cero, o un entero positivo si esta asociación
     * es menor, igual, o mayor que la otra asociación.
     */
    @Override
public int compareTo(Association<K, V> other) {
    if (other == null) {
        return 1; // Indica que esta asociación es mayor que null
    }
    if (this.key == null) {
        return other.key == null ? 0 : -1;
    }
    if (other.key == null) {
        return 1;
    }
    return this.key.compareTo(other.key);
}

    /**
     * Construye una asociación con una clave y un valor.
     *
     * @param key   la clave de la asociación.
     * @param value el valor de la asociación.
     */
    public Association(K key, V value) {
        this.key = key;
        this.value = value;
    }

    /**
     * Obtiene la clave de la asociación.
     *
     * @return la clave de la asociación.
     */
    public K getKey() {
        return this.key;
    }

    /**
     * Obtiene el valor de la asociación.
     *
     * @return el valor de la asociación.
     */
    public V getValue() {
        return this.value;
    }

    /**
     * Devuelve una representación de la asociación en formato de cadena.
     *
     * @return una cadena que representa la clave y el valor de la asociación.
     */
    @Override
    public String toString() {
        return "(" + key + " " + value + ")";
    }
}


