import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.SequenceInputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;
import java.util.Properties;

public class combinefile
{

	public static void main(String[] args) throws IOException
	{
		ArrayList<FileInputStream> al = new ArrayList<FileInputStream>();
		Properties prop=new Properties();
		FileInputStream fiss=new FileInputStream("F:\\JAVA\\Learn\\IO\\0.Properties");
		prop.load(fiss);
		String filename=prop.getProperty("filename");
		int a=Integer.parseInt(prop.getProperty("count"));
		for(int i=0;i<=a;i++)
		{
			al.add(new FileInputStream(i+".part"));
		}
		Enumeration<FileInputStream> en=Collections.enumeration(al);
		SequenceInputStream sis=new SequenceInputStream(en);
		byte[] buf=new byte[1024*1024];
		int len=0;
		FileOutputStream fos=new FileOutputStream(filename);
		while((len=sis.read(buf))!=-1)
		{
			fos.write(buf, 0, len);
		}		
	}

}
