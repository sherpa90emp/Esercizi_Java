package Stringhe;

public class Palindroma {
    public static void main(String[] args) {
        // itopononavevanonipoti = palindroma

        String s1 = "itopinonavevanonipoti";
        String s2 = "ciao";
        System.out.println(
                isPalindroma(s1)
        );
        System.out.println(
                isPalindroma(s2)
        );
        String s4 = "mamma";
        System.out.println(
                "Il contrario di" + s4 + "è" + reverse(s4)
        );

    }

    public static boolean isPalindroma(String input) {
        for (char i = 0; i < input.length() / 2; i++) {
            if (input.charAt(i) != input.charAt(input.length() - 1 - i)) {
                return false;
            }
        }
        return true;
    }

    public static boolean isPalindroma2(String input){
        int left = 0;
        int right = input.length() - 1;
        while (left < right) {
            if (input.charAt(left) != input.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    //inverte una stringa
    public static String reverse(String input) {
        String reverse = "";
        for (int i = input.length(); i >= 0; i--) {
            reverse += input.charAt(i);
        }
        return reverse;
    }

}
