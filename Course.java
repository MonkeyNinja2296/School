public class Course {
    int id;
    String name;
    String description;
    int teacher_id;
    String schedule;


    public Course(String name, String description, int teacher_id, String schedule ){
        this.name = name;
        this.description = description;
        this.teacher_id = teacher_id;
        this.schedule = schedule;
    }
    public Course(int id,String name, String description, int teacher_id, String schedule ){
        this.name = name;
        this.description = description;
        this.teacher_id = teacher_id;
        this.schedule = schedule;
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public String getSchedule() { return this.schedule; }
    public void setSchedule(String schedule) { this.schedule = schedule; }
    public int getTeacher_id(){
        return this.teacher_id;
    }
    public void setTeacher_id(int teacher_id){
        this.teacher_id = teacher_id;
    }
    @Override
    public String toString() {
        return "Name: " + name + ", Description: " + description + ", teacher ID: " + teacher_id + ", schedule: " + schedule;
    }
}
