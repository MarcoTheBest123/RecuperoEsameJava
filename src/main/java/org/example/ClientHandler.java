package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.SocketException;

import com.google.gson.Gson;

public class ClientHandler implements Runnable {
    Socket clientSocket;
    BufferedReader in;
    PrintWriter out;
    MessageResult msgRes = null;

    ClientHandler (Socket clientSocket) {
        this.clientSocket = clientSocket;
    }

    public void run () {
        this.inizializeClientHandler();
        try {
            this.executeClientHandler();
        } catch (SocketException e) {
            System.out.println("error");
        }
    }

    void inizializeClientHandler () {
        try {
            in = new BufferedReader(
                    new InputStreamReader(clientSocket.getInputStream()));
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("reader failed" + e);
        }

        out = null;

        try {
            out = new PrintWriter(clientSocket.getOutputStream(), true);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    void executeClientHandler() throws SocketException {
        out.println("The commands that are available on in application are:");
        out.println("Ahi quanto a dir qual era è cosa dura esta selva selvaggia e aspra e forte che nel pensier rinova la paura!");
        Gson gson = new Gson();
        String s;
        while (true) {
            s = receive();
            try {
                switch (s) {
                    default:
                        out.println(s + " is not a command");
                        break;
                    case "Ahi quanto a dir qual era e cosa dura esta selva selvaggia e aspra e forte che nel pensier rinova la paura!":
                        modificaStrings(s);
                        out.println(gson.toJson(msgRes));
                        break;

                }

            } catch (NullPointerException e) {
                System.out.println("Client: " + clientSocket.getLocalAddress() + " disconnected from the server");
                break;
            }

            if (s == "") break;
        }
    }

    void modificaStrings(String m){
        int totParole = m.split(" ").length;
        System.out.println(totParole);
        String replaced = m.replace(" ", "-");
        int length = m.length();
        System.out.println(length);
         msgRes = new MessageResult(new Message(length, totParole,replaced));
    }




    String receive() {
        String s = "";
        try {
            s = in.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return s;
    }


}