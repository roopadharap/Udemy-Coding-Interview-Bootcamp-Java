/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prjmsprep;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author roopa
 */
public class UdemyCourse1 {

    /**
     * @param args the command line arguments
     */
    
    public static void main(String[] args) {
        // TODO code application logic here
        //System.out.println("Hello World");
        UdemyCourse1 pm = new UdemyCourse1();
        
        /*Number to Words
        String res = pm.numberToWords(200);
        System.out.println(res); */
        
        /* Reverse a String 
        String res = pm.reverseString("Roopa");
        System.out.println(res); */
        
        /* Check Palindrome Anagram
        boolean bool = pm.checkPalindromeAnagram("papa");
        if(bool) System.out.println("String is Palindrome"); 
            else System.out.println("String is NOT Palindrome"); */
        
        
        /* Check Palindrome 
        boolean bool = pm.checkPalindrome("");
        if(bool) System.out.println("String is Palindrome"); 
            else System.out.println("String is NOT Palindrome"); */
        
        /* Reverse an Int 
        int res = pm.reverseInteger(1333333333);
        System.out.println(res); */
        
        /* Return character with max repetitions in a string 
        char res = pm.maxChar("aabbbccaadbbcccc", false);
        System.out.println(res); */
        
        /* Fizz Buzz 
        pm.fizzBuzz(20); */
        
        /* divide array in chunks and add to list 
        pm.arrChunk(new int[]{1,2,3,4,5,6,7,8,9,10,11,12,13}, 4); */
        
        /* check if 2 strings are anagrams 
        boolean res = pm.checkAnagram("r !oo pa","A?oppo  r");
        if(res) System.out.println("Strings are Anagram"); 
            else System.out.println("String are NOT Anagrams");  */ 
        
        /* Capitalize each word in a sentense 
        String res = pm.capitalizeWords("happy birthday to you, roopa");
        System.out.println(res); */
        
        /* Create steps using # character for the number passed to function
        pm.createSteps(5);
        pm.createStepsRecur(5); */
        
        /* Create pyramid using # character for the number passed to function
        pm.createPyramid(5);   */
        
        /* Return number of vowels in a string 
        int res = pm.getVowels("hi there");
        System.out.println(res);   */
        
        /* Accept n and return nxn spiral matrix
        pm.spiralMatrix(4);   */
        
        /* Fibonacci Recursive and iterative 
        int n = 5;
        for(int i=0; i<=n; i++)
            System.out.println(pm.fibonacci(i)); 
        
        System.out.println("Fibonacci result is: " + pm.fibonacci(n)); */
        
        /* Fibonacci memoization
        System.out.println(pm.fibonacciMemoization(10));  */
        
        /* Weave 2 Queues 
        Queue<Integer> q1 = new LinkedList<>();
        Queue<Integer> q2 = new LinkedList<>();
        
        for(int i=1; i<=5; i++)
        {
            q1.add(i);
        }
        for(int i=10; i<=20; i++)
        {
            q2.add(i);
        }
        
        Queue res = pm.weaveQueue(q1,q2);
        while(!res.isEmpty())
        {
            System.out.println(res.poll());
        }
        */
        
        /* Queue from Stack 
        Stack<Integer> s1 = new Stack<>();
        Stack<Integer> s2 = new Stack<>();
        
        for(int i=1; i<=5; i++)
        {
            s1.add(i);
        }
        
        System.out.println("Stack top : " + s1.peek());
        System.out.println("implementing as Q : ");
        
        System.out.println(pm.qFromStack(s1, s2));
        System.out.println(pm.qFromStack(s1, s2));
        System.out.println(pm.qFromStack(s1, s2)); 
        */
        
        
    }
       
