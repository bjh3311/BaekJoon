import java.util.*;
public class 프로그래머스_주차요금계산 {

	public static int[] car_num=new int[10000];//차량 번호에 따른 총 주차시간이 분으로 들어가있다.
	public static int[] solution(int[] fees,String[] records)
	{
		HashMap<Integer,String> map=new HashMap<Integer,String>();//입차해있는 차의 목록
		for(String temp : records)
		{
			String[] s=temp.split(" ");
			if(s[2].equals("IN"))//입차인 경우에
			{
				map.put(Integer.parseInt(s[1]),s[0]);//차량번호(KEY)에다가 시간String(value) 넣는다
			}
			else//출차인경우에
			{
				int index=Integer.parseInt(s[1]);//차량 번호
				String[] out_time=s[0].split(":");// 출차시간을 : 를 기준으로 시간과 분을 나눈다
				int out=0;
				out=out+Integer.parseInt(out_time[0])*60;
				out=out+Integer.parseInt(out_time[1]);//출차시간을 그냥 완전히 분으로만 나타낸다.
				String[] in_time=map.get(index).split(":");
				int in=0;
				in=in+Integer.parseInt(in_time[0])*60;
				in=in+Integer.parseInt(in_time[1]);
				car_num[index]=car_num[index]+(out-in);
				map.remove(index);
			}
		}
		if(map.size()!=0)//23:59분까지 안 나간 차는 강제로 내보내야 한다
		{
			Iterator<Integer> keys=map.keySet().iterator();
			while(keys.hasNext())
			{
				int key=keys.next();
				int out=0;
				out=out+(23*60)+59;
				String[] in_time=map.get(key).split(":");
				int in=0;
				in=in+Integer.parseInt(in_time[0])*60;
				in=in+Integer.parseInt(in_time[1]);
				car_num[key]=car_num[key]+(out-in);
				
			}
		}
		ArrayList<Integer> result=new ArrayList<Integer>();
		for(int i=0;i<10000;i++)
		{
			if(car_num[i]!=0)
			{
				result.add(car_num[i]);
			}
		}
		int[] answer=new int[result.size()];
		for(int i=0;i<result.size();i++)
		{
			int temp=result.get(i);
			if(temp<=fees[0])//기본시간보다 아래라면
			{
				answer[i]=fees[1];//기본요금만
			}
			else
			{
				answer[i]=fees[1];//우선 기본요금
				temp=temp-fees[0];//기본시간을 빼준다
				if(temp%fees[2]==0)
				{
					temp=temp/fees[2];
				}
				else
				{
					temp=temp/fees[2];
					temp++;
				}
				answer[i]=answer[i]+(temp*fees[3]);
			}
		}
		return answer;
	}
}
