import java.util.*;

class TrieNode {
    TrieNode[] children = new TrieNode[26];
    boolean isEnd = false;
}

class Trie {
    TrieNode root = new TrieNode();

    public void insert(String word) {
        TrieNode curr = root;
        for (char ch : word.toCharArray()) {
            int idx = ch - 'a';
            if (curr.children[idx] == null) {
                curr.children[idx] = new TrieNode();
            }
            curr = curr.children[idx];
        }
        curr.isEnd = true;
    }
}

public class WordBreakTrie {

    public static boolean wordBreak(String s, List<String> wordDict) {
        Trie trie = new Trie();

        // Insert all dictionary words into Trie
        for (String word : wordDict) {
            trie.insert(word);
        }

        int n = s.length();
        boolean[] dp = new boolean[n + 1];
        dp[0] = true; // empty string is always valid

        // dp[i] means: s[0...i-1] can be segmented
        for (int i = 0; i < n; i++) {
            if (!dp[i]) continue;

            TrieNode curr = trie.root;

            for (int j = i; j < n; j++) {
                char ch = s.charAt(j);
                int idx = ch - 'a';

                if (curr.children[idx] == null) break;

                curr = curr.children[idx];

                // if word ends here, mark dp[j+1] = true
                if (curr.isEnd) {
                    dp[j + 1] = true;
                }
            }
        }

        return dp[n];
    }

    public static void main(String[] args) {
        String s = "leetcode";
        List<String> wordDict = Arrays.asList("leet", "code");

        System.out.println(wordBreak(s, wordDict)); // true
    }
}
