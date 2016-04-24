package thread;
import java.util.concurrent.locks.*;	


class resource
{
	private int count=0;
	private boolean flag=false;
	final Lock lock=new ReentrantLock();
	final Condition con1=lock.newCondition();
	final Condition con2=lock.newCondition();
	public void product() throws InterruptedException
	{
		lock.lock();
		try
		{
			while(flag)
			{
				con1.await();
			}
			count++;
			System.out.println("food-product"+count);
			flag=true;
			con2.signal();
		}
		finally
		{
			lock.unlock();
		}
	}
	public void eat() throws InterruptedException
	{
		lock.lock();
		try
		{
			while(!flag)
			{
				con2.await();
			}
			System.out.println("food-eat"+count);
			flag=false;
			con1.signal();
		}
		finally
		{
			lock.unlock();
		}
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
			try{r.product();}catch(InterruptedException e){}
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
			try{r.eat();}catch(InterruptedException e){}
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

