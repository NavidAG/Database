import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        System.out.println("WikiSoccer | Database by Navid");

//        System.out.println("Enter table's name: ");
//        Scanner scanner = new Scanner(System.in);
//        String talbleName = scanner.nextLine();
//        database.showPlayerTable();
        body();

    }
    public static void body(){
        Database database = new Database();
        String command;

        System.out.println("Tables you can see: club, coach, player and sponsor");
        System.out.println("Available Informations: ");
        System.out.println("1. Who is the best player and what team dees he playes in?");
        System.out.println("2. Which team has won the 2020 Championship?");
        System.out.println("3. Which teams have featured Nike as the sponsor and How much is the fee?");
        System.out.println("4. Which brand is choosen the most as the sponsor? How many teams have choosen that company?");
        System.out.println("5. What trophies did manchester achieve in 2020?");
        System.out.println("6. Which team own Cristiano Ronaldo and what's the coach of that team?");
        System.out.println("7. Which teams have won the ongoing leagues?");
        System.out.println("8. Which players have reached the over all 80 and How much is their income?");
        System.out.println("9. What teams are well know for using red or blue as their icon and what countries are they located in?");
        System.out.println("10. Who are the champion of Serie A in recent years?");
        do {
            System.out.println();
            System.out.print("Enter table's name or the number of question: ");
            Scanner scanner = new Scanner(System.in);
            command = scanner.nextLine();

            switch (command){
                case "club": database.showClubTable();break;
                case "coach": database.showCoachTable();break;
                case "player": database.showPlayerTable();break;
                case "sponsor": database.showSponsorTable();break;
                case "1": database.query1();break;
                case "2": database.query2();break;
                case "3": database.query3();break;
                case "4": database.query4();break;
                case "5": database.query5();break;
                case "6": database.query6();break;
                case "7": database.query7();break;
                case "8": database.query8();break;
                case "9": database.query9();break;
                case "10": database.query10();break;
                case "11": database.insertInstanceForCoach();break;

                default: System.err.println("Invalid input! try again.");
            }
        }while (!command.equals("exit"));
    }
}
