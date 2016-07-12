package com.penghong.login.service;



import java.util.HashMap;
import java.util.Map;

import javax.transaction.Transactional;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.domain.Sort.Order;
import org.springframework.stereotype.Service;
import com.penghong.login.entities.User;
import com.penghong.login.repository.UserRepository;





@Service
@Transactional
public class UserService {
	@Autowired
	private UserRepository userRepository;

	/**
	 * 登录检查
	 */
	public Map<String,Object> loginCheck(String loginName,String password) {
		Map<String,Object> loginMap = new HashMap<>();
		User user=null;
		String trimLoginName = loginName.trim();
		String trimPassWord = password.trim();
		if(loginName!=null&&trimLoginName!=""){
			user = userRepository.findByLoginName(trimLoginName);
		}
		String md5PassWord = DigestUtils.md5Hex(trimPassWord);
		if(password!=null&&trimPassWord!=""&&user!=null&&md5PassWord.equals(user.getPassword())){
			loginMap.put("check", true);
			loginMap.put("user", user);
			return loginMap;
		}
		loginMap.put("check", false);
		return loginMap;
		
	}
	/**
	 * 保存
	 * @param user
	 */
	public void save(User user){
		userRepository.save(user);
	}
	
	/**
	 * 页面列表 
	 * @param pageNo
	 * @return
	 */
	public Page<User> pageList(Integer pageNo){
		Sort sort = new Sort(new Order(Direction.ASC, "id"));
		PageRequest pageRequest = new PageRequest(pageNo, 3,sort);
		return userRepository.findAll(pageRequest);
	}
	
	//public List<User> findAll(){
	//	return userRepository.findAll();
	//}
	
	public void delete(Integer id) {
		userRepository.delete(id);
		
	}
	public void update(Integer id) {
		User user = userRepository.findOne(id);
		userRepository.save(user);
		
	}
	public Object findById(Integer id) {
		return userRepository.findOne(id);
	}

}
