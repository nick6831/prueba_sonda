package nvelasquez.pruebaImp;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;

import org.json.JSONObject;



public class BuscarBinario {

    private static final int MAXIMO_BYTE_TARJETA = 7;

    public  JSONObject buscarNumero (String num) throws IOException{

        JSONObject json = new JSONObject(num);  
        long numero = json.getLong("id");
        int numeroTransaccion = 0;
        long numeroTarjeta = 0;

        Path path = Paths.get("C:/Users/nvelasquez/Desktop/prueba/prueba/src/main/resources/OperacionesBinarias.bin");
        byte[] data = Files.readAllBytes(path);
        for (int i = 0; i < data.length; i=i+9) {        
            byte[] temp = Arrays.copyOfRange(data,i,i+7);
            numeroTarjeta = valor7bytesToInt(temp);
            if(numero == numeroTarjeta){
                byte[] temp2 = Arrays.copyOfRange(data,i+7,i+9);
                numeroTransaccion = valor2bytesToInt(temp2);
                break;
            }  
        }
            JSONObject jsonObject = new JSONObject("{tarjetaId:"+ numeroTarjeta +", transactionId:"+ numeroTransaccion+"}");
            return jsonObject;
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


    /** Metodo que obtiene el numero en int de un arreglo de 2 bytes.
     * @param leido arreglo de byte leido con el numero de la tarjeta
     * @return codigo de producto
     * @throws TablasReferenciasException TablasReferenciasException */
    public static int valor2bytesToInt(final byte[] leidoIn){
        byte[] leido = leidoIn;
        reverse(leido);
        final int largoValor = 2;
        if (leido.length != largoValor) {
            System.out.print("Esto esta mal!!!!");
        }
        final byte largoInt = 4;
        byte[] bytes = new byte[largoInt];
        final int indiceValor = 2;
        bytes[indiceValor] = leido[0];
        bytes[indiceValor + 1] = leido[1];
        ByteBuffer byteBuffer = ByteBuffer.allocate(Integer.BYTES);
        byteBuffer.put(bytes);
        byteBuffer.flip();
        return byteBuffer.getInt();
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
