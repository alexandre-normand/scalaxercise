package org.scalamtl.collections

import org.scalatest.FunSuite
import scala.collection.mutable.ListBuffer

class CollectionsExercises extends FunSuite {

  test("create some collections") {
    //Scala provides many collections implementations.
    //By default, the collections are immutable. If you want mutable collections,
    //you will have to import them.
    val emptyList = Nil
    val list = List(1, 2, 3, 4)
    val set = Set(1, 2, 2)

    //Some collections functions
    assert(emptyList.length === 0)
    assert(list.head === 1)
    assert(list.tail === List(2, 3, 4))
    assert(set.size === 2)
    assert(set.toList.contains(1))

    //A Map is a list of Tuples. Tuples can be created in two ways.
    // ("a", 2) is the same Tuple as "a" -> 2
    //Usually, the arrow syntax is used for maps.
    val map = Map("k" -> 1, ("kk", 4))

    //The apply operation (using the () directly on the map) returns a value or throws a NoSuchElementException
    assert(map("k") === 1)
    //The get function returns an object of type Option
    assert(map.get("kk").isDefined)

    //Many types support conversion to common collections such as List, Set, etc...
    val string = "abc"
    assert(string.toList === List('a', 'b', 'c'))
  }

  test("check palindrome") {
    //This function returns true is the string is the same by reading forward or backward, false otherwise.
    def isPalindrome(string: String): Boolean = {
      string.reverse.equals(string)
    }

    assert(isPalindrome("hahah"))
    assert(!isPalindrome("haha"))
  }

  test("remove duplicate elements in a list") {
    def removeDuplicate(list: List[Int]): List[Int] = {
      list.distinct
    }

    val initialList = List(1, 2, 2, 3, 3)
    assert(removeDuplicate(initialList) === List(1, 2, 3))
  }

  test("collect words with more than 3 letters") {
    def collectLongWords(list: List[String]): List[String] = {
      list.filter(_.length > 3)
    }

    assert(collectLongWords(List("mama", "apple", "to", "two")) === List("mama", "apple"))
  }

  test("translate numbers to english") {
    def toEnglish(number: Int): String = {
      val numberAsListOfChars = number.toString.toList
      numberAsListOfChars.map(digit => digit match {
        case '0' => "zero"
        case '1' => "one"
        case '2' => "two"
        case '3' => "three"
        case '4' => "four"
        case '5' => "five"
        case '6' => "six"
        case '7' => "seven"
        case '8' => "eight"
        case '9' => "nine"
      }).mkString("-")
    }

    assert(toEnglish(42) === "four-two")
    assert(toEnglish(11) === "one-one")
  }
}
