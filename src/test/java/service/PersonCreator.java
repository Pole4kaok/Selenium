package service;

import model.PersonModel;

public class PersonCreator {
    public static final String TESTDATA_PERSON_FIRST_NAME = "first";
    public static final String TESTDATA_PERSON_LAST_NAME = "last";
    public static final String TESTDATA_PERSON_LINE1 = "line1";
    public static final String TESTDATA_PERSON_COUNTRY = "Wales";

    public static PersonModel withDataFromProperties(){
        return new PersonModel(TESTDATA_PERSON_FIRST_NAME,TESTDATA_PERSON_LAST_NAME,TESTDATA_PERSON_LINE1,TESTDATA_PERSON_COUNTRY);
    }
}
