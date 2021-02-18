import java.util.Scanner;
public class 백준_15965번 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan=new Scanner(System.in);		
		boolean[] prime=new boolean[10000001];//소수면 false,소수가 아니라면 true
		int[] result=new int[10000000];
		int index=1;
		for(int i=2;i<=10000000;i++)
		{
			if(!prime[i])
			{
				for(int j=i+i;j<=10000000;j=j+i)
				{
					prime[j]=true;
				}
				result[index]=i;
				index++;
			}				
		}
		int K=scan.nextInt();
		System.out.println(result[K]);	
	}

}
