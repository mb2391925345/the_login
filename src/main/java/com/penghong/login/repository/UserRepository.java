package com.penghong.login.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import com.penghong.login.entities.User;




public interface UserRepository extends JpaRepository<User, Integer> {
	
	/**
	 * 根据用户名查询
	 * @param loginName
	 * @return
	 */
    @Query("select u FROM User u where u.loginName=:loginName")
	 User findByLoginName(@Param("loginName") String loginName) ;
   
    
	
	

}
