/* FCFS- the logic is that we sort all process by arrival time */

import java.util.Scanner;
public class FCFS{
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the number of Processes : ");
		int n = sc.nextInt();
		int pid[] = new int[n];   //process ids
		int at[] = new int[n];    //arival time
		int bt[] = new int[n];    //brust or execution time
		int ct[] = new int[n];    //completion time
		int tat[] = new int[n];   //turn around time 
		int wt[] = new int[n];    //waiting time
		int temp;
		float avgwt=0, avgtat=0;
		
		for(int i=0;i<n;i++)
		{
			System.out.println("Enter Process "+(i+1)+" Arrival Time: ");
			at[i]=sc.nextInt();
			System.out.println("Enter Process "+(i+1)+" Brust Time: ");
			bt[i]=sc.nextInt();
			pid[i]=i+1;	
		}
		
		//sorting according to arrival time 
		for(int i=0;i<n;i++)
		{
			for(int j=0;j<n-(i+1);j++)
			{
				if(at[j] > at[j+1])
				{
					temp = at[j];
					at[j] = at[j+1];
					at[j+1] = temp;
					temp = bt[j];
					bt[j] = bt[j+1];
					bt[j+1] = temp;
					temp = pid[j];
					pid[j] = pid[j+1];
					pid[j+1] = temp;
					
				}
			}
		}
		
		//finding completion time 
		for(int i=0; i<n; i++)
		{
			if(i==0)
			{ ct[i]=at[i]+bt[i];}
			else
			{
				if(at[i] > ct[i-1])
				{ ct[i]=at[i]+bt[i];}
				else
				  ct[i]=ct[i-1]+bt[i];
			}
	                 tat[i]=ct[i]-at[i];
	                 wt[i]=tat[i]-bt[i];
	                 avgwt += wt[i];
	                 avgtat += tat[i];
		}
		System.out.println("\nPid\tArrival Time\tBurst Time\tCompletion Time\tTurn Around Time\tWaiting Time");
		for(int i=0; i<n; i++)
		{
			System.out.println(pid[i] + "\t" + at[i] + "\t" + bt[i] + "\t" + ct[i] + "\t" + tat[i] + "\t" + wt[i]);
		}
		sc.close();
		System.out.println("\nAverage of Turn Around Time (tat) : " + (avgtat/n));
		System.out.println("\nAverage of Waiting Time (wt) : " + (avgwt/n));		
	}
}





