package com.poly.edu.project.graduation.services;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.stereotype.Service;

import com.poly.edu.project.graduation.exception.CustomerNotFoundException;
import com.poly.edu.project.graduation.model.AppUserEntity;
import com.poly.edu.project.graduation.model.UserDto;

@Service
public interface UserService {

	Page<AppUserEntity> findByKeyWord(String keyword, Pageable pageable);

	void changeStatusIsdeleted(long id);

	void changeStatusInstock(long id);

//	void saveUser(UserDto userDto);

//	UserEntity findByEmail(String email);

	List<UserDto> findAllUsers();

	void loginFromOAuth2(OAuth2AuthenticationToken oAuth2AuthenticationToken);
	
	void updateResetPasswordToken(String token, String email) throws CustomerNotFoundException;
	
	public AppUserEntity getByResetPasswordToken(String token);
	
	void updatePassword(AppUserEntity appUserEntity, String newPassword);

	AppUserEntity findUserById(String name);

	String findIdUserByPrincipal(String name);

}
