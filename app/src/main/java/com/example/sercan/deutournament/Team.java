package com.example.sercan.deutournament;

public class Team {
    private String name;
    private int teamId;
    private int seed;


    public Team(String name, int teamId) {
        this.name = name;
        this.teamId = teamId;
    }

    public String getName() {
    	return name;
    }
    
    public int getTeamId() {
		return teamId;
	}
    
    public int getSeed() {
		return seed;
	}
    
    public void setSeed(int seed) {
    	this.seed = seed;
    }
}