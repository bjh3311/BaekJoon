import java.util.*;
import java.io.*;
public class DAY5_��ȣ���� {

	public static char[] P;
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		String[] s=br.readLine().split(" ");
		int K=Integer.parseInt(s[1]);
		boolean[] isPrime=new boolean[K+1];
		Arrays.fill(isPrime, true);
		isPrime[1]=false;//1�� �Ҽ��� �ƴϴ�
		ArrayList<Integer> primes=new ArrayList<Integer>();
		P=s[0].toCharArray();
		for(int i=2;i<=K;i++)
		{
			if(isPrime[i])//�Ҽ��ϰ��
			{
				primes.add(i);
				for(int j=2;i*j<=K;j++)
				{
					isPrime[i*j]=false;
				}
			}
		}
		for(int prime:primes)
		{
			if(prime>=K)
			{
				break;
			}
			if(checkIsBad(prime))
			{
				System.out.println("BAD"+" "+prime);
				return ;
			}
		}
		System.out.println("GOOD");
	
		
	}
	static boolean checkIsBad(int x)
	{
		int r=0;
		for(int i=0;i<P.length;i++)
		{
			r=(r*10+(P[i]-'0'))%x;
		}
		if(r==0)
		{
			return true;
		}
		else
		{
			return false;
		}
	}

}
