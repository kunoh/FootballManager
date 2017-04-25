/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package footballmanager;

/**
 *
 * @author Kunoh
 */
public class Players {

    String name;
    int stat;
    int routine;

    @Override
    public String toString() {
        return name + " : " + stat + " : " + routine;
    }
}
