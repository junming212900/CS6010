public class student {
    int studentID;
    String name;
    student(int studentID, String name){
       this.studentID = studentID;
       this.name = name;

    }
    public String toString(){
        return studentID+" "+name;
    }


}
