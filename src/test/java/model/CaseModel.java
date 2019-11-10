package model;

public class CaseModel {
    private String caseNumber;
    private String caseTitle;
    private String caseCaption;

    public CaseModel(String  caseNumber, String caseTitle, String caseCaption){
        this.caseNumber = caseNumber;
        this.caseTitle = caseTitle;
        this.caseCaption = caseCaption;
    }

    public String getcaseNumber() {
        return caseNumber;
    }

    public String getcaseTitle() { return caseTitle; }

    public String getcaseCaption(){
        return caseCaption;
    }

    public void setcaseNumber(String caseNumber) {
        this.caseNumber = caseNumber;
    }

    public void setcaseTitle(String caseTitle){
        this.caseTitle = caseTitle;
    }

    public void setcaseCaption(String caseCaption) {
        this.caseCaption = caseCaption;
    }
}
