import java.io.*;
import java.net.*;

public class ChatClient {
    public static void main(String[] args) {
        try (
            Socket socket = new Socket("localhost", 12345);
            BufferedReader console = new BufferedReader(new InputStreamReader(System.in));
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true)
        ) {
            System.out.println("Conectado ao servidor.");

            // Thread para ouvir mensagens do servidor
            Thread leitura = new Thread(() -> {
                String msg;
                try {
                    while ((msg = in.readLine()) != null) {
                        System.out.println("Mensagem: " + msg);
                    }
                } catch (IOException e) {
                    System.out.println("Conexão encerrada.");
                }
            });

            leitura.start();

            // Loop principal para envio
            String texto;
            while ((texto = console.readLine()) != null) {
                out.println(texto);
            }

        } catch (IOException e) {
            System.err.println("Erro de conexão: " + e.getMessage());
        }
    }
}
