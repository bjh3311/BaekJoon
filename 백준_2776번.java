import java.io.BufferedReader;
import java.io.*;
import java.util.HashMap;
public class น้มุ_2776น๘ {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int T=Integer.parseInt(br.readLine());
	    StringBuilder sb=new StringBuilder();
		for(int i=0;i<T;i++)
		{
			int N=Integer.parseInt(br.readLine());
			int[] arr=new int[N];
			String[] s=br.readLine().split(" ");
			HashMap<Integer,Integer>map1=new HashMap<Integer,Integer>();
			for(int j=0;j<N;j++)
			{
				if(map1.containsKey(Integer.parseInt(s[j])))
				{
					map1.put(Integer.parseInt(s[j]), map1.get(Integer.parseInt(s[j])+1));
				}
				else
				{
					map1.put(Integer.parseInt(s[j]), 1);
				}	
			}
			int M=Integer.parseInt(br.readLine());
			s=br.readLine().split(" ");
			for(int j=0;j<M;j++)
			{
				if(map1.containsKey(Integer.parseInt(s[j])))
				{
					sb.append("1\n");
				}
				else
				{
					sb.append("0\n");
				}
			}
			
		}
		System.out.print(sb.toString());		
		br.close();
	}

}
