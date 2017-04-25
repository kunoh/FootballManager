/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package footballmanager;

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

/**
 *
 * @author Yusuf
 */

public class Klient {

    public static void main(String[] arg) throws Exception {
    
        FootballManagerI g=null;
                System.out.println("pre"+g);
                Registry registry = LocateRegistry.getRegistry("192.168.1.10", 53518);
                g= (FootballManagerI)registry.lookup("FootballManagerI15351");
               // g= (FootballManagerI) Naming.lookup("rmi://localhost/FootballManagerI15351");
   System.out.println("post"+g);
    }
}
