package problem3;

public class Document {
    private static int counter = 0;   // shared among all documents
    protected int numRec;
    protected String title;

    public Document(String title) {
        this.title = title;
        this.numRec = ++counter;      // auto-increment each time a new Document is created
    }

    public int getNumRec(){
        return numRec;
    }
    public String getTitle() {
        return title;
    }
    public String toString(){
        return "numRec : "+numRec+" title : "+title;
    }
}
