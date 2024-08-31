import java.util.Scanner;

class Example {
    static final int MAX_STUDENTS = 100;
    static String[] stId = new String[MAX_STUDENTS];
    static String[] stName = new String[MAX_STUDENTS];
    static int[] marksPRF = new int[MAX_STUDENTS];
    static int[] marksDB = new int[MAX_STUDENTS];
    static int stCnt = 0;
    static {
        for (int i = 0; i < MAX_STUDENTS; i++) {
            marksPRF[i] = -1;
            marksDB[i] = -1;
        }
    }
    public static void clearConsole() {
        try {
            final String os = System.getProperty("os.name");
            if (os.contains("Windows")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                System.out.print("\033[H\033[2J");
                System.out.flush();
            }
        } catch (final Exception e) {
            e.printStackTrace();
        }
    }
    public static void addName() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\t\t\tADD NEW STUDENT");
        boolean check = true;
        System.out.print("Enter Student ID\t:");
        String id = scanner.nextLine();
        stId[stCnt] = id;
        System.out.print("Enter Student Name\t:");
        String name = scanner.nextLine();
        stName[stCnt] = name;
        stCnt++;
        while (check) {
            System.out.print("Student has been added successfully. Do you want to add a new student (Y/N):");
            String nw = scanner.nextLine();
            switch (nw) {
                case "Y":
                case "y":
                    System.out.print("Enter Student ID\t:");
                    id = scanner.nextLine();
                    boolean exist = false;
                    for (int i = 0; i < stCnt; i++) {
                        if (stId[i].equals(id)) {
                            exist = true;
                            break;
                        }
                    }
                    while (exist) {
                        System.out.println("The Student ID already exists");
                        System.out.print("Enter Student ID\t:");
                        id = scanner.nextLine();
                        exist = false;
                        for (int i = 0; i < stCnt; i++) {
                            if (stId[i].equals(id)) {
                                exist = true;
                                break;
                            }
                        }
                    }
                    stId[stCnt] = id;
                    System.out.print("Enter Student Name\t:");
                    name = scanner.nextLine();
                    stName[stCnt] = name;
                    stCnt++;
                    break;
                default:
                    check = false;
                    break;
            }
        }
    }
    public static void nameWithMarks() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\t\t\tADD NEW STUDENT WITH MARKS");
        boolean check = true;
        System.out.print("Enter Student ID\t:");
        String id = scanner.nextLine();
        stId[stCnt] = id;
        System.out.print("Enter Student Name\t:");
        String name = scanner.nextLine();
        stName[stCnt] = name;
        System.out.print("Programming Fundamentals marks :");
        int marksPRFInput = scanner.nextInt();
        scanner.nextLine();
        while (marksPRFInput < 0 || marksPRFInput > 100) {
            System.out.println("Invalid marks, please enter correct marks");
            System.out.print("Programming Fundamentals marks :");
            marksPRFInput = scanner.nextInt();
            scanner.nextLine();
        }
        marksPRF[stCnt] = marksPRFInput;
        System.out.print("Database Management System marks :");
        int marksDBInput = scanner.nextInt();
        scanner.nextLine();
        while (marksDBInput < 0 || marksDBInput > 100) {
            System.out.println("Invalid marks, please enter correct marks.");
            System.out.print("Database Management System marks :");
            marksDBInput = scanner.nextInt();
            scanner.nextLine();
        }
        marksDB[stCnt] = marksDBInput;
        stCnt++;
        while (check) {
            System.out.print("Student has been added successfully. Do you want to add a new student (Y/N):");
            String nw = scanner.nextLine();
            switch (nw) {
                case "Y":
                case "y":
                    System.out.print("Enter Student ID\t:");
                    id = scanner.nextLine();
                    boolean exist = false;
                    for (int i = 0; i < stCnt; i++) {
                        if (stId[i].equals(id)) {
                            exist = true;
                            break;
                        }
                    }
                    while (exist) {
                        System.out.println("The Student ID already exists");
                        System.out.print("Enter Student ID\t:");
                        id = scanner.nextLine();
                        exist = false;
                        for (int i = 0; i < stCnt; i++) {
                            if (stId[i].equals(id)) {
                                exist = true;
                                break;
                            }
                        }
                    }
                    stId[stCnt] = id;
                    System.out.print("Enter Student Name\t:");
                    name = scanner.nextLine();
                    stName[stCnt] = name;
                    System.out.print("Programming Fundamentals marks :");
                    marksPRFInput = scanner.nextInt();
                    scanner.nextLine();
                    while (marksPRFInput < 0 || marksPRFInput > 100) {
                        System.out.println("Invalid marks, please enter correct marks");
                        System.out.print("Programming Fundamentals marks :");
                        marksPRFInput = scanner.nextInt();
                        scanner.nextLine();
                    }
                    marksPRF[stCnt] = marksPRFInput;
                    System.out.print("Database Management System marks :");
                    marksDBInput = scanner.nextInt();
                    scanner.nextLine();
                    while (marksDBInput < 0 || marksDBInput > 100) {
                        System.out.println("Invalid marks, please enter correct marks");
                        System.out.print("Database Management System marks :");
                        marksDBInput = scanner.nextInt();
                        scanner.nextLine();
                    }
                    marksDB[stCnt] = marksDBInput;
                    stCnt++;
                    break;
                default:
                    check = false;
                    break;
            }
        }
    }
    public static void addMarks() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\t\t\tADD MARKS");
        boolean check = true;
        while (check) {
            System.out.print("Enter Student ID  :");
            String tempID = scanner.nextLine();
            boolean exist = false;
            int index = 101;
            for (int i = 0; i < stCnt; i++) {
                if (stId[i].equals(tempID)) {
                    exist = true;
                    index = i;
                    break;
                }
            }
            if (!exist) {
                System.out.print("Invalid Student ID. Do you want to search again? (Y/N):");
                String nw = scanner.nextLine();
                if (!nw.equalsIgnoreCase("Y")) {
                    return;
                }
            } else if (marksPRF[index] != -1 || marksDB[index] != -1) {
                System.out.println("This student's marks have been already added.");
                System.out.println("If you want to update the marks, please use [4] Update Marks option");
                System.out.print("Do you want to add marks for another student? (Y/N): ");
                String nw = scanner.nextLine();
                if (!nw.equalsIgnoreCase("Y")) {
                    return;
                }
            } else {
                System.out.println("Student Name: " + stName[index]);
                System.out.print("Programming Fundamentals marks :");
                int marksPRFInput = scanner.nextInt();
                scanner.nextLine();
                while (marksPRFInput < 0 || marksPRFInput > 100) {
                    System.out.println("Invalid marks, please enter correct marks");
                    System.out.print("Programming Fundamentals marks :");
                    marksPRFInput = scanner.nextInt();
                    scanner.nextLine();
                }
                marksPRF[index] = marksPRFInput;
                System.out.print("Database Management System marks :");
                int marksDBInput = scanner.nextInt();
                scanner.nextLine();
                while (marksDBInput < 0 || marksDBInput > 100) {
                    System.out.println("Invalid marks, please enter correct marks");
                    System.out.print("Database Management System marks :");
                    marksDBInput = scanner.nextInt();
                    scanner.nextLine();
                }
                marksDB[index] = marksDBInput;
                System.out.print("Marks have been added. Do you want to add marks for another student? (Y/N): ");
                String nw = scanner.nextLine();
                if (!nw.equalsIgnoreCase("Y")) {
                    return;
                }
            }
        }
    }
    public static void updateStDetails() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\t\t\tUPDATE STUDENT WITH MARKS");
        while (true) {
            System.out.print("Enter Student ID  :");
            String tempID = scanner.nextLine();
            boolean exist = false;
            int index = -1;
            for (int i = 0; i < stCnt; i++) {
                if (stId[i].equals(tempID)) {
                    exist = true;
                    index = i;
                    break;
                }
            }
            if (!exist) {
                System.out.print("Invalid Student ID. Do you want to continue search? (Y/N):");
                String nw = scanner.nextLine();
                if (!nw.equalsIgnoreCase("Y")) {
                    return;
                }
            } else {
                System.out.println("Current Student Name: " + stName[index]);
                System.out.print("Enter New Student Name: ");
                String newName = scanner.nextLine();
                stName[index] = newName;
                System.out.println("Student details has been updated successfully.");
                System.out.print("Do you want to update another student details? (Y/N): ");
                String nw = scanner.nextLine();
                if (!nw.equalsIgnoreCase("Y")) {
                    return;
                }
            }
        }
    }
    public static void updateMarks() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\t\t\tUPDATE MARKS");
        while (true) {
            System.out.print("Enter Student ID  :");
            String tempID = scanner.nextLine();
            boolean exist = false;
            int index = -1;
            for (int i = 0; i < stCnt; i++) {
                if (stId[i].equals(tempID)) {
                    exist = true;
                    index = i;
                    break;
                }
            }
            if (!exist) {
                System.out.print("Invalid Student ID. Do you want to search again?(Y/N):");
                String nw = scanner.nextLine();
                if (!nw.equalsIgnoreCase("Y")) {
                    return;
                }
            } else {
                if (marksPRF[index] == -1 && marksDB[index] == -1) {
                    System.out.println("This student's marks yet to be added.");
                    System.out.print("Do you want to update the marks of another student? (Y/N): ");
                    String nw = scanner.nextLine();
                    if (!nw.equalsIgnoreCase("Y")) {
                        return;
                    }
                } else {
                    System.out.println("Student Name: " + stName[index]);
                    System.out.println("Programming Fundamentals marks: " + (marksPRF[index] == -1 ? "Not added yet" : marksPRF[index]));
                    System.out.println("Database Management System marks: " + (marksDB[index] == -1 ? "Not added yet" : marksDB[index]));
                    System.out.print("Enter new Programming Fundamentals Marks: ");
                    int marksPRFInput = scanner.nextInt();
                    scanner.nextLine();
                    while (marksPRFInput < 0 || marksPRFInput > 100) {
                        System.out.println("Invalid marks, please enter correct marks");
                        System.out.print("Enter new Programming Fundamentals Marks: ");
                        marksPRFInput = scanner.nextInt();
                        scanner.nextLine();
                    }
                    marksPRF[index] = marksPRFInput;
                    System.out.print("Enter new Database Management System Marks: ");
                    int marksDBInput = scanner.nextInt();
                    scanner.nextLine();
                    while (marksDBInput < 0 || marksDBInput > 100) {
                        System.out.println("Invalid marks, please enter correct marks");
                        System.out.print("Enter new Database Management System Marks: ");
                        marksDBInput = scanner.nextInt();
                        scanner.nextLine();
                    }
                    marksDB[index] = marksDBInput;
                    System.out.println("Marks have been updated successfully.");
                    System.out.print("Do you want to update marks for another student? (Y/N): ");
                    String nw = scanner.nextLine();
                    if (!nw.equalsIgnoreCase("Y")) {
                        return;
                    }
                }
            }
        }
    }
    public static void deleteSt(){
    Scanner scanner=new Scanner(System.in);
        System.out.println("\t\t\tDELETE STUDENT");
    while (true) {
        System.out.print("Enter Student ID: ");
        String tempID = scanner.nextLine();
        int index = 404;
        boolean exist = false;
        for (int i = 0; i < stCnt; i++) {
            if (stId[i].equals(tempID)) {
                exist = true;
                index = i;
                break;
            }
        }
            if (!exist) {
                System.out.print("Invalid Student ID. Do you want to search again? (Y/n):");
                String nw = scanner.nextLine();
                if (!nw.equalsIgnoreCase("Y")) {
                    return;
                }
            }else {
                for (int i = index; i < stCnt - 1; i++) {
                    stId[i] = stId[i + 1];
                    stName[i] = stName[i + 1];
                    marksPRF[i] = marksPRF[i + 1];
                    marksDB[i] = marksDB[i + 1];
                }
                stCnt--;
                System.out.println("Student has been deleted successfully");
                System.out.print("Do you want to delete another student? (y/n)");
                String nw = scanner.nextLine();
                if (!nw.equalsIgnoreCase("Y")) {
                    return;
                }
            }
        }
    }
    public static void printSt() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\t\t\tPRINT STUDENT DETAILS");
        while (true) {
            System.out.print("Enter Student ID: ");
            String tempID = scanner.nextLine();
            int index = 404;
            boolean exist = false;
            for (int i = 0; i < stCnt; i++) {
                if (stId[i].equals(tempID)) {
                    exist = true;
                    index = i;
                    break;
                }
            }
            if (!exist) {
                System.out.print("Invalid Student ID. Do you want to search again? (Y/n):");
                String nw = scanner.nextLine();
                if (!nw.equalsIgnoreCase("Y")) {
                    return;
                }
            } else {
                System.out.println("Student Name: " + stName[index]);
                if (marksPRF[index] == -1 || marksDB[index] == -1) {
                    System.out.println("Marks yet to be added.");
                } else {
                    int totalMarks = marksPRF[index] + marksDB[index];
                    double avgMarks = totalMarks / 2.0;
                    int rank = 1;
                    for (int i = 0; i < stCnt; i++) {
                        if (i != index && marksPRF[i] != -1 && marksDB[i] != -1) {
                            int otherTotal = marksPRF[i] + marksDB[i];
                            if (otherTotal > totalMarks) {
                                rank++;
                            }
                        }
                    }
                    String rankText = "";
                    if (rank == 1) {
                        rankText = "(First)";
                    } else if (rank == 2) {
                        rankText = "(Second)";
                    } else if (rank == 3) {
                        rankText = "(Third)";
                    } else if (rank == stCnt) {
                        rankText = "(Last)";
                    }
                    System.out.println("Programming Fundamentals Marks: " + marksPRF[index]);
                    System.out.println("Database Management System Marks: " + marksDB[index]);
                    System.out.println("Total Marks: " + totalMarks);
                    System.out.println("Average Marks: " + avgMarks);
                    System.out.println("Rank: " + rank + " " + rankText);
                }
                System.out.print("Do you want to search another student details? (y/n): ");
                String nw = scanner.nextLine();
                if (!nw.equalsIgnoreCase("Y")) {
                    return;
                }
            }
        }
    }
    public static void printRanks() {
        Scanner scanner=new Scanner(System.in);
        System.out.println("\t\t\tPRINT STUDENT RANKS");
        int[][] array=new int[stCnt][3];
        int num=0;
        for(int i=0;i<stCnt;i++){
            if(marksPRF[i]!=-1&& marksDB[i]!=-1){
                array[num][0]=i;
                array[num][1]=marksPRF[i]+marksDB[i];
                array[num][2]=array[num][1]/2;
                num++;
            }
        }
        for(int i=0;i<num-1;i++){
            for(int j=i+1;j<num;j++){
                if(array[i][1]<array[j][1]){
                    int[] temp=array[i];
                    array[i]=array[j];
                    array[j]=temp;
                }
            }
        }
        System.out.println("Rank  ID  Name  Total Marks  Avg.Marks ");
        for(int i=0;i<num;i++){
            int oriSt=array[i][0];
            System.out.println((i+1)+"\t  "+stId[oriSt]+"\t   "+stName[oriSt]+"\t   "+array[i][1]+"\t\t\t"+array[i][2]);
        }
        while (true){
            System.out.print("Do want to go back to main menu?(Y/n)");
            String nw= scanner.nextLine();
            if(nw.equalsIgnoreCase("Y")){
                break;
            }else {
                continue;
            }
        }
    }
    public static void bestinPRF(){
        Scanner scanner=new Scanner(System.in);
        System.out.println("\t\t\tBEST IN PROGRAMMING FUNDAMENTALS");
        int[][] array=new int[stCnt][2];
        int num=0;
        for(int i=0;i<stCnt;i++){
            if(marksPRF[i]!=-1){
                array[i][0]=i;
                array[i][1]=marksPRF[i];
                num++;
            }
        }
        for(int i=0;i<num-1;i++){
            for(int j=i+1;j<num;j++){
                if(array[i][1]<array[j][1]){
                    int[] temp=array[i];
                    array[i]=array[j];
                    array[j]=temp;
                }
            }
        }
        System.out.println("ID\tName  PRF Marks");
        for(int i=0;i<num;i++){
            int x=array[i][0];
            System.out.println(stId[x]+"\t "+stName[x]+"\t\t"+array[i][1]);
        }
        while (true){
            System.out.print("Do you want to go to back menu(y/n):");
            String nw= scanner.nextLine();
            if(nw.equalsIgnoreCase("y")){
                break;
            }else{
                continue;
            }
        }
    }
    public static void bestinDB(){
        Scanner scanner=new Scanner(System.in);
        System.out.println("\t\t\tBEST IN DATABASE MANAGEMENT SYSTEM");
        int[][] array=new int[stCnt][2];
        int num=0;
        for(int i=0;i<stCnt;i++){
            if(marksDB[i]!=-1){
                array[i][0]=i;
                array[i][1]=marksDB[i];
                num++;
            }
        }
        for(int i=0;i<num-1;i++){
            for(int j=i+1;j<num;j++){
                if(array[i][1]<array[j][1]){
                    int[] temp=array[i];
                    array[i]=array[j];
                    array[j]=array[i];
                }
            }
        }
        System.out.println("ID\tName   DBMS Marks");
        for(int i=0;i<num;i++){
            int x=array[i][0];
            System.out.println(stId[x]+"\t"+stName[x]+"\t\t "+array[i][1]);
        }
        while (true){
            System.out.print("Do you want to go back to main menu(y/n):");
            String nw= scanner.nextLine();
            if(nw.equalsIgnoreCase("Y")){
                break;
            }else{
                continue;
            }
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\t\t\tWELCOME TO GDSE MARKS MANAGEMENT SYSTEM");
        while (true) {
            System.out.println("[1] Add New Student\t\t\t\t\t\t\t[2] Add New Student With Marks");
            System.out.println("[3] Add marks\t\t\t\t\t\t\t\t[4] Update Student Details");
            System.out.println("[5] Update marks\t\t\t\t\t\t\t[6] Delete Student");
            System.out.println("[7] Print Student Details\t\t\t\t\t[8] Print Student Ranks");
            System.out.println("[9] Best in Programming Fundamentals\t\t[10] Best in DataBase Management System");
            System.out.print("Enter an option to continue :");
            int option = scanner.nextInt();
            scanner.nextLine();
            clearConsole();
            System.out.println();
            switch (option) {
                case 1:
                    addName();
                    break;
                case 2:
                    nameWithMarks();
                    break;
                case 3:
                    addMarks();
                    break;
                case 4:
                    updateStDetails();
                    break;
                case 5:
                    updateMarks();
                    break;
                case 6:
                    deleteSt();
                    break;
                case 7:
                    printSt();
                    break;
                case 8:
                    printRanks();
                    break;
                case 9:
                    bestinPRF();
                    break;
                case 10:
                    bestinDB();
                    break;
                default:
                    System.out.println("........Invalid option........");
                    break;
            }
        }
    }
}
