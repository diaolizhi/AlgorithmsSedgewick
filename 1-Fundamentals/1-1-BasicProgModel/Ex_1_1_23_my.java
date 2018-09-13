/**
 * ���㷨 ���İ桷�� 1.1.23 ��
 * ������һ����Ŀ�Ĵ��룬�ж���Ŀ����˼�ǣ�
 * ���û����� + ���� -��
 * Ȼ��������һ�����֣�����Щ����Ϊ����������
 * ���������ǣ�+�����ӡ��Ԥ��׼���õ������в��ڡ�����������ֵ������Ԥ��׼���������У�22��33��������ֻ�У�33�����ӡ 22��
 * ���������ǣ�-�����ӡ�� 22��
 * 
 * Ϊ�˼򵥣��������ݶ��Ѿ�д����
 * @author dlz
 *
 */
public class Ex_1_1_23_my {

	public static void main(String[] args) {

		int a[] = {1, 2, 3, 4, 5, 7, 9, 10, 11, 22, 33, 44};
		int b[] = {4, 5, 6, 33};

//		char arg = '-';
		char arg = '+';
		
		for(int i=0; i<a.length; i++) {
			rank(a[i], b, arg);
		}

	}

	public static void rank(int key, int a[], char arg) {
		
		int res = rank(key, a, 0, a.length-1);
		
		if (res == -1 && arg == '+') {
			System.out.println(key);
		} else if(res != -1 && arg == '-') {
			System.out.println(key);
		}
	}
	
	public static int rank(int key, int a[], int lo, int hi) {
		if(lo > hi) {
			return -1;
		}

		int pos = (hi + lo) / 2;
		int mid = a[pos];
		
		if(key < mid) {
			return rank(key, a, lo, pos-1);
		} else if(key > mid) {
			return rank(key, a, pos+1, hi);
		} else {
			return pos;
		}
	}

}
