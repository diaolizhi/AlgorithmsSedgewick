
// Exercise 1.2.18
public class VarianceAccumulator
{
//	平均值
    private double m;
//    和
    private double s;
//    个数
    private int n;

    public void addDataValue(double x)
    {
        n++;
        s = s + 1.0 * (n-1) / n * (x - m) * (x - m);
        m = m + (x - m) / n;
    }

//    所有数据的平均值
    public double mean()
    {
        return m;
    }
    
//    方差
    public double var()
    {
        return s/(n - 1);
    }
    
//    标准差
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
//    	从命令行获取个数 n
//        int n = Integer.parseInt(args[0]);
    	
//    	直接设置
    	int n = 10;
        
        VarianceAccumulator a = new VarianceAccumulator();
        
//        个数为 n 的数组，这个数组用来直接对方差和标准差
        double[] v = new double[n];
//        统计总和
        double total = 0;
        
        for (int i = 0; i < n; i++)
        {
//        	随机生成一个小数
            double x = StdRandom.uniform();
//            放入数组
            v[i] = x;
//            添加
            total += x;
//            调用 addDataValue 来添加
            a.addDataValue(x);
        }
        
//        直接求平均数
        double mean = total / n;
        
        double s = 0;
        
//        求方差
//        方差公式：https://baike.baidu.com/item/%E6%96%B9%E5%B7%AE%E8%AE%A1%E7%AE%97%E5%85%AC%E5%BC%8F
        for (int i = 0; i < n; i++)
        {
            double d = v[i] - mean;
            s += d * d;
        }
        
//        求标准差
        double stddev = Math.sqrt(s / (n-1));
        
//        对比两种方式的方差和标准差
        StdOut.println(a.mean() - mean);
        StdOut.println(a.stddev() - stddev);
    }
}
