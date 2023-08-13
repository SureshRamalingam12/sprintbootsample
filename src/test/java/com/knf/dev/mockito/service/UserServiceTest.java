package com.knf.dev.mockito.service;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.context.junit4.SpringRunner;

import com.knf.dev.mockito.entity.User;
import com.knf.dev.mockito.repository.UserRepository;

import static org.mockito.Mockito.*;


@RunWith(SpringRunner.class)
public class UserServiceTest {

	@InjectMocks
	private UserService userService;

	@Mock
	private UserRepository userRepository;

	@Before
	public void setUp() {

		User user = new User();
		user.setName("Rajalakshmi");
		user.setId(1);
		User user1 = new User();
		user1.setName("Raji");
		user1.setId(2);



		List<User> users = new ArrayList<User>();
		users.add(user1);
		users.add(user);

		Mockito.when(userRepository.findAll()).thenReturn(users);
	}


	@Test
	public void saveUser() {

		User user = new User();
		user.setId(2);
		user.setName("Nandhini");
		userService.saveUser(user);
		verify(userRepository, times(1)).save(user);
	}

	@Test
	public void getAllUsers() {

		List<User> users = userService.getAllUsers();
		Assert.assertEquals(users.size(), 2);

	}

	@Test
	public void updating() {
		User user2 = new User();
		user2.setName("vimal");
		user2.setId(3);
		when(userRepository.save(user2)).thenReturn(user2);
		//Assert.assertEquals(2, userRepository.save(user2));

	}
}

