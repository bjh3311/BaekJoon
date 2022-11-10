import java.util.*;
import java.io.*;

class Node implements Comparable<Node>
{
	int index;
	int value;
	Node(int index,int value)
	{
		this.index=index;
		this.value=value;
	}
	public int compareTo(Node o1)//value가 높은 순서
	{
		return o1.value-value;
	}
}
public class 프로그래머스_베스트앨범 {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		String[] genres= {"classic","pop","classic","classic","pop"};
		int[] plays= {500,600,150,800,2500};
		for(int temp : solution(genres,plays))
		{
			System.out.print(temp+" ");
		}

	}
	public static int[] solution(String[] genres,int[] plays)
	{
		HashMap<String,Integer> map=new HashMap<String,Integer>();//맵에 각 장르와 장르재생횟수 저장
		for(int i=0;i<plays.length;i++)
		{
			if(map.containsKey(genres[i]))//해당 장르가 있는가
			{
				int value=map.get(genres[i])+plays[i];//해당하는 장르의 재생횟수
				map.put(genres[i], value);
			}
			else
			{
				map.put(genres[i], plays[i]);
			}
		}
		List<String> listKey=new ArrayList<>(map.keySet());
		Collections.sort(listKey,(value1,value2)->map.get(value2).compareTo(map.get(value1)));
		//listKey에는 가장 높은 value값을 가지고 있는 Key가 0부터 순서대로 들어가있다.
		List<Integer> result=new LinkedList<Integer>();
		
		for(String key : listKey)//최대 100
		{
			PriorityQueue<Node> q=new PriorityQueue<Node>();
			for(int i=0;i<genres.length;i++)//최대 1만
			{
				if(genres[i].equals(key))
				{
					q.add(new Node(i,plays[i]));
				}
			}
			result.add(q.poll().index);
			if(!q.isEmpty())//한 장르에 노래가 1개만 있을수도 있다
			{
				result.add(q.poll().index);
			}
		}
		int[] answer= new int[result.size()];
		for(int i=0;i<result.size();i++)
		{
			answer[i]=result.get(i);
		}
		return answer;
	}

}
