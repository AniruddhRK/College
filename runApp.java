import java.util.HashMap;
import java.util.Scanner;
import java.util.TreeSet;
public class runApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        HashMap<Integer,student> hm = new HashMap<>(10,0.5f);
        int choice;
        int rollNo =0;
        while(true){
            System.out.println("1. Create Student\n2. Delete Student\n3. View Student");
            System.out.println("4. View All Students\n5. View Rank Card\n6.Exit");
            System.out.println("Enter the choice");
            choice = sc.nextInt();
            sc.nextLine();
            switch (choice){
                case 1:
                    student s = new student();
                    s.setDetails(sc,++rollNo);
                    hm.put(rollNo,s);
                    break;
                case 2:
                    System.out.println("Enter the Roll No to Delete: ");
                    int delRollNo = sc.nextInt();
                    hm.remove(delRollNo);
                    break;
                case 3:
                    student currStudent;
                    System.out.println("Enter the Student Roll No to view his Details: ");
                    int viewRollNo = sc.nextInt();
                    System.out.printf("%-12s%-26s%8s\n","Roll Number","Name","Total Marks");
                    currStudent = hm.get(viewRollNo);
                    System.out.printf(String.valueOf(currStudent));
                    break;
                case 4:
                    System.out.printf("%-12s%-26s%8s\n","Roll Number","Name","Total Marks");
                    hm.forEach((k,v)->System.out.printf(String.valueOf(v)));
                    break;
                case 5:
                    TreeSet<student> rank = new TreeSet<>();
                    hm.forEach((k,v)->rank.add(v));
                    System.out.printf("%-12s%-26s%8s\n","Roll Number","Name","Total Marks");
                    rank.forEach(System.out::println);
                    break;
                case 6:
                    System.exit(0);
            }
        }
    }
}
