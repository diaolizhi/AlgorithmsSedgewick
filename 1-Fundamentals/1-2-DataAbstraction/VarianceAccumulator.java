
// Exercise 1.2.18
public class VarianceAccumulator
{
//	ƽ��ֵ
    private double m;
//    ��
    private double s;
//    ����
    private int n;

    public void addDataValue(double x)
    {
        n++;
        s = s + 1.0 * (n-1) / n * (x - m) * (x - m);
        m = m + (x - m) / n;
    }

//    �������ݵ�ƽ��ֵ
    public double mean()
    {
        return m;
    }
    
//    ����
    public double var()
    {
        return s/(n - 1);
    }
    
//    ��׼��
    public double stddev()
    {
        return Math.sqrt(var());
    }

    public String toString()
    {
        return "Mean (" + n + " values): " + String.format("%7.5f", mean());
    }
    
    public static void main(String[] args)
    {
//    	�������л�ȡ���� n
//        int n = Integer.parseInt(args[0]);
    	
//    	ֱ������
    	int n = 10;
        
        VarianceAccumulator a = new VarianceAccumulator();
        
//        ����Ϊ n �����飬�����������ֱ�ӶԷ���ͱ�׼��
        double[] v = new double[n];
//        ͳ���ܺ�
        double total = 0;
        
        for (int i = 0; i < n; i++)
        {
//        	�������һ��С��
            double x = StdRandom.uniform();
//            ��������
            v[i] = x;
//            ���
            total += x;
//            ���� addDataValue �����
            a.addDataValue(x);
        }
        
//        ֱ����ƽ����
        double mean = total / n;
        
        double s = 0;
        
//        �󷽲�
//        ���ʽ��https://baike.baidu.com/item/%E6%96%B9%E5%B7%AE%E8%AE%A1%E7%AE%97%E5%85%AC%E5%BC%8F
        for (int i = 0; i < n; i++)
        {
            double d = v[i] - mean;
            s += d * d;
        }
        
//        ���׼��
        double stddev = Math.sqrt(s / (n-1));
        
//        �Ա����ַ�ʽ�ķ���ͱ�׼��
        StdOut.println(a.mean() - mean);
        StdOut.println(a.stddev() - stddev);
    }
}
