import java.util.*;
import java.io.*;
public class น้มุ_6198น๘ {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int N=Integer.parseInt(br.readLine());
		Stack<Integer> s=new Stack<Integer>();
		long res=0;
		int a=Integer.parseInt(br.readLine());
		s.push(a);
		for(int i=1;i<N;i++)
		{
			a=Integer.parseInt(br.readLine());
			if(s.peek()>a)
			{
				res+=s.size();
				s.push(a);
			}
			else
			{
				while(s.size()!=0)
				{
					if(s.peek()<=a)
					{
						s.pop();
					}
					else
					{
						break;
					}
				}
				res+=s.size();
				s.push(a);
			}
		}
		System.out.println(res);
	}
}
