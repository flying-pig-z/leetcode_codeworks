package leetcode.editor.cn.doc;

public class KMP {

    // 计算 needle 的前缀函数
    private static int[] computePrefixFunction(String needle) {
        int m = needle.length();
        int[] prefixFunction = new int[m];

        // j 是前缀的长度
        int j = 0;

        // 从 needle 的第二个字符开始计算前缀函数
        for (int i = 1; i < m; i++) {
            // 回退 j，直到找到一个合适的前缀
            while (j > 0 && needle.charAt(i) != needle.charAt(j)) {
                j = prefixFunction[j - 1];
            }
            // 如果字符匹配，扩展前缀长度
            if (needle.charAt(i) == needle.charAt(j)) {
                j++;
            }
            prefixFunction[i] = j;  // 存储前缀函数值
        }

        return prefixFunction;
    }

    // 使用 KMP 算法在 haystack 中查找 needle
    public static int strStr(String haystack, String needle) {
        if (needle.isEmpty()) {
            return 0;  // 如果 needle 是空字符串，返回 0
        }

        int n = haystack.length();
        int m = needle.length();

        // 如果 needle 长度大于 haystack，肯定没有匹配
        if (m > n) {
            return -1;
        }

        // 计算 needle 的前缀函数
        int[] prefixFunction = computePrefixFunction(needle);

        int i = 0;  // haystack 的指针
        int j = 0;  // needle 的指针

        // 开始匹配
        while (i < n) {
            // 如果当前字符匹配，两个指针都向后移动
            if (haystack.charAt(i) == needle.charAt(j)) {
                i++;
                j++;

                // 如果 j 达到 needle 的长度，说明匹配成功，返回匹配的起始位置
                if (j == m) {
                    return i - j;
                }
            } else {
                // 如果不匹配，根据前缀函数决定是否回退 needle 指针
                if (j > 0) {
                    j = prefixFunction[j - 1];
                } else {
                    // 如果 j == 0，则 haystack 指针向后移动
                    i++;
                }
            }
        }

        // 如果没有找到匹配项，返回 -1
        return -1;
    }

    public static void main(String[] args) {
        String haystack1 = "sadbutsad";
        String needle1 = "sad";
        System.out.println(strStr(haystack1, needle1));  // 输出: 0

        String haystack2 = "leetcode";
        String needle2 = "leeto";
        System.out.println(strStr(haystack2, needle2));  // 输出: -1
    }
}
