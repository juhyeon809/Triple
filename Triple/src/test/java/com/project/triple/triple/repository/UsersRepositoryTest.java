package com.project.triple.triple.repository;

import com.project.triple.model.entity.User.Users;
import com.project.triple.model.enumclass.UserStatus;
import com.project.triple.repository.UsersRepository;
import com.project.triple.triple.TripleApplicationTests;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;
import java.util.Optional;

public class UsersRepositoryTest extends TripleApplicationTests {

    @Autowired
    private UsersRepository usersRepository;

//    @Test
//    public void create(){
//        Users users = Users.builder().userid("apple").email("apple@apple.com").userpw("1234")
//                .nickname("김사과").countryCode("82").zipcode(111111).address1("서울")
//                .address2("11-11").address3("111111").regDate(LocalDateTime.now())
//                .status(UserStatus.REGISTERED).tosAgree("동의")
//                .build();
//        Users newUsers = usersRepository.save(users);
//    }
//
//    @Test
//    public void read() {
//        Optional<Users> users = usersRepository.findByUserid("apple");
//
//        users.ifPresent(
//                selectUsers -> {
//                    System.out.println(selectUsers.getEmail());
//                    System.out.println(selectUsers.getNickname());
//                }
//        );
//    }

//    @Test
//    public void update() {
//        Optional<Users> users = usersRepository.findByUserid("apple");
//
//        users.ifPresent(
//                selectUsers ->{
//                    selectUsers.setEmail("apple@naver.com");
//                    selectUsers.setNickname("사과");
//                    usersRepository.save(selectUsers);
//                }
//        );
//    }
//
//    @Test
//    public void delete(){
//        Optional<Users> users = usersRepository.findByUserid("apple");
//
//        users.ifPresent(
//                selectUsers -> {
//                    usersRepository.delete(selectUsers);
//                }
//        );
//    }
}
