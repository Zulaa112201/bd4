package Dasgal25;

import java.util.*;

public class Solution {

    public static List<Integer> waiter(List<Integer> numbers, int q) {
        List<Integer> primes = generatePrimes(q);
        List<Integer> result = new ArrayList<>();
        Stack<Integer> A = new Stack<>();
        A.addAll(numbers);
        
        for (int i = 0; i < q; i++) {
            int prime = primes.get(i);
            Stack<Integer> newA = new Stack<>();
            Stack<Integer> B = new Stack<>();
            
            while (!A.isEmpty()) {
                int num = A.pop();
                if (num % prime == 0) {
                    B.push(num);
                } else {
                    newA.push(num);
                }
            }
            
            while (!B.isEmpty()) {
                result.add(B.pop());
            }
            
            A = newA;
        }
        
        while (!A.isEmpty()) {
            result.add(A.pop());
        }
        
        return result;
    }

    private static List<Integer> generatePrimes(int n) {
        List<Integer> primes = new ArrayList<>();
        if (n == 0) return primes;
        
        boolean[] isPrime = new boolean[10000]; // Adjust size as needed
        Arrays.fill(isPrime, true);
        isPrime[0] = isPrime[1] = false;
        
        for (int i = 2; i < isPrime.length; i++) {
            if (isPrime[i]) {
                primes.add(i);
                if (primes.size() == n) break;
                for (int j = i*i; j < isPrime.length; j += i) {
                    isPrime[j] = false;
                }
            }
        }
        
        return primes;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int q = scanner.nextInt();
        
        List<Integer> numbers = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            numbers.add(scanner.nextInt());
        }
        
        List<Integer> result = waiter(numbers, q);
        for (int num : result) {
            System.out.println(num);
        }
        
        scanner.close();
    }
}