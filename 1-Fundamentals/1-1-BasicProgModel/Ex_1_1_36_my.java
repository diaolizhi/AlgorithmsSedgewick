/**
 * �ȶ���һ����СΪ M ������ ms��������� N �Σ����� shuffle ������
 * ÿ�δ���֮ǰ ms[i]=i��
 * ����һ�� M*M �ı�� table��
 * table[i][j] ��ֵ��ʾ������ j �ڴ���֮�󣬳����ڵ� i λ�Ĵ�����
 * ���Դ���֮�󣬱������� ms��table[i][ms[i]]++��
 * ����˵��table ������һ�б�ʾ���ǡ�λ�á������ȥ��Ӧ���ǡ���ֵ����
 * ...˵�����
 * 2018��9��15�� 21:26:53
 * @author dlz
 *
 */

public class Ex_1_1_36_my {
	
	public interface MyShuffle{
		public void shuffle(int a[]);
	}
	
	public static void ShuffleTest(MyShuffle shuffle, int M, int N) {
//		 M * M ���
		int[][] table = new int[M][M];

//		��СΪ M ������
		int[] ms = new int[M];
		
//		���� N ��
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				ms[j] = j;
			}

			shuffle.shuffle(ms);

//			����Ϣ���� table ��
			for(int j=0; j<M; j++) {
				table[j][(int) ms[j]]++;
			}
		}
		
//		��ӡ���
		for(int i=0; i<M; i++) {
			for(int j=0; j<M; j++) {
				System.out.printf("%6d ", table[i][j]);
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {
		
		int M = 10,
			N = 1000000;

		MyShuffle shuffle = new MyShuffle() {
			
			@Override
			public void shuffle(int[] a) {
				StdRandom.shuffle(a);
			}
		};
		
		ShuffleTest(shuffle, M, N);
	}

}
