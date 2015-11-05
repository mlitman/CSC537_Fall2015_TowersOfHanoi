
public class Tower 
{
	private Disk top;
	private int count;
	private String name;
	
	public Tower(String name)
	{
		this.top = null;
		this.name = name;
	}
	
	public void push(Disk d)
	{
		d.setNextDisk(this.top);
		this.top = d;
	}
	
	public Disk pop()
	{
		if(this.top == null)
		{
			return null;
		}
		Disk diskToReturn = this.top;
		this.top = this.top.getNextDisk();
		return diskToReturn;
	}
	
	public Disk peek()
	{
		return this.top;
	}
	
	public void display()
	{
		Disk currDisk = this.top;
		while(currDisk != null)
		{
			currDisk.display();
			currDisk = currDisk.getNextDisk();
		}
		System.out.println("____________________");
		System.out.println(this.name);
		System.out.println("\n\n");
	}
}
