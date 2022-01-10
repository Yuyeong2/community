package com.koreait.community.user;

import com.koreait.community.UserUtils;
import com.koreait.community.model.UserEntity;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpSession;

@Service
public class UserService {

    @Autowired
    private UserMapper mapper;

    @Autowired
    private UserUtils userUtils;

    public int login(UserEntity entity) { //uid, upw
        UserEntity dbUser = null;
        try {
            dbUser = mapper.selUser(entity);
        } catch (Exception e) {
            e.printStackTrace();
            return 0; //알 수 없는 에러
        }

        if(dbUser == null) {
            return 2; //아이디 없음
        } else if(!BCrypt.checkpw(entity.getUpw(), dbUser.getUpw())) {
            return 3; //비번 틀림
        }
        dbUser.setUpw(null);
        dbUser.setRdt(null);
        dbUser.setMdt(null);
        userUtils.setLoginUser(dbUser);
        return 1; //로그인 성공!
    }

    public int join(UserEntity entity) {
        UserEntity copyEntity = new UserEntity();
        BeanUtils.copyProperties(entity, copyEntity);

        String hashPw = BCrypt.hashpw(entity.getUpw(), BCrypt.gensalt());
        copyEntity.setUpw(hashPw);
        return mapper.insUser(copyEntity);
    }

    public int idChk(String uid) {
        UserEntity entity = new UserEntity();
        entity.setUid(uid);

        UserEntity result = mapper.selUser(entity);

        return result == null ? 1 : 0;
    }

}
