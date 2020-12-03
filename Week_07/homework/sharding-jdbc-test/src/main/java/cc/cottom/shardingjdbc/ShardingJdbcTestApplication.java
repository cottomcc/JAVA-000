package cc.cottom.shardingjdbc;

import cc.cottom.shardingjdbc.entities.User;
import cc.cottom.shardingjdbc.mapper.UserMapper;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ShardingJdbcTestApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(ShardingJdbcTestApplication.class, args);
	}

	private UserMapper userMapper;

	public ShardingJdbcTestApplication(UserMapper userMapper) {
		this.userMapper = userMapper;
	}

	@Override
	public void run(String... args) throws Exception {

		User newUser = new User();
		String id = String.valueOf(Math.random());
		newUser.setId(id);
		newUser.setNickname(String.format("编号 %s", Math.random()));
		newUser.setRealname(String.format("真名 %s", Math.random()));
		newUser.setUsername(String.format("username %s", Math.random()));
		newUser.setPassword(String.format("pwd %s", Math.random()));

		newUser.setFace("http://gogle.com/png");
		this.userMapper.insertUser(newUser);

		Thread.sleep(2000);

		User user = userMapper.findUserById(id);
		if (null != user) {
			System.out.println(String.format("username: %s", user.getUsername()));
		}


	}
}
