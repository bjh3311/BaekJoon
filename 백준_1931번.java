package ����_1931��;
import java.util.Scanner;
import java.util.Arrays;
import java.util.Comparator;
public class ����_1931�� {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
         Scanner scan=new Scanner(System.in);
         int N=scan.nextInt();
         int[][] arr=new int[N][2];
         int count=1;
         for(int i=0;i<N;i++)
         {
        	 for(int j=0;j<2;j++)
        	 {
        		 arr[i][j]=scan.nextInt();
        	 }
         }
         Arrays.sort(arr,new Comparator<int[]>() {
        	 public int compare(int[] o1,int[] o2)
        	 {
        		 if(o1[1]==o2[1])
        		 {
        			 return o1[0]-o2[0];
        		 }
        		 else
        		 {
        			 return o1[1]-o2[1];
        		 }
        	 }
         });//ȸ�ǽ� �ð��� ������ �ð��� �����ϴ� ������ �����Ͽ���.
         int end_time=arr[0][1];
         for(int i=1;i<N;i++)
         {
        	 if(end_time<=arr[i][0])
        	 {
        		 count++;
        		 end_time=arr[i][1];
        	 }
         }//ȸ�ǰ� �����ϴ� �ð��� ���õ� ������ �ð����� ũ�ٸ�
         System.out.println(count);
	}

}
