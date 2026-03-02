package pet_management;

public class PhDStudent extends Student {
    private String researchTopic;
    private int papersPublished;
    
    public PhDStudent(String name, int age, String major, int studentId, 
                      String researchTopic, int papersPublished) {
        super(name, age, major, studentId);
        this.researchTopic = researchTopic;
        this.papersPublished = papersPublished;
    }
    
    public String getResearchTopic() {
        return researchTopic;
    }
    
    public int getPapersPublished() {
        return papersPublished;
    }
    
    @Override
    protected boolean canHavePet(Animal pet) {
        
        return !(pet instanceof Dog);
    }
    
    @Override
    public String getOccupation() {
        return "PhD Student: " + getMajor() + ", Research: " + researchTopic;
    }
    
    @Override
    public String toString() {
        return super.toString() + ", Research: " + researchTopic + 
               ", Papers: " + papersPublished;
    }
}