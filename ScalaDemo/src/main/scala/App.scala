package example

import scala.collection.mutable

object App {
  def main(args: Array[String]) {
//    writeTextToConsole("First text");
//    val testText:String = "test string";
    //println((test))

    val nums = List(1,2,3,4);
    var list = List.range(2,9);
    nums.filter(e=>e>2);
    println(nums.filter(e=>e>2));
    println(list.map(Math.pow(_,2).toInt));
//    println(List.range(2,9).tabulate(2));
    def reverse (e1:Int, e2:Int) = e1>2
    def addOne(e:Int)=e+1


    println(List.range(0,100).sortWith(_>_).map(_+1));
    println(List.range(0,100).sortWith((e1,e2)=> e1>e2).map(_+1));
    println(List.range(0,100).sortWith(reverse).map(addOne));

    println(List.range(0,100) sortWith reverse map addOne );

  }

  def writeTextToConsole (text:String):Unit = {
    println(text);
  }


}
