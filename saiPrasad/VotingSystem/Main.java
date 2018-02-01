import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
	static Map<String, VotingTask> MotionNames=new HashMap<>();
	public static void main(String[] args) {
		while(true){
		 System.out.println("Enter 1 to introduce motion");
		 System.out.println("Enter 2 to vote on a motion");
		 System.out.println("Enter 3 to Vp vote");
		 Scanner sc= new Scanner(System.in);
		 int a=sc.nextInt();
		 
		 if(a==1){
			 System.out.println("Enter the motion name");
			 String motionName=sc.next();
			 System.out.println("Enter the Motion duration in minutes");
			 long duration=sc.nextLong();
			 long startTime=System.currentTimeMillis();
			 long endTime= (duration*60000)+ startTime;
			 VotingTask voting=new VotingTask(motionName, startTime,endTime);
			 Thread votingThread=new Thread(voting);
			 votingThread.setName(motionName);
			 votingThread.start();
			 MotionNames.put(votingThread.getName(),voting);
		 }else if(a==2){
			 System.out.println("Enter the name of motion to vote ");
			 String motionToVote=sc.next();
			 if(MotionNames.containsKey(motionToVote)){
				 VotingTask votingThread=MotionNames.get(motionToVote);
				 System.out.println("Voter Name");
				 String voterName=sc.next();
				 System.out.println("Voter id");
				 int voterId=sc.nextInt();
				 System.out.println("Yes or No");
				 String YesorNo=sc.next();
				 Candidate vote = new Candidate(voterName,voterId,YesorNo);
				 votingThread.recordVote(vote);
			 }else {
				 System.out.println("The motion is not passed");
			 }
		}else {
				 sc.close();
				 System.out.println("The motion is not present");
			 }
		 }
		

}
}
