class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        HashMap<Character, Integer> need = new HashMap<>();
        HashMap<Character, Integer> have = new HashMap<>();

        // Frequency of ransomNote
        for (int i = 0; i < ransomNote.length(); i++) {
            char ch = ransomNote.charAt(i);
            need.put(ch, need.getOrDefault(ch, 0) + 1);
        }

        // Frequency of magazine
        for (int i = 0; i < magazine.length(); i++) {
            char ch = magazine.charAt(i);
            have.put(ch, have.getOrDefault(ch, 0) + 1);
        }

        return check(have, need);
    }

    public boolean check(HashMap<Character, Integer> have,
                         HashMap<Character, Integer> need) {

        for (Character ch : need.keySet()) {

            int fNeed = need.get(ch);
            int fHave = have.getOrDefault(ch, 0);

            if (fHave < fNeed) {
                return false;
            }
        }

        return true;
    }
}