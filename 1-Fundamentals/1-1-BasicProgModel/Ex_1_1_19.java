
public class Ex_1_1_19
{
    public static long F(int N)
    {
        if (N == 0) return 0;
        if (N == 1) return 1;
        return F(N-1) + F(N-2);
    }
    
    public static long Fib(int N)
    {
    	/**
    	 * 创建一个数组，因为主方法中调用了 100 次，所以数组也创建了一百次
    	 * 之所以数组元素个数是 N+1，是因为主方法中，从 0 开始，0 到 n 一共 n+1 个。
    	 * 换个角度，传个 0 过来，也不可能就创建一个 0 个元素的数组。
    	 * 这个数组 N 号元素保存了 Fib(N) 的值，将数组传过去，减少重复计算。
    	 */
        long[] f = new long[N+1];
        
        return Fib(N, f);
    }

    public static long Fib(int N, long[] f)
    {
    	/**
    	 * 首先判断数组 N 号位的值是不是 0，不是就直接返回 f[N] 的值。
    	 * 因为不是 0 的话说明 N 的值计算过了，现在直接返回就完事了。（这一步就是减少重复计算的关键）
    	 * 假如 f[N] 等于 0，可能有两种情况，一种是：N 等于 0，f[N] 为 0。另一种情况是：N 还没有计算过。
    	 * 对于第一种情况，不用管，反正现在已经是对的了。
    	 * 对于第二种情况，又分为两种情况，一是 N 等于 1，二是 N 大于 1。
    	 * N 等于 1 则 f[N] = 1，这从原来的题目中可以看出。
    	 * N 大于 1 则 f[N] = Fib(N-1, f) + Fib(N-2, f)。这里与题目不同之处就是传了一个数组过去，这样一来，计算过的值就不会重复计算。
    	 * 2018年9月10日 17:11:51
    	 */
        if (f[N] == 0)
        {
            if (N == 1)
                f[N] = 1;
            else if (N > 1)
                f[N] = Fib(N-1, f) + Fib(N-2, f);
        }
        
        return f[N];
    }

    public static void main(String[] args)
    {
//        for (int N = 0; N < 100; N++)
//            StdOut.println(N + " " + F(N));
        for (int N = 0; N < 100; N++)
            StdOut.println(N + " " + Fib(N));
    }

}
