import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.SequenceInputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;

public class combinefile
{

	public static void main(String[] args) throws IOException
	{
		ArrayList<FileInputStream> al = new ArrayList<FileInputStream>();
		for(int i=0;i<=3;i++)
		{
			al.add(new FileInputStream(i+".part"));
		}
		Enumeration<FileInputStream> en=Collections.enumeration(al);
		SequenceInputStream sis=new SequenceInputStream(en);
		byte[] buf=new byte[1024*1024];
		int len=0;
		FileOutputStream fos=new FileOutputStream("1.bmp");
		while((len=sis.read(buf))!=-1)
		{
			fos.write(buf, 0, len);
		}		
	}

}
