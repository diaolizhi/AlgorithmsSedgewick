import java.util.Arrays;

/**
 * 2018��9��11�� 21:48:19
 * �����ʵ����������Ŀ
 * �͵����ǣ�ɾ��һ�������е��ظ�Ԫ�ء�
 * @author dlz
 *
 */

public class Ex_1_1_28_my {

	public static void main(String[] args) {
		int whiteList[] = { 7, 1, 5, 1, 9, 5, 7, 7, 5, 1, 9, 9, 9, 11, 11, 11, 11, 11, 11, 11, 11 };
		
		Arrays.sort(whiteList);
		
		int a[] = f(whiteList);

		show(a);
//		show(whiteList);
	}
	
	public static void show(int a[]) {
		for(int i=0; i<a.length; i++) {
			System.out.print(a[i] + " ");
		}
		System.out.println();
	}

	/**
	 * �������һλ��ʼ�������һλ����һλ�����ͬ��
	 * ��ô����һλ����һλ��ʼ��ÿһλ��ǰŲһλ���������һλ��Ϊ��һλ��ֵ -1
	 * �磺1 1 5 5 7 -> 1 5 5 7 0 -> 1 5 7 0 0
	 * ע��㣺�����ѭ����i ����ֵΪ len-remoNum-1��
	 * 2018��9��12�� 21:28:11
	 * @param whiteList
	 * @return
	 */
	public static int[] f(int whiteList[]) {
		
		int remoNum = 0;
		int newNum = 0;
		int len = whiteList.length-1;
		
		/**
		 * ��Ϊ����Ԫ����ǰ�ƶ����������һ��Ԫ��û�д������Ժ����Ԫ��ȫ���� 9
		 * 
		 */
		
		for(int i=0; i<len-remoNum; i++) {
			while(whiteList[i] == whiteList[i+1]) {
//				�������ȫ�� 9
				whiteList[len-remoNum] = whiteList[0]-1;
				
				for(int j=i+1; j<len-remoNum; j++) {
					whiteList[j] = whiteList[j+1];
				}
				remoNum++;
			}
			newNum++;
		}
		
		int newList[] = new int[newNum];
		
		for(int i=0; i<newNum; i++) {
			newList[i] = whiteList[i];
		}
		
		return newList;
	}
}
