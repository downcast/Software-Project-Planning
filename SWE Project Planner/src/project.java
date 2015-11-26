import java.awt.Component;
import java.util.ArrayList;
import java.util.Date;

public class project implements java.io.Serializable{
	String customer;
	String title;
	//ArrayList<person> stakeholders;
	String stakeholders;
	String description;
	schedule schedj;
	ArrayList<team> responsibleTeams = new ArrayList<team>();
	ArrayList<Component> nonFunRequirements = new ArrayList<>();
	ArrayList<Component> funRequirements = new ArrayList<>();
	String teamMembers;
	double estimatedCost;
	double actualCost;
	Date startDate;
	Date endDate;
	
	//set/get owner
	void setCustomer(String own){
		customer = own;
	}
	String getCustomer(){
		return customer;
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
	
	void setStakeholders(String stakeholders){
		this.stakeholders = stakeholders;
	}
	String getStakeholder(){
		return stakeholders;
	}
	
	public ArrayList<Component> getNonFunRequirements() {
		return nonFunRequirements;
	}
	public void setNonFunRequirements(ArrayList<Component> nonFunRequirements) {
		this.nonFunRequirements = nonFunRequirements;
	}
	
	public ArrayList<Component> getFunRequirements() {
		return funRequirements;
	}
	public void setFunRequirements(ArrayList<Component> funRequirements) {
		this.funRequirements = funRequirements;
	}
	
	void setTeamMembers(String teamMembers){
		this.teamMembers = teamMembers;
	}
	String getTeamMembers(){
		return teamMembers;
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
