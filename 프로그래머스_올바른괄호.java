import java.util.*;

public class 프로그래머스_올바른괄호 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(solution(2));
		System.out.println(solution(3));

	}
	public static int count=0;
	public static int solution(int n)
	{
		count=0;
		dfs(0,0,n);
		return count;
	}
	public static void dfs(int left,int right,int n)
	{
		if(left<right)
		{
			return;
		}
		if(left>n||right>n)
		{
			return;
		}
		if(left==right&&right==n)
		{
			count++;
			return;
		}
		dfs(left+1,right,n);
		dfs(left,right+1,n);
	}

}
