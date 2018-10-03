package com.example.sercan.deutournament;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

public class Tournament {

		private int branch;
		ArrayList<Match> round1 = new ArrayList<>();
		ArrayList<Match> round2 = new ArrayList<>();
		ArrayList<Match> round3 = new ArrayList<>();
		ArrayList<Match> round4 = new ArrayList<>();
		Team[] tournamentTeams;

	public Tournament(int branch) {

		this.branch = branch;
	}

	public Team[] createTeams() {
		Team[] teams = new Team[11];
		teams[0] = new Team("CompEng", 1);
		teams[1] = new Team("EnvEng", 2);
		teams[2] = new Team("EEng", 3);
		teams[3] = new Team("EndEng", 4);
		teams[4] = new Team("CivEng", 5);
		teams[5] = new Team("GeoPhyEng", 6);
		teams[6] = new Team("GeoEng", 7);
		teams[7] = new Team("MinEng", 8);
		teams[8] = new Team("MEng", 9);
		teams[9] = new Team("MMEng", 10);
		teams[10] = new Team("TxtEng", 11);
		return teams;
	}

	private Match randomizeScores(Team team1, Team team2) {
		Random rand = new Random();
		Match match = new Match(team1, team2);

		match.setTeam1Score(0);
		match.setTeam2Score(0);
		
		if (branch == Constants.FOOTBALL) {
			match.setTeam1Score(0);
			match.setTeam2Score(0);
			while (match.getTeam1Score() == match.getTeam2Score()) {
				match.setTeam1Score(rand.nextInt(6));
				match.setTeam2Score(rand.nextInt(6));
			}
		}
		else if (branch == Constants.BASKETBALL) {
			while (match.getTeam1Score() == match.getTeam2Score()) {
				match.setTeam1Score(rand.nextInt((120 - 60) + 1) + 60);
				match.setTeam2Score(rand.nextInt((120 - 60) + 1) + 60);
			}
		}
		else if (branch == Constants.VOLLEYBALL) {
			while (match.getTeam1Score() != 3 && match.getTeam2Score() != 3 || (match.getTeam1Score() == match.getTeam2Score())) {
				match.setTeam1Score(rand.nextInt(4));
				match.setTeam2Score(rand.nextInt(4));
			}
			
		}
		else if (branch == Constants.TENNIS) {
			while (match.getTeam1Score() != 2 && match.getTeam2Score() != 2 || (match.getTeam1Score() == match.getTeam2Score())) {
				match.setTeam1Score(rand.nextInt(3));
				match.setTeam2Score(rand.nextInt(3));
			}
		}
		else if (branch == Constants.ESPORTS) {
			while (match.getTeam1Score() != 1 && match.getTeam2Score() != 1 || (match.getTeam1Score() == match.getTeam2Score())) {
				match.setTeam1Score(rand.nextInt(2));
				match.setTeam2Score(rand.nextInt(2));
			}
		}
		return match;
	}

	private Match playMatch(Match match) {
		
		match = randomizeScores(match.getTeam1(), match.getTeam2());

		if (match.getTeam1Score() > match.getTeam2Score())
			match.setWinner(match.getTeam1());
		else
			match.setWinner(match.getTeam2());

		
		//System.out.println(match.getTeam1().getName() + ": " + match.getTeam1Score() + " - " + match.getTeam2Score() + " :" + match.getTeam2().getName());
		return match;
	}

	public Team[] seedTeams(Team[] teams) {
		Random rand = new Random();
		for (int i = teams.length - 1; i > 0; i--) {
			int index = rand.nextInt(i + 1);
			Team a = teams[index];
			teams[index] = teams[i];
			teams[i] = a;
		}
		return teams;
	}

	public void simulateTournament(Team[] seededTeams) {

		round1.add(playMatch(new Match(seededTeams[7], seededTeams[8])));
		round1.add(playMatch(new Match(seededTeams[6], seededTeams[9])));
		round1.add(playMatch(new Match(seededTeams[5], seededTeams[10])));
		
		
		
		round2.add(playMatch(new Match(seededTeams[0], round1.get(0).getWinner())));
		round2.add(playMatch(new Match(seededTeams[3], seededTeams[4])));
		round2.add(playMatch(new Match(seededTeams[1], round1.get(1).getWinner())));
		round2.add(playMatch(new Match(seededTeams[2], round1.get(2).getWinner())));

		round3.add(playMatch(new Match(round2.get(0).getWinner(), round2.get(1).getWinner())));
		round3.add(playMatch(new Match(round2.get(2).getWinner(), round2.get(3).getWinner())));

		round4.add(playMatch(new Match(round3.get(0).getWinner(), round3.get(1).getWinner())));
	}

}
