package com.lubycon.devti.domain.devti.api

import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.core.test.TestCase
import org.junit.jupiter.api.Assertions.*
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders
import org.springframework.test.web.servlet.result.MockMvcResultHandlers
import org.springframework.test.web.servlet.result.MockMvcResultMatchers
import org.springframework.test.web.servlet.setup.MockMvcBuilders
import org.springframework.util.LinkedMultiValueMap

//@AutoConfigureMockMvc
//@WebMvcTest
class DevtiControllerTest(): BehaviorSpec() {

    @Autowired
    private lateinit var mockMvc: MockMvc
//    override fun beforeTest(testCase: TestCase) {
//
//        mockMvc = MockMvcBuilders.standaloneSetup(
//            DevtiController::class)
//                .alwaysExpect(MockMvcResultMatchers.status().isOk())
//                .build();
//
//    }

    init {
        Given("DEVTI") {
            val uri = "/results/v2"

            val queryParams = LinkedMultiValueMap<String, String>()
            queryParams.add("V", "100")
            queryParams.add("A", "0")
            queryParams.add("P", "100")
            queryParams.add("T", "0")
            queryParams.add("C", "0")
            queryParams.add("S", "100")
            queryParams.add("L", "0")
            queryParams.add("W", "100")
            queryParams.add("job", "F")



            When("VSPW-front") {
                Then("결과") {
                    mockMvc.perform(MockMvcRequestBuilders.get(uri).queryParams(queryParams))
                        .andExpect(MockMvcResultMatchers.status().isOk)
                        .andDo(MockMvcResultHandlers.print())

                }
            }
        }
    }

}