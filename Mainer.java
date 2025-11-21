import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
import java.util.Scanner;
public class Mainer {

    //The Scanner class ..it is a object from Scanner class that make you able to get the users inputs
    public static Scanner scanner = new Scanner(System.in);

    //this hasOneDot() function i make it to help me check if the users enter a number has a dot or not to
    // because i need to check the format of the marks

    public static boolean hasOneDot(String string)
    {
        short count = 0;
        for(char c : string.toCharArray())
        {
            if(c == '.')
            {
                count ++;
            }
        }
        if(count == 1)
        {
            return true;
        }
        else
        {
            return false;
        }

    }

    //the function ValidationMethod() verify the entry if its suitable as the programmer need or not base on the condition that the programmers wrote in the parameters
    // It checks if the input is too long or have wrong letters or numbers
    // It is keep asking the user again and again until it's correct
    public static String ValidationMethod(String question, short textLength, String validationString, String lengthAlert, String validationAlert)
    {

        if(question == null)
        {
            question = "please enter : \n";
        }

        String entry;
        byte check = 1;

        do{

            if(check == -1)
            {
                System.out.println(lengthAlert);
            }
            else if(check == 0)
            {
                System.out.println(validationAlert);
            }
            System.out.println(question);
            entry = scanner.nextLine();
            entry = entry.trim();
            System.out.println();


            check = 1;

            if(entry.length() > (int)textLength)
            {
                check = -1;
            }

            if(check != -1)
            {
                if(!entry.matches(validationString))
                {
                    check = 0;
                }
            }

        }while(entry == null || entry.isEmpty() || check == 0 || check == -1);

        return entry;

    }

    // This function is like the above one but it is only for grades
    // It also checks if the grade is a number between 0 and 100
    // If the user types a grade like -5 or 150 or a letter, it tells them it's wrong
    public static String ValidationMethodForMarks(String question, short textLength, String validationString, String lengthAlert, String validationAlert, short less , short most, String rangeAlert)
    {

        if(question == null)
        {
            question = "Please enter your mark: \n";
        }
        String entry;
        byte check = 1;

        do{

            if(check == -1)
            {
                System.out.println(lengthAlert);
            }
            else if(check == 0)
            {
                System.out.println(validationAlert);
            }
            else if(check == -3)
            {
                System.out.println(rangeAlert);
            }
            System.out.println(question);
            entry = scanner.nextLine();
            entry = entry.trim();
            System.out.println();


            check = 1;

            if((entry.length() >= (int)textLength) && !hasOneDot(entry))
            {
                check = -1;
            }

            if(check != -1)
            {
                if(!entry.matches(validationString))
                {
                    check = 0;
                }
                else if (Float.parseFloat(entry) < less || Float.parseFloat(entry) > most)
                {
                    check = -3;
                }
            }

        }while(entry == null || entry.isEmpty() || check == 0 || check == -1 || check == -3);

        return entry;

    }

    // This ask the student to write first or last name
    // The name must only have letters
    public static String readStudentName(String question)
    {

        if(question == null)
        {
            question = "Please write your name : ";
        }
        //short length = 20;
        String studentName = ValidationMethod(question, (short)20,"[a-zA-Z ]+", "The name is too long!", "The entry must be letters only! ..");

        return studentName;

    }

    // This function ask the student to write the ID ..the Id must be numbers only, not letters
    public static String readStudentID(String question)
    {

        if(question == null)
        {
            question = "Please write your ID: ";
        }
        String Id =  ValidationMethod(question, (short)12, "\\d+", "The ID is too long! maximum [ 12 Digits]", "The entry must be numbers only! ..");

        return Id;

    }

    // This ask the student to write the name of their course and the course should also be letters only.. not numbers
    public static String readStudentcourse(String question)
    {

        if(question == null)
        {
            question = "Please write your course: ";
        }

        String course = ValidationMethod(question,(short)30, "[a-zA-Z ]+", "The course name is too long!", "The entry must be letters only! ..");

        return course;

    }

    // This reads one grade from the user It checks that if the entry between 0 and 100 and has correct decimal format
    public static Float readMark(String quesstion)
    {

        String mark = ValidationMethodForMarks(quesstion,(short)4, "-?\\d+\\.?\\d*", "The mark digits is too long.. please enter format like: [00.0]", "The entry must be numbers only! ..", (short)0 , (short)100, "Sorry.. the mark is out of range");

        return Float.valueOf(mark);
    }

