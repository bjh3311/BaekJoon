import java.util.*;
import java.io.*;
class loc
{
	int y;
	int x;
	public loc(int y,int x)
	{
		this.y=y;
		this.x=x;
	}
}
public class 카카오_키패드누르기 {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int N=Integer.parseInt(br.readLine());
		String[] s=br.readLine().split(" ");
		int[] numbers=new int[N];
		for(int i=0;i<N;i++)
		{
			numbers[i]=Integer.parseInt(s[i]);
		}
		String hand=br.readLine();
		System.out.println(solution(numbers,hand));
	}
	public static String solution(int[] numbers,String hand)
	{
		Queue<loc> left=new LinkedList<loc>();
		Queue<loc> right=new LinkedList<loc>();
		StringBuilder sb=new StringBuilder();
		left.add(new loc(3,0));
		right.add(new loc(3,2));
		for(int i=0;i<numbers.length;i++)
		{
			if(numbers[i]==1||numbers[i]==4||numbers[i]==7)
			{
				sb.append("L");
				left.poll();
				if(numbers[i]==1)
				{
					left.add(new loc(0,0));
				}
				else if(numbers[i]==4)
				{
					left.add(new loc(1,0));
				}
				else
				{
					left.add(new loc(2,0));
				}
			}
			else if(numbers[i]==3||numbers[i]==6||numbers[i]==9)
			{
				sb.append("R");
				right.poll();
				if(numbers[i]==3)
				{
					right.add(new loc(0,2));
				}
				else if(numbers[i]==6)
				{
					right.add(new loc(1,2));
				}
				else
				{
					right.add(new loc(2,2));
				}
			}
			else
			{
				if(numbers[i]==2)
				{
					if(Math.abs(0-left.peek().y)+Math.abs(1-left.peek().x)>Math.abs(0-right.peek().y)+Math.abs(1-right.peek().x))
					{
						sb.append("R");
						right.poll();
						right.add(new loc(0,1));
					}
					else if(Math.abs(0-left.peek().y)+Math.abs(1-left.peek().x)<Math.abs(0-right.peek().y)+Math.abs(1-right.peek().x))
					{
						sb.append("L");
						left.poll();
						left.add(new loc(0,1));
					}
					else
					{
						if(hand.equals("right"))
						{
							sb.append("R");
							right.poll();
							right.add(new loc(0,1));
						}
						else
						{
							sb.append("L");
							left.poll();
							left.add(new loc(0,1));
						}
					}
				}
				else if(numbers[i]==5)
				{
					if(Math.abs(1-left.peek().y)+Math.abs(1-left.peek().x)>Math.abs(1-right.peek().y)+Math.abs(1-right.peek().x))
					{
						sb.append("R");
						right.poll();
						right.add(new loc(1,1));
					}
					else if(Math.abs(1-left.peek().y)+Math.abs(1-left.peek().x)<Math.abs(1-right.peek().y)+Math.abs(1-right.peek().x))
					{
						sb.append("L");
						left.poll();
						left.add(new loc(1,1));
					}
					else
					{
						if(hand.equals("right"))
						{
							sb.append("R");
							right.poll();
							right.add(new loc(1,1));
						}
						else
						{
							sb.append("L");
							left.poll();
							left.add(new loc(1,1));
						}
					}
				}
				else if(numbers[i]==8)
				{
					if(Math.abs(2-left.peek().y)+Math.abs(1-left.peek().x)>Math.abs(2-right.peek().y)+Math.abs(1-right.peek().x))
					{
						sb.append("R");
						right.poll();
						right.add(new loc(2,1));
					}
					else if(Math.abs(2-left.peek().y)+Math.abs(1-left.peek().x)<Math.abs(2-right.peek().y)+Math.abs(1-right.peek().x))
					{
						sb.append("L");
						left.poll();
						left.add(new loc(2,1));
					}
					else
					{
						if(hand.equals("right"))
						{
							sb.append("R");
							right.poll();
							right.add(new loc(2,1));
						}
						else
						{
							sb.append("L");
							left.poll();
							left.add(new loc(2,1));
						}
					}
				}
				else
				{
					if(Math.abs(3-left.peek().y)+Math.abs(1-left.peek().x)>Math.abs(3-right.peek().y)+Math.abs(1-right.peek().x))
					{
						sb.append("R");
						right.poll();
						right.add(new loc(3,1));
					}
					else if(Math.abs(3-left.peek().y)+Math.abs(1-left.peek().x)<Math.abs(3-right.peek().y)+Math.abs(1-right.peek().x))
					{
						sb.append("L");
						left.poll();
						left.add(new loc(3,1));
					}
					else
					{
						if(hand.equals("right"))
						{
							sb.append("R");
							right.poll();
							right.add(new loc(3,1));
						}
						else
						{
							sb.append("L");
							left.poll();
							left.add(new loc(3,1));
						}
					}
				}
			}
				
		}
		return sb.toString();
	}

}
