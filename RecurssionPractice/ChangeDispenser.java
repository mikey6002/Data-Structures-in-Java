package assign5_template;

import java.util.*;



//Hints:
        //Use a list to store the denomination values of coins in decreasing order.
	//Use a second list to store the names of coins in the same order as their denomination value list.

	//Two string arrays in the code will hold the value of the denomination, and one integer array will hold the denomination itself.

	//NOTE - your recursive method does NOT have to be a void method.
    //       Your recursive method uses the coin value list and the coin name list. 
    //       In each call to the recursive method, the count of the first coin in the list 
    //          (coin in largest denomination value) is calculated and printed out. 
    //       Then the first coin is removed from the lists. 
    //       The remaining amount of money is calculated. 
    //       The coin lists and the remaining amount are passed to the next recursive call. 
    //       The recursion ends when no money is left.



	//The recursion method makeChange takes up the amount , singular_coins , plural_coins array , denominations array.
	//For getting the minimum number of coins we should always start from the biggest coin.
public class ChangeDispenser {
	public static int makeChange(float amount, String[] singular_coins, String[] plural_coins,int[] denominations, int i) {
		if (amount == 0) {
			return 0;
		}
		int temp = (int) amount / denominations[i];
		if (temp != 0) {
			if (temp > 1) {
				System.out.println(temp + " " + plural_coins[i]);
			} else {
				System.out.println(temp + " " + singular_coins[i]);
			}
		}
		return makeChange(amount % denominations[i], singular_coins, plural_coins, denominations, i + 1);
	}



	//add your code to do the following:
        
        //prompt the user to enter the amount in dollars and cents
        //get the amount
        //convert the amount to all cents
        //call the public wrapper method
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.print("\nEnter the money amount in dollars and cents : ");
		float amount = sc.nextFloat();
		String[] singular_coins = { "DOLLAR", "HALF_DOLLAR", "QUATER", "DIME", "NICKEL", "PENNY" };
		String[] plural_coins = { "DOLLARS", "HALF_DOLLARS", "QUATERS", "DIMES", "NICKELS", "PENNIES" };
		int[] denominations = { 100, 50, 25, 10, 5, 1 };
		 makeChange(amount * 100, singular_coins, plural_coins, denominations, 0);
		sc.close();
	}

}