    // This function adds three marks together and returns the total of them if any grade is missing it returns -1 as a error value
    public static float getTotal(Float one, Float two, Float three)
    {
        if(one != null && two != null && three != null)
        {
            return one + two + three;
        }
        else
        {
            return -1;
        }
    }

    // This function gives the average of the three marks by deviding them on ÷ 3
    public static float getAverage(Float one, Float two, Float three)
    {
        if(one != null && two != null && three != null)
        {
            return (one + two + three)/3;
        }
        else
        {
            return -1;
        }

    }

    // The function take the average as a parameter and gives the final grade
    // equal A for excellent if over 90/100, B for good, C.., D.., and F for fail
    public static char getFinalGrade(Float grade)
    {
        if(grade == null)
        {
            return '-';
        }

        if(grade < 100 && grade > 89)
        {
            return 'A';
        }
        else if(grade < 90 && grade > 79)
        {
            return 'B';
        }
        else if(grade < 80 && grade > 69)
        {
            return 'C';
        }
        else if(grade < 70 && grade > 59)
        {
            return 'D';
        }
        else if(grade < 60 && grade > 0)
        {
            return 'F';
        }

        return '-';
    }

    // This function prints all the student details in a nice way
    // It shows name, ID, course, 3 marks, total, average, and final grade
    public static void printDetails(String fullName, String ID, String course,float sub1, float sub2, float sub3, Float total, Float avarage, char final_grade)
    {
        System.out.println("=================================================================");
        System.out.println("------------------------ STUDENTS DETAILS -----------------------");
        System.out.println("=================================================================");
        System.out.println();
        System.out.println("STUDENT FULL-NAME            : " + fullName + "\n");
        System.out.println("STUDENT ID                   : " + ID + "\n");
        System.out.println("STUDENT COURSE               : " + course + "\n");
        System.out.println("-----------------------------------------------------------------\n");
        System.out.println("THE FIRST MARK               : " + sub1 + "\n");
        System.out.println("THE SECOND MARK              : " + sub2 + "\n");
        System.out.println("THE THIRD MARK               : " + sub3 + "\n");
        System.out.println("-----------------------------------------------------------------\n");
        System.out.println("THE TOTAL OF YOUR MARKS IS   : " + total + "\n");
        System.out.println("THE AVERAGE OF YOUR MARKS IS : " + avarage + "\n");
        System.out.println("THE FINAL GRADE IS           : " + final_grade );
        System.out.println();
        System.out.println("-----------------------------------------------------------------");
        System.out.println("=================================================================\n");
    }

    // This function just for clearing the screen by printing a lot of empty lines to give a feeling that the console screen became clear
    public static void clearConsole() {
        for (byte i = 0; i <= 30; i++) {
            System.out.println();
        }
    }

    // This is the heart of the program, it does everything:
    // It reads the inputs, gets the total and average, calculates the final grade, and prints the result
    public static void calcutaleTotal()
    {
        String firstName = readStudentName("Please write your first name :");
        String lastName = readStudentName("Please write your last name :");
        String ID = readStudentID("Please write your ID :");
        String course = readStudentcourse("Please write your course:");
        Float firstMark = readMark("Please enter your first mark: (GRADE/100)");
        Float secondMark = readMark("Please enter your second mark: (GRADE/100)");
        Float thirdMark = readMark("Please enter your third mark: (GRADE/100)");

        String fullName = firstName + ' ' + lastName;
        Float total = getTotal(firstMark, secondMark, thirdMark);
        Float average = getAverage(firstMark, secondMark, thirdMark);
        char finalGrade = getFinalGrade(average);

        printDetails(fullName, ID, course,firstMark, secondMark, thirdMark, total, average, finalGrade);

    }

    // This is the main method where the program starts running It runs the grade calculator, then asks if the user wants to repeat
    // If they type "YES" it will run again for another student

    public static void main(String[] Args)
    {

        String ask = "";
        do
        {

            calcutaleTotal();
            System.out.println("Do you wanna calculate another student grades? (YES/NO)");
            ask = scanner.nextLine();
            ask = ask.trim();
            if(ask.equalsIgnoreCase("YES"))
            {

                clearConsole();

            }

        } while(ask.equalsIgnoreCase("YES"));


    }



}