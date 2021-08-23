package com.lubycon.devti.bdd.behavior.advertisement

import com.lubycon.devti.SpringDataConfig
import com.lubycon.devti.domain.advertisement.api.AdvertisementController
import com.lubycon.devti.domain.advertisement.dao.AdvertisementRepository
import com.lubycon.devti.domain.advertisement.dto.AdvertisementResDto
import com.lubycon.devti.domain.advertisement.service.AdvertisementService
import com.lubycon.devti.global.code.AdvertisementType
import io.kotest.core.spec.IsolationMode
import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.date.shouldBeAfter
import io.kotest.matchers.date.shouldBeBefore
import io.kotest.matchers.shouldBe
import io.mockk.mockk
import io.mockk.spyk
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.ContextConfiguration
import java.time.LocalDate
import javax.transaction.Transactional

@ContextConfiguration(classes = [SpringDataConfig::class])
class AdvertisementFeature(
    _advertisementRepository: AdvertisementRepository,
) : BehaviorSpec() {
    private val advertisementRepository = spyk(_advertisementRepository)
    private val advertisementService = AdvertisementService(advertisementRepository)
    override fun isolationMode(): IsolationMode = IsolationMode.InstancePerLeaf


    init{
        Given("광고를 호출 할 때") {

            When("원하는 광고 타입을 입력시") {

                And("모든 광고 불러올 경우 : Advertisement.ALL") {
                    val result = advertisementService.findAllAdvertisementByAdvertisementType(AdvertisementType.ALL)
                    Then("유효한 기간 내의 모든 광고를 불러온다.") {
                        result
                            .stream()
                            .forEach{
                                it.advertisementStartDate.shouldBeBefore(LocalDate.now())
                                it.advertisementEndDate.shouldBeAfter(LocalDate.now())
                            }
                    }

                }
                And("LECTURE 광고만 불러올 경우 : Advertisement.LECTURE") {
                    val result = advertisementService.findAllAdvertisementByAdvertisementType(AdvertisementType.LECTURE)
                    Then("유효 기간 내의 LECTURE 광고만 불러온다.") {
                        result
                            .stream()
                            .forEach{
                                it.advertisementType.shouldBe(AdvertisementType.LECTURE)
                                it.advertisementStartDate.shouldBeBefore(LocalDate.now())
                                it.advertisementEndDate.shouldBeAfter(LocalDate.now())
                            }
                    }
                }
                And("RECRUIT 광고만 불러올 경우 : Advertisement.RECRUIT") {
                    val result = advertisementService.findAllAdvertisementByAdvertisementType(AdvertisementType.RECRUIT)
                    Then("유효 기간 내의 RECRUIT 광고만 불러온다.") {
                        result
                            .stream()
                            .forEach{
                                it.advertisementType.shouldBe(AdvertisementType.RECRUIT)
                                it.advertisementStartDate.shouldBeBefore(LocalDate.now())
                                it.advertisementEndDate.shouldBeAfter(LocalDate.now())
                            }
                    }

                }
            }

        }
    }
}