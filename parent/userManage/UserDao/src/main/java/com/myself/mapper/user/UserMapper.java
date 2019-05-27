package com.myself.mapper.user;

import com.myself.MyMapper;
import com.myself.user.vo.domain.UserInfo;

public interface UserMapper extends MyMapper<UserInfo>{
	int Myinsert(UserInfo userInfo);
}
