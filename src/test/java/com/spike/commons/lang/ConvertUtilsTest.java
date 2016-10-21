package com.spike.commons.lang;

import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.Converter;

import com.spike.commons.lang.domain.Address;

/**
 * {@link ConvertUtils}单元测试
 * @author zhoujiagen
 */
public class ConvertUtilsTest {

  static {
    // 注册或覆盖类的Convert
    ConvertUtils.register(new CustomedConverter(), Address.class);
  }

  public static void main(String[] args) {
    // 将String转化为Bean
    // Address address = new CustomedConverter().convert(Address.class,
    // "name1");
    Address address = (Address) ConvertUtils.convert("name1", Address.class);
    System.out.println(address);
  }

  /**
   * <pre>
   * 自定义转换器
   * </pre>
   * @author zhoujiagen
   */
  @SuppressWarnings("unchecked")
  static class CustomedConverter implements Converter {

    @Override
    public <T> T convert(Class<T> type, Object value) {
      if (type.equals(Address.class)) {
        Address result = new Address();

        result.setName(value.toString());
        return (T) result;
      }

      throw new UnsupportedOperationException();
    }
  }

}
