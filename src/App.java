import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

public class App {
    public static void main(String[] args) throws Exception {
        
        
        final ServerSocket server = new ServerSocket(8080);
        System.out.println("Listening on port " + server.getLocalPort());

        while (true) {
           try ( Socket socket = server.accept()) {
            Date today = new Date();
            String httpresponse = "HTTP/1.1 200 OK\r\n\r\n" + today + " H!";
            socket.getOutputStream().write(httpresponse.getBytes("UTF-8"));
           }
            //final Socket client = server.accept(); 
            // 1. Read HTTP request from the client socket
            // 2. Prepare an HTTP response
            // 3. Send HTTP response to the client 
            // 4. Close the socket
            // InputStreamReader isr = new InputStreamReader(clientSocket.getInputStream());
            // BufferedReader reader = new BufferedReader(isr);

            // String line = reader.readLine();

            // while (!line.isEmpty()) {
            //     System.out.println(line);
            //     line = reader.readLine();
            // }
        }
    }
}