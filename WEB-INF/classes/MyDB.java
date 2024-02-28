import java.sql.*;

public class MyDB {
    public static void main(String[] args) {
        store(19,"peter", "male", "2001-08-10","Manager",3000,"dork");
        update(19,"Yes","Yes","8610023734","2001-08-10");
    }
    public static void store( int id, String name, String gender, String dob, String designation, int salary, String dept){
        try{
            Connection connection= DriverManager.getConnection("jdbc:mysql://localhost:3306/employeeform","root","root");
            //PreparedStatement prepst2=connection.prepareStatement("select * from employee;");
            PreparedStatement prepstmt=connection.prepareStatement("insert into employee (id,name,gender,dob,designation,salary, dept) values ( ? , ? , ? , ? , ? , ? , ? );");
            /*PreparedStatement prep2=connection.prepareStatement("insert into employee (id,fname,lname,dob,designation,salary,doj,exp,addr) values (11,\"peter\",\"parker\",\"10/08/02\",\"intern\",\"5000\",\"13/06/23\",\"0\",\"myh\");");
            PreparedStatement prepstmt=connection.prepareStatement("insert into employee (id,fname,lname,dob,designation,salary,doj,exp,addr) values ("+id+","+fname+","+lname+","+dob+","+designation+","+salary+","+doj+","+exp+","+addr+");");
            */
            prepstmt.setInt(1, id);
            prepstmt.setString(2, name);
            prepstmt.setString(3, gender);
            prepstmt.setString(4, dob);
            prepstmt.setString(5, designation);
            prepstmt.setInt(6, salary);
            prepstmt.setString(7, dept);
            prepstmt.executeUpdate();
            /*ResultSet rs=prepst2.executeQuery();
            while(rs.next()){
                int eid=rs.getInt(1);
                String him=rs.getString("name");
                System.out.println(him+" "+eid);
            }*/
            System.out.println("Done connectingg with 1");
        }catch (Exception e){
            System.out.println(e);
            e.printStackTrace();
        }
    }

    public static void update( int id, String fresher, String training, String phone, String doj){
        try{
            Connection connection= DriverManager.getConnection("jdbc:mysql://localhost:3306/employeeform","root","root");
            //PreparedStatement prepst2=connection.prepareStatement("select * from employee;");
            PreparedStatement prepstmt=connection.prepareStatement("update employee set fresher=?, training=?, phone=?,  doj=? where (id=?);");
            /*PreparedStatement prep2=connection.prepareStatement("insert into employee (id,fname,lname,dob,designation,salary,doj,exp,addr) values (11,\"peter\",\"parker\",\"10/08/02\",\"intern\",\"5000\",\"13/06/23\",\"0\",\"myh\");");
            PreparedStatement prepstmt=connection.prepareStatement("insert into employee (id,fname,lname,dob,designation,salary,doj,exp,addr) values ("+id+","+fname+","+lname+","+dob+","+designation+","+salary+","+doj+","+exp+","+addr+");");
            */
            prepstmt.setString(1, fresher);
            prepstmt.setString(2, training);
            prepstmt.setString(3, phone);
            prepstmt.setString(4, doj);
            prepstmt.setInt(5, id);
            prepstmt.executeUpdate();
            /*ResultSet rs=prepst2.executeQuery();
            while(rs.next()){
                int eid=rs.getInt(1);
                String him=rs.getString("name");
                System.out.println(him+" "+eid);
            }*/
            System.out.println("Done connectingg with 1");
        }catch (Exception e){
            System.out.println(e);
            e.printStackTrace();
        }
    }

    public static void dataget(){
        try{
            Connection connection= DriverManager.getConnection("jdbc:mysql://localhost:3306/employeeform","root","root");
            PreparedStatement prepstmt=connection.prepareStatement("select * from employee;");
        }catch (SQLException e){
            System.out.println("data not received");
        }
    }
}