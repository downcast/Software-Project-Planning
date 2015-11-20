import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class ProjectData{
	
	public void saveData(project p){

		try {
			ObjectOutputStream oos= new ObjectOutputStream(new FileOutputStream((p.getTitle() + ".xxxVirus").toString()));
			oos.writeObject(p);
			oos.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e){
			e.printStackTrace();
		}
	}
	
	public project loadData(String fileName){
		
		project x = new project();
		
		try{ 
			FileInputStream door = new FileInputStream(fileName); 
			ObjectInputStream reader = new ObjectInputStream(door);
			
			x = (project) reader.readObject();
		}
		catch (IOException e){ 
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return x;
	}
}