    public String numberToWords(int num) {
        int temp = num;
        int rem = 0, count = 0;
        String strNum = "", mainStr = "";
        
        if(num == 0)
            mainStr = convertNumberToWords(num, 1);
            
        while(temp > 0)
        {
            
            switch(count)
                {
                    case 1:
                        mainStr = " Thousand " + mainStr;
                        break;
                    case 2:
                        mainStr = " Million " + mainStr;
                        break;
                    case 3:
                        mainStr = " Billion " + mainStr;
                        break;
                }
            
            strNum = "";
            rem = temp % 1000;
            
            if(rem > 99)
                strNum = strNum + convertNumberToWords(rem/100, 3);
            
            if(rem/100 > 0)
                strNum = strNum + " Hundred ";
            
            if(rem % 100 < 20 || (rem % 100)%10 == 0)
            {
                strNum = strNum + convertNumberToWords(rem%100, 1);
            }
            else
            {
                strNum = strNum + convertNumberToWords((rem%100)/10, 2);
                strNum = strNum + " ";
                strNum = strNum + convertNumberToWords((rem%100)%10, 1);
            }
            
            temp = temp/1000;
            mainStr = strNum + mainStr;
            count++;
        }
        
        return mainStr;
    }
    
    public String convertNumberToWords(int subNum, int pos)
    {
        
                
        return "";            
 
    }
    
