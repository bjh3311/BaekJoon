import java.util.*;
import java.io.*;
public class น้มุ_10775น๘ {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int G=Integer.parseInt(br.readLine());
		int P=Integer.parseInt(br.readLine());
		boolean[] avail=new boolean[G];
		int ans=0;
		boolean closure=true;
		for(int i=0;i<P;i++)
		{
			int a=Integer.parseInt(br.readLine());
			int loc=a;
			closure=true;
			for(int j=loc-1;j>=0;j--)
			{
				if(!avail[j])
				{
					closure=false;
					avail[j]=true;
					ans++;
					break;
				}
			}
			if(closure)
			{
				break;
			}
		}
		System.out.println(ans);
	}

}
