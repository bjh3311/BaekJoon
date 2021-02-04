import java.util.Arrays;
import java.util.Scanner;
public class 백준_14888번 {
	public static int max=-1100000000;
	public static int min=1100000000;
	public static void calc(int plus,int minus,int mul,int div,int[] arr,int count,int result,int N)
	{	
		if(count==N)
		{
			if(result>max)
			{
				max=result;
			}
			if(result<min)
			{
				min=result;
			}
			return ;
		}
		if(plus>0)
		{
			int tmp_result=0;
			tmp_result=result+arr[count];
			calc(plus-1,minus,mul,div,arr,count+1,tmp_result,N);
		}
		if(minus>0)
		{
			int tmp_result=0;
			tmp_result=result-arr[count];
			calc(plus,minus-1,mul,div,arr,count+1,tmp_result,N);
		}
		if(mul>0)
		{
			int tmp_result=0;
			tmp_result=result*arr[count];
			calc(plus,minus,mul-1,div,arr,count+1,tmp_result,N);
		}
		if(div>0)
		{
			int tmp_result=0;
			tmp_result=result/arr[count];
			calc(plus,minus,mul,div-1,arr,count+1,tmp_result,N);
		}
		
		
	}
	public static void main(String[] args) {
		int N;//수의 개수
        Scanner scan=new Scanner(System.in);	    		// TODO Auto-generated method stub	
		N=scan.nextInt();
		int[] arr_temp=new int[N];//N개의 수 배열
		int[] Op=new int[4];//+,-,*,/의 개수
		for(int i=0;i<N;i++)
		{
			arr_temp[i]=scan.nextInt();
		}
		for(int i=0;i<4;i++)
		{
			Op[i]=scan.nextInt();
		}//정수 입력 및 연산자 개수 입력
		calc(Op[0],Op[1],Op[2],Op[3],arr_temp,1,arr_temp[0],N);
		System.out.println(max);
		System.out.println(min);
		
		

	}

}