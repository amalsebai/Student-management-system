class Person { //parents class
   private String id; //applying encapsulation to keep data private and safe 
   private String name;
   private String email;
    
public Person(String id,String name,String email){ //creating a constructor with arguments 
this.id=id;
this.name=name;
this.email=email;



}

public String getId(){ //using getters to read data safely 
    return id;


}
public String getname(){
    return name;


}
public String getemail(){
    return email;


}

public void displayInfo(){ //method to print the info
System.out.println("Name: "+ name);
System.out.println("ID: "+ id);
System.out.println("Email: "+ email);

}
    
}
