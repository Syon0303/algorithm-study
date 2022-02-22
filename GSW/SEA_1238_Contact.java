import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

class Node {
	int vertex; //정점
	int num = 0;//너비 단계 0으로 초기화, 이걸 이용해서 방문했던 정점인지 체크도 함
 	List<Integer> edge = new ArrayList<Integer>(); //해당정점과 연결된 정점 목록

	Node(int vertex) {
		this.vertex = vertex; //처음 노드 생성시 vertex입력
	}

	@Override
	public boolean equals(Object obj) { //Node배열에 해당 정점이 포함되어있는지 확인하기 위해 정점을 기준으로 equals연산 수행
		// TODO Auto-generated method stub
		Node temp = (Node) obj;
		return this.vertex == temp.vertex;
	}

}


public class Solution {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		// System.setIn(new FileInputStream("input.txt"));
		Scanner sc = new Scanner(System.in);
		// int testCase = sc.nextInt();

		for (int t = 1; t <= 10; t++) {
			////////////////////////////
			int N = sc.nextInt(); //간선의 수
			int start = sc.nextInt(); //시작지점
			List<Node> arr = new ArrayList<Node>(); //현재 그래프의 정점 저장용
			Queue<Integer> queue = new LinkedList<Integer>(); //bfs를 위한 큐

			for (int i = 0; i < N / 2; i++) {
				int vertex = sc.nextInt(); //from
				int edge = sc.nextInt();   //to
				Node newNode = new Node(vertex); //from정점 저장하기위해 
				Node newNode2 = new Node(edge);  // to 정점 저장하기 위해 to노드에서 뻗어나가는 간선이 없어도 마지막 연락받은 정점을 찾기 위해 다 넣어줌

				if (arr.contains(newNode)) { //equals를 vertex기준으로 바꿨기 때문에 contains그대로 사용
					arr.get(arr.indexOf(newNode)).edge.add(edge); //만약 현재 from정점이 이미 리스트에 있으면 뻗어나갈 다음 정점만 저장
				} else {
					newNode.edge.add(edge); //리스트에 없으면 다음 정점 저장 후
					arr.add(newNode); //리스트에 추가
				}
				if (!arr.contains(newNode2)) //만약 to 정점이 리스트에 없으면
					arr.add(newNode2); //리스트에 추가
			}

			Node temp = new Node(start); // 시작노드의 인덱스를 찾기위한 임시노드 생성
			int current;
			queue.offer(start); //시작정점을 큐에 넣음
			arr.get(arr.indexOf(temp)).num = 1; //시작정점의 num을 1로설정

			while (queue.size() != 0) {

				temp = new Node(queue.poll()); //이번에 탐색할 정점 vertex poll이후 해당 vertex를 가진 임시노드 생성

				current = arr.indexOf(temp); //리스트에서 현재 노드의 인덱스 찾기
				for (int i = 0; i < arr.get(current).edge.size(); i++) { //현재노드에서 뻗어나가는 정점 탐색
					int index = arr.indexOf(new Node(arr.get(current).edge.get(i))); //뻗어나가는 정점이 리스트에서 몇번째 있는지 찾기 
					if (arr.get(index).num == 0) { //연결노드의 num이 0이면 한번도 방문하지 않은것
						arr.get(index).num = arr.get(current).num + 1; //현재노드의 num+1 값을 연결노드에 저장
						queue.offer(arr.get(current).edge.get(i)); //연결노드의 vertex를 큐에 저장

					}
				}

			}
			int res = Collections.max(arr, new Comparator<Node>() { //노드들 중 가장 마지막에 방문하는 노드 찾기
				@Override
				public int compare(Node o1, Node o2) {
					int flag = o1.num - o2.num; //먼저 num을 이용해 비교 num이 클수록 늦게 방문함 
					if (flag == 0) { //num 이 같으면 같은 시간에 연락받았다는 뜻
						flag = o1.vertex - o2.vertex; //같은시간에 연락받은 노드중에 vertex값이 클수록 늦게 받은걸로 생각 
					}
					return flag;
				}

			}).vertex; //가장 큰  num 중에서 가장 큰 vertex값
			System.out.printf("#%d %d\n",t,res);
			///////////////////////
		}

	}
}
