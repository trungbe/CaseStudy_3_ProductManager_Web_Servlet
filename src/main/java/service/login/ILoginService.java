package service.login;

import model.User;
import service.IGeneralService;

public interface ILoginService extends IGeneralService<User> {
    User login(String user, String pass);
}
