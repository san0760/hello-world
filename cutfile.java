import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class cutfile
{

	public static void main(String[] args) throws IOException
	{
			File file = new File("F:\\JAVA\\Learn\\IO\\0.bmp");
		   FileInputStream fis=new FileInputStream(file);
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
	}
}