package com.company;

import javax.swing.table.AbstractTableModel;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class BookTableModel extends AbstractTableModel {
    private int columnCount = 4;
    private ArrayList<String[]> dataArrayList;


    public BookTableModel(){
        dataArrayList = new ArrayList<String[]>();
        for (int i = 0; i < dataArrayList.size(); i++){
            dataArrayList.add(new String[getColumnCount()]);
        }
    }

    @Override
    //строки
    public int getRowCount() {
        return dataArrayList.size();
    }

    @Override
    //колонки
    public int getColumnCount() {
        return columnCount;
    }
    @Override
    public String getColumnName(int columnIndex){
        switch (columnIndex){
            case 0: return "id";
            case 1: return "title";
            case 2: return "isbn";
            case 3: return "description";
        }
        return "";
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        String [] rows = dataArrayList.get(rowIndex);

        return rows[columnIndex];
    }
    public void addData(String[] row){
        String[] rowTable = new String[getColumnCount()];
        rowTable = row;
        dataArrayList.add(rowTable);
    }
    public void addData(ConnectionDB connection){
        ResultSet resultSet = connection.resultSetQuery("SELECT * FROM book");
        try {
            while (resultSet.next()){
                String[] row = {
                        resultSet.getString("id"),
                        resultSet.getString("title"),
                        resultSet.getString("isbn"),
                        resultSet.getString("description")
                };
                addData(row);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
