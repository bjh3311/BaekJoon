import java.util.*;
class Node implements Comparable<Node>
{
	int y;//y��ǥ
	int x;//x��ǥ
	int num;//��� ��ȣ
	public Node(int y,int x,int num)
	{
		this.y=y;
		this.x=x;
		this.num=num;
	}
	Node left;//���� ���
	Node right;//������ ���
	public int compareTo(Node o)//y���� Ŭ���� ū �켱������ ���� �Ѵ�.
	{
		if(y==o.y)//y�� ���ٸ� x�� ��
		{
			return o.x-x;
		}
		else//y�� ��
		{
			return o.y-y;
		}
	}
}
public class īī��_��ã����� {

	public static Queue<Integer> pre=new LinkedList<Integer>();
	public static Queue<Integer> post=new LinkedList<Integer>();
	public int[][] solution(int[][] nodeinfo)
	{
		int[][] answer= new int[2][nodeinfo.length];
		PriorityQueue<Node> q=new PriorityQueue<Node>();
		for(int i=0;i<nodeinfo.length;i++)
		{
			q.add(new Node(nodeinfo[i][1],nodeinfo[i][0],i+1));
		}
		Node root=q.poll();
		while(!q.isEmpty())
		{
			AddNode(root,q.poll());
		}
		preorder(root);
		postorder(root);
		int index=0;
		while(!pre.isEmpty())
		{

			answer[0][index++]=pre.poll();
		}
		index=0;
		while(!post.isEmpty())
		{
			answer[1][index++]=post.poll();
		}
		return answer;
	}
	public static void AddNode(Node parent,Node child)//�˸��� �������� �̾��ش�
	{
		if(parent.x<child.x)//�ڽ��� �����ʿ� �ִٸ�
		{
			if(parent.right==null)
			{
				parent.right=child;
			}
			else
			{
				AddNode(parent.right,child);
			}
		}
		else
		{
			if(parent.left==null)
			{
				parent.left=child;
			}
			else
			{
				AddNode(parent.left,child);
			}
		}
	}
	
	public static void preorder(Node parent)//���� ��ȸ
	{
		pre.add(parent.num);
		if(parent.left!=null)
		{
			preorder(parent.left);
		}
		if(parent.right!=null)
		{
			preorder(parent.right);
		}
	}
	public static void postorder(Node parent)//������ȸ
	{
		if(parent.left!=null)
		{
			postorder(parent.left);
		}
		if(parent.right!=null)
		{
			postorder(parent.right);
		}
		post.add(parent.num);
	}

}
