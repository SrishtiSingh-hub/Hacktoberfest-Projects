Brute Force Approach
In this approach, every set of items are tried, and for every set, the value is calculated. 
The set that generates the maximum value is the answer.

public class KnapsackExample  
{  
// A utility method, which returns  
// the maximum of the two numbers a1 and a2  
public int max(int a1, int a2)  
{  
return (a1 > a2) ? a1 : a2;  
}  
// A method that returns the maximum value that  
// may be put in the given knapsack of  
// capacity c by applying brute force with the help of recursion  
public int maxknapSackVal(int C, int wt[], int v[], int l)  
{  
// handling Base Case  
if (l == 0 || C == 0)  
{  
    // if no item is present or   
    // the capacity of the knapsack is 0,   
    // then there is no need to go further.   
    return 0;  
}  
// The capacity C of the knapsack is less   
// than the lth item. Therefore, it is   
// not possible to include this item   
// in creating the solution  
if (wt[l - 1] > C)  
{  
return maxknapSackVal(C, wt, v, l - 1);  
}  
else  
{  
// recursively solving the answer  
// Case 1: include the lth item  
int val1 = maxknapSackVal(C - wt[l - 1], wt, v, l - 1);  
// Case 2: exclude the lth item  
int val2 = maxknapSackVal(C, wt, v, l - 1);  
// return the maximum of both   
return max(v[l - 1] + val1, val2);  
}  
}  
// main method  
public static void main(String argvs[])  
{  
// input arrays  
int values[] = new int[] { 100, 60, 120 };  
int weight[] = new int[] { 20, 10, 30 };  
// capacity of the knapsack  
int C = 50;  
// calculating the length  
int length = values.length;  
// instantiating the class KnapsackExample  
KnapsackExample knapObj = new KnapsackExample();  
int maxVal = knapObj.maxknapSackVal(C, weight, values, length);  
System.out.println("The maximum value is: " + maxVal);  
}  
}  
