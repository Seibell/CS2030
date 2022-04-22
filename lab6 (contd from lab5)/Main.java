import java.util.Scanner;
import java.util.List;

class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        Roster roster = new Roster("test");

        while (n > 0) {
            String input = sc.nextLine();
            String[] arr = input.split(" ");

            for (String character : arr) {
                roster = roster.add(arr[0], arr[1], arr[2], arr[3]);
            }
            //roster = roster.add(id, code, name, grade);
        }

        List<String> queries = List.of();

        while (true) {
            String id = sc.next();
            String code = sc.next();
            String name = sc.next();

            if (id.contains("^D") || code.contains("^D") || name.contains("^D")) {
                break;
            }

            System.out.println(roster.getGrade(id, code, name));
        }
    }
}
