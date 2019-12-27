package somePackage;

import java.io.IOException;
import java.util.Scanner;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.servlet.http.Part;

@ManagedBean
@ViewScoped
public class UploadBean {

    private int filesUploaded = 0;

    //javax.servlet.http.Part (Servlet 3.0 API)
    private Part file;
    private String fileContent;
    private String text="start";
    
    /**
     * Just prints out file content
     */
    public String upload() {
    	
    	 System.out.println("TEXT="+text);
    	 
        try {
            fileContent = new Scanner(file.getInputStream())
                    .useDelimiter("\\A").next();
            System.out.println(fileContent + " uploaded");
            filesUploaded++;
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        return "";
    }

    public int getFilesUploaded() {
        return filesUploaded;
    }

    public Part getFile() {
        return file;
    }

    public void setFile(Part file) {
        this.file = file;
    }

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}
}