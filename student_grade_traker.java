import java.util.Scanner;
public class student_grade_traker{
    public static void main(String args[]){
    Scanner s=new Scanner(System.in);
    System.out.println("Enter the number of subjects :");
    int numsubjects=s.nextInt();
    int marks[]=new int[numsubjects];
    String namesubjects=s.nextLine();


    int totalmarks=0;
    
    for(int i=0;i<numsubjects;i++){
        System.out.println("Enter obtained marks in each subjects  " +(i+1)+":");
        marks[i]=s.nextInt();
        totalmarks=totalmarks+marks[i];

    }
    System.out.println("Entet the length of string :");
    int n=s.nextInt();
    String name[]=new String[n];
    for(int i=0;i<n;i++){
        System.out.println("Enter the name of Subject "+(i+1)+":");
        name[i]=s.next();
    }

    double averagepercentage=(double) totalmarks/(numsubjects*100)*100;

    System.out.println("This is your result :");
    System.out.println("_____________________________________________________________________________________");
    System.out.println("Subjects entered by user :");
    for(int i=0;i<n;i++){
        System.out.println(name[i]+"="+marks[i]);
    }

    System.out.println("________________________________________________________________________________________");

    System.out.println("Your obtained marks :"+totalmarks);
    System.out.println("Total marks :"+numsubjects*100);
    System.out.println("Average Percentage :"+averagepercentage+ "%");

    String grade=calculategrade(averagepercentage);
    System.out.println("Grade :"+grade);




}
public static String calculategrade(double percentage){
    if(percentage>=90){
        return "A+";
    }
    else if(percentage>=80){
        return "A";
    }
    else if(percentage>=70){
        return "B";
    }
    else if(percentage>=60){
        return "C";
    }
    else if(percentage>=50){
        return "D";
    }
    else{
        return "Fail";
    }
}


}