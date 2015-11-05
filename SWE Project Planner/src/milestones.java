public class milestones{
	String name;
	boolean completed = false;
	String description;
	
	//set/get name
	void setName(String mName){
		name = mName;
	}
	String getName(){
		return name;
	}
	
	//set/get completion status
	void setStatus(boolean b){
		completed = b;
	}
	boolean getStatus(){
		return completed;
	}
	
	//set/get description
	void setDescription(String describe){
		description = describe;
	}
	String getDescription(){
		return description;
	}
}
