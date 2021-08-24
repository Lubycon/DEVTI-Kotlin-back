package com.lubycon.devti.domain.bucket_test_type.dao

import com.lubycon.devti.domain.bucket_test_type.entity.BucketTestType
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface BucketTestTypeRepository: JpaRepository<BucketTestType, Long>{
}