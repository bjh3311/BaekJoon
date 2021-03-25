import java.util.*;
import java.io.*;
public class 백준_13904번 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan=new Scanner(System.in);
		int N=scan.nextInt();
		int[][] arr=new int[N][2];
		int[] score=new int[1001];
		for(int i=0;i<N;i++)
		{
			arr[i][0]=scan.nextInt();
			arr[i][1]=scan.nextInt();
		}
		Arrays.sort(arr,new Comparator<int[]>() {
			public int compare(int[] o1,int[] o2)
			{
				if(o2[1]==o1[1])
				{
					return o2[0]-o1[0];
				}
				else
				{
					return o2[1]-o1[1];
				}
			}
		});//점수순으로 정렬
		for(int i=0;i<N;i++)
		{
			for(int j=arr[i][0];j>=1;j--)
			{
				if(score[j]==0)
				{
					score[j]=arr[i][1];
					break;
				}
			}
		}
		int sum=0;
		for(int i=0;i<=1000;i++)
		{
			sum+=score[i];
		}
		System.out.println(sum);

	}

}
