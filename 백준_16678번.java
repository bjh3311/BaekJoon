import java.util.*;
public class น้มุ_16678น๘ {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan=new Scanner(System.in);
		int N=scan.nextInt();
		int[] arr=new int[N];
		for(int i=0;i<N;i++)
		{
			arr[i]=scan.nextInt();
		}
		Arrays.sort(arr);
		long ans=0;
		ans+=arr[0]-1;
		arr[0]=1;
		for(int i=1;i<N;i++)
		{		
			if(arr[i]>arr[i-1])
			{
				ans+=arr[i]-(arr[i-1]+1);	
				arr[i]=arr[i-1]+1;
			}		
		}
		System.out.println(ans);
	}
}
