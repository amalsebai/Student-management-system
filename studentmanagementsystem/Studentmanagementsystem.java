import java.util.Scanner; //importing scanner for input
import java.util.ArrayList;// importing array for creating array
public class Studentmanagementsystem{
    
    
    public static void main(String[]args){
        boolean working=true; //control variable to keep the loop running 
   Scanner input=new Scanner (System.in); //scanner object
    ArrayList<Student> ALLSTUDENTS =new ArrayList<>();  //creating an array 
    ArrayList<Course> ALLCOURSES =new ArrayList<>();//creating an array 
    while(working){ // loop that keep looping until the user enters 7 so the boolean becomes false
        System.out.println("----- STUDENT MANAGEMENT SYSTEM -----"); //printing the menu 
            System.out.println("1.Add student");
            System.out.println("2.Add course");
            System.out.println("3.Enroll a student in a course");
            System.out.println("4.Enter or update a grade");
            System.out.println("5.Display student transcript");
            System.out.println("6.Display all students and courses");
            System.out.println("7.Exit");
            System.out.println("Enter your choice: ");
            int choice=input.nextInt();// taking input
            input.nextLine(); //removes the trailing \n 
            
            
            if(choice==1){ //Add student option

            System.out.println("Enter your National ID: ");         //display 
            String id=input.nextLine();                     // taking input
            System.out.println("Enter your name: ");
            String name=input.nextLine();
            System.out.println("Enter your email: ");
            String email=input.nextLine();
            System.out.println("Enter your student ID: ");
            String  studentId=input.nextLine();
            System.out.println("Enter your major: ");
            String major=input.nextLine();
            
           
       addStudent( id, name, email, studentId, major,ALLSTUDENTS);
    
    
    
    
    }
           
            else if (choice==2){ //Add course option
         
         System.out.println("Enter course code: ");
            String courseCode=input.nextLine();  // taking input
            System.out.println("Enter course title: ");    //display 
            String  courseTitle=input.nextLine();
            System.out.println("Enter credit hours : ");
            int creditHours=input.nextInt();
            input.nextLine();   //removes the trailing \n 
             addCourse(courseCode, courseTitle, creditHours,ALLCOURSES);
         
         
       
        
    }
   else if(choice==3){//Enroll a student in a course option
       
     System.out.println("Enter student ID: ");
            String searchID=input.nextLine();
            System.out.println("Enter course code: ");
            String  searchCODE=input.nextLine();

     enrollStudent (searchCODE,searchID,ALLCOURSES,ALLSTUDENTS);
    
    
    
    
    
    
    
    
    
    }
    
    else if(choice==4){//Enter or update a grade
    
    System.out.println("Enter student ID: ");
            String searchID=input.nextLine();
            System.out.println("Enter course code: ");
            String  searchCODE=input.nextLine();
            System.out.println("Enter grade(0-100): ");
            double newgrade=input.nextDouble();
            input.nextLine();
  enterGrade(searchCODE, searchID, newgrade,ALLSTUDENTS);
    
    
    }
    
    
    else if(choice==5){//Display student transcript option
             System.out.println("Enter student ID: ");
            String searchID=input.nextLine();
            
    displayTranscript(searchID,ALLSTUDENTS);
    
    
    
    
  }
 else if(choice==6){//Display all students and courses option
    displayReports(ALLSTUDENTS,ALLCOURSES);
 
 
 
 }
            
            
 else if(choice==7){
 working=false; //updating boolean to exit the while loop 
   System.out.println("Exiting the system.Thank you !");
 
 
 }
            
            
            
            
            
            
            
    }       
            
            
    }
    public static void addStudent(String id,String name,String email,String studentId,String major,ArrayList<Student>ALLSTUDENTS){
    boolean IDexist=false; //boolean to track if the id exists or no
            
           for(int i=0;i<ALLSTUDENTS.size();i++){  //looping over the array
           if(ALLSTUDENTS.get(i).getstudentId().equalsIgnoreCase(studentId)){
           IDexist=true; //updating boolean
           }
           }
            
           if(IDexist){
               
             System.out.println("ERROR:student with this ID already exist.");
            }
            else{ //creating a new data for student using a constructor 
            Student newstud=new Student( id,name,email, studentId, major);
                    ALLSTUDENTS.add(newstud); //adding info to the array
                    System.out.println("Student added: "+studentId+" - "+name+" - "+major);
            
            
            }}
    public static void addCourse(String courseCode,String courseTitle,int creditHours,ArrayList<Course> ALLCOURSES){
    boolean CODEexist=false; //boolean to track if the code exists or no
    for(int i=0;i<ALLCOURSES.size();i++){   //looping over the array
             if(ALLCOURSES.get(i).getCourseCode().equalsIgnoreCase(courseCode)){
             CODEexist=true;
             
             }
         
         
         
         
         }
         if(CODEexist){
         
          System.out.println("ERROR:course with this code already exist.");
         
         }
         else{ //creating a new data set for student using a constructor 
         Course newcourse= new Course(courseCode,courseTitle,creditHours);
         ALLCOURSES.add(newcourse); //adding info to the array
          System.out.println("Course added: "+courseCode+" - "+courseTitle+" - "+ creditHours+"C.H");
         
         }
    
    
    
    }
    public static void enrollStudent(String searchCODE,String searchID,ArrayList<Course> ALLCOURSES,ArrayList<Student>ALLSTUDENTS){
     Student studentfound=null;   //variable that will hold the new name  /student before so we can access the student class 
    for(int i=0;i<ALLSTUDENTS.size();i++){
           if(ALLSTUDENTS.get(i).getstudentId().equalsIgnoreCase(searchID)){
          studentfound=ALLSTUDENTS.get(i); //updating it 
           }
           }
    
     Course codefound=null;  //variable that will hold the code for the subject
     for(int i=0;i<ALLCOURSES.size();i++){ //loop over the array
          if(ALLCOURSES.get(i).getCourseCode().equalsIgnoreCase(searchCODE)){
          codefound=ALLCOURSES.get(i); //updating it 
           }
           }
    
    
    if(studentfound==null){  //case handeling if no student name or course code found 
        System.out.println("Student not found. ");
    }
    else if(codefound==null){
        System.out.println("Code not found. ");
    }
    else if ((studentfound!=null)&&(codefound!=null)){
      studentfound.enroll(codefound);
        
    }
    
        
    
    
    
    }
    public static void enterGrade(String searchCODE,String searchID,double newgrade,ArrayList<Student>ALLSTUDENTS){
    
       Student studentfound=null;
    for(int i=0;i<ALLSTUDENTS.size();i++){ //loop over tha array
           if(ALLSTUDENTS.get(i).getstudentId().equalsIgnoreCase(searchID)){
          studentfound=ALLSTUDENTS.get(i);
           }
           }
    if(studentfound==null){
     System.out.println("ERROR:student doesnt exist. ");
    
    
    }
    else{
    studentfound.addGrade( searchCODE,newgrade); //passing the parameters that are in the student class for add grade method
    
    
    }
    
    }
    public static void displayTranscript(String searchID,ArrayList<Student>ALLSTUDENTS){
             Student studentfound=null;
    for(int i=0;i<ALLSTUDENTS.size();i++){
           if(ALLSTUDENTS.get(i).getstudentId().equalsIgnoreCase(searchID)){
          studentfound=ALLSTUDENTS.get(i);
           }
           }
            
     if(studentfound==null){ // checks if student is found before printing 
     System.out.println("ERROR:student doesnt exist. ");
    
    
    }
    else{
    studentfound.displayTranscript();
    
    
    }
    
    
    
    
    }
    public static void displayReports(ArrayList<Student>ALLSTUDENTS,ArrayList<Course> ALLCOURSES){
     for(int i=0;i<ALLSTUDENTS.size()-1;i++){ //outer loop through the whole list
     
     for(int j=0;j<ALLSTUDENTS.size()-i-1;j++){ //inner loop to comapre the value 
     if(ALLSTUDENTS.get(j).calculateAverage()<ALLSTUDENTS.get(j+1).calculateAverage()){ //highest to lowest gpa
     Student temp= ALLSTUDENTS.get(j);// to save current student 
     ALLSTUDENTS.set(j,ALLSTUDENTS.get(j+1)); //moving the next student into the current postion
     ALLSTUDENTS.set(j+1,temp); //the saved current student position 
     
     
     }
     
     
     }
     
     
     }
     
     
     
     
     
     
     
  System.out.println("-----ALL STUDENTS----- ");
  if(ALLSTUDENTS.isEmpty()){ //checking id the array is empty
      
  System.out.println("No registered students yet.");}
  else{ // if not empty loop over the student array
     for(int i=0;i<ALLSTUDENTS.size();i++){ 
     ALLSTUDENTS.get(i).displayInfo(); 
      System.out.println("Average: " + String.format("%.2f",ALLSTUDENTS.get(i).calculateAverage()));
     }
  
  
  }
  
    System.out.println("-----ALL COURSES----- ");
  
 if(ALLCOURSES.isEmpty()){
      
  System.out.println("No created courses yet!");
 
 }
  else{
     for(int i=0;i<ALLCOURSES.size();i++){
     
     ALLCOURSES.get(i).displayCourseInfo();
     }
 
 
 
 
 
 }
 
    
    
    }



}
