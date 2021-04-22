import java.util.*;
public class น้มุ_2512น๘ {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		int N=sc.nextInt();
		int[] arr=new int[N];
		for(int i=0;i<N;i++)
		{
			arr[i]=sc.nextInt();
		}
		Arrays.sort(arr);
		int M=sc.nextInt();
		int left=0;
		int right=arr[N-1];
		int answer=0;
		while(left<=right)
		{
			int mid=(left+right)/2;
			long sum=0;
			for(int money:arr)
			{
				if(money>=mid)
				{
					sum+=mid;
				}
				else
				{
					sum+=money;
				}
			}
			if(sum>M)
			{
				right=mid-1;
			}
			else
			{
				left=mid+1;
				answer=Math.max(answer, mid);
			}
		}
		System.out.println(answer);
		
		

	}

}
