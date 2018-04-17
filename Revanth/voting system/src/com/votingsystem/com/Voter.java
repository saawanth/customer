package com.votingsystem.com;

public class Voter {
	private String voterName;
	private int voterId;
	private String vote;
	private boolean isVp;

	public Voter(String voterName, int voterId, String vote) {
		this.voterName = voterName;
		this.voterId = voterId;
		this.vote = vote;
	}

	public Voter(String voterName, int voterId, String vote, boolean isVp) {
		this.voterName = voterName;
		this.voterId = voterId;
		this.vote = vote;
		this.isVp = isVp;
	}

	public boolean isVp() {
		return isVp;
	}

	public String getVoterName() {
		return voterName;
	}

	public void setVoterName(String voterName) {
		this.voterName = voterName;
	}

	public int getVoterId() {
		return voterId;
	}

	public void setVoterId(int voterId) {
		this.voterId = voterId;
	}

	public String getVote() {
		return vote;
	}

	public void setVote(String vote) {
		this.vote = vote;
	}

}
