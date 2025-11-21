import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
import java.util.Scanner;
public class Mainer {

    public static Scanner scanner = new Scanner(System.in);

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

    public static String ValidationMethodForGrades(String question, short textLength, String validationString, String lengthAlert, String validationAlert, short less , short most, String rangeAlert)
    {

        if(question == null)
        {
            question = "Please enter your grade: \n";
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

    public static String readStudentID(String question)
    {

        if(question == null)
        {
            question = "Please write your ID: ";
        }
        String Id =  ValidationMethod(question, (short)12, "\\d+", "The ID is too long! maximum [ 12 Digits]", "The entry must be numbers only! ..");

        return Id;

    }

    public static String readStudentcourse(String question)
    {

        if(question == null)
        {
            question = "Please write your course: ";
        }

        String course = ValidationMethod(question,(short)30, "[a-zA-Z ]+", "The course name is too long!", "The entry must be letters only! ..");

        return course;

    }

    public static Float readGrade(String quesstion)
    {

        String grade = ValidationMethodForGrades(quesstion,(short)4, "-?\\d+\\.?\\d*", "The garde digits is too long.. please enter format like: [00.0]", "The entry must be numbers only! ..", (short)0 , (short)100, "Sorry.. the grade is out of range");

        return Float.valueOf(grade);
    }

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

    public static void clearConsole() {
        for (int i = 0; i <= 30; i++) {
            System.out.println();
        }
    }

    public static void calcutaleTotal()
    {
        String firstName = readStudentName("Please write your first name :");
        String lastName = readStudentName("Please write your last name :");
        String ID = readStudentID("Please write your ID :");
        String course = readStudentcourse("Please write your course:");
        Float firstGrade = readGrade("Please enter your first grade: (GRADE/100)");
        Float secondGrade = readGrade("Please enter your second grade: (GRADE/100)");
        Float thirdGrade = readGrade("Please enter your third grade: (GRADE/100)");

        String fullName = firstName + ' ' + lastName;
        Float total = getTotal(firstGrade, secondGrade, thirdGrade);
        Float average = getAverage(firstGrade, secondGrade, thirdGrade);
        char finalGrade = getFinalGrade(average);

        printDetails(fullName, ID, course,firstGrade, secondGrade, thirdGrade, total, average, finalGrade);

    }

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