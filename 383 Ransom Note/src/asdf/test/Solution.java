package asdf.test;

/**
 * (笔记)
 *  Given  an  arbitrary  ransom  note  string  and  another  string  containing  letters from  all  the  magazines,  write  a  function  that  will  return  true  if  the  ransom   note  can  be  constructed  from  the  magazines ;  otherwise,  it  will  return  false.
 * <p>
 * Each  letter  in  the  magazine  string  can  only  be  used  once  in  your  ransom  note.
 * <p>
 * Note:
 * You may assume that both strings contain only lowercase letters.
 * <p>
 * canConstruct("a", "b") -> false
 * canConstruct("aa", "ab") -> false
 * canConstruct("aa", "aab") -> true
 */
public class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] note = new int[256];
        int[] maga = new int[256];
        for (int i = 0; i < ransomNote.length(); i++) {
            note[ransomNote.charAt(i)]++;
        }
        for (int i = 0; i < magazine.length(); i++) {
            maga[magazine.charAt(i)]++;
        }
        for (int i = 0; i < 256; i++) {
            if (note[i] > maga[i])
                return false;
        }

        return true;
    }
}
