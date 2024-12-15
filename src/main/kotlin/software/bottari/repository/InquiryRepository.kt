package software.bottari.repository

import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param
import org.springframework.stereotype.Repository
import software.bottari.domain.Inquiry

@Repository
interface InquiryRepository : JpaRepository<Inquiry , Long> {
    @Query("SELECT i FROM Inquiry i where i.member.name = :memberName")
    fun findAllByMemberName(@Param("memberName")memberName: String, pageable: Pageable): Page<Inquiry>
}