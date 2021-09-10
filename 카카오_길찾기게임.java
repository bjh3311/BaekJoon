import java.util.*;
class Node implements Comparable<Node>
{
	int y;//y좌표
	int x;//x좌표
	int num;//노드 번호
	public Node(int y,int x,int num)
	{
		this.y=y;
		this.x=x;
		this.num=num;
	}
	Node left;//왼쪽 노드
	Node right;//오른쪽 노드
	public int compareTo(Node o)//y값이 클수록 큰 우선순위를 갖게 한다.
	{
		if(y==o.y)//y가 같다면 x를 비교
		{
			return o.x-x;
		}
		else//y를 비교
		{
			return o.y-y;
		}
	}
}
public class 카카오_길찾기게임 {

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
	public static void AddNode(Node parent,Node child)//알맞은 간선들을 이어준다
	{
		if(parent.x<child.x)//자식이 오른쪽에 있다면
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
	
	public static void preorder(Node parent)//전위 순회
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
	public static void postorder(Node parent)//후위순회
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
