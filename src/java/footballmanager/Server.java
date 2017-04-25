/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package footballmanager;

//import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.RemoteException;

/**
 *
 * @author Yusuf
 */
public class Server extends java.rmi.server.RemoteServer{

    public static void main(String[] args) throws Exception {
         
        try {
            
            FootballManagerI foot = (FootballManagerI) new FootballManager();
            Registry registry = LocateRegistry.createRegistry(53518);
            registry.bind("FootballManagerI15351", foot);
            System.err.println("Server Ready");
            Server.toStub(foot);
            
        } catch (Exception e) {

            System.err.println("Server exception: " + e.toString());
            e.printStackTrace();

        }
    }

}

