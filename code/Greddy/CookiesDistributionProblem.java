package code.Greddy;

import java.util.Arrays;

/**
 * CookiesDistributionProblem
 */
public class CookiesDistributionProblem {

    // 思路1：优先考虑饼干，小饼干先喂饱小胃口
    public static int findCookiesNumberForChildren(int[] g, int[] s){
        Arrays.sort(g);
        Arrays.sort(s);

        int start = 0;
        int count = 0;

        for (int i = 0; i < s.length && start < g.length; i++){
            if (s[i] >= g[start]){
                start++;
                count++;
            }
        }

        return count;
    }

    // 思路2：优先考虑胃口，先喂饱大胃口
    public static int findCookiesNumberForChildren2(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int count = 0;
        int start = s.length - 1;
        // 遍历胃口
        for (int index = g.length - 1; index >= 0; index--) {
            if(start >= 0 && g[index] <= s[start]) {
                start--;
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int [] g = new int[] {2, 3, 4, 7, 9};
        int [] s = new int[] {1, 2, 3, 10, 20};
        System.out.println(findCookiesNumberForChildren(g, s));
        System.out.println(findCookiesNumberForChildren2(g, s));
        

    }
}