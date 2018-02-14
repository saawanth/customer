
public class Candidate {
	String candidateName;
	int candidateId; 
	String YesorNo;
	public Candidate(String candidateName,int candidateId,String YesorNo){
		this.candidateName=candidateName;
		this.candidateId=candidateId;
		this.YesorNo=YesorNo;
	}
	public String getVoterName() {
		return candidateName;
	}
	public void setVoterName(String candidateName) {
		this.candidateName = candidateName;
	}
	public int getVoterId() {
		return candidateId;
	}
	public void setVoterId(int candidateId) { 
		this.candidateId = candidateId ;
	}
	public String getYesorNo() {
		return YesorNo;
	}
	public void setYesorNo(String YesorNo) {
		this.YesorNo = YesorNo;
	}
	

}
