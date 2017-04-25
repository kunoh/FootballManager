package footballmanager;

import brugerautorisation.data.Bruger;
import brugerautorisation.transport.rmi.Brugeradmin;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Collections;
import java.util.ArrayList;

public class FootballManager extends UnicastRemoteObject implements FootballManagerI {
// obs. jeg har skudt lidt med sprede hagl og sat remoteException på alt, det bør der ikke være og det skal undersøges nærmere (det var en quick fix).

    public FootballManager() throws java.rmi.RemoteException {
        CreateTeams();
    }

    int count = 1;
    int myteam = 0;
    String result = null;
    boolean firstHalfSeason = false;

    ArrayList<Hold> liga = new ArrayList();
    ArrayList<Hold> teams = new ArrayList();
    ArrayList<Matches> playedMatches = new ArrayList();

    Hold hold = new Hold();
    Hold hold1 = new Hold();
    Hold hold2 = new Hold();
    Hold hold3 = new Hold();
    Hold hold4 = new Hold();
    Hold hold5 = new Hold();
    Hold hold6 = new Hold();
    Hold hold7 = new Hold();
    Hold hold8 = new Hold();
    Hold hold9 = new Hold();
    Hold hold10 = new Hold();
    Hold hold11 = new Hold();

    @Override
    public int getLigaPoints(int i) throws java.rmi.RemoteException {
        return liga.get(i).points;

    }

    @Override
    public int getLigaGoalDifference(int i) throws java.rmi.RemoteException {
        return liga.get(i).goalDifference;

    }

    @Override
    public int getLigaGoalAgainst(int i) throws java.rmi.RemoteException {
        return liga.get(i).goalAgainst;

    }

    @Override
    public int getLigaGoalFor(int i) throws java.rmi.RemoteException {
        return liga.get(i).goalFor;

    }

    @Override
    public String getLigaName(int i) throws java.rmi.RemoteException {
        return liga.get(i).name;
    }

    @Override
    public int SizeofLiga() throws java.rmi.RemoteException {
        return liga.size();

    }

    @Override
    public String getResults(int i) throws java.rmi.RemoteException {
        return playedMatches.get(i).results;

    }

    @Override
    public String getMatch(int i) throws java.rmi.RemoteException {
        return playedMatches.get(i).match;

    }

    @Override
    public int SizeofplayedMatches() throws java.rmi.RemoteException {
        return playedMatches.size();

    }

    @Override
    public String getOwnTeamName() throws java.rmi.RemoteException {
        return hold.name;

    }

    @Override
    public int getPlayersSize() throws java.rmi.RemoteException {
        return hold.players.size();

    }

    @Override
    public String getPlayersName(int i) throws java.rmi.RemoteException {
        return hold.players.get(i).name;

    }

    @Override
    public int getPlayersStat(int i) throws java.rmi.RemoteException {
        return hold.players.get(i).stat;
    }

    @Override
    public int getPlayersRoutine(int i) throws java.rmi.RemoteException {
        return hold.players.get(i).routine;
    }

    public void CreateLiga() throws java.rmi.RemoteException {

        ArrayList<Integer> brugteHold = new ArrayList<>();

        liga.add(hold);
        liga.add(hold1);
        liga.add(hold2);
        liga.add(hold3);
        liga.add(hold4);
        liga.add(hold5);
        liga.add(hold6);
        liga.add(hold7);
        liga.add(hold8);
        liga.add(hold9);
        liga.add(hold10);
        liga.add(hold11);

        teams.add(hold);
        while (teams.size() < liga.size()) {

            int rand = (int) (Math.random() * 12);

            if (!brugteHold.contains(rand)) {

                if (rand > 0 && rand <= 1) {
                    teams.add(hold1);
                }
                if (rand > 1 && rand <= 2) {
                    teams.add(hold2);
                }
                if (rand > 2 && rand <= 3) {
                    teams.add(hold3);
                }
                if (rand > 3 && rand <= 4) {
                    teams.add(hold4);
                }
                if (rand > 4 && rand <= 5) {
                    teams.add(hold5);
                }
                if (rand > 5 && rand <= 6) {
                    teams.add(hold6);
                }
                if (rand > 6 && rand <= 7) {
                    teams.add(hold7);
                }
                if (rand > 7 && rand <= 8) {
                    teams.add(hold8);
                }
                if (rand > 8 && rand <= 9) {
                    teams.add(hold9);
                }
                if (rand > 9 && rand <= 10) {
                    teams.add(hold10);
                }
                if (rand > 10 && rand <= 11) {
                    teams.add(hold11);
                }
                brugteHold.add(rand);
            }
        }
    }

    public void League() throws java.rmi.RemoteException {
        Collections.sort(liga);
        System.out.println(liga);
    }

