public class Enrollment { //to link between parent and student 
    Student student; //connecting enrollment to Student and Course and giving them the name "student" and "course
    Course course;
    private double grade; //keeping the value private
    public  Enrollment (Student student,Course course){//removed grade from parameters because you need to enroll first before having any grade 
        this.student=student;
        this.course=course;
        this.grade=0.0;//set to zero because we dont have any grade yet
}

    public void setGrade(double grade){ ///using setters to change data safely 
         this.grade=grade;
    }

      public double getGrade(){ //using getters to read data safely 

         return grade;
    }
      
      public String letter(){ //method to add a letter beside the final grade 
      if(grade>=90)
          return "A";
      else if (grade>=80)
          return "B";
      
       else if (grade>=70)
          return "C";
       else if (grade>=60)
          return "D";
      else
        
          return "F";
      
      
      }
      

      public void displayEnrollment(){ //printing
       System.out.println("Course:"+ course.getCourseCode());
       System.out.println("Grade:"+ grade+"("+letter()+")");

      }


} 

