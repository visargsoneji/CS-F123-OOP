public class Teacher extends SchoolMember{
    private int numCourses;
    private String[] courses;
    private int[] credits;
    private int[] feedbacks;
    private static final int MAX_NUMBER_OF_COURSES = 10;
    private static final int REQUIRED_PERCENTAGE_FOR_PROMOTION = 60;

    public Teacher(String name, String address){
        super(name, address);
        this.numCourses = 0;
        this.courses = new String[MAX_NUMBER_OF_COURSES];
        this.credits = new int[MAX_NUMBER_OF_COURSES];
        this.feedbacks = new int[MAX_NUMBER_OF_COURSES];
    }

    public String toString(){
        String s = ("Teacher: "+super.toString());
        return s;
    }

    public boolean floatCourse​(String course, int credit){
        boolean fcourse = true;
        for(int i=0;i<this.numCourses;i++)
        {
            if(this.courses[i].equals(course))
                fcourse = false;
        }
        if(fcourse)
        {
            this.courses[this.numCourses] = course;
            this.credits[this.numCourses] = credit;
            this.numCourses++;
        }
        return fcourse;
    }

    public boolean addFeedback​(java.lang.String course, int feedback){
        for(int i=0;i<this.numCourses;i++)
        {
            if(this.courses[i].equals(course))
            {
                feedbacks[i] = feedback;
                return true;
            }
        }
        return false;
    }

    public int getAverageFeedback(){
        int av = 0;
        for(int i=0;i<this.numCourses;i++)
            av += feedbacks[i];
        if(this.numCourses != 0)
            av = av/this.numCourses;
        this.setChanceOfPromotion​(av);
        return av;
    }

    public int promoted(){
        if(super.promoted() >= REQUIRED_PERCENTAGE_FOR_PROMOTION)
            return 1;
        else
            return 0;

    }
}
