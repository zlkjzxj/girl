package com.walle.girl.service;

import com.walle.girl.entity.Girl;
import com.walle.girl.enums.ResultEnum;
import com.walle.girl.exception.MyException;
import com.walle.girl.mapper.GirlMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class GirlService {
    @Autowired
    private GirlMapper girlMapper;

    public Girl getGirlById(int id){
        Girl girl = girlMapper.findGirl(id);
        return girl;
    }

    /**
     * 测试失误,同事插入两个女孩。
     */
    @Transactional
    public void insertTwo(){
        Girl girlA = new Girl();
        girlA.setName("cassie");
        girlA.setCupSize("G");
        girlA.setAge(25);
        girlMapper.insertAGirl(girlA);

        Girl girlB = new Girl();
        girlB.setName("judy");
        girlB.setCupSize("D");
        girlB.setAge(28);
        girlMapper.insertAGirl(girlB);
    }

    public void getAge(int id) throws Exception {
        Girl girl = girlMapper.findGirl(id);
        if (girl != null){

            int age = girl.getAge();
            if(age<10){
                throw new MyException(ResultEnum.PRIMARY_SCHOOL);
            }else if(age >10 && age<16 ){
                throw new MyException(ResultEnum.MIDDLE_SCHOOL);
            }else{
                throw new MyException(ResultEnum.SUCCESS);
            }
        }else {
            throw new MyException(ResultEnum.NO_BODY);
        }
    }
}
