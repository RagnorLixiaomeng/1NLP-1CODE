
package code.MyString;

/**
 * StringReverse
 * 
 * 编写一个函数，其作用是将输入的字符串反转过来。输入字符串以字符数组 char[] 的形式给出。

    不要给另外的数组分配额外的空间，你必须原地修改输入数组、使用 O(1) 的额外空间解决这一问题。

    你可以假设数组中的所有字符都是 ASCII 码表中的可打印字符。

    示例 1：
    输入：["h","e","l","l","o"]
    输出：["o","l","l","e","h"]

    示例 2：
    输入：["H","a","n","n","a","h"]
    输出：["h","a","n","n","a","H"]

 */
public class MyStringReverse {

    // 双指针法 
    public static void reverseString(char[] s){
        int l = 0;
        int r = s.length - 1;
        while (l < r){
            // swap(s[l], s[r]); // - 面试的时候表达这个意思即可有时候
            char temp = s[l];
            s[l] = s[r];
            s[r] = temp;
            l++;
            r--;
        }

    };
    

    public static void main(String[] args) {
        char [] hello = new char[]{'h', 'e', 'l', 'l', 'o'};
        reverseString(hello);
        System.out.println(hello);

    };

};