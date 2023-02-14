class StudentMarksProject {

    private int id;
    private int mid_marks;
    private String name;
    private int final_exam_marks;

    StudentMarksProject(int id, String name, int mid_marks)
    {
        this.mid_marks = mid_marks;
        this.name = name;
        this.id = id;
    }
    StudentMarksProject(int id, String name, int mid_marks,int final_exam_marks)
    {
        this(id,name,mid_marks);
        this.final_exam_marks=final_exam_marks;
    }

    private void show()
    {
        System.out.println("Name of the student"+name);
        System.out.println("Id no of the student"+id);
        System.out.println("Mid marks "+mid_marks);
        System.out.println("Final marks"+final_exam_marks);
    }


    public static void main(String[] args) {

        StudentMarksProject[] students = new StudentMarksProject[1];

        students[0] = new StudentMarksProject(83,"Harsh",30,100);

//        students[0].name = "Harsh";
//        students[0].id =83;
//        students[0].mid_marks=30;
//        students[0].final_exam_marks = 100;

        students[0].show();

    }


}
