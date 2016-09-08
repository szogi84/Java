/**
 * Created by e-snci on 9/8/2016.
 */
class GradleDemoTest extends spock.lang.Specification {
    def "Main"() {
        expect: hello == "Gradle test"

        where: hello = new Hello().sayHello()
    }
}
