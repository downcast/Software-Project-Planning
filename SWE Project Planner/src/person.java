import java.util.ArrayList;

public class person{
	
	String id;
	String name;
	String firstName;
	String lastName;
	String role;
	ArrayList<String> teams = new ArrayList<String>();
	ArrayList<String> skillset = new ArrayList<String>();
	ArrayList<String> projects = new ArrayList<String>();
	double hourlyRate;
	
	//set/get id
	void setID(String personId){
		id = personId;
	}
	String getID(){
		return id;
	}
	
	//set/get names
	void setFullName(String nombre){
		name = nombre;
	}
	String getFullName(){
		return name;
	}
	void setFirstName(String first){
		name = first;
	}
	String getFirstName(){
		return firstName;
	}
	void setLastName(String last){
		name = last;
	}
	String getLastName(){
		return lastName;
	}
	
	//set/get role
	void setRole(String position){
		role = position;
	}
	String getRole(){
		return role;
	}
	
	//show as member of team, add as member of team, remove member of team
	String showTeams(){
		String str = "";
		if(teams.isEmpty()){
			str = "Not on any Teams";
		}
		else{
			for(int i = 0; i < teams.size();i++){
				str += (teams.get(i) + ", ").toString();
			}
		}
		return str;
	}	
	void addToTeam(String onTeam){
		teams.add(onTeam);
	}	
	void removeFromTeam(String offTeam){
		for(int i = 0; i < teams.size(); i++){
			String cur = teams.get(i);
			if(cur.equalsIgnoreCase(offTeam)){
				teams.remove(i);
			}
		}
	}
	
	
	//show skillset, add skillset, remove skillset
	String showSkills(){
		String str = "";
		if(skillset.isEmpty()){
			str = "Not on any Teams";
		}
		else{
			for(int i = 0; i < skillset.size();i++){
				str += (skillset.get(i) + ", ").toString();
			}
		}
		return str;
	}	
	void addToSkills(String nextSkill){
		skillset.add(nextSkill);
	}	
	void removeFromSkills(String noSkillIn){
		for(int i = 0; i < skillset.size(); i++){
			String cur = skillset.get(i);
			if(cur.equalsIgnoreCase(noSkillIn)){
				skillset.remove(i);
			}
		}
	}
	
	//show as part of project, add project as part of responsibilities, remove project from responsibilities 
	String showProjects(){
		String str = "";
		if(projects.isEmpty()){
			str = "No current projects";
		}
		else{
			for(int i = 0; i < projects.size();i++){
				str += (projects.get(i) + ", ").toString();
			}
		}
		return str;
	}	
	void addToProjects(String proj){
		projects.add(proj);
	}	
	void removeFromProjects(String proj){
		for(int i = 0; i < projects.size(); i++){
			String cur = projects.get(i);
			if(cur.equalsIgnoreCase(proj)){
				projects.remove(i);
			}
		}
	}
	
	//set/get hourly rate
	void setRate(double hr){
		hourlyRate = hr;
	}
	double getRate(){
		return hourlyRate;
	}
	
}
