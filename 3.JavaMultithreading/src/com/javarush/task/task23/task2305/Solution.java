package com.javarush.task.task23.task2305;

/* 
Inner
*/
public class Solution {
    public InnerClass[] innerClasses = new InnerClass[2];

    public class InnerClass {
    }

    public static Solution[] getTwoSolutions() {
        Solution solutionFirst = new Solution();
        Solution solutionSecond = new Solution();

        solutionFirst.innerClasses[0] = solutionFirst.new InnerClass();
        solutionFirst.innerClasses[1] = solutionFirst.new InnerClass();
        solutionSecond.innerClasses[0] = solutionSecond.new InnerClass();
        solutionSecond.innerClasses[1] = solutionSecond.new InnerClass();


        return new Solution[]{solutionFirst, solutionSecond};
    }

    public static void main(String[] args) {

    }
}
