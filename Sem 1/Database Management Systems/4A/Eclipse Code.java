import java.io.*;
import java.sql.*;

import java.util.*;

public class DMA2 {
    public static void main(String[] args) throws Exception {
        int rno, age;
        String col1, col2, col3, col4, col5, col6;
        Connection con = null;
        Statement s = null;
        ResultSet rs = null;
        int ch;
        boolean flag = true;
        Scanner sc = new Scanner(System.in);
        try {
            //Class.forName("com.mysql.jdbc.Driver");

            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/teacher", "root", "123@atharva");

            do {
                System.out.println("Press 1 to CREATE TABLE");
                System.out.println("Press 2 to INSERT into the table");
                System.out.println("Press 3 to DELETE from table");
                System.out.println("Press 4 to UPDATE data in the table");
                System.out.println("Press 5 to VIEW ALL from the table");
                System.out.println("Press 6 to Alter Table to Add Column");
                System.out.println("Press 7 to Alter Table to Modify Column");
                System.out.println("Press 8 to Alter Table to Drop Column");
                System.out.println("Press 9 to EXIT");
                System.out.println("Enter your choice");
                ch = Integer.parseInt(sc.nextLine());

                switch (ch) {
                    case 1:
                        System.out.println("Enter the name of the table to be created");
                        String tname = sc.nextLine();
                        /* enter the name of the table as stud whenever the table name is asked throughout the program*/
                        /* Enter columns as id, name, and marks*/
                        System.out.println("Enter the first column name");
                        col1 = sc.nextLine();
                        System.out.println("Enter the second column name");
                        col2 = sc.nextLine();
                        System.out.println("Enter the third column name");
                        col3 = sc.nextLine();

                        String sql = "CREATE TABLE " + tname +
                                " ( " + col1 + " INTEGER not NULL, " +
                                col2 + " VARCHAR(255), " +
                                col3 + " VARCHAR(255)) ";

                        s = con.createStatement();
                        s.execute(sql);
                        System.out.println("Table is created\n");

                        break;

                    case 2:
                        System.out.println("Enter the table name");
                        String insert_table = sc.nextLine();
                        System.out.println("Enter the first column value");
                        col4 = sc.nextLine();
                        System.out.println("Enter the second column value");
                        col5 = sc.nextLine();
                        System.out.println("Enter the third column value");
                        col6 = sc.nextLine();
                        String query = "INSERT INTO " + insert_table + " VALUES('" + col4 + "','" + col5 + "','" + col6 + "')";
                        s = con.createStatement();
                        s.executeUpdate(query);
                        System.out.println("Row inserted");
                        break;

                    case 3:
                        System.out.println("Enter the id");
                        String str2 = sc.nextLine();
                        s = con.createStatement();
                        int x = s.executeUpdate("DELETE FROM student WHERE id='" + str2 + "'");
                        System.out.println("Deleted rows are: " + x);
                        break;

                    case 4:
                        System.out.println("Enter id to be updated");
                        String id1 = sc.nextLine();
                        System.out.println("Enter marks to be updated");
                        String mks = sc.nextLine();
                        String query1 = "UPDATE student SET marks='" + mks + "' WHERE id='" + id1 + "'";
                        s = con.createStatement();
                        int y = s.executeUpdate(query1);
                        System.out.println("Updated rows are: " + y);
                        break;

                    case 5:
                        String query2 = "SELECT * FROM stud";
                        s = con.createStatement();
                        rs = s.executeQuery(query2);
                        boolean rec = rs.next();
                        if (!rec) {
                            System.out.println("No record");
                        }

                        while (rs.next()) {
                            col4 = rs.getString(1);
                            col5 = rs.getString(2);
                            col6 = rs.getString(3);
                            System.out.print(col4 + "\t");
                            System.out.print(col5 + "\t");
                            System.out.println(col6);
                        }

                        break;

                    case 6:
                        System.out.println("Enter the table name for Altering the table");
                        String table = sc.nextLine();

                        System.out.println("Enter column name");
                        String colnm = sc.nextLine();

                        String sql1 = "ALTER TABLE " + table + " ADD " + colnm + " VARCHAR(100)";

                        s = con.createStatement();
                        s.executeUpdate(sql1);
                        System.out.println("Table is Altered\n");

                        break;

                    case 7:
                        System.out.println("Enter the table name for modifying column in the table");
                        String table1 = sc.nextLine();

                        System.out.println("Enter column name to modify");
                        /* Give the name of the above column added to the table*/
                        String colnm1 = sc.nextLine();

                        String sql2 = "ALTER TABLE " + table1 + " MODIFY " + colnm1 + " VARCHAR(50)";

                        s = con.createStatement();
                        s.executeUpdate(sql2);
                        System.out.println("Table is Altered\n");

                        break;

                    case 8:
                        System.out.println("Enter the table name for dropping the column");
                        String table2 = sc.nextLine();

                        System.out.println("Enter column name to be dropped");
                        String colnm2 = sc.nextLine();

                        String sql3 = "ALTER TABLE " + table2 + " DROP COLUMN " + colnm2;

                        s = con.createStatement();
                        s.executeUpdate(sql3);
                        System.out.println("Table is Altered\n");

                        break;

                    case 9:
                        System.exit(1);
                        break;

                    default:
                        System.out.println("I am default");
                }

                System.out.println("Do you want to continue (yes/no)?");
                String str = sc.nextLine();
                if (str.equalsIgnoreCase("yes") || str.equalsIgnoreCase("y")) {
                    flag = true;
                }
                if (str.equalsIgnoreCase("no") || str.equalsIgnoreCase("n")) {
                    flag = false;
                }

            } while (flag);

        } catch (Exception e) {
            System.out.println(e);
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (s != null) {
                s.close();
            }
            if (con != null) {
                con.close();
            }
        }
    }
}
