import java.util.Scanner;
public class student implements Comparable {
    private String Name;
    private int rollNo;
    private double[] markList = new double[5];
    private double totalMarks;
    public void setDetails(Scanner sc,int rollNo){
        System.out.println("Enter the Name: ");
        this.Name = sc.nextLine();
        this.rollNo = rollNo;
        for(int i=0;i<5;++i){
            System.out.println("Enter mark for subject "+(i+1));
            double temp = sc.nextDouble();
            if(temp>100||temp<0){
                --i;
                continue;
            }
            this.markList[i] = temp;
            this.totalMarks+=temp;
        }
    }
    public double getTotalMarks(){
        return this.totalMarks;
    }
    public int getRollNo(){
        return this.rollNo;
    }
    @Override
    public int compareTo(Object o) {
        student s = (student) o;
        if(this.totalMarks>s.totalMarks)
            return -1;
        else if(this.totalMarks<s.totalMarks)
            return 1;
        else{
            if(this.rollNo<s.rollNo)
                return -1;
            else
                return 1;
        }
    }
    public String toString(){
        String send = String.format("%-12d%-26s%7.3f\n",this.rollNo,this.Name,this.totalMarks);
        return send;
    }
}
