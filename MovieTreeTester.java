//////////////// FILE HEADER (INCLUDE IN EVERY FILE) //////////////////////////
//
// Title: MovieTree
// Course: CS 300 Fall 2020
//
// Author: Elgini Neci
// Email: neci@wisc.edu
// Lecturer: Hobbes LeGault
//
///////////////////////// ALWAYS CREDIT OUTSIDE HELP //////////////////////////
//
// Persons: (identify each by name and describe how they helped)
// Online Sources: (identify each by URL and describe how it helped)
//
///////////////////////////////////////////////////////////////////////////////

import java.util.ArrayList;
import java.util.NoSuchElementException;

/**
 * This class checks the correctness of the implementation of the methods defined in the class
 * MovieTree.
 *
 */

public class MovieTreeTester {

  /**
   * Checks the correctness of the implementation of both addMovie() and toString() methods
   * implemented in the MovieTree class. This unit test considers at least the following scenarios.
   * (1) Create a new empty MovieTree, and check that its size is 0, it is empty, and that its
   * string representation is an empty string "". (2) try adding one movie and then check that the
   * addMovie() method call returns true, the tree is not empty, its size is 1, and the .toString()
   * called on the tree returns the expected output. (3) Try adding another movie which is smaller
   * that the movie at the root, (4) Try adding a third movie which is greater than the one at the
   * root, (5) Try adding at least two further movies such that one must be added at the left
   * subtree, and the other at the right subtree. For all the above scenarios, and more, double
   * check each time that size() method returns the expected value, the add method call returns
   * true, and that the .toString() method returns the expected string representation of the
   * contents of the binary search tree in an increasing order from the smallest to the greatest
   * movie with respect to year, rating, and then name. (6) Try adding a movie already stored in the
   * tree. Make sure that the addMovie() method call returned false, and that the size of the tree
   * did not change.
   * 
   * @return true when this test verifies a correct functionality, and false otherwise
   */
  public static boolean testAddMovieToStringSize() {
   try {
    MovieTree tree = new MovieTree();
    if (tree.size() != 0 && tree.toString().equals("")) {
      System.out.println("Size isn't 0 when creating a new tree");
      return false;
    }

    Movie movie1 = new Movie(2010, 1, "Film 1");
    String expected = movie1.toString();
    if (!tree.addMovie(movie1)) {
      System.out.println("There is an error when adding the first movie");
      return false;
    }
    if (tree.size() != 1) {
      System.out.println("There is an error whith the size of tree");
      return false;
    }
    if (tree.toString().trim().compareTo(expected) != 0) {
      System.out
          .println(tree.toString() + "" + " There is an error1 whith the toString method of tree");
      return false;
    }


    Movie movie2 = new Movie(2000, 2, "Film 2");
    expected = movie2.toString() + "\n" + movie1.toString();
    if (!tree.addMovie(movie2)) {
      System.out.println("There is an error when adding the second movie");
      return false;
    }
    if (tree.size() != 2) {
      System.out.println("There is an error whith the size of tree");
      return false;
    }
    if (tree.toString().trim().compareTo(expected) != 0) {
      System.out
          .println(tree.toString() + "" + " There is an error2 whith the toString method of tree");
      return false;
    }


    Movie movie3 = new Movie(2012, 3, "Film 3");
    expected += "\n" + movie3.toString();
    if (!tree.addMovie(movie3)) {
      System.out.println("There is an error when adding the third movie");
      return false;
    }
    if (tree.size() != 3) {
      System.out.println("There is an error whith the size of tree");
      return false;
    }
    if (tree.toString().trim().compareTo(expected) != 0) {
      System.out.println(tree.toString() + " There is an error whith the toString method of tree");
      return false;
    }



    Movie movie4 = new Movie(2015, 4, "Film 4");
    expected += "\n" + movie4.toString();
    if (!tree.addMovie(movie4)) {
      System.out.println("There is an error when adding the 4th and 5th movie");
      return false;
    }
    if (tree.size() != 4) {
      System.out.println("There is an error whith the size of tree");
      return false;
    }
    if (tree.toString().trim().compareTo(expected) != 0) {
      System.out.println(tree.toString() + " There is an error whith the toString method of tree");
      return false;
    }


    Movie movie5 = new Movie(2002, 5, "Film 5");
    expected = movie2.toString() + "\n" + movie5.toString() + "\n" + movie1.toString() + "\n"
        + movie3.toString() + "\n" + movie4.toString();
    if (!tree.addMovie(movie5)) {
      System.out.println("There is an error when adding the 4th and 5th movie");
      return false;
    }
    if (tree.size() != 5) {
      System.out.println("There is an error whith the size of tree");
      return false;
    }
    if (tree.toString().trim().compareTo(expected) != 0) {
      System.out.println(tree.toString() + " There is an error whith the toString method of tree");
      return false;
    }


    if (tree.addMovie(movie5)) {
      System.out.println("There is an error when adding a movie already in the tree");
      return false;
    }
    if (tree.size() != 5) {
      System.out.println("There is an error whith the size of tree");
      return false;
    }
   }catch (Exception e) {
     return false;
   }
    return true;
  }

