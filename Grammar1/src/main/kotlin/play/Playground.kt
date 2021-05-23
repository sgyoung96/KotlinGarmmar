package play
// command + option + R 하면 main() 함수를 실행할 파일을 선택할 수 있음!

//class Playground {
//    fun main() = println("Hello!!!!")
//}

//fun main() = println("Hello!!!!")
// Hello!!!!

fun main() {
    infix fun Int.times(str: String) = str.repeat(this)
    println(2 times "Bye ")
    // Bye Bye
    /**
     * operator functi
     * on 도 가능함
     * perator fun Unt.times(str: String) = str.repeat(this)
     */

    /**
     * infix 함수
     * Member functions and extensions with a 'single parameter' can be turned into infix functions.
     */

    val pair = "F" to "K"
    println(pair)
    // (F, K)

    infix fun String.onto(other: String) = Pair(this, other)
    //println(Pair) ------------> error!
    val myPair = "M" onto "L"
    println(myPair)
    // (M, L)

    val sophia = Person("S")
    println(sophia)
//    var test = sophia.likes(sophia)
//    println(test)
    val claudia = Person("C")
    println(claudia)
    sophia likes claudia
    println(sophia likes claudia)


    /**
     * varag parameter (키워드가 varag 임)
     * allow you to pass any number of arguments by seperating them with commas.
     */
    fun printAll(vararg messages: String) {
        for (m in messages) println(m)
    }
    printAll("A", "B", "C", "D", "E") // varag 키워드가 있어서 파라미터는 하나인데 , 로 여러 개의 인자값을 전달하는 것이 가능해진 것임

    // varag 로 메세지 값 여러개 받고, prefix 에 하나만 넣어 줌.
    // 그리고 출력할 때는 prefix + message
    fun printAllWithPrefix(vararg messages: String, prefix: String) {
        for (m in messages) println(prefix + m)
    }
    printAllWithPrefix(
        "A", "B", "C", "D", "E", "F",
        prefix = "Hello "
    )

    // At runtime, a varag is just an array.
    // To pass it along into a vararg parameter, user the special spread operator * that lets you pass in *entreis (a varag of String) / instead of entries (and Array<String>).
    // 아, for 를 써서 변수에 담지 않고도 * 키워드로 그냥 전체 선택(? 출력?) 이 가능한가보다!
    fun log(vararg entreis: String) {
        printAll(*entreis)
    }
    log("entry1", "entry2", "entry3", "entry4")

//    var inferedNonNull = inferredNonNull = null // -> 에러 : 타입이 정확히 지정되지 않은 것. 추론 타입 변수는 null 할당 불가다.

    // class 실습
    val customer = Customer()
    val contact = Contact(1, "asdf@naver.com")
    println(contact.id)
    println(contact.email)
//    contact.id = 2 // 에러, 매개변수 선언해줄 때 val 이라고 했었음
    contact.email = "12345@naver.com"
    println(contact.email)

}
class Person(val name: String) {
    val likedPeople = mutableListOf<Person>()
    infix fun likes(other: Person) {
        likedPeople.add(other)

        println(likedPeople)
    }
    //println() -----------> error!
}

class Customer // {} 내용이 없으면 생략 가능
class Contact (val id: Int, var email: String)