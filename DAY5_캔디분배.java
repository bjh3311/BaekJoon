import java.util.*;
import java.io.*;
public class DAY5_캔디분배 {

	public static void main(String[] args) throws IOException	{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int T=Integer.parseInt(br.readLine());
		//(K*X)+1=C*y;
		//K는 인원수, X는 몇개씩 나눠주려는지
		//C는 한봉지에 몇개, y는 몇 봉지 사려는지
		//(-K*x)+C*y=1
		//k*(-x)+C*y=1로 변환
		while(T>0)
		{
			String[] s=br.readLine().split(" ");
			int K=Integer.parseInt(s[0]);
			int C=Integer.parseInt(s[1]);
			long x0,y0;
			EGResult result=extendedGcd(K,C);
			if(result.r!=1)//최대공약수가 1이어야 한다
			{
				System.out.println("IMPOSSIBLE");
			}
			else
			{
				x0=result.s;
				y0=result.t;
				long kFromY = (long) Math.ceil((double) y0 / (double) K) - 1;
                long kFromX = (long) Math.ceil((double) -x0 / (double) C) - 1;
                long k = Math.min(kFromX, kFromY);
                long kLimitFromY = (long) Math.ceil((y0 - 1e9) / (double) K);
                if (kLimitFromY <= k) 
                {
                    System.out.println(y0 - K * k);
                } else
                {
                    System.out.println("IMPOSSIBLE");
                }
            }
			T--;
		}
	}
	public static EGResult extendedGcd(long a,long b)//확장 유클리드호제법
	{
		long s0=1,t0=0,r0=a;
		long s1=0,t1=1,r1=b;
		long temp;
		while(r1!=0)
		{
			long q=r0/r1;
			
			temp=r0-q*r1;
			r0=r1;
			r1=temp;
			
			temp=s0-q*s1;
			s0=s1;
			s1=temp;
			
			temp=t0-q*t1;
			t0=t1;
			t1=temp;
		}
		return new EGResult(s0,t0,r0);
	}
}
class EGResult
{
	long s,t,r;
	public EGResult(long s,long t,long r)
	{
		this.s=s;
		this.t=t;
		this.r=r;
	}
}
