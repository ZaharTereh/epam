package by.training.epam.task3multithreading.bean;

public class Element {
    private int info;
    private boolean isModified = false;

    public Element(int info){
        this.info = info;
        this.isModified = false;
    }

    public int getInfo() {
        return info;
    }

    public void setInfo(int info) {
        this.info = info;
    }

    public boolean isModified() {
        return isModified;
    }

    public void setModified(boolean modified) {
        isModified = modified;
    }
}
