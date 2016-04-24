class demo implements Runnable 
{	
	public void run() 
	{
		int i=1;				
		System.out.println(Thread.currentThread().getName()+"......."+i);
		
	}
}

class threaddemo 
{
	public static void main(String[] args) 
	{
		System.out.println("---This is a demo test---");
		demo d = new demo();
		Thread a = new Thread(d);
		a.setName("haha");
		Thread b = new Thread(d);
		b.setName("hehe");
		a.start();
		b.start();
		
		
	}
}
