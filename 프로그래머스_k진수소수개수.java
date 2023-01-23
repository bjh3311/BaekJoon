import java.util.*;
public class 프로그래머스_k진수소수개수 {

	public static void main(String[] args){
		// TODO Auto-generated method stub
		System.out.println(solution(437674,3));
	}
	public static int solution(int n, int k) {
		int result=0;
        String renew="";
        Stack<Integer> stack=new Stack<Integer>();
        while(n!=0)
        {
        	stack.add(n%k);
        	n=n/k;
        }
        while(!stack.isEmpty())
        {
        	renew=renew+stack.pop();
        }
        String[] arr=renew.split("0");
		for(String temp : arr)
		{
			if(temp.length()==0)
			{
				continue;
			}
			if(isPrime(Long.parseLong(temp)))
			{
				result++;
			}
		}
        return result;
    }
	public static boolean isPrime(long n)
	{
		if(n==1)
		{
			return false;
		}
		else if(n==2)
		{
			return true;
		}
		for(int i=2;i<=(int)Math.sqrt(n);i++)
		{
			if(n%i==0)
			{
				return false;
			}
		}
		return true;
	}
}
