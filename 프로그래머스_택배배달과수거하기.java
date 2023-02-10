public class 프로그래머스_택배배달과수거하기 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] deliveries= {1,0,3,1,2};
		int[] pickups= {0,3,0,4,0};
		System.out.println(solution(4,5,deliveries,pickups));
	}
	 public static long solution(int cap, int n, int[] deliveries, int[] pickups) 
	 {
	        long answer = 0;
	        long cnt=0;
	        long give=0;
	        long get=0;
	        for(int i=n-1;i>=0;i--)
	        {
	        	cnt=0;
	        	while(give<deliveries[i]||get<pickups[i])//둘다 넘어야 한다
	        	{
	        		cnt++;
	        		give=give+cap;
	        		get=get+cap;
	        	}
	        	give=give-deliveries[i];
	        	get=get-pickups[i];
	        	answer=answer+((i+1)*cnt*2);
	        }
	        return answer;
	 }
}