    public String GetNextMatch() throws java.rmi.RemoteException {
        String nextmatch = teams.get(myteam).name + " vs " + teams.get(count).name;
        return nextmatch;
    }

    public void MatchEngine() throws java.rmi.RemoteException {
        if (count != 0) {
            int firstTeamChances = teams.get(myteam).totstat + teams.get(myteam).totroutine / 4;
            double secondTeamChances = teams.get(count).totstat + teams.get(count).totroutine / 4;
            double totTeamStat = firstTeamChances + secondTeamChances;
            int winningChanceTeam1 = ((int) (((totTeamStat - secondTeamChances) / totTeamStat) * 100));
            int x = 0;
            int y = 0;
            int rand = getRandomNum();
            ArrayList<Integer> holdKampe = new ArrayList();
            boolean won = false;
            boolean draw = false;
            boolean lost = false;

            if (winningChanceTeam1 - 5 > rand) {        // her får den et mellemrum på 10, som gør at det kan blive uafgjort
                int rand2 = getRandomNum();
                if (rand2 < 20) {
                    x = 1;
                    y = 0;
                }
                if (rand2 >= 20 && rand2 < 40) {
                    x = 2;
                    y = 0;
                }
                if (rand2 >= 40 && rand2 < 60) {
                    x = 3;
                    y = 0;
                }
                if (rand2 >= 60 && rand2 < 80) {
                    x = 3;
                    y = 1;
                }
                if (rand2 >= 80 && rand2 <= 100) {
                    x = 3;
                    y = 2;
                }
                teams.get(myteam).points += 3;
                teams.get(myteam).goalDifference += (x - y);
                teams.get(count).goalDifference += (y - x);
                teams.get(myteam).goalFor += (x);
                teams.get(count).goalFor += (y);
                teams.get(myteam).goalAgainst += y;
                teams.get(count).goalAgainst += x;

            } else if (winningChanceTeam1 + 5 < rand) {
                int rand2 = getRandomNum();
                if (rand2 < 20) {
                    x = 0;
                    y = 1;
                }
                if (rand2 >= 20 && rand2 < 40) {
                    x = 0;
                    y = 2;
                }
                if (rand2 >= 40 && rand2 < 60) {
                    x = 0;
                    y = 3;
                }
                if (rand2 >= 60 && rand2 < 80) {
                    x = 1;
                    y = 3;
                }
                if (rand2 >= 80 && rand2 <= 100) {
                    x = 2;
                    y = 3;
                }
                teams.get(count).points += 3;
                teams.get(myteam).goalDifference += (x - y);
                teams.get(count).goalDifference += (y - x);
                teams.get(myteam).goalFor += (x);
                teams.get(count).goalFor += (y);
                teams.get(myteam).goalAgainst += y;
                teams.get(count).goalAgainst += x;

            } else if (winningChanceTeam1 - 5 <= rand && rand <= winningChanceTeam1 + 5) {
                int rand2 = getRandomNum();
                if (rand2 < 25) {
                    x = 0;
                    y = 0;
                }
                if (rand2 >= 25 && rand2 < 50) {
                    x = 1;
                    y = 1;
                }
                if (rand2 >= 50 && rand2 < 75) {
                    x = 2;
                    y = 2;
                }
                if (rand2 >= 75 && rand2 < 100) {
                    x = 3;
                    y = 3;
                }
                teams.get(myteam).points += 1;
                teams.get(count).points += 1;
                teams.get(myteam).goalFor += (x);
                teams.get(count).goalFor += (y);
                teams.get(myteam).goalAgainst += y;
                teams.get(count).goalAgainst += x;

            }
            Matches match = new Matches();
            match.results = x + " - " + y;
            match.match = teams.get(myteam).name + " vs " + teams.get(count).name;
            playedMatches.add(match);
            result = x + " - " + y;

            holdKampe.add(myteam);
            holdKampe.add(count);
            while (holdKampe.size() < 12) {

                int rand3 = (int) (Math.random() * 12);
                int rand4 = (int) (Math.random() * 8);

                if (!holdKampe.contains(rand3)) {
                    if (won == true) {
                        won = false;
                        teams.get(rand3).goalDifference += (y - x);
                        teams.get(rand3).goalFor += y;
                        teams.get(rand3).goalAgainst += x;
                    } else if (draw == true) {
                        teams.get(rand3).points += 1;
                        teams.get(rand3).goalFor += y;
                        teams.get(rand3).goalAgainst += x;
                        draw = false;
                    } else if (lost == true) {
                        teams.get(rand3).points += 3;
                        teams.get(rand3).goalFor += y;
                        teams.get(rand3).goalAgainst += x;
                        teams.get(rand3).goalDifference += (y - x);
                        lost = false;
                    } else {
                        if (rand4 >= 0 && rand4 < 3) {
                            int rand2 = getRandomNum();
                            if (rand2 < 20) {
                                x = 1;
                                y = 0;
                            }
                            if (rand2 >= 20 && rand2 < 40) {
                                x = 2;
                                y = 0;
                            }
                            if (rand2 >= 40 && rand2 < 60) {
                                x = 3;
                                y = 0;
                            }
                            if (rand2 >= 60 && rand2 < 80) {
                                x = 3;
                                y = 1;
                            }
                            if (rand2 >= 80 && rand2 <= 100) {
                                x = 3;
                                y = 2;
                            }
                            teams.get(rand3).goalDifference += x - y;
                            teams.get(rand3).points += 3;
                            teams.get(rand3).goalFor += x;
                            teams.get(rand3).goalAgainst += y;

                            won = true;
                        }
                        if (rand4 >= 3 && rand4 < 6) {
                            int rand2 = getRandomNum();
                            if (rand2 < 25) {
                                x = 0;
                                y = 0;
                            }
                            if (rand2 >= 25 && rand2 < 50) {
                                x = 1;
                                y = 1;
                            }
                            if (rand2 >= 50 && rand2 < 75) {
                                x = 2;
                                y = 2;
                            }
                            if (rand2 >= 75 && rand2 < 100) {
                                x = 3;
                                y = 3;
                            }
                            teams.get(rand3).points += 1;
                            teams.get(rand3).goalFor += x;
                            teams.get(rand3).goalAgainst += y;
                            draw = true;
                        }
                        if (rand4 >= 6 && rand4 < 9) {
                            int rand2 = getRandomNum();
                            if (rand2 < 20) {
                                x = 0;
                                y = 1;
                            }
                            if (rand2 >= 20 && rand2 < 40) {
                                x = 0;
                                y = 2;
                            }
                            if (rand2 >= 40 && rand2 < 60) {
                                x = 0;
                                y = 3;
                            }
                            if (rand2 >= 60 && rand2 < 80) {
                                x = 1;
                                y = 3;
                            }
                            if (rand2 >= 80 && rand2 <= 100) {
                                x = 2;
                                y = 3;
                            }
                            teams.get(rand3).goalDifference += x - y;
                            teams.get(rand3).goalFor += x;
                            teams.get(rand3).goalAgainst += y;
                            lost = true;
                        }

                    }
                    holdKampe.add(rand3);
                }

            }

            if (count < teams.size() - 1 && firstHalfSeason == false) {
                count++;
            } else if (firstHalfSeason == true) {
                count--;
            } else {
                firstHalfSeason = true;

            }
        }

    }

