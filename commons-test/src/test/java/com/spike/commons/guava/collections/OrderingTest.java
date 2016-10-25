package com.spike.commons.guava.collections;

import java.util.Comparator;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.google.common.collect.Lists;
import com.google.common.collect.Ordering;
import com.spike.commons.guava.collections.domain.City;
import com.spike.commons.guava.collections.domain.Climate;

/**
 * {@link Ordering}的单元测试
 * @author zhoujiagen
 */
public class OrderingTest {

  private City city1 = new City(Climate.TEMPERATE, 10000L, .5);
  private City city2 = new City(Climate.TEMPERATE, 10000L, .6);
  private City city3 = new City(Climate.TEMPERATE, 2000L, .2);
  private City city4 = new City(Climate.TEMPERATE, 5000L, .4);

  private List<City> cities;
  private List<City> citiesWithNull;

  class CityByPopulation implements Comparator<City> {
    @Override
    public int compare(City city1, City city2) {
      return Long.compare(city1.getPopulation(), city2.getPopulation());
    }
  }

  class CityByAverageRainfall implements Comparator<City> {
    @Override
    public int compare(City city1, City city2) {
      return Double.compare(city1.getAverageRainfall(), city2.getAverageRainfall());
    }
  }

  @Before
  public void setUp() {
    cities = Lists.newArrayList(city1, city2, city3, city4);
    citiesWithNull = Lists.newArrayList(city1, city2, city3, city4, null);
  }

  @Test
  public void _create() {
    // 从Comparator实现上生成
    Ordering<City> cityOrdering = Ordering.from(new CityByPopulation());

    // 获取最小的
    City minCity = cityOrdering.min(cities);
    Assert.assertEquals(city3.getPopulation(), minCity.getPopulation());
    System.out.println(minCity);
  }

  @Test(expected = NullPointerException.class)
  public void _nullFirst() {
    Ordering<City> cityOrdering = Ordering.from(new CityByPopulation());
    // 会抛出空指针
    City minCity = cityOrdering.min(citiesWithNull);

    Ordering<City> nullCityFirstOrdering = Ordering.from(new CityByPopulation()).nullsFirst();
    minCity = nullCityFirstOrdering.min(citiesWithNull);
    // 空优先
    Assert.assertNull(minCity);
  }

  @Test
  public void _secondarySorting() {
    Ordering<City> compoundSorting =
        Ordering.from(new CityByPopulation()).compound(new CityByAverageRainfall());

    City maxCity = compoundSorting.max(cities);

    Assert.assertEquals(city2.getAverageRainfall(), maxCity.getAverageRainfall(), 0.01);
  }

  @Test
  public void topAndBottom() {
    Ordering<City> cityOrdering = Ordering.from(new CityByPopulation());
    List<City> top2Cities = cityOrdering.greatestOf(cities, 2);
    Assert.assertEquals(city2.getPopulation(), top2Cities.get(0).getPopulation());
    Assert.assertEquals(city1.getPopulation(), top2Cities.get(1).getPopulation());

    List<City> bottom2Cities = cityOrdering.leastOf(cities, 2);
    Assert.assertEquals(city3.getPopulation(), bottom2Cities.get(0).getPopulation());
    Assert.assertEquals(city4.getPopulation(), bottom2Cities.get(1).getPopulation());

  }

}
