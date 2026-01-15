public class Primes {
    public static void main(String[ ] args){
        for (int i = 2; i <= 100; i++){
            if (isPrime(i)){
                System.out.println(i);
            }
        }
    }

    public static boolean isPrime(int n){
        double nSqrt = Math.sqrt(n);
        for (int i = 2; i < nSqrt; i++){
            if (n % i == 0){
                return false;
            }
        }
        return true;
    }
}
