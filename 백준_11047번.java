package 백준_11047번;
import java.util.Scanner;
public class 백준_11047번 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan=new Scanner(System.in);
        int N=scan.nextInt();
        int K=scan.nextInt();
        int[] arr=new int[N];
        for(int i=0;i<N;i++)
        {
        	arr[i]=scan.nextInt();
        }
        int count=0;
        int index=N;
        while(true)
        {
        	if(arr[index-1]<K)
        	{
        		K=K-arr[index-1];
        		count++;
        	}
        	else if(arr[index-1]==K)
        	{
        		count++;
        		break;
        	}
        	else
        	{
        		index=index-1;
        		
        	}
        }
        System.out.println(count);

	}

}
