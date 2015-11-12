import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

public class project implements Serializable{
	
	private static final long serialVersionUID = -3965839388062034258L;
	
	String owner;
	String title;
	String description;
	schedule schedj;
	ArrayList<team> responsibleTeams = new ArrayList<team>();
	double estimatedCost;
	double actualCost;
	Date startDate;
	Date endDate;
	
	//set/get owner
	void setOwner(String own){
		owner = own;
	}
	String getOwner(){
		return owner;
	}
	
	//set/get project title
	void setTitle(String pt){
		title = pt;
	}
	String getTitle(){
		return title;
	}
	
	//set/get description
	void setDescription(String describe){
		description = describe;
	}
	String getDescription(){
		return description;
	}
	
	//set/get schedule
	//...
	
	//set/get teams
	void setTeams(team tname){
		responsibleTeams.add(tname);
	}
	String getTeams(){
		String str = ("Teams: " + "\n");
		for(int i = 0; i < responsibleTeams.size(); i++){
			str += responsibleTeams.get(i).getName() + ", Members: " + responsibleTeams.get(i).getMembers() + "\n";
		}		
		return str;
	}
	
	//set/get estimated cost
	void setEstimatedCost(double ec){
		estimatedCost = ec;
	}
	double getEstimatedCost(){
		return estimatedCost;
	}
	
	//set/get actual cost
	void setActualCost(double ac){
		actualCost = ac;
	}
	double getActualCost(){
		return actualCost;
	}
	
	//set/get start date
	
	
	//set/get end date
	
}
