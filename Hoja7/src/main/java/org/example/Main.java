package org.example;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

/**
 * Clase principal que ejecuta el traductor Inglés-Español.
 * Lee un archivo de diccionario y utiliza sus definiciones para traducir un archivo de texto.
 */
public class Main {
    /**
     * El punto de entrada principal del programa.
     *
     * @param args Los argumentos de la línea de comandos.
     */
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Bienvenido al Traductor Inglés-Español.");

            // Solicitar al usuario los nombres de los archivos de diccionario y texto.
            System.out.print("Por favor, ingrese el nombre del archivo de diccionario (por ejemplo, diccionario.txt): ");
            String nombreArchivoDiccionario = scanner.nextLine().trim();

            System.out.print("Ahora, ingrese el nombre del archivo de texto (por ejemplo, texto.txt): ");
            String nombreArchivoTexto = scanner.nextLine().trim();

            // Crea un árbol binario para almacenar las asociaciones del diccionario.
            BinaryTree<Association<String, String>> diccionario = new BinaryTree<>();

            // Carga las palabras y sus traducciones en el diccionario.
            try (BufferedReader br = new BufferedReader(new FileReader(nombreArchivoDiccionario))) {
                String linea;
                while ((linea = br.readLine()) != null) {
                    String[] partes = linea.replaceAll("[()]", "").split("\\s+");
                    if (partes.length == 2) {
                        diccionario.insert(new Association<>(partes[0], partes[1]));
                    }
                }
                System.out.println("Diccionario cargado exitosamente.");
            } catch (IOException e) {
                System.err.println("Error al leer el archivo " + nombreArchivoDiccionario + ": " + e.getMessage());
                return;
            }

            // Traduce las palabras del archivo de texto utilizando el diccionario.
            System.out.println("\nTraduciendo el archivo " + nombreArchivoTexto + "...");
            try (BufferedReader br = new BufferedReader(new FileReader(nombreArchivoTexto))) {
                String linea;
                while ((linea = br.readLine()) != null) {
                    String[] palabras = linea.split("\\s+");
                    for (String palabra : palabras) {
                        String palabraLimpia = palabra.replaceAll("[^a-zA-Z]", "").toLowerCase();
                        Association<String, String> resultadoBusqueda = diccionario.find(new Association<>(palabraLimpia, ""));
                        if (resultadoBusqueda != null) {
                            System.out.print(resultadoBusqueda.getValue() + " ");
                        } else {
                            System.out.print("*" + palabra + "* ");
                        }
                    }
                    System.out.println();
                }
            } catch (IOException e) {
                System.err.println("Error al leer el archivo " + nombreArchivoTexto + ": " + e.getMessage());
            }
        }
        // Indica que la traducción se ha completado.
        System.out.println("\nTraducción completada. ¡Gracias por utilizar el traductor!");
    }
}
