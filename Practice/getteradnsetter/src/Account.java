public class Account {
    String Name;
    int age;
    public static void main(String[] args) {
      Account a = new Account();
      a.setAge(34);
      a.setName("Palo");
      System.out.println(a.getName());
      System.out.println(a.getAge());

      a.printDetails();

    }
    public void setName(String Name){
        this.Name = Name;
    }
    public void setAge(int age){
        this.age = age;
    }
    public String getName(){
        return this.Name;
    }
    public Integer getAge(){
    return this.age;
    }
    public void printDetails() {
        System.out.println(Name+","+age);
    }
}