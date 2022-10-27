package com.poly.edu.project.graduation.dao;

import javax.transaction.Transactional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import com.poly.edu.project.graduation.model.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity, Long> {

	// Câu lệnh tìm kiếm Nhân Viên theo nhiều điều kiện
	@Query(value = "SELECT * FROM user  where user.is_deleted = false "
			+ "AND user.id 				LIKE CONCAT('%',:keyword,'%') "
			+ "OR  user.username 		LIKE CONCAT('%',:keyword,'%') "
			+ "OR  user.last_name 		LIKE CONCAT('%',:keyword,'%') "
			+ "OR  user.first_name 			LIKE CONCAT('%',:keyword,'%') "
			+ "OR  user.email 		LIKE CONCAT('%',:keyword,'%') "
			+ "OR  user.birthday 	LIKE CONCAT('%',:keyword,'%') "
			+ "OR  user.address 		LIKE CONCAT('%',:keyword,'%') "
			+ "OR  user.country 	LIKE CONCAT('%',:keyword,'%') "
			+ "OR user.city 				LIKE CONCAT('%',:keyword,'%') "
			+ "OR user.created_at 			LIKE CONCAT('%',:keyword,'%') "
			+ "OR user.updated_at 			LIKE CONCAT('%',:keyword,'%') ", nativeQuery = true)
	Page<UserEntity> findByKeyWord(String keyword, Pageable pageable);

	@Modifying
	@Query(value = "UPDATE UserEntity SET isDeleted = TRUE WHERE id = ?1")
	@Transactional
	void changeStatusIsdeleted(long id);

	@Modifying
	@Query(value = "UPDATE UserEntity SET isDeleted = FALSE WHERE id = ?1")
	@Transactional
	void changeIstock(long id);

	UserEntity findByEmail(String email);
}
