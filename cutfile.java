import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class cutfile
{

	public static void main(String[] args) throws IOException
	{
				File file = new File("F:\\JAVA\\Learn\\IO\\src\\0.bmp");
				FileOutputStream fiss=new FileOutputStream("F:\\JAVA\\Learn\\IO\\0.Properties"); 
				FileInputStream fis=new FileInputStream(file);
				Properties prop=new Properties();
				prop.setProperty("filename", file.getName());
			    byte[] buf=new byte[1024*1024];
			    FileOutputStream fos=null;
			    int count=0;
			    int ch=0;
			    while((ch=fis.read(buf))!=-1)
			    {
				   fos=new FileOutputStream((count++)+".part");
			   		fos.write(buf, 0, ch);
			   		fos.close();	
			    }
			    prop.setProperty("count", (count-1)+"");
			    prop.store(fiss, "");
	}
}
