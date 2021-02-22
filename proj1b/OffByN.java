public class OffByN implements CharacterComparator {
    int N;
    public OffByN(int n) {
        N = n;
    }
    @Override
    public boolean equalChars(char x, char y) {
        return Math.abs(x - y) == N;
    }

    public Deque<Character> wordToDeque(String word) {
        char[] ch = word.toCharArray();
        LinkedListDeque<Character> res = new LinkedListDeque<>();
        for (int i = 0; i < ch.length; i++) {
            res.addLast(ch[i]);
        }
        return res;
    }

    public boolean isPalindrome(String word) {
        LinkedListDeque<Character> deque = (LinkedListDeque<Character>) wordToDeque(word);
        while (deque.size() != 0) {
            if (deque.size() == 0 || deque.size() == 1) {
                return true;
            }
            char head = deque.removeFirst();
            char tail = deque.removeLast();
            if (!equalChars(head, tail)) {
                return false;
            }
        }
        return true;
    }
}
