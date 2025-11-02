package problem3;

public class Novel extends Book{
    public double price;


    public Novel( String title, String author, int nbrPages,double price){
        super(title,author,nbrPages);
        this.price=price;


    }
    public String toString(){
        return "numRec : "+numRec+" title : "+title+ "Author : "+author+" nbrPages : "+nbrPages +"Price :"+price;
    }
}