package com.poly.edu.project.graduation.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.poly.edu.project.graduation.dao.RoleRepository;
import com.poly.edu.project.graduation.dao.UserRepository;
import com.poly.edu.project.graduation.model.RoleUserEntity;
import com.poly.edu.project.graduation.model.UserDto;
import com.poly.edu.project.graduation.model.UserEntity;
import com.poly.edu.project.graduation.services.UserService;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
     UserRepository userRepository;
	@Autowired
     RoleRepository roleRepository;
	@Autowired
     PasswordEncoder passwordEncoder;

    public UserServiceImpl(UserRepository userRepository,
                           RoleRepository roleRepository,
                           PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void saveUser(UserDto userDto) {
        UserEntity user = new UserEntity();
        user.setFirstName(userDto.getFirstName());
        user.setLastName(userDto.getLastName());
        user.setEmail(userDto.getEmail());
        user.setUsername(userDto.getUsername());

        //encrypt the password once we integrate spring security
        //user.setPassword(userDto.getPassword());
        user.setPassword(passwordEncoder.encode(userDto.getPassword()));
        RoleUserEntity role = roleRepository.findByName("ROLE_ADMIN");
        if(role == null){
            role = checkRoleExist();
        }
        user.setRoles(Arrays.asList(role));
        userRepository.save(user);
    }

    @Override
    public UserEntity findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public List<UserDto> findAllUsers() {
        List<UserEntity> users = userRepository.findAll();
        return users.stream().map((user) -> convertEntityToDto(user))
                .collect(Collectors.toList());
    }

    private UserDto convertEntityToDto(UserEntity user){
        UserDto userDto = new UserDto();
        String[] name = user.getLastName().split(" ");
        userDto.setUsername(user.getUsername());
        userDto.setFirstName(user.getFirstName());
        userDto.setLastName(user.getLastName());
        userDto.setEmail(user.getEmail());
        return userDto;
    }

    private RoleUserEntity checkRoleExist() {
    	RoleUserEntity role = new RoleUserEntity();
        role.setName("ROLE_ADMIN");
        return roleRepository.save(role);
    }

	@Override
	public Page<UserEntity> findByKeyWord(String keyword, Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void changeStatusIsdeleted(long id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void changeStatusInstock(long id) {
		// TODO Auto-generated method stub
		
	}
}
