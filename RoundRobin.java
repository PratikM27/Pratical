import java.util.Scanner;
public class RR
{
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		int[] wtime;
		int[] rtime;
		int[] btime;
		int n,quantum;
		
		wtime= new int[10];
		rtime= new int[10];
		btime= new int[10];
		
		System.out.print("Enter the no. of Processes : ");
		n=sc.nextInt();
		for(int i=0;i<n;i++)
		{
			System.out.print("\nEnter the Burst time for Process P["+(i+1)+"] :");
			btime[i]=sc.nextInt();
			rtime[i]=btime[i];
			wtime[i]=0;
		}
		System.out.print("\n\nEnyer quantum : ");
		quantum=sc.nextInt();
		int rp=n;
		int i=0;
		int time=0;
		System.out.print('0');
		wtime[0]=0;
		
		while(rp!=0)
		{
			if(rtime[i]>quantum)
			{
				rtime[i]=rtime[i]-quantum;
				System.out.print(" |P["+(i+1)+"] |"+"\n");
				time+=quantum;
				System.out.print(time);
			}
			else if(rtime[i]<=quantum && rtime[i]>0)
			{
				time+=rtime[i];
				System.out.print(" |P["+(i+1)+"] |"+"\n");
				rp--;
				System.out.print(time);
			}
			i++;
			if(i==n)
			{i=0;}
		}
		System.out.println();
		
	}
}

