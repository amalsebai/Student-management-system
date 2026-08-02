
public class Course  {
    private String courseCode; //applying encapsulation to keep data private and safe  
    private String courseTitle;
    private int creditHours;
    public Course(String courseCode,String courseTitle,int creditHours){//constructor with arguments and initializing them
        this.courseCode=courseCode;
        this.courseTitle=courseTitle;
        this.creditHours=creditHours;
    
    
    
    }
    public String getCourseCode(){ //getter to read the course code safely 
    return courseCode;
    
    
    }
    public void displayCourseInfo(){//printing 
    System.out.println("-----COURSE INFO-----");
    System.out.println("Course Code: "+courseCode);
    System.out.println("Course Title: "+courseTitle);
    System.out.println("Credit Hours: "+creditHours);
     System.out.println("--------------------------");
    
    
    } 
            
    
}
