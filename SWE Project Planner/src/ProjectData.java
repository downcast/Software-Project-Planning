import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class ProjectData implements Serializable{

	private static final long serialVersionUID = -3965839388062034258L;
	
	
	public void saveData(){
		//SpeechWriterObjHolder SWOH= new SpeechWriterObjHolder();
		//SpeechWriterObj sw= SWOH.getCurrentSpeechObj();

		try {
			File file= new File("c:\\TestFileName.xxx");
			ObjectOutputStream oos= new ObjectOutputStream(new FileOutputStream(file));
			project p = new project();
			p.setTitle("HEre is the title");
			oos.writeObject(p);
			oos.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e){
			e.printStackTrace();
		}
	}
	
	public void loadData(){
		ObjectInputStream input= null;

		File file= new File("c:\\TestFileName.xxx");
		
		// Confirm list if not empty
		if (file.list() != null){
			String [] listOfFileNames= new String[file.list().length];
			listOfFileNames= file.list();

			try {
				for (int i= 0; i < listOfFileNames.length; i++){
					FileInputStream fis= new FileInputStream(listOfFileNames[i]);
					input = new ObjectInputStream(fis);
					if (input!= null){
						try {
							System.out.println(((project)input.readObject()).getTitle());
						} catch (ClassNotFoundException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						input.close();
					}
				}
			} catch (IOException e1) {
			}
		}
	}
}
