import java.util.*;
import java.io.*;
class Info implements Comparable<Info>
{
	int attack;
	int dura;
	public Info(int attack,int dura)
	{
		this.attack=attack;
		this.dura=dura;
	}
	public int compareTo(Info o)
	{
		return attack-o.attack;
	}
}
public class 알고리즘_몬스터사냥 {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int Hp=Integer.parseInt(br.readLine());
		int N=Integer.parseInt(br.readLine());
		String[] s;
		Info[] info=new Info[N];
 		for(int i=0;i<N;i++)
		{
			s=br.readLine().split(" ");
			int a=Integer.parseInt(s[0]);
			int b=Integer.parseInt(s[1]);
			info[i]=new Info(a,b);
		}
 		for(int i=0;i<N;i++)//버블정렬
 		{
 			for(int j=0;j<N-i-1;j++)
 			{
 				if(info[j].attack<info[j+1].attack)
 				{
 					Info temp=info[j];
 					info[j]=info[j+1];
 					info[j+1]=temp;	
 				}
 			}
 		}
 		int count=0;
 		for(int i=0;i<N;i++)
 		{
 			while(info[i].dura>0)
 			{
 				if(info[i].dura==0)
 				{
 					break;
 				}
 				info[i].dura--;
 				Hp=Hp-info[i].attack;
 				count++;
 				if(Hp<=0)
 				{
 					break;
 				}
 			}
 			if(Hp<=0)
			{
 				System.out.println(count);
				break;
			}
 		}

	}
}
