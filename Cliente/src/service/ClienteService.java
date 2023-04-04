/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import bean.ChatMessage;
import java.net.InetAddress;

/**
 *
 * @author João P. Arquim
 */
public class ClienteService {
    
    private Socket socket;
    private ObjectOutputStream output;
 
    public Socket connect(int porta){
        try {
            socket = new Socket(InetAddress.getLocalHost(), porta);
            output = new ObjectOutputStream(socket.getOutputStream());
        } catch (IOException ex) {
            Logger.getLogger(ClienteService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return socket;
    }
    
    public void send(ChatMessage message){
        try {
            output.writeObject(message);
        } catch (IOException ex) {
            Logger.getLogger(ClienteService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