  /**
   * This method checks mainly for the correctness of the MovieTree.contains() method. It must
   * consider at least the following test scenarios. (1) Create a new MovieTree. Then, check that
   * calling the contains() method on an empty MovieTree returns false. (2) Consider a MovieTree of
   * height 3 which contains at least 5 movies. Then, try to call contains() method to search for
   * the movie having a match at the root of the tree. (3) Then, search for a movie at the right and
   * left subtrees at different levels considering successful and unsuccessful search operations.
   * Make sure that the contains() method returns the expected output for every method call.
   * 
   * @return true when this test verifies a correct functionality, and false otherwise
   */
  public static boolean testContains() {
    try {
      MovieTree tree = new MovieTree();
      if (tree.contains(2000, 1, "j")) { // test contains() with a empty tree
        return false;
      }
      Movie movie1 = new Movie(2010, 1, "Film 1");
      Movie movie2 = new Movie(2015, 1, "Film 1");
      Movie movie3 = new Movie(2000, 1, "Film 1");
      Movie movie4 = new Movie(2002, 1, "Film 1");
      Movie movie5 = new Movie(2012, 1, "Film 1");
      tree.addMovie(movie1);
      tree.addMovie(movie2);
      tree.addMovie(movie3);
      tree.addMovie(movie4);
      tree.addMovie(movie5);

      // testing different movie and if contain finds them
      if (!tree.contains(movie1.getYear(), movie1.getRating(), movie1.getName())) {
        return false;
      }

      if (!tree.contains(movie2.getYear(), movie2.getRating(), movie2.getName())) {
        return false;
      }

      if (!tree.contains(movie4.getYear(), movie4.getRating(), movie4.getName())) {
        return false;
      }

      if (tree.contains(movie1.getYear() + 2, movie1.getRating() + 3, movie1.getName())) {
        return false;
      }
    } catch (Exception e) {
      return false;
    }
    return true;
  }

  /**
   * Checks for the correctness of MovieTree.height() method. This test must consider several
   * scenarios such as, (1) ensures that the height of an empty movie tree is zero. (2) ensures that
   * the height of a tree which consists of only one node is 1. (3) ensures that the height of a
   * MovieTree with the following structure for instance, is 4. (*) / \ (*) (*) \ / \ (*) (*) (*) /
   * (*)
   * 
   * @return true when this test verifies a correct functionality, and false otherwise
   */
  public static boolean testHeight() {
    try {
      MovieTree tree = new MovieTree();
      if (tree.height() != 0) { // test on a empty tree
        return false;
      }
      Movie movie1 = new Movie(2010, 1, "Film 1");
      Movie movie2 = new Movie(2015, 1, "Film 1");
      Movie movie3 = new Movie(2000, 1, "Film 1");
      Movie movie4 = new Movie(2002, 1, "Film 1");
      Movie movie5 = new Movie(2001, 1, "Film 1");
      Movie movie6 = new Movie(2016, 1, "Film 1");
      Movie movie7 = new Movie(2014, 1, "Film 1");
      tree.addMovie(movie1);
      if (tree.height() != 1) { // test on a tree with only the root
        return false;
      }
      tree.addMovie(movie2);
      tree.addMovie(movie3);
      tree.addMovie(movie4);
      tree.addMovie(movie5);
      tree.addMovie(movie6);
      tree.addMovie(movie7);

      if (tree.height() != 4) { // test on a height 4 tree
        return false;
      }

    } catch (Exception e) {
      return false;
    }
    return true;
  }

