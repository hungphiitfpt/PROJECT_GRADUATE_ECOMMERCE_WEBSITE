package com.poly.edu.project.graduation.dao;

import javax.transaction.Transactional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.poly.edu.project.graduation.model.AppUserEntity;

public interface UserRepository extends JpaRepository<AppUserEntity, Long> {

	// Câu lệnh tìm kiếm Nhân Viên theo nhiều điều kiện
	@Query(value = "SELECT * FROM app_user  where app_user.is_deleted = false "
			+ "AND app_user.user_id				LIKE CONCAT('%',:keyword,'%') "
			+ "OR  app_user.user_name 		LIKE CONCAT('%',:keyword,'%') "
			+ "OR  app_user.last_name 		LIKE CONCAT('%',:keyword,'%') "
			+ "OR  app_user.first_name 			LIKE CONCAT('%',:keyword,'%') "
			+ "OR  app_user.email 		LIKE CONCAT('%',:keyword,'%') "
			+ "OR  app_user.birthday 	LIKE CONCAT('%',:keyword,'%') "
			+ "OR  app_user.address 		LIKE CONCAT('%',:keyword,'%') "
			+ "OR  app_user.country 	LIKE CONCAT('%',:keyword,'%') "
			+ "OR app_user.city 				LIKE CONCAT('%',:keyword,'%') "
			+ "OR app_user.created_at 			LIKE CONCAT('%',:keyword,'%') "
			+ "OR app_user.updated_at 			LIKE CONCAT('%',:keyword,'%') ", nativeQuery = true)
	Page<AppUserEntity> findByKeyWord(String keyword, Pageable pageable);

	@Modifying
	@Query(value = "UPDATE AppUserEntity SET isDeleted = TRUE WHERE userId = ?1")
	@Transactional
	void changeStatusIsdeleted(long id);

	@Modifying
	@Query(value = "UPDATE AppUserEntity SET isDeleted = FALSE WHERE userId = ?1")
	@Transactional
	void changeIstock(long id);

//	AppUserEntity findByEmail(String email);
	
    @Query("SELECT c FROM AppUserEntity c WHERE c.email = ?1")
    public AppUserEntity findByEmail(String email); 
     
    public AppUserEntity findByResetPasswordToken(String token);
    
    @Query("SELECT c FROM AppUserEntity c WHERE c.userName = ?1")
	AppUserEntity findUserById(String name);
    



	

}
