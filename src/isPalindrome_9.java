public class isPalindrome_9 {

    public static void main(String[] args){

        boolean answer = false;

        answer = isPalindrome(1221);
        System.out.println( answer);
        answer = isPalindrome( 121);
        System.out.println(answer);
        answer = isPalindrome( 12021);
        System.out.println(answer);
        answer = isPalindrome( 10021); //negative
        System.out.println(answer);

    }
    public static boolean isPalindrome(int num){
        if(num < 0) return  false;
        int reversed = 0, remainder, original = num;
        while(num != 0) {
            remainder = num % 10; // reversed integer is stored in variable
            reversed = reversed * 10 + remainder; //multiply reversed by 10 then add the remainder so it gets stored at next decimal place.
            num  /= 10;  //the last digit is removed from num after division by 10.
        }
        // palindrome if original and reversed are equal
        return original == reversed;
    }
}
