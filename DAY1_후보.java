import java.util.*;
import java.io.*;
class Item implements Comparable<Item>
{
	int num;
	int count;
	int timeStamp;
	boolean isIn;
	public Item(int num,int count,int timeStamp,boolean isIn)
	{
		this.num=num;
		this.count=count;
		this.timeStamp=timeStamp;
		this.isIn=isIn;
	}
	@Override
	public int compareTo(Item o)
	{
		if(count==o.count)
		{
			return timeStamp-o.timeStamp;
		}
		else
		{
			return count-o.count;
		}
	}
}
public class DAY1_�ĺ� {

	static int N,K;
	static int[] inputs;
	static Item[] people;
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		N=Integer.parseInt(br.readLine());
		K=Integer.parseInt(br.readLine());
		people=new Item[101];
		List<Item> list=new ArrayList<>();
		String[] s=br.readLine().split(" ");
		for(int i=0;i<K;i++)
		{
			int temp=Integer.parseInt(s[i]);
			if(people[temp]==null)
			{
				people[temp]=new Item(temp,0,0,false);
			}
			if(people[temp].isIn==true)//�ȿ� �ִٸ�
			{
				people[temp].count++;
			}
			else//������ �ȿ� ���ٸ�
			{
				if(list.size()==N)
				{
					Collections.sort(list);
					Item p=list.remove(0);
					p.isIn=false;
				}
				people[temp].count=1;
				people[temp].isIn=true;
				people[temp].timeStamp=i;
				list.add(people[temp]);
			}
		}
		Collections.sort(list,new Comparator<Item>()
		{
			@Override
			public int compare(Item o1,Item o2)
			{
					return o1.num-o2.num;
			}
		});
		for(Item temp:list)
		{
			System.out.print(temp.num+" ");
		}
	}
}
