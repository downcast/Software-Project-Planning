import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class ProjectData{
	
	project p;
	
	ProjectData(){
		p = new project();
		p.setTitle("Here is the title");
	}
	
	public void saveData(){
		//SpeechWriterObjHolder SWOH= new SpeechWriterObjHolder();
		//SpeechWriterObj sw= SWOH.getCurrentSpeechObj();

		try {
			//File file = new File("Summer in New York");
			ObjectOutputStream oos= new ObjectOutputStream(new FileOutputStream((p.getTitle() + ".pjm").toString()));
			oos.writeObject(p);
			oos.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e){
			e.printStackTrace();
		}
	}
	
	public void loadData(){
		
		try{ 
			FileInputStream door = new FileInputStream((p.getTitle() + ".pjm").toString()); 
			ObjectInputStream reader = new ObjectInputStream(door);
			project x = new project();
			x = (project) reader.readObject(); 
			System.out.println(x.getTitle());
		}
		catch (IOException e){ 
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
