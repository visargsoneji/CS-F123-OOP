public class Student extends SchoolMember{
    private int numCourses;
    private int numCredits;
    private java.lang.String[] courses;
    private int[] grades;
    protected int minCredits;
    private static final int MAX_NUMBER_OF_COURSES = 4;
    private static final int MAX_CREDITS = 20;
    private static final int REQUIRED_PERCENTAGE_FOR_PROMOTION = 75;

    public Student​(java.lang.String name, java.lang.String address){
        super(name, address);
        this.numCourses = 0;
        this.courses = new String[MAX_NUMBER_OF_COURSES];
        this.grades = new int[MAX_NUMBER_OF_COURSES];
        this.minCredits = 10;
    }

    public java.lang.String toString(){
        String s = ("Student: "+super.toString());
        return s;
    }

    public boolean registerCourse​(java.lang.String course, int credit){
        boolean flag = true;
        if(!this.enoughCourseSlots() || this.exceedsMaxCredits​(credit))
            flag = false;
        for(int i=0;i<this.numCourses;i++)
        {
            if(this.courses[i].equals(course))
                flag = false;
        }
        if(flag)
        {
            this.courses[this.numCourses++] = course;
            this.numCredits += credit;
        }
        return flag;
    }

    public boolean isRegistrationSuccessful(){
        if(this.numCourses <= MAX_NUMBER_OF_COURSES && this.numCredits <= MAX_CREDITS && this.numCredits >= this.minCredits)
            return true;
        else
            return false;
    }

    public boolean addGrades​(java.lang.String course, int grade){
        for(int i=0;i<this.numCourses;i++)
        {
            if(this.courses[i].equals(course))
            {
                this.grades[i] = grade;
                return true;
            }
        }
        return false;
    }

    private boolean enoughCourseSlots(){
        if(this.numCourses < MAX_NUMBER_OF_COURSES)
            return true;
        else
            return false;
    }

    private boolean exceedsMaxCredits​(int credit){
        if(this.numCredits + credit > MAX_CREDITS)
            return true;
        else
            return false;
    }

    public int getAverageGrade(){
        int av = 0;
        for(int i=0;i<this.numCourses;i++)
            av += grades[i];
        if(this.numCourses != 0)
            av = av/this.numCourses;
        if(this.numCourses == 0)
            av = 100;
        super.setChanceOfPromotion​(av);
        return av;
    }

    public int promoted(){
        if(super.promoted() >= REQUIRED_PERCENTAGE_FOR_PROMOTION)
            return 1;
        else
            return 0;
    }

    public boolean removeCourse​(java.lang.String course){
        int i;
        for(i=0;i<this.numCourses;i++)
            if(this.courses[i].equals(course))
                break;

        if(i == this.numCourses)
            return false;
        if(i == this.numCourses-1)
            this.courses[i] == null;
        while(i+1<this.numCourses)
        {
            this.courses[i] = this.courses[i+1];
            this.courses[i+1] = null;
            i++;
        }
        this.numCourses--;
        return true;
    }

    public int getMinCredits(){
        return this.minCredits;
    }

    public int getNumberOfCourses(){
        return this.numCourses;
    }

}
