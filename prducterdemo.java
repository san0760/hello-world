class resource
{
	private int count=1;
	private boolean flag=false;
	public synchronized void product()
	{
		while(flag)
		{
			try{this.wait();}catch(InterruptedException e){}
		}
		count++;
		System.out.println("food-product"+count);
		flag=true;
		notifyAll();
	}
	public synchronized void eat()
	{
		while(!flag)
		{
			try{this.wait();}catch(InterruptedException e){} 
		}
		System.out.println("food-eat"+count);
		flag=false;
		notifyAll();
	}
}

class producter implements Runnable
{
	private resource r;
	producter(resource r)
	{
		this.r=r;
	}
	public void run()
	{
		while(true)
		{
			r.product();
		}
	}
}

class custmer implements Runnable
{
	private resource r;
	custmer(resource r)
	{
		this.r=r;
	}
	public void run()
	{
		while(true)
		{
			r.eat();
		}
	}
}

class  prducterdemo
{
	public static void main(String[] args) 
	{
		resource r=new resource();
		producter p=new producter(r);
		custmer c=new custmer(r);
		Thread t1=new Thread(p);
		Thread t2=new Thread(p);
		Thread t3=new Thread(c);
		Thread t4=new Thread(c);
		t1.start();
		t2.start();
		t3.start();
		t4.start();
	}
}
