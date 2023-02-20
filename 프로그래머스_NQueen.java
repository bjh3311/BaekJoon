import java.util.*;

public class 프로그래머스_NQueen {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(solution(4));
	}
	public static int[] arr;//arr[0]=0;이면 0번째행에 0번쨰열에 퀸을 놓았다는 뜻이다
	public static int N;
	public static int answer=0;
	public static int solution(int n)
	{
		arr=new int[n+1];
		N=n;
		NQueen(0);
		return answer;
	}
	public static void NQueen(int depth)
	{
		if(depth==N)
		{
			answer++;
			return;
		}
		for(int i=0;i<N;i++)
		{
			arr[depth]=i;
			if(possible(depth))
			{
				NQueen(depth+1);
			}
		}
	}
	public static boolean possible(int row)
	{
		for(int i=0;i<row;i++)
		{
			if(arr[i]==arr[row])
			{
				return false;
			}
			else if(Math.abs(row-i)==Math.abs(arr[row]-arr[i]))
			{
				return false;
			}
		}
		return true;
	}
}
