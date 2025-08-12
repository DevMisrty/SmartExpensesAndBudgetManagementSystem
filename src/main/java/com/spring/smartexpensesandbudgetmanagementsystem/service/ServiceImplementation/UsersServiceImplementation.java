package com.spring.smartexpensesandbudgetmanagementsystem.service.ServiceImplementation;

import com.spring.smartexpensesandbudgetmanagementsystem.dto.SignInRequestDto;
import com.spring.smartexpensesandbudgetmanagementsystem.dto.SignInResponseDto;
import com.spring.smartexpensesandbudgetmanagementsystem.model.Users;
import com.spring.smartexpensesandbudgetmanagementsystem.repository.UsersRepo;
import com.spring.smartexpensesandbudgetmanagementsystem.service.UsersService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class UsersServiceImplementation implements UsersService {

    private final ModelMapper modelMapper;
    private final PasswordEncoder passwordEncoder;
    private final UsersRepo usersRepo;

    @Override
    public SignInResponseDto saveNewUsers(SignInRequestDto signInRequestDto) {
        Users user = modelMapper.map(signInRequestDto, Users.class);
        user.setRole("user");
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return modelMapper.map(saveNewUsers(user), SignInResponseDto.class);
    }

    @Override
    public Optional<Users> findByUsername(String username) {
        return usersRepo.findByUsername(username);
    }

    @Override
    public Users saveNewUsers(Users users) {
        return usersRepo.save(users);
    }
}
