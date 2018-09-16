/**
 * �� Ex_1_1_36_my �ж��� MyShuffle �ӿڣ�һ��ԭ����Ϊ��������������ٴ�ʹ�á�
 * �������Ҫ����д StdRandom �� shuffle ����
 * ��˵��������һ���������ȷ������Ӧ�ø� StdRandom.shuffle һ����
 * 2018��9��16�� 13:16:07
 * @author dlz
 *
 */

public class Ex_1_1_37_my {

	public static void main(String[] args) {
		
		int M = 10,
			N = 1000000;
		
		Ex_1_1_36_my.MyShuffle myShuffle = new Ex_1_1_36_my.MyShuffle() {
			
			@Override
			public void shuffle(int[] a) {
				for(int i=0; i<a.length; i++) {
					int r = StdRandom.uniform(M);    //�� 0~N-1 ֮�� 
					int temp = a[i];
					a[i] = a[r];
					a[r] = temp;
				}
			}
		};
		
		Ex_1_1_36_my.ShuffleTest(myShuffle, M, N);

	}

}
