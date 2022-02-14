import java.io.IOException;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		int height = sc.nextInt();
		int width = sc.nextInt();
		int N = sc.nextInt();
		int max = Math.max(height, width);
		int  arr[][] =new int[max][max];//3,4번처럼 90도로 회전하면 가로,세로 길이가 서로 바뀌기 때문에 둘중 더 큰 값으로 배열 생성
		int temp[][] = new int[max][max];//배열 이동 저장용
		for(int i=0;i<height;i++) {
			for(int j=0;j<width;j++) {
				arr[i][j] = sc.nextInt();
			}
		}
		int temp1;
		for(int i=0;i<N;i++) {
			switch(sc.nextInt()){
			case 1://상하반전
				for(int j=0;j<height;j++) {
					for(int k=0;k<width;k++) {
						temp[j][k] = arr[height-1-j][k];
					}
				}
				for(int j=0;j<height;j++) {
					arr[j]=Arrays.copyOf(temp[j],width );
				}
				
				break;
				
			case 2://좌우반전
				for(int j=0;j<height;j++) {
					for(int k=0;k<width;k++) {
						temp[j][k] = arr[j][width-k-1];
					}
				}
				for(int j=0;j<height;j++) {
					arr[j]=Arrays.copyOf(temp[j],width );
				}
				break;
				
			case 3://오른쪽 90도회전
				for(int j=0;j<height;j++) {
					for(int k=0;k<width;k++) {
						temp[k][j] = arr[height-1-j][k];
					}
				}
				temp1 = height;
				height = width;
				width = temp1;
				for(int j=0;j<height;j++) {
					arr[j]=Arrays.copyOf(temp[j],width );
				}
				break;
				
			case 4: //왼쪽90도회전
				for(int j=0;j<height;j++) {
					for(int k=0;k<width;k++) {
						temp[k][j] = arr[j][width-1-k];
					}
				}
				temp1 = height;
				height = width;
				width = temp1;
				for(int j=0;j<height;j++) {
					arr[j]=Arrays.copyOf(temp[j],width );
				}
				break;
				
			case 5://1,2,3,4 시계방향이동
				for(int j=0;j<height/2;j++) {//1->2
					for(int k=0;k<width/2;k++) {
						temp[j][k+width/2] = arr[j][k];
					}
				}
				
				for(int j=0;j<height/2;j++) {//2->3
					for(int k=width/2;k<width;k++) {
						temp[j+height/2][k] = arr[j][k];
					}
				}
				
				for(int j=height/2;j<height;j++) {//3->4
					for(int k=width/2;k<width;k++) {
						temp[j][k-width/2] = arr[j][k];
					}
				}
				for(int j=height/2;j<height;j++) {//4->1
					for(int k=0;k<width/2;k++) {
						temp[j-height/2][k] = arr[j][k];
					}
				}
				for(int j=0;j<height;j++) {
					arr[j]=Arrays.copyOf(temp[j],width );
				}
				break;
				
			case 6://1,2,3,4, 반시계이동
				for(int j=0;j<height/2;j++) {//1->4
					for(int k=0;k<width/2;k++) {
						temp[j+height/2][k] = arr[j][k];
					}
				}
				
				for(int j=0;j<height/2;j++) {//2->1
					for(int k=width/2;k<width;k++) {
						temp[j][k-width/2] = arr[j][k];
					}
				}
				
				for(int j=height/2;j<height;j++) {//3->2
					for(int k=width/2;k<width;k++) {
						temp[j-height/2][k] = arr[j][k];
					}
				}
				for(int j=height/2;j<height;j++) {//4->3
					for(int k=0;k<width/2;k++) {
						temp[j][k+width/2] = arr[j][k];
					}
				}
				for(int j=0;j<height;j++) {
					arr[j]=Arrays.copyOf(temp[j],width );
				}
				break;
			}	
		}
		
		for(int i=0;i<height;i++) {
			for(int j=0;j<width;j++) {
				System.out.print(arr[i][j]+" ");
			}
			System.out.println();
		}
		
		
	}

}
