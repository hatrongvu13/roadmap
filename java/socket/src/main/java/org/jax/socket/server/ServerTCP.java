package org.jax.socket.server;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerTCP {
    public static void main(String[] args) {
        System.out.println("Server TCP is start !");

        try {

            String sentence_from_client;
            String sentence_to_client;

            //Tạo socket server, chờ tại cổng '6543'
            ServerSocket welcomeSocket = new ServerSocket(6543);

            while(true) {
                //chờ yêu cầu từ client
                Socket connectionSocket = welcomeSocket.accept();

                //Tạo input stream, nối tới Socket
                BufferedReader inFromClient =
                        new BufferedReader(new
                                InputStreamReader(connectionSocket.getInputStream()));

                //Tạo outputStream, nối tới socket
                DataOutputStream outToClient =
                        new DataOutputStream(connectionSocket.getOutputStream());

                //Đọc thông tin từ socket
                sentence_from_client = inFromClient.readLine();

                sentence_to_client = sentence_from_client +" (Server accepted!)" + '\n';
                System.out.println(sentence_from_client);
                //ghi dữ liệu ra socket
                outToClient.writeBytes(sentence_to_client);
//                return;
            }

        } catch (IOException e) {
            System.err.println("Start server error ! ");
            e.printStackTrace();
        }

        System.out.println("Server is stopped !");
    }
}
