package com.poly.edu.project.graduation.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.stereotype.Service;

import com.poly.edu.project.graduation.dao.RoleRepository;
import com.poly.edu.project.graduation.dao.UserRepository;
import com.poly.edu.project.graduation.exception.CustomerNotFoundException;
import com.poly.edu.project.graduation.model.AppUserEntity;
import com.poly.edu.project.graduation.model.UserDto;
import com.poly.edu.project.graduation.services.UserService;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	BCryptPasswordEncoder pe;

	@Autowired
	UserRepository userRepository;
	@Autowired
	RoleRepository roleRepository;
//	@Autowired
//	PasswordEncoder passwordEncoder;


	/**
	 * Đăng ký User mơi
	 */
//	@Override
//	public void saveUser(UserDto userDto) {
//		UserEntity user = new UserEntity();
//		user.setFirstName(userDto.getFirstName());
//		user.setLastName(userDto.getLastName());
//		user.setEmail(userDto.getEmail());
//		user.setUsername(userDto.getUsername());
//
//		// encrypt the password once we integrate spring security
//		// user.setPassword(userDto.getPassword());
//		user.setPassword(passwordEncoder.encode(userDto.getPassword()));
//		RoleUserEntity role = roleRepository.findByName("ROLE_ADMIN");
//		if (role == null) {
//			role = checkRoleExist();
//		}
//		user.setRoles(Arrays.asList(role));
//		userRepository.save(user);
//	}

//	@Override
//	public UserEntity findByEmail(String email) {
//		return userRepository.findByEmail(email);
//	}

//	@Override
//	public List<UserDto> findAllUsers() {
//		List<UserRoleEntity> users = userRepository.findAll();
//		return users.stream().map((user) -> convertEntityToDto(user)).collect(Collectors.toList());
//	}
//
//	private UserDto convertEntityToDto(AppUserEntity user) {
//		UserDto userDto = new UserDto();
//		String[] name = user.getLastName().split(" ");
//		userDto.setUsername(user.getUserName());
//		userDto.setFirstName(user.getFirstName());
//		userDto.setLastName(user.getLastName());
//		userDto.setEmail(user.getEmail());
//		return userDto;
//	}
//
//	private AppRoleEntity checkRoleExist() {
//		UserRoleEntity role = new UserRoleEntity();
//		role.setName("ROLE_ADMIN");
//		return roleRepository.save(role);
//	}

	@Override
	public Page<AppUserEntity> findByKeyWord(String keyword, Pageable pageable) {
		// TODO Auto-generated method stub
		return userRepository.findByKeyWord(keyword, pageable);
	}

	/**
	 * Cập nhật trạng thái đã xoá user
	 */
	@Override
	public void changeStatusIsdeleted(long id) {
		// TODO Auto-generated method stub
		userRepository.changeStatusIsdeleted(id);
	}

	/**
	 * Cập nhật trạng thái đang làm việc nhân viên
	 */
	@Override
	public void changeStatusInstock(long id) {
		// TODO Auto-generated method stub
		userRepository.changeIstock(id);
	}

	@Override
	public List<UserDto> findAllUsers() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void loginFromOAuth2(OAuth2AuthenticationToken oAuth2AuthenticationToken) {
		
		String email = oAuth2AuthenticationToken.getPrincipal().getAttribute("email");
		String password = Long.toHexString(System.currentTimeMillis());
		
		UserDetails userDetails = User.withUsername(email).password(pe.encode(password)).roles("GUEST").build();
		
		org.springframework.security.core.Authentication auth = 
				new UsernamePasswordAuthenticationToken(userDetails, null,userDetails.getAuthorities());
		
		SecurityContextHolder.getContext().setAuthentication((org.springframework.security.core.Authentication) auth);
			
		
	}

	@Override
	public void updateResetPasswordToken(String token, String email) throws CustomerNotFoundException {
		AppUserEntity customer = userRepository.findByEmail(email);
        if (customer != null) {
            customer.setResetPasswordToken(token);
            userRepository.save(customer);
        } else {
            throw new CustomerNotFoundException("Could not find any customer with the email " + email);
        }
		
	}

	@Override
	public AppUserEntity getByResetPasswordToken(String token) {
		// TODO Auto-generated method stub
		return userRepository.findByResetPasswordToken(token);
	}

	@Override
	public void updatePassword(AppUserEntity appUserEntity, String newPassword) {
		
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String encodedPassword = passwordEncoder.encode(newPassword);
        appUserEntity.setEncrytedPassword(encodedPassword);
         
        appUserEntity.setResetPasswordToken(null);
        userRepository.save(appUserEntity);
		
	}

	@Override
	public AppUserEntity findUserById(String name) {
		// TODO Auto-generated method stub
		return userRepository.findUserById(name);
	}

	@Override
	public String findIdUserByPrincipal(String name) {
		// TODO Auto-generated method stub
		return userRepository.findIdUserByPricipal(name);
	}
}
