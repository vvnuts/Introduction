import java.lang.IllegalArgumentException
//Hello, world!
fun start(): String = "OK"

//Named arguments
fun joinOptions(options: Collection<String>) =
    options.joinToString(prefix = "[", postfix = "]")

//Default arguments
fun foo(name: String, number: Int = 42, toUpperCase: Boolean = false) =
    (if (toUpperCase) name.uppercase() else name) + number

fun useFoo() = listOf(
    foo("a", 42, false),
    foo("b", number = 1, false),
    foo("c", 42, toUpperCase = true),
    foo(name = "d", number = 2, toUpperCase = true)
)

//Triple-quoted strings
const val question = "life, the universe, and everything"
const val answer = 42

val tripleQuotedString = """
    #question = "$question"
    #answer = $answer""".trimMargin("#")

fun main() {
    println(tripleQuotedString)
}

//String templates
val month = "(JAN|FEB|MAR|APR|MAY|JUN|JUL|AUG|SEP|OCT|NOV|DEC)"

fun getPattern(): String = """\d{2} $month \d{4}"""

//Nullable types
fun sendMessageToClient(
    client: Client?, message: String?, mailer: Mailer
) {
    val personalInfo = client?.personalInfo;
    val email = personalInfo?.email;
    if (email != null && message != null) {
        mailer.sendMessage(email, message)
    }
}

class Client(val personalInfo: PersonalInfo?)
class PersonalInfo(val email: String?)
interface Mailer {
    fun sendMessage(email: String, message: String)
}

//Nothing type
fun failWithWrongAge(age: Int?) : Nothing {
    throw IllegalArgumentException("Wrong age: $age")
}

fun checkAge(age: Int?) {
    if (age == null || age !in 0..150) failWithWrongAge(age)
    println("Congrats! Next year you'll be ${age + 1}.")
}

fun notMain() {
    checkAge(10)
}

//Lambdas
fun containsEven(collection: Collection<Int>): Boolean =
    collection.any { number -> number % 2 == 0 }
