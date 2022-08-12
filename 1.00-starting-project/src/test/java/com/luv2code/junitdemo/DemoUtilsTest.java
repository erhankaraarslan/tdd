package com.luv2code.junitdemo;

import org.junit.jupiter.api.*;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class DemoUtilsTest {

    DemoUtils demoUtils;

    @BeforeEach
    void setupBeforeEach() {
        demoUtils = new DemoUtils();
        System.out.println("@BeforeEach executes before the executions of each test method");
    }

    @Test
    @DisplayName("Equals and Not Equals")
    @Order(1)
    void testEqualsAndNotEquals() {

        System.out.println("Running test: testEqualsAndNotEquals");

        assertEquals(6, demoUtils.add(2, 4), "2+4 must be 6");
        assertNotEquals(6, demoUtils.add(1, 9), "1+9 must not be 6");

    }
    @Test
    @DisplayName("Multiply")
    void testMultiply(){
        assertEquals(12,demoUtils.multiply(3,4),"3*4 must be 12");
        assertNotEquals(12,demoUtils.multiply(3,5),"3*5 must not be 12");
    }

    @Test
    @DisplayName("Null and Not Null")
    @Order(0)
    void testNullAndNotNull() {
        System.out.println("Running test: testNullAndNotNull");

        String str1 = null;
        String str2 = "karaarslan";

        assertNull(demoUtils.checkNull(str1), "Object should be null");
        assertNotNull(demoUtils.checkNull(str2), "Object should not be null");

    }

    @DisplayName("Same and Not Same")
    @Test
    void testSameAndNotSame() {
        String str = "luv2code";

        assertSame(demoUtils.getAcademy(), demoUtils.getAcademyDuplicate(), "Objects should refer to same object");
        assertNotSame(str, demoUtils.getAcademy(), "Objects should not refer to same object");
    }

    @DisplayName("True and False")
    @Test
    void testTrueFalse() {
        int gradeOne = 10;
        int gradeTwo = 5;

        assertTrue(demoUtils.isGreater(gradeOne,gradeTwo),"This should return true");
        assertFalse(demoUtils.isGreater(gradeTwo,gradeOne),"This should return false");
    }

    @DisplayName("Array Equals")
    @Test
    void testArrayEquals(){
        String[] stringArr={"A","B","C"};

        assertArrayEquals(stringArr,demoUtils.getFirstThreeLettersOfAlphabet(),"Arrays should be the same");

    }

    @DisplayName("Iterable Equals")
    @Test
    void testIterableEquals(){

        List<String> theList= Arrays.asList("luv","2","code");
        assertIterableEquals(theList,demoUtils.getAcademyInList(),"Expected list should be same as actual list");
    }
    @DisplayName("Lines Match")
    @Test
    void testLinesMatch(){
        List<String> theList= Arrays.asList("luv","2","code");
        assertLinesMatch(theList,demoUtils.getAcademyInList(),"Lines should match");
    }


    @DisplayName("Throws and Does Not Throw")
    @Test
    void testThrowsAndDoesNotThrow(){
        assertThrows(Exception.class,()->{demoUtils.throwException(-1);},"Should throw exception");
        assertDoesNotThrow(()->{demoUtils.throwException(9);},"Should not throw exception");
    }

    @DisplayName("Timeout")
    @Test
    void testTimeOut(){
        assertTimeoutPreemptively(Duration.ofSeconds(3),()->{demoUtils.checkTimeout();},"Method should execute in 3 seconds");
    }


//
//    @AfterEach
//    void tearDownAfterEach(){
//        System.out.println("Running @AfterEach");
//        System.out.println();
//    }
//
//    @BeforeAll
//    static void setupBeforeEachClass(){
//        System.out.println("@BeforeAll executes only once before all test methods executions in the class");
//    }
//
//    @AfterAll
//    static void setupAfterEachClass(){
//        System.out.println("@AfterAll executes only once after all test methods executions in the class");
//    }


}