    public int getRandomNum() throws java.rmi.RemoteException {
        return (int) (Math.random() * 100);
    }

    public String getResult() throws java.rmi.RemoteException {
        return result;
    }

    public boolean getFirsthalfseason() throws java.rmi.RemoteException {
        return firstHalfSeason;
    }

    public int getPosition() throws java.rmi.RemoteException {
        Collections.sort(liga);
        int i;
        for (i = 0; i < liga.size(); i++) {
            if (hold.equals(liga.get(i))) {
                break;
            }
        }
        return i + 1;
    }

    public void CreateTeams() throws java.rmi.RemoteException {

        hold1.name = "Herning F.C";
        hold2.name = "Ølstykke Bold Klub";
        hold3.name = "Vanløse Kvareteret";
        hold4.name = "Rødderne fra Islev";
        hold5.name = "Lyngby DTU";
        hold6.name = "Ballerup DTU";
        hold7.name = "De Forfærdelige";
        hold8.name = "Spejderne";
        hold9.name = "Helsingør F.C";
        hold10.name = "Klub Greve";
        hold11.name = "Glostrup";
    }

    public void sortLiga() throws java.rmi.RemoteException {
        Collections.sort(liga);
    }

    public void SetTeamName(String str) throws java.rmi.RemoteException {
        hold.name = str;
    }

    public boolean loggedIn(String bruger, String adgangskode) throws RemoteException, NotBoundException, MalformedURLException {
        Brugeradmin ba = null;

        ba = (Brugeradmin) Naming.lookup("rmi://javabog.dk/brugeradmin");

        try {
            Bruger b = ba.hentBruger(bruger, adgangskode);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    /*
    public void SaveFile() throws IOException {

        FileWriter fil = new FileWriter("SpilledeKampe.txt");
        PrintWriter ud = new PrintWriter(fil);
        for (Matches kampe : playedMatches) {
            ud.println(kampe.match + " " + kampe.results);
        }
        ud.close();
    }*/
}
