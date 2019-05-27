package com.myself.mapper.daily;

import com.myself.MyMapper;
import com.myself.daily.vo.domain.UserInfo;

public interface UserMapper extends MyMapper<UserInfo>{
	int Myinsert(UserInfo userInfo);
}
