/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package footballmanager;

import java.util.ArrayList;

class Hold implements Comparable<Hold> {

    int goalDifference = 0;
    int goalFor = 0;
    int goalAgainst = 0;
    int points = 0;
    String name;

    int totstat;
    int totroutine;

    @Override
    public String toString() {
        return name + " : " + points + " : " + goalDifference;
    }

    @Override
    public int compareTo(Hold arg0) {
        if (this.points < arg0.points) {
            return 1;
        } else if (this.points > arg0.points) {
            return -1;
        } else if (this.points == arg0.points) {
            if (this.goalDifference < arg0.goalDifference) {
                return 1;
            } else if (this.goalDifference > arg0.goalDifference) {
                return -1;
            }
        }
        return 0;
    }

    public Hold() {
        Names();
        CreateTeams();
    }

    ArrayList<Players> players = new ArrayList();
    ArrayList<String> fornavn = new ArrayList();
    ArrayList<String> efternavn = new ArrayList();

    public void CreateTeams() {
        for (int i = 0; i < 11; i++) {
            Players player = new Players();
            player.name = CreateName();
            player.routine = (int) (Math.random() * 50);
            player.stat = (int) (Math.random() * 20);
            players.add(player);
            totroutine = totroutine + player.routine;
            totstat = totstat + player.stat;
        }
    }

    public void Names() {

        fornavn.add("Ajmal ");
        fornavn.add("Preben ");
        fornavn.add("Mogens ");
        fornavn.add("Kasper ");
        fornavn.add("Yusuf ");
        fornavn.add("Mustafa ");
        fornavn.add("Michael ");
        fornavn.add("Peter ");
        fornavn.add("Abdi ");
        fornavn.add("Wiz ");
        fornavn.add("Hvem ");
        fornavn.add("Ole ");
        fornavn.add("Hans ");
        fornavn.add("Gamle ");
        fornavn.add("Sunesen ");
        fornavn.add("Bums ");
        fornavn.add("Jens ");
        fornavn.add("Musti ");
        fornavn.add("Mikkel ");
        fornavn.add("Bøgse ");

        efternavn.add("Hansen");
        efternavn.add("Mikkelsen");
        efternavn.add("Pedersen");
        efternavn.add("Safi");
        efternavn.add("Sahebzadeh");
        efternavn.add("Gulce");
        efternavn.add("HAAA");
        efternavn.add("Holse");
        efternavn.add("Kool");
        efternavn.add("Flode");
        efternavn.add("Werner");
        efternavn.add("Du Ve'");
        efternavn.add("Halla");
        efternavn.add("Jensen");
        efternavn.add("Bøfhus");
        efternavn.add("Nielson");
    }

    public String CreateName() {
        int i = (int) (Math.random() * fornavn.size());
        int o = (int) (Math.random() * efternavn.size());

        String tempName = fornavn.get(i) + efternavn.get(o);
        return tempName;
    }

    public int getTotalStat() {
        return totstat;
    }

    public int getTotalRoutine() {
        return this.totroutine;
    }

}
