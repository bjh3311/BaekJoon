import java.util.*;
public class น้มุ_16953น๘ {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan=new Scanner(System.in);
		Long A=scan.nextLong();
		Long B=scan.nextLong();
		Queue<Long> q=new LinkedList<Long>();
		q.add(A);
		HashMap<Long,Integer> map=new HashMap<Long,Integer>();
		map.put(A, 0);
		while(!q.isEmpty())
		{
			long temp=q.poll();
			if(temp==B)
			{
				System.out.println(map.get(B)+1);
				System.exit(0);
			}
			if(temp*2<=B&&!map.containsKey(temp*2))
			{
				q.add(temp*2);
			    map.put(temp*2,map.get(temp)+1);
			}
		    if((temp*10)+1<=B&&!map.containsKey((temp*10)+1))
		    {
		    	q.add((temp*10)+1);
			    map.put(temp*10+1, map.get(temp)+1);
		    }		
		}
		System.out.println("-1");
	}
}