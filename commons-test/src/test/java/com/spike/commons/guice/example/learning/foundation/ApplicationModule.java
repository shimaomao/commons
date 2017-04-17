package com.spike.commons.guice.example.learning.foundation;

import java.io.File;
import java.util.Properties;
import java.util.ResourceBundle;

import com.google.inject.AbstractModule;
import com.google.inject.name.Names;
import com.spike.commons.guice.example.learning.support.FlightUtils;
import com.spike.commons.guice.example.learning.support.annotation.XML;

public class ApplicationModule extends AbstractModule {

  /** 属性文件的名称 */
  public static final String PROPERTIES_FILE_NAME = "guice_bindings";

  @Override
  protected void configure() {
    this.configureStaticInjection();
    this.configureLoadProperties();

    this.configureFlightSupplier();
    this.configureFlightEngine();
  }

  /**
   * 配置静态注入
   */
  private void configureStaticInjection() {
    bindConstant()//
        .annotatedWith(Names.named(FlightUtils.NAMED_DATE_FORMAT))//
        .to("yyyy-MM-dd");

    requestStaticInjection(FlightUtils.class);
  }

  /**
   * 配置加载属性文件
   */
  private void configureLoadProperties() {
    Names.bindProperties(binder(), loadProperties());
  }

  private Properties loadProperties() {
    Properties result = new Properties();

    ResourceBundle rb = ResourceBundle.getBundle(PROPERTIES_FILE_NAME);
    for (String key : rb.keySet()) {
      result.put(key, rb.getString(key));
    }

    return result;
  }

  /**
   * 配置{@link FlightSupplier}
   */
  private void configureFlightSupplier() {
    // 注入String
    bind(String.class)//
        .annotatedWith(Names.named(FlightSupplier.NAMED_CSVPATH))//
        .toInstance("./flightCSV/");

    // 同一接口的多种实现
    // 通过别名区分接口的两种实现
    bind(FlightSupplier.class)//
        .annotatedWith(Names.named(FlightSupplier.CSVFlightSupplier))// (1)
        .to(CSVFlightSupplier.class);

    try {
      bind(String.class).toInstance("./flightCSV/"); // un-targeted binding
      // constructor binding: 注入java.io.File
      bind(File.class).toConstructor(File.class.getConstructor(String.class));
    } catch (NoSuchMethodException e) {
      e.printStackTrace();
    } catch (SecurityException e) {
      e.printStackTrace();
    }
    bind(FlightSupplier.class)//
        .annotatedWith(Names.named(FlightSupplier.CSVFolderFlightSupplier))// (2)
        .to(CSVFolderFlightSupplier.class);

    // 使用自定义绑定注解区分
    bind(String.class)//
        .annotatedWith(Names.named(FlightSupplier.NAMED_XMLPATH))//
        .toInstance("./xmlPath");
    bind(FlightSupplier.class)//
        .annotatedWith(XML.class)// (3)
        .to(XMLFlightSupplier.class);
  }

  /**
   * 配置{@link FlightEngine}
   */
  private void configureFlightEngine() {
    // 绑定常量
    bindConstant().annotatedWith(Names.named("maxResults")).to(10);
  }
}
