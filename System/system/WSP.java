package system;
import java.io.*;

import users.*;


public class WSP {
	private static BufferedReader in;
    private static Data data;
    FileOutputStream fos;
	ObjectOutputStream oos;
	FileInputStream fis;
	ObjectInputStream ois; 
    public WSP() throws ClassNotFoundException, IOException {
    	data = Data.getInstance();
    	if (new File("data.out").exists()) {data = deserialize("data.out");}
    	in = new BufferedReader(new InputStreamReader(System.in));
    }
    public static Data getData() {
        return data;
    }
    public static String readFromConsole()   {
    	String read = "";
    	try {
    		read = in.readLine();
    	}
    	catch(IOException e) {
    		System.out.println("Unsupported format");
    	}
		return read; 	
    }
   
    public static boolean serialize(Data data, String fileName) throws IOException {
    	File file = new File(fileName);
    	if (!file.exists()) 
    		file.createNewFile();
        try(FileOutputStream fileStream = new FileOutputStream(fileName);
        ObjectOutputStream objectStream = new ObjectOutputStream(fileStream)) 
        {
            objectStream.writeObject(data);
        }catch(IOException e){
            System.out.println("Exception Occurred while Serializing");
            return false;
        }
        return true;
    }
    
    public static Data deserialize(String fileName) throws ClassNotFoundException {
        Data data = null;
        try(FileInputStream fileStream = new FileInputStream(fileName);
            ObjectInputStream objectStream = new ObjectInputStream(fileStream)) {
            data = (Data)objectStream.readObject();
        }catch(IOException e){
        	e.printStackTrace();
            System.out.println("Exception Occurred while Serializing");
        }
        return data;
    }
   
    	
    
    
}

