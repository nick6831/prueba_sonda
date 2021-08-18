package nvelasquez.pruebaImp;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.nio.file.Path;



public class BuscarBinario {

    private static final int MAXIMO_BYTE_TARJETA = 8;

    public  void buscarNumero (int numero) throws IOException{

        Path path = Paths.get("C:/Users/nvelasquez/Desktop/prueba/prueba/src/main/resources/OperacionesBinarias.bin");
        byte[] data = Files.readAllBytes(path);

    

            byte[] temp = Arrays.copyOfRange(data,0,0+8);


            long numeroTarjeta = valor7bytesToInt(temp);

            
            System.out.print(numeroTarjeta);
        

        
    }
    


    /** Metodo que obtiene el numero en long de un arreglo de 7 bytes.
     * @param leido arreglo de byte leido con el numero de la tarjeta
     * @return numero de tarjeta
     * @throws TablasReferenciasException Arreglo debe ser de 7 bytes. */
    public final long valor7bytesToInt(final byte[] leidoIn)  {
        byte[] leido = leidoIn;
        reverse(leido);
        final int largoValor = MAXIMO_BYTE_TARJETA;
        if (leido.length != largoValor) {
            System.out.print("Esto esta mal!!!!");
        }
        final byte largoLong = 8;
        byte[] bytes = new byte[largoLong];
        final int indiceValor = 1;
        for (int i = 0; i < largoValor; i++) {
            bytes[indiceValor + i] = leido[0 + i];
        }
        ByteBuffer buffer = ByteBuffer.allocate(Long.BYTES);
        buffer.put(bytes);
        buffer.flip(); // need flip
        return buffer.getLong();
    }


    public static void reverse(byte[] array) {
        if (array == null) {
            return;
        }
        int i = 0;
        int j = array.length - 1;
        byte tmp;
        while (j > i) {
            tmp = array[j];
            array[j] = array[i];
            array[i] = tmp;
            j--;
            i++;
        }
    }


}
