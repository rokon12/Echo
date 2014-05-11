package edu.univdhaka.iit.echo.repository;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import edu.univdhaka.iit.echo.domain.Echo;
import edu.univdhaka.iit.echo.domain.UserAccount;

public class EchoFactory {
	
    private static List<UserAccount> userList;
    private static List<Echo> echoList;

    private static int echoId = 0;
    private static int userId = 0;

    static {
        userList = new CopyOnWriteArrayList<UserAccount>();
        echoList = new CopyOnWriteArrayList<Echo>();
    }

    public static int getGeneratedTweetId() {
        return echoId = echoId + 1;
    }

    public static int getGeneratedUserId() {
        return userId = userId + 1;
    }

    public static List<UserAccount> getUserList() {
        return userList;
    }

    public static List<Echo> getEchoList() {
        return echoList;
    }
}
