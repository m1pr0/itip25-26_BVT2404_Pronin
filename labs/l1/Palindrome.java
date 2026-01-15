public class Palindrome {
    public static void main(String[] args){
        for (int i = 0; i <= args.length; i++){
            String s = args[i];
            System.out.println(isPalindrome(s));
        }
    }

    public static String reverseString(String str){
        String reversStr = "";
        for (int i = str.length() - 1; i >= 0; i--) {
            reversStr += str.charAt(i);
        }
        return reversStr;
    }
    public static boolean isPalindrome(String str){
        if (str.equals(reverseString(str))){
            return true;
        }
        return false;
    }
}
