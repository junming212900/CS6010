import java.net.ServerSocket;
import java.io.IOException;
import java.net.Socket;
import java.util.Date;
public class Main {
    public static void main(String args[]) throws IOException{
        int port = 8080;
        ServerSocket  server = new ServerSocket(port);
        System.out.println("Server started on port 8080");
        while (true){
            try(Socket socket = server.accept()){
                Date date = new Date();
                String httpResponse = "HTTP/1.1 200 OK\r\n\r\n" + date;
                socket.getOutputStream().write(httpResponse.getBytes("UTF-8"));
            }
        }
    }
}