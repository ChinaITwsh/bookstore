package hlju.edu.user;

import hlju.edu.domain.User;
import hlju.edu.utils.BookStoreUtils;
import hlju.edu.utils.PasswordUtils;

public class UserService {
	private UserDao dao = new UserDao();
	public void save(User user) {
		user.setId(BookStoreUtils.uuid());
		user.setPwd(PasswordUtils.encodePassword(user.getName(), user.getPwd()));
		dao.save(user);
	}
	/*
	 * 对密码进行计算
	 * */
	public User login(User user) {
		user.setPwd(PasswordUtils.encodePassword(user.getName(), user.getPwd()));
		return dao.login(user);
	}

}
