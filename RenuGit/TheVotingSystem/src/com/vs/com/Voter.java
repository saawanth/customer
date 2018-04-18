package com.vs.com;

public class Voter {
	private String voterName;
	private int voterId;
	private boolean vote;

	public Voter(int voterId, String voterName, boolean vote) {
		super();
		this.voterName = voterName;
		this.voterId = voterId;
		this.vote = vote;
	}

	public Voter() {

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

	public boolean isVote() {
		return vote;
	}

	public void setVote(boolean vote) {
		this.vote = vote;
	}

	@Override
	public String toString() {
		return voterName + "," + voterId + "," + vote;
	}

}
