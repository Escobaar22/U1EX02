import javax.swing.*;
import java.io.*;

/**
 * @author Poly Escobar Sanchez
 * @version 1.0
 * @since 2023-10-08
 */

public class Main {
    public static void main(String[] args) {
        try {
            //Pedimos la ruta del archivo 'src/nombre_archivo.txt'
            String rutaArchivo = JOptionPane.showInputDialog("Introduce la ruta del archivo:");

            //Pedimos el texto que queremos cambiar
            String texto = JOptionPane.showInputDialog("Introduce el texto a escribir en el archivo:");

            //Mandamos el texto al metodo transformartexto
            String textoTransformado = transformarTexto(texto);
            mostrarTextoTransformado(textoTransformado);

            //Mandamos a escribir el texto en la ruta establecida
            escribirArchivo(rutaArchivo, textoTransformado);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error al manipular el archivo: " + e.getMessage());
        }
    }

    private static String transformarTexto(String texto) {
        StringBuilder textoTransformado = new StringBuilder();

        for (char c : texto.toCharArray()) {
            // Verificamos si el carácter es una letra
            if (Character.isLetter(c)) {
                // Si es una letra, verificamos si es mayúscula
                if (Character.isUpperCase(c)) {
                    // Si es mayúscula, lo convertimos a minúscula
                    textoTransformado.append(Character.toLowerCase(c));
                } else {
                    // Si es minúscula, lo convertimos a mayúscula
                    textoTransformado.append(Character.toUpperCase(c));
                }
            } else {
                // Si no es una letra, lo agregamos al texto transformado tal como está
                textoTransformado.append(c);
            }
        }

        return textoTransformado.toString();
    }

    private static void mostrarTextoTransformado(String texto) {
        // Mostramos el texto transformado
        JOptionPane.showMessageDialog(null, "Texto transformado: " + texto);
    }

    private static void escribirArchivo(String rutaArchivo, String texto) throws IOException {
        BufferedWriter bw = new BufferedWriter(new FileWriter(rutaArchivo));

        // Escribimos el texto transformado en el archivo
        bw.write(texto);

        // Cerramos el archivo
        bw.close();
    }
}