package by.training.epam.task3multithreading.bean;

import java.util.ArrayList;

public class Matrix {
    private int size;
    private static final Matrix instance = new Matrix();
    private  ArrayList<ArrayList<Element>> matrix;

    public boolean isModified(){
        for(ArrayList<Element> arr: matrix){
            for (Element element:arr){
               if(!element.isModified()){return false;}
            }
        }
        return true;
    }

    public void setMatrix(ArrayList<ArrayList<Element>> matrix){
        this.matrix = matrix;
    }

    public ArrayList<ArrayList<Element>> getMatrix() {
        return matrix;
    }

    public static Matrix getInstance(){
        return instance;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    private Matrix(){}
    @Override
    public String toString() {
        if(matrix == null){
            return "Matrix is empty";
        }

        StringBuilder stringBuilder = new StringBuilder();

        for(ArrayList<Element> arr: matrix){
            for (Element element:arr){
                stringBuilder.append(Integer.toString(element.getInfo())+" ");
            }
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }
}
