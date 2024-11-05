import java.util.Scanner;
public class priority{
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		int[] ct;
		int[] at;
		int x,n,i;
		int[] p;
		int[] pp;
		int[] bt;
		int[] tat;
		int[] wt;
		int k=0;
		double avgtat,avgwt;
		p= new int[10];
		at= new int[10];
		bt= new int[10];
		ct= new int[10];
		wt= new int[10];
		tat= new int[10];
		pp= new int[10];
		System.out.println("Enter Number of Processes : ");
		n=sc.nextInt();
		
		for(i=0;i<n;i++)
		{
			System.out.println("Process ["+(i+1)+"]: ");
			at[i]=sc.nextInt();
			bt[i]=sc.nextInt();
			pp[i]=sc.nextInt();
			p[i]=(i+1);
		}
		
		//sort on basis of arrival time and priority
		for(i=0;i<n-1;i++)
		{
			for(int j=i+1;j<n;j++)
			{
				if(at[i] > at[j] || pp[i] > pp[j])
				{
					x=pp[i];
					pp[i]=pp[j];
					pp[j]=x;
					x=bt[i];
					bt[i]=bt[j];
					bt[j]=x;
					x=at[i];
					at[i]=at[j];
					at[j]=x;
					x=p[i];
					p[i]=p[j];
					p[j]=x;
				}
			}
		}
		
		for(i=1;i<n;i++)
		{
			if(i==1)
			{
				k=bt[0];
				ct[0]=k;
			}
			else
			{
				k=bt[i-1]+k;
				ct[i-1]=k;
			}
			for(int j=i+1;j<n;j++)
			{
				if(pp[i]<pp[j] && at[j]<=k)
				{
					x=pp[i];
					pp[i]=pp[j];
					pp[j]=x;
					x=bt[i];
					bt[i]=bt[j];
					bt[j]=x;
					x=at[i];
					at[i]=at[j];
					at[j]=x;
					x=p[i];
					p[i]=p[j];
					p[j]=x;
				}
			}
		}
		wt[0]=0;
		avgwt=0;
		tat[0]=bt[0];
		avgtat=tat[0];
		for(i=1;i<n;i++)
		{
			tat[i]=ct[i]-at[i];
			wt[i]=tat[i]-bt[i];
			avgwt += wt[i];
			avgtat += tat[i];
		}
		System.out.println("\nProcess\tArrival\tBurst\tTurnAround\tWaiting\tpriority");
		for(i=0;i<n;i++)
		{
			System.out.println("\n"+p[i]+"\t"+at[i]+"\t"+bt[i]+"\t"+tat[i]+"\t"+wt[i]+"\t"+pp[i]);
		}
		avgwt/=n;
		avgtat/=n;
		System.out.println("\nAverage of Waiting Time : "+ avgwt);
		System.out.println("\nAverage of TurnAround Time : "+ avgtat);
	}
}
