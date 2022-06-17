package com.spring.boot.development.project.repository;

 import com.spring.boot.development.project.model.Token;
 import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created By zepaG on 7/9/2021.
 */
public interface TokenRepository extends JpaRepository<Token, String> {
    Token findTop1ByOrderByIdDesc();
//    TfBcpmCusSerTargetStatus findTop1ByTargetIdOrderByCreatedDateDesc(String targetId);

}
