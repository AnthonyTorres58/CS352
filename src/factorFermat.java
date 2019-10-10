import java.math.BigInteger;
import java.security.SecureRandom;

public class factorFermat {
    private static SecureRandom rand = new SecureRandom();
    private static BigInteger zero = new BigInteger("0");
    private static BigInteger ferm(int n) {
        long power = (long) Math.pow(2, n);
        BigInteger one = new BigInteger("1");
        BigInteger a = new BigInteger("2");
        BigInteger b = a.pow((int) power);
        b = b.add(one);
        return b;
    }
    public static void bruteFerm(int n){
        BigInteger fermat = ferm(n); //ferm(n) just makes bigInt of [2^(2^n)+1].
        long square = (long) Math.sqrt(fermat.doubleValue());
        while ( fermat.mod(BigInteger.TWO).compareTo(zero) == 0){
            System.out.print(2 + " * ");
            fermat = fermat.divide(BigInteger.valueOf(2));
        }
        for (long i = 3; i<=square; i=i+2){
            while ( fermat.mod(new BigInteger(String.valueOf(i))).compareTo(zero) == 0){
                System.out.print(i + " * ");
                fermat = fermat.divide(BigInteger.valueOf(i));
            }
        }
        if ((fermat.longValue() ) > 2)      System.out.print(fermat);
    }
    //Need to generate random num's.
    //Need a function that generates "random" numbers, use f(x)= (x^2) + a mod N
    //make a with Math.Rand
    public static BigInteger pollardRho (BigInteger n)
    {
        /* div = 1;
        long x = 2,y = 2;
        if ((n%2)==0)   return 2;
        while (div == 1){
            x = f(x);
            y = f(f(y));
            div = gcd(Math.abs((x-y)), n);
        }
        if (div == n)   return 0;
        else    return div; */
        BigInteger div = BigInteger.ONE;
        BigInteger a =  BigInteger.TWO;
        BigInteger x =  BigInteger.TWO;
        BigInteger x2 = x;
        if (n.mod(BigInteger.TWO).compareTo(BigInteger.ZERO)==0)
            return BigInteger.TWO;
        while(div.compareTo(BigInteger.ONE)==0){
            x = f(x,a,n);
            x2 = f( f(x2,a,n), a, n);
            div = (x.subtract(x2).gcd(n));
        }
        return div;
    }
    public static BigInteger f(BigInteger x, BigInteger a, BigInteger n){
        //this is function f(x) = ( (x^2) + 1 )mod n
        return x.multiply(x).mod(n).add(a);
    }
    public static void factPollard(BigInteger num){
        //Factoring with Pollard rho algo.
        if (num.compareTo(BigInteger.ONE)==0) return;
        if (num.isProbablePrime(10)){
            System.out.println(num);
            return;
        }
        BigInteger div = pollardRho(num);
        factPollard(div);
        factPollard(num.divide(div));
    }
    public static void main(String[] args){
        factPollard(ferm(6));
    }
}
