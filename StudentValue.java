
    import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
    public class StudentValue {

        public static int add(List<Student> students) {
            var sql = "INSERT INTO students (stu_name, age, gender, grade_level) values (?,?,?,?)";
            try (var conn = DB.connect();
                 var pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
// bind the values
                for(var i: students) {
                    pstmt.setString(1, i.getName());
                    pstmt.setInt(2, i.getAge());
                    pstmt.setString(3, i.getGender());
                    pstmt.setInt(4, i.getGrade());

// execute the INSERT statement and get the inserted id
                    int insertedRow = pstmt.executeUpdate();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return -1;
        }
}
