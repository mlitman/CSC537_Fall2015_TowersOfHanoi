import java.util.Scanner;


public class Game 
{
	private Tower[] theTowers;;
	private Scanner input;
	
	public Game(int numDisks, int numTowers)
	{
		this.theTowers = new Tower[numTowers];
		this.input = new Scanner(System.in);
		
		for(int i = 0; i < this.theTowers.length; i++)
		{
			this.theTowers[i] = new Tower("Tower " + i);
		}
		for(int i = numDisks; i > 0; i--)
		{
			this.theTowers[0].push(new Disk(i));
		}
	}
	
	public void display()
	{
		for(Tower t : this.theTowers)
		{
			t.display();
		}
		this.testWinner();
		System.out.print("Source: ");
		int theSource = Integer.parseInt(this.input.nextLine());
		System.out.print("Destination: ");
		int theDestination = Integer.parseInt(this.input.nextLine());
		this.makeMove(theSource, theDestination);
	}
	
	public void makeMove(int source, int dest)
	{
		Disk temp = this.theTowers[source].pop();
		Disk topOfDestTower = this.theTowers[dest].peek();
		if(topOfDestTower == null || topOfDestTower.getSize() > temp.getSize())
		{
			this.theTowers[dest].push(temp);
		}
		else
		{
			this.theTowers[source].push(temp);
		}
		this.display();
	}
	
	public void testWinner()
	{
		for(int i = 0; i < this.theTowers.length-1; i++)
		{
			if(this.theTowers[i].peek() != null)
			{
				return;
			}
		}
		System.out.println("WINNER!!!!!!!");
		System.exit(0);
	}
}
