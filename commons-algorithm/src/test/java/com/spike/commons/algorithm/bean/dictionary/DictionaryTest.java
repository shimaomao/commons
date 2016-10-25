package com.spike.commons.algorithm.bean.dictionary;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * Description: Dictionary Unit Test<br/>
 * Date: 2014-4-27 下午9:52:24
 */
public class DictionaryTest {

  public DictionaryTest() {
  }

  /**
   * Description: <br/>
   * PRE: <br/>
   * POST: <br/>
   */
  @BeforeClass
  public static void setUpBeforeClass() throws Exception {
  }

  /**
   * Description: <br/>
   * PRE: <br/>
   * POST: <br/>
   */
  @AfterClass
  public static void tearDownAfterClass() throws Exception {
  }

  /**
   * Description: <br/>
   * PRE: <br/>
   * POST: <br/>
   */
  @Before
  public void setUp() throws Exception {
  }

  /**
   * Description: <br/>
   * PRE: <br/>
   * POST: <br/>
   */
  @After
  public void tearDown() throws Exception {
  }

  @Test
  public void test() {
    // 创建不同的键类型的字典
    DictionaryADT<Integer, Payroll> IDDict = new UALDictionary<Integer, Payroll>();
    DictionaryADT<String, Payroll> nameDict = new UALDictionary<String, Payroll>();

    Payroll payroll1 = new Payroll(5, "Joe", "Beijing");
    Payroll payroll2 = new Payroll(10, "Cartman", "Jiangsu");

    IDDict.insert(payroll1.getID(), payroll1);
    IDDict.insert(payroll2.getID(), payroll2);

    nameDict.insert(payroll1.getName(), payroll1);
    nameDict.insert(payroll2.getName(), payroll2);

    // payrolls that exist
    Payroll findPayroll1 = IDDict.find(5);
    Payroll findPayroll2 = nameDict.find("Cartman");
    System.out.println(findPayroll1);
    System.out.println(findPayroll2);

    // payrolls that not exist
    System.out.println(IDDict.find(1));
    System.out.println(nameDict.find("Alice"));
  }

}
