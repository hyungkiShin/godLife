package server;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

public class CustomWebApplicationServer {

    private final int port;

    private static final Logger logger = LoggerFactory.getLogger(CustomWebApplicationServer.class);

    public CustomWebApplicationServer(final int port) {
        this.port = port;
    }

    public void start() throws IOException {
        try(ServerSocket serverSocket = new ServerSocket(port)) {
            logger.info("[CustomWebApplicationServer] Server started on port {}", port);

            Socket clientSocket;
            logger.info("[CustomWebApplicationServer] Waiting for client connection...");
            while((clientSocket = serverSocket.accept()) != null) {
                logger.info("[CustomWebApplicationServer] Client connected from {}", clientSocket.getRemoteSocketAddress());

                /**
                 * Step1 - 사용자 요청을 메인 Thread 가 처리하도록 한다.
                 */

                try(InputStream in = clientSocket.getInputStream(); OutputStream out = clientSocket.getOutputStream()) {
                    // input stream 을 읽어들인다. (request) - BufferedReader 를 사용하면 편리하다.
                    BufferedReader br = new BufferedReader(new InputStreamReader(in, StandardCharsets.UTF_8));
                    DataOutputStream dos = new DataOutputStream(out);

                    String line;
                    while((line = br.readLine()) != "") {
                        System.out.println("line = " + line);
                    }
                }
            }
        }
    }
}
