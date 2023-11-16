package services;

import java.util.*;
//import es.deusto.ingenieria.sd.auctions.server.data.domain.User;

//TODO: Implement Singleton Pattern
public class LoginAppService {
	private static Map<String, User> userMap = new HashMap<>();
		
	public boolean regist(User user) {
		if(userMap.containsKey(user.getEmail())) {
			return false;
		} 
		userMap.put(user.getEmail(), user);
		return true;
	}
	
	public User login(String email, String password) {
		//TODO: Get User using DAO and check 		
		if(userMap.containsKey(email)) {
			if(userMap.get(email).checkPassword(password)) {
				return userMap.get(email);
			} 
		}
		return null;
	}
	
	public static Map<String, User> getUserMap() {
		return userMap;
	}
}