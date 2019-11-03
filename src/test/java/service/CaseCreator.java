package service;

import model.CaseModel;

public class CaseCreator {
    public static final String TESTDATA_CASE_NUMBER = "first";
    public static final String TESTDATA_CASE_CAPTION = "CASE_CAPTION";
    public static final String TESTDATA_CASE_TITLE = "CASE_TITLE";


    public static CaseModel withDataFromProperties(){
        return new CaseModel(TESTDATA_CASE_NUMBER,TESTDATA_CASE_CAPTION,TESTDATA_CASE_TITLE);
    }
}
