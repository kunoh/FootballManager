/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package footballmanager;

import java.net.MalformedURLException;
import java.rmi.NotBoundException;

/**
 *
 * @author Yusuf
 */
public interface FootballManagerI extends java.rmi.Remote {

    public void CreateLiga() throws java.rmi.RemoteException;

    public void League() throws java.rmi.RemoteException;

    public String GetNextMatch() throws java.rmi.RemoteException;
//  @WebMethod public void MatchEngine();
//  @WebMethod public int getRandomNum();

    public String getResult() throws java.rmi.RemoteException;

    public boolean getFirsthalfseason() throws java.rmi.RemoteException;

    public int getPosition() throws java.rmi.RemoteException;

    public void CreateTeams() throws java.rmi.RemoteException;

    public void SetTeamName(String str) throws java.rmi.RemoteException;

    public String getPlayersName(int i) throws java.rmi.RemoteException;

    public int getPlayersSize() throws java.rmi.RemoteException;

    public int getPlayersStat(int i) throws java.rmi.RemoteException;

    public int getPlayersRoutine(int i) throws java.rmi.RemoteException;

    public int getLigaPoints(int i) throws java.rmi.RemoteException;

    public int getLigaGoalDifference(int i) throws java.rmi.RemoteException;

    public int getLigaGoalAgainst(int i) throws java.rmi.RemoteException;

    public int getLigaGoalFor(int i) throws java.rmi.RemoteException;

    public String getLigaName(int i) throws java.rmi.RemoteException;

    public int SizeofLiga() throws java.rmi.RemoteException;

    public String getResults(int i) throws java.rmi.RemoteException;

    public String getMatch(int i) throws java.rmi.RemoteException;

    public int SizeofplayedMatches() throws java.rmi.RemoteException;

    public String getOwnTeamName() throws java.rmi.RemoteException;

//  public void SaveFile() throws java.rmi.RemoteException;
    public void MatchEngine() throws java.rmi.RemoteException;

    public void sortLiga() throws java.rmi.RemoteException;
    
    public boolean loggedIn(String bruger, String adgangskode) throws java.rmi.RemoteException, NotBoundException, MalformedURLException;

}
