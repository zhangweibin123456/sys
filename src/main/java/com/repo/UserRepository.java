package com.repo;

import com.bean.UserPO;
import com.commons.BaseRepository;

public interface UserRepository extends BaseRepository<UserPO, Long> {

	public UserPO findByUserNameAndPassWord(String userName, String passWord);

}
