package com.leumit.utils.Guru99;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class Guru99DataProvider {

    private static final String PROPERTIES_SINGLE_SEARCH_FEILD_FILE = "Guru99/singleSearchField.properties";
    private static final int PROP_NUM_FOR_SINGLE_SEARCH_FEILD = 2;
    private static final String PROPERTIES_TWO_SEARCH_FEILDS_FILE = "Guru99/twoSearchFields.properties";
    private static final int PROP_NUM_FOR_TWO_SEARCH_FEILDS = 3;

    public static Object[][] getSingleSearchFieldData(){
        Properties properties = loadProperties(PROPERTIES_SINGLE_SEARCH_FEILD_FILE);
        List<Object[]> testData = new ArrayList<>();
        //Calculation of the number of groups of parameters, each group is a separate test
        int numOfPropTests = properties.size()/PROP_NUM_FOR_SINGLE_SEARCH_FEILD;
        for (int i=1; i<=numOfPropTests;i++){
            String input1 = properties.getProperty(STR."test\{i}.input1");
            String expected = properties.getProperty(STR."test\{i}.expected");
            testData.add(new Object[]{input1, expected});
        }
        return testData.toArray(new Object[0][]);
    }
    public static Object[][] getTwoSearchFieldsData(){
        Properties properties = loadProperties(PROPERTIES_TWO_SEARCH_FEILDS_FILE);
        List<Object[]> testData = new ArrayList<>();
        //Calculation of the number of groups of parameters, each group is a separate test
        int numOfPropTests = properties.size()/PROP_NUM_FOR_TWO_SEARCH_FEILDS;
        for (int i=1; i<=numOfPropTests;i++){
            String input1 = properties.getProperty(STR."test\{i}.input1");
            String input2 = properties.getProperty(STR."test\{i}.input2");
            String expected = properties.getProperty(STR."test\{i}.expected");
            testData.add(new Object[]{input1, input2, expected});
        }
        return testData.toArray(new Object[0][]);
    }

    private static Properties loadProperties(String fileName) {
        Properties properties = new Properties();
        try (InputStream inputStream = Guru99DataProvider.class.getClassLoader().getResourceAsStream(fileName)) {
            if (inputStream != null) {
                properties.load(inputStream);
            } else {
                throw new RuntimeException("Cannot find properties file: " + fileName);
            }
        } catch (IOException e) {
            throw new RuntimeException("Error loading properties file: " + fileName, e);
        }
        return properties;
    }
}
