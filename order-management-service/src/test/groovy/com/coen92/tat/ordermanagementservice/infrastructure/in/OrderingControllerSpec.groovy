    package com.coen92.tat.ordermanagementservice.infrastructure.in

    import spock.lang.Specification

    class OrderingControllerSpec extends Specification {

        def "example test in spock"() {
            given:
                List<String> exampleList = ["item1", "item2", "item3"]

            when:
                exampleList.remove("item2")

            then:
                exampleList.size() == 2
                exampleList.contains("item1")
                !exampleList.contains("item2")
                exampleList.contains("item3")
        }
    }
