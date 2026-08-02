import java.util.ArrayList; 
 public class Student extends Person{ //child class that is realted to person class
        private  String studentId; //applying encapsulation to keep data private and safe 
        private String  major;
       private  ArrayList<Enrollment>enrolledCourses ; //array to keep track of the registered courses for each student 
         private double grades;
    public Student(String id,String name,String email,String studentId, String major){
    super(id,name,email); //passing these from parent class 
    this.studentId=studentId;
    this.major=major;
    this.enrolledCourses=new ArrayList <>() ; //initializes the course array
    this.grades=0;
    }
     public String getstudentId(){ //using getters to read data safely 
     return studentId;
     
     
     }
    
     public String getmajor( ){//using getters to read data safely 
     return major;
     
     
     }
     
     public ArrayList<Enrollment> getEnrolledCourses(){//using getters to read data safely 
     return enrolledCourses;
     
     
     }
      public void setstudentId(String studentId){ ///using setters to change data safely 
          this.studentId=studentId;
          
      
      
      }
      public void setmajor(String major){
          this.major=major;
           
      
      
      }
      
      
      public void enroll(Course course){ //method to enroll passing the netire class so we have access
          for(int i=0;i<enrolledCourses.size();i++){//looping over the array to see if student is already enrolled 
          Enrollment currentEnrollment=enrolledCourses.get(i); //creating a variable 
          if( currentEnrollment.course.getCourseCode().equalsIgnoreCase(course.getCourseCode())){
          System.out.println("ERROR:student already enrolled in this course. ");
          return ; //stops if the sudent is enrolled
          }
          
          
          }
          // this referes to studentfound in main class
          Enrollment newEnrollment= new Enrollment(this,course);//if student is not found then enroll them 
          enrolledCourses.add(newEnrollment);
          System.out.println("Course registered: "+ this.getname()+"->"+course.getCourseCode());

          
      
      
      }
      public void addGrade(String courseCode, double grade){ //method to enter or update a grade
      if((grade<0)||(grade>100)){ //input validation
      System.out.println("ERROR: grades must be between 0 and 100. ");
          return;
      
      } 
      for(int i=0;i<enrolledCourses.size();i++){//loop over enrolledCourses for thr student 
          Enrollment currentEnrollment=enrolledCourses.get(i);
          if( currentEnrollment.course.getCourseCode().equalsIgnoreCase(courseCode)){
          currentEnrollment.setGrade(grade);//update the grade value
          System.out.println("Grade updated for: "+courseCode);
          return;
          }
      
      
      }
       System.out.println("ERROR: cannot add grade student is not enrolled in "+courseCode);
      
      }
      public double calculateAverage(){ //method to calculate the avg for the students 
          double total=0;
      if(enrolledCourses.isEmpty()){ //checks if the student has ant enrolled courses if no return 0 
      return 0.0;
      
      }
      else{
      for(int i=0;i<enrolledCourses.size();i++){
      Enrollment currentEnrollment=enrolledCourses.get(i);
      total+= currentEnrollment.getGrade();// updating total
      
      
      }
      return total/enrolledCourses.size(); //return the avg 
      
      }
      
      
      }
      
      public void displayTranscript(){ //printing 
          System.out.println("-----STUDENTS TRANSCRIPT-----");
          super.displayInfo();// access from person (parent class)
          System.out.println("Student ID:"+studentId);
          System.out.println("Major:"+major);
          System.out.println("Enrolled Courses:");
    
        if(enrolledCourses.isEmpty()){
        System.out.println("No courses enrolled yet.");
        } 
        else{ //loop over  enrolledCourses and print each one 
        for (int i=0;i<enrolledCourses.size();i++) {
            Enrollment current = enrolledCourses.get(i);//we used Enrollment class so we can access anything inside the class
            current.displayEnrollment(); //accessed from the enrollment class
        }
        }
    
   
    System.out.println("Average Grade: "+String.format("%.2f",calculateAverage())); 
        
    System.out.println("--------------------------");
      
      
      
      }
     
}
