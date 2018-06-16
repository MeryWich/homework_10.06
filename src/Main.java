import java.util.*;

public class Main {
    public static void main(String[] args) {

        homeworkSelector();

    }

    private static void homeworkSelector() {
        Scanner scanner = new Scanner(System.in);
        int task = 0;

        do {
            System.out.println("Select task: \n 1. Array of names, \n 2. Duplicate letters in string.");
            task = scanner.nextInt();
        } while (task < 0 || task > 2 );

        if(task == 1){
            arrayOfNames();
        }
        else if(task == 2){
            duplicateLetters();
        }
        else{
            System.out.println("Something went wrong :(");
        }

    }
    private static void arrayOfNames(){
       // arraySize();
        arrayNames();
    }
    private static Names arraySize() {
        Scanner scanner = new Scanner(System.in);
        Names names = new Names();
        System.out.println("Enter number of names:");
        names.setNumber(scanner.nextInt());

        return names;

    }
    private static void arrayNames() {
        Names names = arraySize();
        int number = names.getNumber();
        String[] list = new String[number];
        Scanner scanner = new Scanner(System.in);

        for (int i = 0; i < number; i++) {

            System.out.println("Enter name number " + (i + 1) + ":");
            list[i] = scanner.nextLine();
        }

        names.setList(list);

        int maxLength = list[0].length();
        int minLength = list[0].length();

        for (int i = 0; i < number; i++) {

            if (list[i].length() > maxLength) {
                maxLength = i;
            }

            if (list[i].length() < minLength) {
                minLength = i;
            }

        }
        System.out.println("The longest name: " + list[maxLength]);
        System.out.println("The shortest name: " + list[minLength]);

        Set<String> mySet = new HashSet<String>(Arrays.asList(list));
        String duplicatesList = "";

        for (String n : mySet) {
            int rep = 0;
            for(int i =0; i<number; i++){
                if(list[i].equals(n)){
                    rep ++;
                }
            }
            if(rep>1){

                duplicatesList = duplicatesList + n +"("+rep+") ";

            }
        }
        System.out.println("Repeated names: " + duplicatesList);

    }

    private static void duplicateLetters(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter name or a string: ");
        String userString = scanner.nextLine();

        boolean duplicate = false;

        char[] chars = userString.toLowerCase().toCharArray();

       for(int i = 0; i < chars.length; i++){
           for(int j = 0; j < chars.length; j++){
               if(j!=i && chars[i] == (chars[j])){
                   duplicate = true;
                   break;
               }
           }
       }
        System.out.println(userString +" - "+duplicate);





    }
}
