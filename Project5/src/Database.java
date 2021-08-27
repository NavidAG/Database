import javax.swing.plaf.synth.SynthLookAndFeel;
import java.sql.*;
import java.util.Scanner;

public class Database {
    private Connection connection = null;
    Database(){
    }
    public void Connection(){
        try {
            Class.forName("org.sqlite.JDBC");
            connection = DriverManager.getConnection("jdbc:sqlite:/Users/navid/Library/Mobile Documents/com~apple~CloudDocs/university/پایگاه داده/Projects/5/soccer.db");
            System.out.println("connected");
        } catch (Exception e) {
            System.err.println("This is an error.");
        }
    }

    public void query1(){
        Statement statement = null;
        Connection();
        String query = "select Player.name as Player, Club.name as Club from Player, Club\n" +
                "where Player.clubID = Club.ID\n" +
                "order by Player.overall desc\n" +
                "limit 1";

        try {

            statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(query);
            while (rs.next()){
                System.out.println(rs.getString("player")+ " is the best player and he plays in "+rs.getString("club")+".");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void query2(){
        Statement statement = null;
        Connection();
        String query = "select name from\n" +
                "club, tournament\n" +
                "where club.id = tournament.championClubID\n" +
                "and strftime('%Y',tournament.startingDate)='2020'\n" +
                "and trophy = 'Champion league trophy'\n";

        try {

            statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(query);
            while (rs.next()){
                System.out.println(rs.getString("name")+ " has won the championship in 2020.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void query3(){
        Statement statement = null;
        Connection();
        String query = "select name,contactfee from\n" +
                "sponsor, club\n" +
                "where sponsor.clubID = club.ID\n" +
                "and sponsor.companyFullName = 'Nike'\n";

        try {

            statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(query);
            while (rs.next()){
                System.out.println(rs.getString("name")+ " is sponsored by Nike. They have made this deal for a whopping "+rs.getString("contactfee")+"$.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void query4(){
        Statement statement = null;
        Connection();
        String query = "select companyfullname,count(*) as count from\n" +
                "sponsor\n" +
                "group by companyfullname\n" +
                "order by count(*) desc\n" +
                "limit 1\n";

        try {

            statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(query);
            while (rs.next()){
                System.out.println(rs.getString("companyfullname")+ " takes the cake for being choosen by "+rs.getString("count")+" teams.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void query5(){
        Statement statement = null;
        Connection();
        String query = "select trophy \n" +
                "from tournament, club\n" +
                "where tournament.championClubID = club.ID\n" +
                "and name = 'Manchester United'\n";

        try {

            statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(query);
            System.out.println("In 2020, Manchester United achived the following trophies:");
            while (rs.next()){
                System.out.println("* " + rs.getString("trophy"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void query6(){
        Statement statement = null;
        Connection();
        String query = "select club.name as club, coach.name as coach\n" +
                "from Player, coach, club\n" +
                "where player.clubID = club.id\n" +
                "and coach.ID = player.coachID\n" +
                "and Player.name = 'Cristiano Ronaldo'\n";

        try {

            statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(query);

            while (rs.next()){
                System.out.println("He has been aquisioned by "+rs.getString("club")+", where "+rs.getString("coach") + " is responsible for the team management.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void query7(){
        Statement statement = null;
        Connection();
        String query = "select name as club, trophy \n" +
                "from tournament, club\n" +
                "where tournament.championClubID = club.ID\n" +
                "and strftime('%Y', tournament.startingDate)='2020'\n";
        System.out.println("2020 has been a Weird year. However, of course, soccer community didn't let it disapear by the evil panademic.");
        System.out.println("There has been this saying that \"sport and culture are the glue of community.\"");
        System.out.println("OK, let's get back to the question.");
        try {
            statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(query);

            while (rs.next()){
                System.out.println(rs.getString("club")+" has taken the crown by achieving the "+rs.getString("trophy")+".");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void query8(){
        Statement statement = null;
        Connection();
        String query = "select name, fee\n" +
                "from player\n" +
                "where overall>80\n";
        System.out.println("These players are considered as the best athletes.");

        try {
            statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(query);

            while (rs.next()){
                System.out.println(rs.getString("name")+" will earn "+rs.getString("fee")+" for what he has done for the team.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void query9(){
        Statement statement = null;
        Connection();
        String query = "select name, country \n" +
                "from club\n" +
                "where color='red'\n" +
                "or color = 'blue'\n";
        System.out.println("These are the teams whose primary color are either red or blue.");

        try {
            statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(query);

            while (rs.next()){
                System.out.println(rs.getString("name")+" was born in "+rs.getString("country")+".");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void query10(){
        Statement statement = null;
        Connection();
        String query = "select name, strftime('%Y',tournament.startingDate) as year\n" +
                "from tournament, club\n" +
                "where club.ID = tournament.championClubID\n" +
                "and trophy = 'Series A trophy'\n";
        System.out.println("These are the teams that won Serie A:");

        try {
            statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(query);

            while (rs.next()){
                System.out.println(rs.getString("name")+" was able to take the trophy home in "+rs.getString("year")+".");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void insertInstanceForCoach(){
        Statement statement = null;

        Statement statement2 = null;
        Connection();
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter ID: ");
        String ID = scanner.nextLine();
        if(!isInteger(ID)){
            System.out.println("Enter integer for ID");
            return;
        }
        System.out.print("Enter name: ");
        String name = scanner.nextLine();
        System.out.print("Enter nationality: ");
        String nationality = scanner.nextLine();
        System.out.print("Enter overall: ");
        String overall = scanner.nextLine();

        String queryForID = "SELECT ID FROM coach";

        try {
            statement2 = connection.createStatement();
            ResultSet rs = statement2.executeQuery(queryForID);
            while(rs.next()){
                if((rs.getString("ID")).equals(ID)){
                    System.err.println("This ID is taken. Enter new ID.");
                    return;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        String query = "INSERT INTO coach (ID,name,nationality,overall)\n" +
                "VALUES ("+ID+",'"+name+"','"+nationality+"',"+overall+");\n";
        System.out.println(query);
        if(ID.isEmpty() || name.isEmpty() || nationality.isEmpty() || overall.isEmpty()){
            System.err.println("In order to perform insert, you must fill all of the fields.");
            return;
        }

       Connection();
       try {
           connection.setAutoCommit(false);
           statement = connection.createStatement();
           statement.executeUpdate(query);

           statement.close();
           connection.commit();
           connection.close();

       } catch (Exception e){
           e.printStackTrace();
       }


    }
    public void showClubTable(){
        Statement statement = null;
        Connection();
        String query = "SELECT * from club";

        try{
            statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(query);
            System.out.println("--------------------------------------------------- Club ---------------------------------------------------");
            System.out.print("ID");
            spacer(0, 0);
            System.out.print("Name");
            spacer(20, 4);
            System.out.print("City");
            spacer(10, 4);
            System.out.print("StadiumName");
            spacer(20, 11);
            System.out.print("NickName");
            spacer(20, 8);
            System.out.print("establishdate");
            spacer(15, 13);
            System.out.print("Country");
            spacer(15, 7);
            System.out.print("Color");
            spacer(15, 5);

            System.out.println();
            while(rs.next()) {

                System.out.print(rs.getString("ID"));
                spacer(2, rs.getString("ID").length());
                System.out.print(rs.getString("name"));
                spacer(20, rs.getString("name").length());
                System.out.print(rs.getString("city"));
                spacer(10, rs.getString("city").length());
                System.out.print(rs.getString("StadiumName"));
                spacer(20, rs.getString("StadiumName").length());
                System.out.print(rs.getString("NickName"));
                spacer(20, rs.getString("NickName").length());
                System.out.print(rs.getString("establishDate"));
                spacer(15, rs.getString("establishDate").length());
                System.out.print(rs.getString("Country"));
                spacer(15, rs.getString("Country").length());
                System.out.print(rs.getString("Color"));
                spacer(15, rs.getString("Color").length());
                System.out.println();
            }
        } catch (Exception e){
            e.printStackTrace();
        }
        System.out.println();

    }
    public void showPlayerTable(){
        Statement statement = null;
        Connection();
        String query = "SELECT * from player";

        try{
            statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(query);
            System.out.println("--------------------------------------------------- player ---------------------------------------------------");
            System.out.print("ID");
            spacer(0, 0);
            System.out.print("Name");
            spacer(20, 4);
            System.out.print("nationality");
            spacer(20, 11);
            System.out.print("overall");
            spacer(7, 7);
            System.out.print("Number");
            spacer(7, 6);
            System.out.print("Fee");
            spacer(8, 3);
            System.out.print("StartingDate");
            spacer(15, 12);
            System.out.print("EndingDate");
            spacer(15, 10);
            System.out.print("coachID");
            spacer(7, 7);
            System.out.print("clubID");
            spacer(6, 6);
            System.out.println();
            while(rs.next()) {

                System.out.print(rs.getString("ID"));
                spacer(2, rs.getString("ID").length());
                System.out.print(rs.getString("name"));
                spacer(20, rs.getString("name").length());
                System.out.print(rs.getString("nationality"));
                spacer(20, rs.getString("nationality").length());
                System.out.print(rs.getString("overall"));
                spacer(7, rs.getString("overall").length());
                System.out.print(rs.getString("Number"));
                spacer(7, rs.getString("Number").length());
                System.out.print(rs.getString("Fee"));
                spacer(8, rs.getString("fee").length());
                System.out.print(rs.getString("startingDate"));
                spacer(15, rs.getString("startingDate").length());
                System.out.print(rs.getString("EndingDate"));
                spacer(15, rs.getString("EndingDate").length());
                System.out.print(rs.getString("coachID"));
                spacer(7, rs.getString("coachID").length());
                System.out.print(rs.getString("clubID"));
                spacer(6, rs.getString("clubID").length());
                System.out.println();
            }
        } catch (Exception e){
            e.printStackTrace();
        }
        System.out.println();

    }
    public void showCoachTable(){
        Statement statement = null;
        Connection();
        String query = "SELECT * from coach";

        try{
            statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(query);
            System.out.println("--------------------------------------------------- Coach ---------------------------------------------------");
            System.out.print("ID");
            spacer(0, 0);
            System.out.print("Name");
            spacer(20, 4);
            System.out.print("nationality");
            spacer(20, 11);
            System.out.print("overall");
            spacer(7, 7);

            System.out.println();
            while(rs.next()) {

                System.out.print(rs.getString("ID"));
                spacer(2, rs.getString("ID").length());
                System.out.print(rs.getString("name"));
                spacer(20, rs.getString("name").length());
                System.out.print(rs.getString("nationality"));
                spacer(20, rs.getString("nationality").length());
                System.out.print(rs.getString("overall"));
                spacer(7, rs.getString("overall").length());

                System.out.println();
            }
        } catch (Exception e){
            e.printStackTrace();
        }
        System.out.println();
    }
    public void showSponsorTable(){
        Statement statement = null;
        Connection();
        String query = "SELECT * from sponsor";

        try{
            statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(query);
            System.out.println("------- Sponsor -------");
            System.out.print("clubID");
            spacer(6, 6);
            System.out.print("CompanyName");
            spacer(20, 11);

            System.out.print("contactfee");
            spacer(10, 10);

            System.out.println();
            while(rs.next()) {

                System.out.print(rs.getString("clubID"));
                spacer(6, rs.getString("clubID").length());
                System.out.print(rs.getString("CompanyFullName"));
                spacer(20, rs.getString("CompanyFullName").length());
                System.out.print(rs.getString("contactfee"));
                spacer(10, rs.getString("contactfee").length());


                System.out.println();
            }
        } catch (Exception e){
            e.printStackTrace();
        }
        System.out.println();
    }
    public void spacer(int n, int length){
        for(int i=0; i<n-length; i++){
            System.out.print(" ");
        }
        System.out.print("|");
    }
    public boolean isInteger( String input ) {
        try {
            Integer.parseInt( input );
            return true;
        }
        catch( Exception e ) {
            return false;
        }
    }
}
