package leetcode.editor.cn.doc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
         Scanner input=new Scanner(System.in);
        // String str=input.next();
        Integer[] intArgs = new Integer[5];
        intArgs[0]=1;
        intArgs[1]=2;intArgs[3]=4;intArgs[4]=5;
        HashSet<Integer> integerHashSet = new HashSet<>();
        integerHashSet.addAll(Arrays.asList(intArgs));
        int max = 0;
        for (int i = 0; i < args.length; i++) {
            int num = intArgs[i];
            int count = 0;
            while (true) {
                if (integerHashSet.contains(num)) {
                    count++;
                } else {
                    break;
                }
                num++;
            }
            if (count > max) {
                max = count;
            }
        }
        System.out.println(max);

    }


}
