import java.util.*;
import java.io.*;
public class ����_2075�� {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int N=Integer.parseInt(br.readLine());
		String[] s;
		PriorityQueue<Integer> q=new PriorityQueue<Integer>();
	    s=br.readLine().split(" ");
	   	for(int j=0;j<N;j++)
	   	{
	   		q.add(Integer.parseInt(s[j]));
	   	}
	    for(int i=1;i<N;i++)
	    {
	    	s=br.readLine().split(" ");
	    	for(int j=0;j<N;j++)
	    	{
	    		int a=Integer.parseInt(s[j]);
	    		if(q.peek()<a)//ū ���� �����
	    		{
	    			q.poll();
	    			q.add(a);
	    		}
	    	}
	    }
	    System.out.println(q.poll());
	}
}
