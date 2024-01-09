/*
We can represent a sentence as an array of words, for example, the sentence "I am happy with leetcode" can be represented as arr = ["I","am",happy","with","leetcode"].

Given two sentences sentence1 and sentence2 each represented as a string array and given an array of string pairs similarPairs where similarPairs[i] = [xi, yi] indicates that the two words xi and yi are similar.

Return true if sentence1 and sentence2 are similar, or false if they are not similar.

Two sentences are similar if:

They have the same length (i.e., the same number of words)
sentence1[i] and sentence2[i] are similar.
Notice that a word is always similar to itself, also notice that the similarity relation is not transitive. For example, if the words a and b are similar, and the words b and c are similar, a and c are not necessarily similar.



Example 1:

Input: sentence1 = ["great","acting","skills"], sentence2 = ["fine","drama","talent"], similarPairs = [["great","fine"],["drama","acting"],["skills","talent"]]
Output: true
Explanation: The two sentences have the same length and each word i of sentence1 is also similar to the corresponding word in sentence2.
Example 2:

Input: sentence1 = ["great"], sentence2 = ["great"], similarPairs = []
Output: true
Explanation: A word is similar to itself.
Example 3:

Input: sentence1 = ["great"], sentence2 = ["doubleplus","good"], similarPairs = [["great","doubleplus"]]
Output: false
Explanation: As they don't have the same length, we return false.


Constraints:

1 <= sentence1.length, sentence2.length <= 1000
1 <= sentence1[i].length, sentence2[i].length <= 20
sentence1[i] and sentence2[i] consist of English letters.
0 <= similarPairs.length <= 1000
similarPairs[i].length == 2
1 <= xi.length, yi.length <= 20
xi and yi consist of lower-case and upper-case English letters.
All the pairs (xi, yi) are distinct.
 */

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class SentenceSimilarity_734 {

    /*
        Time complexity:O((n+k)⋅m)  (n - no of words in s1 or s2; k= no of similar pairs, m = avg length of words
    We iterate over all the elements of similarPairs and insert a pair twice into wordToSimilarWords. To hash each word of length m, we need O(m) time, and to put the same length word in the hash set, we need O(m) time again. Because there are k pairs of words, there can be at most 2⋅k words that can be hashed and added to the set. As a result, we require O(k⋅m) time.
    We also iterate over all of sentence1's words to see if sentence1[i] == sentence2[i]. Because each word is m long, checking words at a specific index would take O(m) time. It will take O(n⋅m) time in total because there are n words.
     For each word sentence1[i], we check if this word is present as the key inwordToSimilarWordswhich takesO(m)O(m)O(m)time per word, and searching for the similar word sentence2[i]in thewordToSimilarWords[sentence1[i]]set also takesO(m)O(m)O(m)time. As a result, fornnnwords, performing the key lookup followed by searching in the set would take O(n⋅m) time.
    The overall time required isO((n+k)⋅m)

    Space complexity: O(k⋅m)
    We are using wordToSimilarWords to store all the similar words for a given word. There are k pairs of
    similar words, so there could be O(k) words that are inserted into wordToSimilarWords.
    Because the average length of each word is m, the required space isO(k⋅m)

         */
    public boolean areSentencesSimilar(String[] sentence1, String[] sentence2, List<List<String>> similarPairs) {

        if (sentence1.length != sentence2.length) {
            return false;
        }

        HashMap<String, HashSet<String>> keyVal = new HashMap<>();

        for (List<String> pair : similarPairs) {

            // (string1 : string2) kv pair
            if (keyVal.containsKey(pair.get(0))) {
                keyVal.get(pair.get(0)).add(pair.get(0));
            } else {
                HashSet<String> keys1 = new HashSet<>();
                keys1.add(pair.get(1));
                keyVal.put(pair.get(0), keys1);
            }


            // (string2 : string1) kv pair
            if (keyVal.containsKey(pair.get(1))) {
                keyVal.get(pair.get(1)).add(pair.get(0));
            } else {
                HashSet<String> keys2 = new HashSet<>();
                keys2.add(pair.get(0));
                keyVal.put(pair.get(1), keys2);
            }
        }

        for (int i = 0; i < sentence1.length; i++) {
            //If s1 word and s2 word are not equal AND
            //(If s1word key is not present OR present but does not have s2 word as value)
            if (!sentence1[i].equals(sentence2[i])) {
                if (!keyVal.containsKey(sentence1[i])) {
                    return false;
                }
                if (keyVal.containsKey(sentence1[i]) && !keyVal.get(sentence1[i]).contains(sentence2[i])) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        SentenceSimilarity_734 s = new SentenceSimilarity_734();
        System.out.println(s.areSentencesSimilar(new String[]{"super", "acting", "skills"}, new String[]{"fine", "drama", "talent"}, Arrays.asList(Arrays.asList("great", "fine"), Arrays.asList("fine", "super"), Arrays.asList("drama", "acting"), Arrays.asList("skills", "talent")))); //true
        System.out.println(s.areSentencesSimilar(new String[]{"great", "acting", "skills"}, new String[]{"fine", "drama", "talent"}, Arrays.asList(Arrays.asList("great", "fine"), Arrays.asList("drama", "acting"), Arrays.asList("skills", "talent")))); //true
        System.out.println(s.areSentencesSimilar(new String[]{"great"}, new String[]{"great"}, Arrays.asList()));  //true
        System.out.println(s.areSentencesSimilar(new String[]{"great"}, new String[]{"doubleplus", "good"}, Arrays.asList(Arrays.asList("great", "doubleplus")))); //false. different length
        System.out.println(s.areSentencesSimilar(new String[]{"an", "extraordinary", "meal"}, new String[]{"one", "good", "dinner"},
                Arrays.asList(
                        Arrays.asList("great", "good"), Arrays.asList("extraordinary", "good"), Arrays.asList("well", "good"),
                        Arrays.asList("wonderful", "good"), Arrays.asList("fine", "good"), Arrays.asList("nice", "good"),
                        Arrays.asList("any", "one"), Arrays.asList("some", "one"), Arrays.asList("unique", "one"),
                        Arrays.asList("the", "one"), Arrays.asList("an", "one"), Arrays.asList("single", "one"),
                        Arrays.asList("a", "one"), Arrays.asList("truck", "car"), Arrays.asList("wagon", "car"),
                        Arrays.asList("automobile", "car"), Arrays.asList("auto", "car"), Arrays.asList("vehicle", "car"),
                        Arrays.asList("entertain", "have"), Arrays.asList("drink", "have"), Arrays.asList("eat", "have"),
                        Arrays.asList("take", "have"), Arrays.asList("fruits", "meal"), Arrays.asList("brunch", "meal"),
                        Arrays.asList("breakfast", "meal"), Arrays.asList("food", "meal"), Arrays.asList("dinner", "meal"),
                        Arrays.asList("super", "meal"), Arrays.asList("lunch", "meal"), Arrays.asList("possess", "own"),
                        Arrays.asList("keep", "own"), Arrays.asList("have", "own"), Arrays.asList("extremely", "very"),
                        Arrays.asList("actually", "very"), Arrays.asList("really", "very"), Arrays.asList("super", "very")
                ))); //true.

        System.out.println(s.areSentencesSimilar(new String[]{"yesterday", "james", "have", "an", "extraordinary", "meal"}, new String[]{"yesterday", "james", "take", "one", "good", "dinner"},
                Arrays.asList(
                        Arrays.asList("great", "good"), Arrays.asList("extraordinary", "good"), Arrays.asList("well", "good"),
                        Arrays.asList("wonderful", "good"), Arrays.asList("fine", "good"), Arrays.asList("nice", "good"),
                        Arrays.asList("any", "one"), Arrays.asList("some", "one"), Arrays.asList("unique", "one"),
                        Arrays.asList("the", "one"), Arrays.asList("an", "one"), Arrays.asList("single", "one"),
                        Arrays.asList("a", "one"), Arrays.asList("truck", "car"), Arrays.asList("wagon", "car"),
                        Arrays.asList("automobile", "car"), Arrays.asList("auto", "car"), Arrays.asList("vehicle", "car"),
                        Arrays.asList("entertain", "have"), Arrays.asList("drink", "have"), Arrays.asList("eat", "have"),
                        Arrays.asList("take", "have"), Arrays.asList("fruits", "meal"), Arrays.asList("brunch", "meal"),
                        Arrays.asList("breakfast", "meal"), Arrays.asList("food", "meal"), Arrays.asList("dinner", "meal"),
                        Arrays.asList("super", "meal"), Arrays.asList("lunch", "meal"), Arrays.asList("possess", "own"),
                        Arrays.asList("keep", "own"), Arrays.asList("have", "own"), Arrays.asList("extremely", "very"),
                        Arrays.asList("actually", "very"), Arrays.asList("really", "very"), Arrays.asList("super", "very")
                ))); //true    //"have" (val) has multiple similar words (keys).

        System.out.println(s.areSentencesSimilar(new String[]{"an", "extraordinary", "meal"}, new String[]{"a", "good", "dinner"},
                Arrays.asList(
                        Arrays.asList("great", "good"), Arrays.asList("extraordinary", "good"), Arrays.asList("well", "good"),
                        Arrays.asList("wonderful", "good"), Arrays.asList("fine", "good"), Arrays.asList("nice", "good"),
                        Arrays.asList("any", "one"), Arrays.asList("some", "one"), Arrays.asList("unique", "one"),
                        Arrays.asList("the", "one"), Arrays.asList("an", "one"), Arrays.asList("single", "one"),
                        Arrays.asList("a", "one"), Arrays.asList("truck", "car"), Arrays.asList("wagon", "car"),
                        Arrays.asList("automobile", "car"), Arrays.asList("auto", "car"), Arrays.asList("vehicle", "car"),
                        Arrays.asList("entertain", "have"), Arrays.asList("drink", "have"), Arrays.asList("eat", "have"),
                        Arrays.asList("take", "have"), Arrays.asList("fruits", "meal"), Arrays.asList("brunch", "meal"),
                        Arrays.asList("breakfast", "meal"), Arrays.asList("food", "meal"), Arrays.asList("dinner", "meal"),
                        Arrays.asList("super", "meal"), Arrays.asList("lunch", "meal"), Arrays.asList("possess", "own"),
                        Arrays.asList("keep", "own"), Arrays.asList("have", "own"), Arrays.asList("extremely", "very"),
                        Arrays.asList("actually", "very"), Arrays.asList("really", "very"), Arrays.asList("super", "very")
                ))); //false.  "an" and "a" both have mapping to "one" but no mapping for "an" and "a" together.

        System.out.println(s.areSentencesSimilar(new String[]{"a", "very", "delicious", "meal"}, new String[]{"one", "really", "good", "dinner"},
                Arrays.asList(
                        Arrays.asList("great", "good"), Arrays.asList("extraordinary", "good"), Arrays.asList("well", "good"),
                        Arrays.asList("wonderful", "good"), Arrays.asList("fine", "good"), Arrays.asList("nice", "good"),
                        Arrays.asList("any", "one"), Arrays.asList("some", "one"), Arrays.asList("unique", "one"),
                        Arrays.asList("the", "one"), Arrays.asList("an", "one"), Arrays.asList("single", "one"),
                        Arrays.asList("a", "one"), Arrays.asList("truck", "car"), Arrays.asList("wagon", "car"),
                        Arrays.asList("automobile", "car"), Arrays.asList("auto", "car"), Arrays.asList("vehicle", "car"),
                        Arrays.asList("entertain", "have"), Arrays.asList("drink", "have"), Arrays.asList("eat", "have"),
                        Arrays.asList("take", "have"), Arrays.asList("fruits", "meal"), Arrays.asList("brunch", "meal"),
                        Arrays.asList("breakfast", "meal"), Arrays.asList("food", "meal"), Arrays.asList("dinner", "meal"),
                        Arrays.asList("super", "meal"), Arrays.asList("lunch", "meal"), Arrays.asList("possess", "own"),
                        Arrays.asList("keep", "own"), Arrays.asList("have", "own"), Arrays.asList("extremely", "very"),
                        Arrays.asList("actually", "very"), Arrays.asList("really", "very"), Arrays.asList("super", "very")
                ))); //false.  "delicious" keyword is not present in similar pairs.
    }

}