    public String reverseString(String str)
    {
        StringBuilder sb = new StringBuilder();
//        for(int i = str.length()-1; i>=0; i--)
//        {
//            sb.append(str.charAt(i));
//        }
        
//        return sb.toString();

        char temp;
        char[] arr = str.toCharArray();
        for(int i=0,j=str.length()-1; i<=j; i++,j--)
        {
            temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
        
        return String.valueOf(arr);
    }
    
    public boolean checkPalindromeAnagram(String str)
    {
        int [] intArr = new int[128]; 
        int i, foundSingle=0;
               
        for(i = 0; i<intArr.length; i++)
        {
            intArr[i] = 0;
        }
        for(i=0; i < str.length(); i++)
        {
            int temp = str.charAt(i);
            intArr[temp]++;
        }
        
        for(i=0; i < intArr.length; i++)
        {
                if(intArr[i] % 2 == 1)
                    foundSingle++;
                
                if(foundSingle > 1)
                    return false;
        }
        return true;
    }
    
    public boolean checkPalindrome(String str)
    {
        for(int i=0, j=str.length()-1; i<j; i++,j--)
        {
            if(str.charAt(i) != str.charAt(j))
                return false;
        }
        return true;
    }
    
    public int reverseInteger(int myInt)
    {
        int result=0, currDigit=0, prevRevNum=0;
        
        while(myInt != 0)
        {
            currDigit = (myInt%10);
            result = (result*10) + currDigit;
            
            //IMPORTANT
            if((result - currDigit)/10 != prevRevNum)
            {
                System.out.println("Number Overflow");
                return 0;
            }
            
            prevRevNum = result;
            myInt = myInt/10;
        }
        
        return result;
    }
    
    public char maxChar(String str, boolean isSorted)
    {
        char maxC = ' ';
        if(isSorted)
        {
            char currC = str.charAt(0);
            char prevC = str.charAt(0);
            
            int cnt = 0, maxCnt = 0;
            
            
            for(int i=0; i<str.length(); i++)
            {
                currC = str.charAt(i);
                if(currC != prevC)
                {
                    if(maxCnt < cnt)
                    {
                        maxC = prevC;
                        maxCnt = cnt;
                    }
                    cnt = 0;
                    prevC = currC;
                    
                }
                cnt++;
            }
            return maxC;
        }
        else
        {
            int [] chrArr = new int[128];
            int maxPos = 0, maxCnt = 0, cnt = 0;
            
            for(int i=0; i<chrArr.length; i++)
            {
                chrArr[i] = 0;
            }
            
            for(int i=0; i<str.length(); i++)
            {
                int pos = str.charAt(i);
                if(chrArr[pos] == 0)
                {
                    chrArr[pos]++;
                }
                if(chrArr[pos] > maxCnt)
                {
                    maxPos = pos;
                }
            }
            
            maxC = (char)maxPos;
                    
        }
        return maxC;
    }
    
    public void fizzBuzz(int n)
    {
        for(int i=1; i<=n; i++)
        {
            if(i%3 == 0 && i%5 == 0)
                System.out.println("FizzBuzz");
            else if(i%3 == 0 && i%5 != 0)
                System.out.println("Fizz");
            else if(i%3 != 0 && i%5 == 0)
                System.out.println("Buzz");
            else
                System.out.println(i);
        }
    }
    
    public void arrChunk(int arr[], int len)
    {
        ArrayList<int[]> chunks = new ArrayList<int[]>();
        int [] tempArr = new int[len];
        int cnt = 0, newLen = len;
        
        for(int i=0; i < arr.length; i++)
        {
            tempArr[cnt++] = arr[i];
            
            if((i+1)%len == 0)
            {
                chunks.add(tempArr);
                //to adjust length of last array
                if(arr.length - (i+1) < len)
                    newLen = arr.length - (i+1);
                
                tempArr = new int[newLen];
                cnt = 0;
            }
        }
        chunks.add(tempArr);
        
        //print ArrayList
        for(int[] printArr : chunks){
            System.out.print(" [");
            
            //iterate through array using its length
            for(int i = 0 ; i < printArr.length; i++){
                System.out.print( printArr[i] + " ");
            }
            
            System.out.println("]");
        }
    }
    
    public boolean checkAnagram(String str1, String str2)
    {
        int [] arr = new int[26];
        int temp;
        
        str1 = str1.replaceAll("[^a-zA-Z]", "");
        str2 = str2.replaceAll("[^a-zA-Z]", "");
        
        if(str1.length() != str2.length())
            return false;
        
        for(int i= 0; i < str1.length(); i++)
        {
            temp = getIndex(str1.charAt(i));
            if(temp != -1) 
                arr[temp]++;
        }
        for(int i= 0; i < str2.length(); i++)
        {
            temp = getIndex(str2.charAt(i));
            if(temp != -1)
            {
                arr[temp]--;
            
                if(arr[temp] < 0)
                    return false;
            }
        }
        
        return true;
    }
    
    public int getIndex(char c)
    {
        int val = c;
        if(val >= 65 && val <= 90)
            return val - 65;
        else if(val >= 97 && val <= 122)
            return val - 97;
        else
            return -1;
    }
    
    
    public String capitalizeWords(String str)
    {
        String [] splitStr = str.split(" ");
        String newStr = "";
        StringBuilder sb = new StringBuilder();
        
        for(int i=0; i<splitStr.length; i++)
        {
            sb.append(splitStr[i].substring(0, 1).toUpperCase() + splitStr[i].substring(1, splitStr[i].length()));
            if(i+1 != splitStr.length)
                sb.append(" ");
        }
        
        return sb.toString();
    }
    
    public void createSteps(int n)
    {
        for(int i=0; i<n; i++)
        {
            for(int j=0;j<n; j++)
            {
                if(j <= i)
                    System.out.print("#");
                else
                    System.out.print(" ");
            }

            System.out.println("");
        }
    }
    
    public void createStepsRecur(int n)
    {
        if(n == 0)
            return;
        
        createSteps(n-1);
        
        for(int j=0;j<n; j++)
        {
            System.out.print("#");
        }
        System.out.println("");
    }
    
    public void createPyramid(int n)
    {
        createRecPyramid(n, n+(n-1));
    }
    
    public void createRecPyramid(int n, int lastRowItems)
    {
        if(n == 0)
            return;
        
        createRecPyramid(n-1, lastRowItems);
        
        for(int j=0;j<(lastRowItems-(n +(n-1)))/2; j++)
        {
            System.out.print(" ");
        }
        for(int j=0;j<n +(n-1); j++)
        {
            System.out.print("#");
        }
        for(int j=0;j<(lastRowItems-(n +(n-1)))/2; j++)
        {
            System.out.print(" ");
        }
        System.out.println("");
    }
    
    public int getVowels(String str)
    {
        int cnt = 0;
        
        //using regex
        if(str.length() > 0)
        {
            Pattern vowelPattern = Pattern.compile("[aeiouAEIOU]");
            Matcher vowelMatcher = vowelPattern.matcher(str);
            
            while(vowelMatcher.find())
                cnt++;
        }
        
        //This method uses simple if condition
        
        /*
        for(int i = 0; i<str.length(); i++)
        {
            Character c = str.charAt(i);
            if(c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u')
                cnt++;
            else if(c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U')
                cnt++;
            
        }
        */
        
        return cnt;
    }
    
    public void spiralMatrix(int n)
    {
        int[][] arr = new int[n][n];
        int startRow = 0;
        int startCol = 0;
        int endRow = n-1;
        int endCol = n-1;
        
        int cnt = 1;
        
        while(startCol <= endCol && startRow <= endRow)
        {
            //top row
            for(int i = startCol; i<=endCol; i++)
            {
                arr[startRow][i] = cnt;
                cnt++;
            }
            startRow++;
            
            //rightmost col
            for(int j = startRow; j<=endRow; j++)
            {
                arr[j][endCol] = cnt;
                cnt++;
            }
            endCol--;
            
            //bottom row
            for(int i = endCol; i>=startCol; i--)
            {
                arr[endRow][i] = cnt;
                cnt++;
            }
            endRow--;
            
            //left col
            for(int j=endRow; j>=startRow; j--)
            {
                arr[j][startCol] = cnt;
                cnt++;
            }
            startCol++;
        }
        
        for(int i=0; i< n; i++)
        {
            for(int j=0; j<n;j++)
            {
                System.out.print(arr[i][j]);
            }
            System.out.println();
        }
    }
    
    public int fibonacci(int n)
    {
        //iterative
        /*int prev1 = 0;
        int prev2 = 1;
        int next = 0;
        
        System.out.println(prev1);
        System.out.println(prev2);
        
        for(int i=2; i<=n; i++)
        {
            next = prev1 + prev2;
            System.out.println(next);
            prev1 = prev2;
            prev2 = next;
        }
        
        return next;
        */
        
        //recursive solution
        if(n<2)
            return n;

        return fibonacci(n-1) + fibonacci(n-2);
    }    
    
    public int fibonacciMemoization(int n)
    {
        int [] arr = new int[n+1];
        
        arr[0] = 0;
        arr[1] = 1;
 
        return (fibMemo(n, arr));
    }
    
    public int fibMemo(int n, int[] arr)
    {
        if(n <= 1)
            return n;
        else if(n > 1 && arr[n] != 0)
            return arr[n];
        else
        {
            int fibVal = fibMemo(n-2, arr) + fibMemo(n-1, arr);
            arr[n] = fibVal;
            return fibVal;
        }
    }
    
    public Queue weaveQueue(Queue q1, Queue q2)
    {
        Queue<Integer> res = new LinkedList<>();
        Queue<Integer> bigQ, smallQ;
        
        
        if(q1.isEmpty())
            return q2;
        
        if(q2.isEmpty())
            return q1;
        
        if(q1.size() < q2.size())
        {
            bigQ = q2;
            smallQ = q1;
        }
        else
        {
            bigQ = q1;
            smallQ = q2;
        }
        
        while(!smallQ.isEmpty())
        {
            res.add(bigQ.poll());
            res.add(smallQ.poll());
        }
        while(!bigQ.isEmpty())
        {
            res.add(bigQ.poll());
        }
        
        return res;
    }
    
    public int qFromStack(Stack s1, Stack s2)
    {
        int res = 0;
        
        Stack<Integer> source;
        Stack<Integer> dest;
        
        if(s1.isEmpty())
        {
            source = s2;
            dest = s1;
        }
        else
        {
            source = s1;
            dest = s2;
        }
        
        while(!source.isEmpty())
        {
            dest.add(source.pop());
        }
        res = dest.pop();
        
        while(!dest.isEmpty())
        {
            source.add(dest.pop());
        }
        
        return res;
    }
    
    
    
}
