import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class VotingTask implements Runnable {
	private String motionName;
	public long startTime;
	public long endTime;
	String VpVote;
	private final Queue<Candidate> queuedVotes = new LinkedList<Candidate>();
	private final Map<Integer, Candidate> candidatesVoted = new HashMap<>();
	public VotingTask(String motionName, long startTime, long endTime) {
		this.motionName = motionName;
		this.startTime = startTime;
		this.endTime = endTime;
	}
	
	

	public String getVpVote() {
		return VpVote;
	}



	public void setVpVote(String vpVote) {
		VpVote = vpVote;
	}



	@Override
	public void run() {
		int Yeahs = 0;
		int Nahs = 0;
		int invalid = 0;

		while (System.currentTimeMillis() > startTime && System.currentTimeMillis() <= endTime
				&& candidatesVoted.size() <= 101) {

			Candidate vote;
			synchronized (queuedVotes) {
				vote = queuedVotes.poll();
			}

			if (vote != null && !candidatesVoted.containsKey(vote.getVoterId())) {
				if (vote.getYesorNo().equals("Yes")) {
					Yeahs++;
				} else if (vote.getYesorNo().equals("No")) {
					Nahs++;
				}
				candidatesVoted.put(vote.getVoterId(), vote);
			} else {
				try {
					Thread.sleep(500);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}

		if (Yeahs > Nahs) {
			System.out.println("Motion passed" + Yeahs + "invalid" + invalid);
		} else if (Nahs > Yeahs) {
			System.out.println("Motion Faild" + Nahs + "invalid" + invalid);
		} else {
			System.out.println("Motion tied: Need Vp vote");
			
			try {
				Thread.sleep(5);
			} catch (Exception e) {
				// TODO: handle exception
			}
			
			long vpEndTime = System.currentTimeMillis() + 30000;
			while (System.currentTimeMillis() < vpEndTime) {
					if (VpVote.equalsIgnoreCase("Yes")) {
						System.out.println("Motion passed by Vp");
					} else if (VpVote.equalsIgnoreCase("No")) {
						System.out.println(" motion failed by Vp ");
					} else
						System.out.println("invalid input from VP");
					try {
						Thread.sleep(3);
					} catch (Exception e) {
						// TODO: handle exception
					}
				}
			}
		}

	public void recordVote(Candidate vote) {
		synchronized (queuedVotes) {
			queuedVotes.add(vote);
		}
	}
		 
	}

