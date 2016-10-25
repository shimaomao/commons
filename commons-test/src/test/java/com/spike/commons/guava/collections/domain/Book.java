package com.spike.commons.guava.collections.domain;

import com.google.common.base.MoreObjects;

public class Book implements Comparable<Book> {

  private Person author;
  private String title;
  private String publisher;
  private String isbn;
  private double price;

  public Book() {
  }

  public Book(Person author, String title, String publisher, String isbn, double price) {
    this.author = author;
    this.title = title;
    this.publisher = publisher;
    this.isbn = isbn;
    this.price = price;
  }

  @Override
  public int compareTo(Book o) {
    return isbn.compareTo(o.isbn);
  }

  public Person getAuthor() {
    return author;
  }

  public void setAuthor(Person author) {
    this.author = author;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getPublisher() {
    return publisher;
  }

  public void setPublisher(String publisher) {
    this.publisher = publisher;
  }

  public String getIsbn() {
    return isbn;
  }

  public void setIsbn(String isbn) {
    this.isbn = isbn;
  }

  public double getPrice() {
    return price;
  }

  public void setPrice(double price) {
    this.price = price;
  }

  @Override
  public String toString() {
    return MoreObjects//
        .toStringHelper(this)//
        .omitNullValues()//
        .add("", author)//
        .add("", publisher)//
        .add("isbn", isbn)//
        .add("", price)// primitive不为null
        .add("标题", title)//
        .toString();
  }

}
