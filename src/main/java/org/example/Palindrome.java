package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Palindrome {
//Returning theList if we have more then 1 with same length
    public static List<String> getLongestPalindrome(String str) {
        List<String> list = new ArrayList<>();
        if (str == null || str.isEmpty()) {
            return list;
        }
        String longestStr = null;
        int maxCount = 0;
        for (int k = 0; k < str.length(); k++) {
            int evenCount = 0;
            int i = k;
            int j = k + 1;
            while (i >= 0 && j < str.length() && ((str.charAt(i)) == (str.charAt(j)))) {
                i--;
                j++;
                evenCount++;
            }
            int l = k - 1;
            int m = k + 1;
            int oddCount = 0;
            while (l >= 0 && m < str.length() && ((str.charAt(l)) == (str.charAt(m)))) {
                l--;
                m++;
                oddCount++;
            }
            int count = 0;
            if (evenCount == oddCount) {
                count = oddCount;
            } else {
                count = Math.max(evenCount, oddCount);
            }

            if (maxCount <= count) {
                if (evenCount == count) {
                    longestStr = evenCount > 0 ? str.substring(k - evenCount + 1, k + evenCount + 1) : String.valueOf(str.charAt(k));
                }
                if (count == oddCount) {
                    longestStr = oddCount > 0 ? str.substring(k - oddCount, k + oddCount + 1) : String.valueOf(str.charAt(k));
                }
                int finalLongestStr = longestStr.length();
                list = list.stream().filter(obj -> obj.length() >= finalLongestStr).collect(Collectors.toList());
                maxCount = count;
                list.add(longestStr);
            }
        }
        return list;
    }
}