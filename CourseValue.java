import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
public class CourseValue {

    public static int add(List<Course> courses) {
        var sql = "INSERT INTO students (course_name, course_description, teacher_id, schedule) values (?,?,?,?)";
        try (var conn = DB.connect();
             var pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
// bind the values
            for(var i: courses) {
                pstmt.setString(1, i.getName());
                pstmt.setString(2, i.getDescription());
                pstmt.setInt(3, i.getTeacher_id());
                pstmt.setString(4, i.getSchedule());

// execute the INSERT statement and get the inserted id
                int insertedRow = pstmt.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return -1;
    }
}
