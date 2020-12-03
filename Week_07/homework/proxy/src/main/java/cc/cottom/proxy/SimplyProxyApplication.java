package cc.cottom.proxy;

import cc.cottom.proxy.entities.User;
import cc.cottom.proxy.mapper.UserMapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import java.util.List;

@SpringBootApplication
@EnableAspectJAutoProxy
public class SimplyProxyApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(SimplyProxyApplication.class, args);
	}

	private final UserMapper userMapper;

	public SimplyProxyApplication(UserMapper userMapper) {
		this.userMapper = userMapper;
	}

	@SuppressWarnings("squid:S106")
	public void run(String... args) {
		testWrite();
	}

	public void testRead() {
		List<User> users = userMapper.queryUsersByName("真名");
		users.stream().forEach(user -> {
			System.out.println(String.format("id: %s, username: %s, nickname: %s, realname: %s", user.getId(), user.getUsername(), user.getNickname(), user.getRealname()));
		});
	};

	public void testWrite() {
		User newUser = new User();
		newUser.setId(String.valueOf(Math.random()));
		newUser.setNickname(String.format("编号 %s", Math.random()));
		newUser.setRealname(String.format("真名 %s", Math.random()));
		newUser.setUsername(String.format("username %s", Math.random()));
		newUser.setPassword(String.format("pwd %s", Math.random()));

		newUser.setFace("http://gogle.com/png");
		this.userMapper.insertUser(newUser);
	};



}
