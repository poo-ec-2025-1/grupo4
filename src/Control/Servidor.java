import java.io.*;
import java.net.*;
import java.util.*;

public class Servidor {
    private static List<ClientHandler> clients = Collections.synchronizedList(new ArrayList<>());

    public static void main(String[] args) {
        System.out.println("Servidor iniciado na porta 12345");

        try (ServerSocket serverSocket = new ServerSocket(12345)) {
            while (true) {
                Socket clientSocket = serverSocket.accept();
                System.out.println("Novo cliente conectado: " + clientSocket);

                ClientHandler handler = new ClientHandler(clientSocket);
                clients.add(handler);
                new Thread(handler).start();
            }
        } catch (IOException e) {
            System.err.println("Erro no servidor: " + e.getMessage());
        }
    }

    static class ClientHandler implements Runnable {
        private Socket socket;
        private BufferedReader in;
        private PrintWriter out;

        public ClientHandler(Socket socket) {
            this.socket = socket;
        }

        public void run() {
            try (
                Socket clientSocket = this.socket;
                BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true)
            ) {
                this.in = in;
                this.out = out;

                String msg;
                while ((msg = in.readLine()) != null) {
                    System.out.println("Recebido: " + msg);
                    broadcast(msg);
                }
            } catch (IOException e) {
                System.out.println("Cliente desconectado ou erro de comunicação: " + e.getMessage());
            } finally {
                clients.remove(this);
            }
        }

        private void broadcast(String msg) {
            synchronized (clients) {
                for (ClientHandler client : clients) {
                    client.out.println(msg);
                }
            }
        }
    }
}
