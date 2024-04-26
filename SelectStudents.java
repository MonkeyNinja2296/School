import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
public class SelectStudents {
    public static List<Student> findAll() {
        var products = new ArrayList<Student>();
        var sql = "SELECT * FROM students";
        try (var conn = DB.connect();
             var stmt = conn.createStatement()) {
            var rs = stmt.executeQuery(sql);
            while (rs.next()) {
                var Student = new Student(
                        rs.getInt("stu_id"),
                rs.getString("stu_name"),
                rs.getInt("age"),

                rs.getInt("grade_level"),
                        rs.getString("gender")
            );
                products.add(Student);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return products;
    }
    public static List<Teacher> findAllTeachers() {
        var products = new ArrayList<Teacher>();
        var sql = "SELECT * FROM teachers";
        try (var conn = DB.connect();
             var stmt = conn.createStatement()) {
            var rs = stmt.executeQuery(sql);
            while (rs.next()) {
                var Teacher = new Teacher(
                        rs.getInt("teacher_id"),
                        rs.getString("teacher_name"),
                        rs.getString("subject_taught"),

                        rs.getInt("years_of_experience"),
                        rs.getString("department")
                );
                products.add(Teacher);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return products;
    }
//
public static List<Course> findAllCourses() {
    var products = new ArrayList<Course>();
    var sql = "SELECT * FROM courses";
    try (var conn = DB.connect();
         var stmt = conn.createStatement()) {
        var rs = stmt.executeQuery(sql);
        while (rs.next()) {
            var Course = new Course(
                    rs.getInt("course_id"),
                    rs.getString("course_name"),
                    rs.getString("course_description"),

                    rs.getInt("teacher_id"),
                    rs.getString("schedule")
            );
            products.add(Course);
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return products;
}
//
// ...
}