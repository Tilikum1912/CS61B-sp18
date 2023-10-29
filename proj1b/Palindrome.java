

public class Palindrome {
    public Deque<Character> wordToDeque(String word) {
        Deque<Character> res = new LinkedListDeque<Character>();
        for (int i = 0; i < word.length(); i++) {
            char w = word.charAt(i);
            res.addLast(w);
        }
        return res;
    }

    public boolean isPalindrome(String word) {
        int length = word.length();
        if (length == 0 || length == 1) {
            return true;
        }
        if (word.charAt(0) != word.charAt(length - 1)) {
            return false;
        }
        return isPalindrome(word.substring(1, length - 1));
    }

    public boolean isPalindrome(String word, CharacterComparator cc) {
        int length = word.length();
        if (length == 0 || length == 1) {
            return true;
        }
        if (!(cc.equalChars(word.charAt(0), word.charAt(length - 1)))) {
            return false;
        }
        return isPalindrome(word.substring(1, length - 1), cc);
    }
}
