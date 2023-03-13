import java.util.*;
class Node implements Comparable<Node>
{
	String name;
	String head;
	int num;
	int idx;
	Node(String name,int idx)
	{
		this.name=name;
		int index=0;
		while(true)
		{
			if(name.charAt(index)>='0'&&name.charAt(index)<='9')
			{
				break;
			}
			index++;
		}
		this.head=name.substring(0,index);
		this.head=head.toLowerCase();
		String temp="";
		while(true)
		{
			temp=temp+name.charAt(index);
			index++;
			if(index>=name.length()||name.charAt(index)<'0'||name.charAt(index)>'9')
			{
				break;
			}
		}
		this.num=Integer.parseInt(temp);
		this.idx=idx;
	}
	public int compareTo(Node o)
	{
		if(head.equals(o.head))//head가 같으면
		{
			if(num==o.num)
			{
				return idx-o.idx;
			}
			else
			{
				return num-o.num;
			}
		}
		else
		{
			return head.compareTo(o.head);
		}
	}
}
public class 프로그래머스_파일명정렬 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] files= {"F-5 Freedom Fighter", "B-50 Superfortress",
				"A-10 Thunderbolt II", "F-14 Tomcat"};
		for(String temp : solution(files))
		{
			System.out.println(temp);
		}
	}
	public static String[] solution(String[] files) {
        PriorityQueue<Node> q=new PriorityQueue<Node>();
        ArrayList<String> arr=new ArrayList<String>();
        for(int i=0;i<files.length;i++)
        {
        	q.add(new Node(files[i],i));
        }
        while(!q.isEmpty())
        {
        	arr.add(q.poll().name);
        }
        String[] answer=arr.toArray(new String[arr.size()]);
        return answer;
    }
}
