import java.util.Scanner;
import java.util.Random;
class game
{
	public static void main(String[] args) throws outException
	{	
		gamemain game=new gamemain();
		game.game();
	}
}
class gamemain
{
	public void game() throws outException
	{
			int min=0,max=100,num;
			Random random=new Random();
			int no=random.nextInt(101);
			System.out.println(no);
			System.out.println("������0-100������");
			Scanner input = new Scanner(System.in);
			num=input.nextInt();
			if(num<min || num>max)
				throw new outException("���ֳ�����Χ�ˣ�");		
		while(num != no)
		{
			if (no>num)
			{
				min=num;
			}
			else
			{
				max=num;
			}
			System.out.println("������"+min+"-"+max+"������");
			Scanner input1 = new Scanner(System.in);
			num=input1.nextInt();
			if(num<min || num>max)
				throw new outException("���ֳ�����Χ�ˣ�");
		}
		System.out.println("----end----");	
	}
}
class outException extends Exception
{
	outException()
	{
	}
	outException(String meg)
	{
		super(meg);
	}
}