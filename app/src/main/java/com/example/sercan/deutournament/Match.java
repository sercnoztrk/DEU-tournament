package com.example.sercan.deutournament;

public class Match {
	    private Team team1;
	    private Team team2;
	    private Team winner;
	    private Team loser;
	    private int team1Score;
	    private int team2Score;
	    


	    public Match(Team team1, Team team2) {
	        this.team1 = team1;
	        this.team2 = team2;
	    }

	    public Team getTeam1(){
	        return team1;
	    }

	    public Team getTeam2() {
	        return team2;
	    }

	    public Team getWinner() {
	        return winner;
	    }
	    
	    public Team getLoser() {
	        return loser;
	    }
	    
	    public void setWinner(Team winner) {
	    	this.winner = winner;
	    }
	    
	    public void setLoser(Team loser) {
	    	this.loser = loser;
	    }
	    
	    public void setTeam1Score(int score){
	        team1Score = score;
	    }

	    public void setTeam2Score(int score){
	        team2Score = score;
	    }

	    public int getTeam1Score(){
	        return team1Score;
	    }

	    public int getTeam2Score() {
	        return team2Score;
	    }
	
}
