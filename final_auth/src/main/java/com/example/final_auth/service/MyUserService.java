package com.example.final_auth.service;

import com.example.final_auth.Advice.ApiExeption;
import com.example.final_auth.model.MyUser;
import com.example.final_auth.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MyUserService {
    private final UserRepository userRepository;


    public List<MyUser> getAllUsers(){
        return userRepository.findAll();
    }

    public MyUser getUser(Integer id){
        MyUser myUser=userRepository.findMyUserById(id);
        if (myUser==null){
            throw new ApiExeption("User Not Found!");
        }
        return myUser;
    }


    public void addUser(MyUser newUser){
        newUser.setRole("USER");
        String hashedPassword=new BCryptPasswordEncoder().encode(newUser.getPassword());
        newUser.setPassword(hashedPassword);
        userRepository.save(newUser);
    }

    public void deleteUser(Integer id){
        MyUser myUser=userRepository.findMyUserById(id);
        if(myUser==null){
            throw new ApiExeption("User Not Found");
        }
        userRepository.delete(myUser);
    }


    public void updateUser(MyUser newUser, Integer id){
        MyUser oldUser=userRepository.findMyUserById(id);

        newUser.setId(id);
        newUser.setRole(oldUser.getRole());
        newUser.setPassword(new BCryptPasswordEncoder().encode(newUser.getPassword()));

        userRepository.save(newUser);
    }
}
