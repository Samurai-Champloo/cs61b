public class Palindrome {
    public Deque<Character> wordToDeque(String word) {
        char[] ch = word.toCharArray();
        LinkedListDeque<Character> res = new LinkedListDeque<>();
        for (int i = 0; i < ch.length; i++) {
            res.addLast(ch[i]);
        }
        return res;
    }


    //uses recursion.
    public boolean isPalindrome(String word) {
        LinkedListDeque<Character> deque = (LinkedListDeque<Character>) wordToDeque(word);
        return isPalindrome(deque);
    }
    private boolean isPalindrome(Deque deque) {
        if (deque.size() == 0 || deque.size() == 1) {
            return true;
        }
        char head = (char) deque.removeFirst();
        char tail = (char) deque.removeLast();
        if (head != tail) {
            return false;
        }
        return isPalindrome(deque);
    }

    public boolean isPalindrome(String word, CharacterComparator cc) {
        OffByOne offByOne = (OffByOne) cc;
        return offByOne.isPalindrome(word);
    }

}
