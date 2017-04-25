/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package footballmanager;

import java.rmi.RemoteException;
import javax.swing.JFrame;   


public class BenytGrafikPanel {
 
    public static void main(String[] arg) throws RemoteException {
        
        SamletPaneler panel = new SamletPaneler();        // opret panelet
        
        JFrame vindue = new JFrame("Football Manager");    // opret et vindue på skærmen
        vindue.add(panel);  

        vindue.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // reagér på luk
        vindue.pack();                       // sæt vinduets størrelse
        vindue.setVisible(true);
    }
}
