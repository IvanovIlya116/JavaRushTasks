package com.javarush.task.task18.task1815;

import java.util.List;

/* 
Таблица
*/

public class Solution {
    public class TableInterfaceWrapper implements TableInterface {
        private TableInterface wrapper;

        public TableInterfaceWrapper(TableInterface wrapper) {
            this.wrapper = wrapper;

        }

        @Override
        public void setModel(List rows) {
            System.out.println(rows.size());
            wrapper.setModel(rows);

        }

        @Override
        public String getHeaderText() {
            return wrapper.getHeaderText().toUpperCase();
        }

        @Override
        public void setHeaderText(String newHeaderText) {
            wrapper.setHeaderText(newHeaderText);

        }
    }

    public interface TableInterface {
        void setModel(List rows);

        String getHeaderText();

        void setHeaderText(String newHeaderText);
    }

    public static void main(String[] args) {
    }
}