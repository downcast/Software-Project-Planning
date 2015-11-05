import java.util.ArrayList;

public class team{
	String teamName;
	ArrayList<String> members = new ArrayList<String>();
	
	//set/get team name
	void setName(String tname){
		teamName = tname;
	}
	String getName(){
		return teamName;
	}
	
	//set/get team members
	void setMembers(){
		
	}
	String getMembers(){
		String str = "";
		if(members.isEmpty()){
			str = "No Members";
		}
		else{
			for(int i = 0; i < members.size(); i++){
				String cur = members.get(i);
				str += (cur + ", ").toString();
			}
		}
		return str;
	}
}
