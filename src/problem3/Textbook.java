package problem3;


public class Textbook extends Book{
    public String level;

    public Textbook( String title, String author, int nbrPages,String level){
        super(title,author,nbrPages);
        this.level=level;


    }
    public String toString(){
        return "numRec : "+numRec+" title : "+title+ "Author : "+author+" nbrPages : "+nbrPages+" level :"+level;
    }
}
