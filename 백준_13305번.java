package 백준_13305번;
import java.util.Scanner;
public class 백준_13305번 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	       Scanner scan=new Scanner(System.in);
	       int N=scan.nextInt();
	       long[] length=new long[N-1];
	       long[] price=new long[N];
	       for(int i=0;i<N-1;i++)
	       {
	    	   length[i]=scan.nextLong();
	       }
	       for(int i=0;i<N-1;i++)
	       {
	    	   price[i]=scan.nextLong();
	       }
	       long min_price=price[0];
	       long sum=price[0]*length[0];
	       for(int i=1;i<N-1;i++)
	       {
	    	   if(min_price<=price[i])
	    	   {
	    		   sum+=min_price*length[i];
	    	   }
	    	   else if(min_price>price[i])
	    	   {
	    		   sum+=length[i]*price[i];
	    		   min_price=price[i];
	    	   }
	       }
	       System.out.println(sum);
	       
	       

	}

}
