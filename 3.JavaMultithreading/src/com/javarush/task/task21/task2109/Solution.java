package com.javarush.task.task21.task2109;

/* 
Запретить клонирование
*/
public class Solution {
    public static class A implements Cloneable {
        private int i;
        private int j;

        public A(int i, int j) {
            this.i = i;
            this.j = j;
        }

        public int getI() {
            return i;
        }

        public int getJ() {
            return j;
        }
    }

    public static class B extends A {
        private String name;

        public B(int i, int j, String name) {
            super(i, j);
            this.name = name;
        }

        public String getName() {
            return name;
        }

        public B clone() throws CloneNotSupportedException {
            throw new CloneNotSupportedException();
        }


    }

    public static class C extends B implements Cloneable {
        public C(int i, int j, String name) {
            super(i, j, name);
        }

        @Override
        public C clone() {
            C c = new C(this.getI(), this.getJ(), this.getName());
            return c;


        }
    }

    public static void main(String[] args) throws CloneNotSupportedException {
//        B b = new B(2, 4, "B");
//        B cloneB = b.clone();
        C c = new C(2,3, "C");
        C cloneC = c.clone();
        System.out.println(c);
        System.out.println(cloneC);


    }
}
