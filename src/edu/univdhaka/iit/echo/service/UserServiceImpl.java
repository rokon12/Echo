package edu.univdhaka.iit.echo.service;

import java.util.List;

import edu.univdhaka.iit.echo.domain.UserAccount;
import edu.univdhaka.iit.echo.repository.EchoFactory;

public class UserServiceImpl implements UserService {


    @Override
    public boolean createNewUser(UserAccount user) {
        System.out.println("createNewUser() new user = " + user);

        user.setId(EchoFactory.getGeneratedUserId());
        EchoFactory.getUserList().add(user);

        System.out.println("new user created successfully");
        return true;
    }

    @Override
    public List<UserAccount> findAllUser() {
        System.out.println("findAllUser()");

        return EchoFactory.getUserList();
    }
}