  /**
   * Checks for the correctness of MovieTree.getBestMovie() method.
   * 
   * @return true when this test verifies a correct functionality, and false otherwise
   */
  public static boolean testGetBestMovie() {
    try {
      MovieTree tree = new MovieTree();
      Movie movie1 = new Movie(2010, 1, "Film 1");
      Movie movie2 = new Movie(2015, 1, "Film 1");
      Movie movie3 = new Movie(2000, 1, "Film 1");
      Movie movie4 = new Movie(2002, 1, "Film 1");
      Movie movie5 = new Movie(2001, 1, "Film 1");
      Movie movie6 = new Movie(2016, 1, "Film 1");
      Movie movie7 = new Movie(2014, 1, "Film 1");
      tree.addMovie(movie1);
      tree.addMovie(movie2);
      tree.addMovie(movie3);
      tree.addMovie(movie4);
      tree.addMovie(movie5);
      tree.addMovie(movie6);
      tree.addMovie(movie7);

      if (!tree.getBestMovie().equals(movie6)) { // tests if movie6 is returned correctly
        return false;
      }
    } catch (Exception e) {
      return false;
    }
    return true;
  }

  /**
   * Checks for the correctness of MovieTree.lookup() method. This test must consider at least 3
   * test scenarios. (1) Ensures that the MovieTree.lookup() method throws a NoSuchElementException
   * when called on an empty tree. (2) Ensures that the MovieTree.lookup() method returns an array
   * list which contains all the movies satisfying the search criteria of year and rating, when
   * called on a non empty movie tree with one match, and two matches and more. Vary your search
   * criteria such that the lookup() method must check in left and right subtrees. (3) Ensures that
   * the MovieTree.lookup() method throws a NoSuchElementException when called on a non-empty movie
   * tree with no search results found.
   * 
   * @return true when this test verifies a correct functionality, and false otherwise
   */
  public static boolean testLookup() {
   
    try {
    MovieTree tree = new MovieTree();
    try { // test if searching for a moving in the empty tree throws an exception
      tree.lookup(2000, 2);
      return false;
    } catch (NoSuchElementException e) {

    }
    Movie movie1 = new Movie(2015, 1, "Film 2");
    Movie movie2 = new Movie(2010, 1, "Film 1");
    Movie movie3 = new Movie(2010, 9, "Film 1");
    Movie movie4 = new Movie(2010, 2, "Film 1");
    Movie movie5 = new Movie(2001, 1, "Film 1");
    Movie movie6 = new Movie(2016, 1, "Film 1");
    Movie movie7 = new Movie(2014, 1, "Film 1");
    tree.addMovie(movie1);
    tree.addMovie(movie2);
    tree.addMovie(movie3);
    tree.addMovie(movie4);
    tree.addMovie(movie5);
    tree.addMovie(movie6);
    tree.addMovie(movie7);

    ArrayList<Movie> movieListExpected = new ArrayList<Movie>();
    movieListExpected.add(movie1);
    if (!tree.lookup(2015, 1).equals(movieListExpected)) { // test if lookup find only one movie
      System.out.println(movieListExpected + " " + tree.lookup(2015, 1));
      return false;
    }

    movieListExpected.clear();
    movieListExpected.add(movie2);
    movieListExpected.add(movie3);
    movieListExpected.add(movie4);
    if (!tree.lookup(2010, 1).equals(movieListExpected)) { // test if lookup find three movies
      System.out.println(movieListExpected + " " + tree.lookup(2010, 1));
      return false;
    }



    try { // test if searching for a moving that isn't in the tree throws an exception
      tree.lookup(2020, 2);
      return false;
    } catch (NoSuchElementException e) {

    }

    }catch (Exception e) {
      return false;
    }
    return true;
  }

  /**
   * Calls the test methods
   * 
   * @param args input arguments if any
   */
  public static void main(String[] args) {

    // runs all the test
    System.out.println("testLookup: " + testLookup());
    System.out.println("testGetBestMovie: " + testGetBestMovie());
    System.out.println("testHeight: " + testHeight());
    System.out.println("testContains: " + testContains());
    System.out.println("testAddMovieToStringSize: " + testAddMovieToStringSize());
  }

}
