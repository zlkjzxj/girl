package com.walle.girl.controller;

import com.walle.girl.entity.Girl;
import com.walle.girl.mapper.GirlMapper;
import com.walle.girl.service.GirlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.List;

@RestController
public class GirlAction2 {

    @Resource
    private GirlService girlService;

    @Autowired
    private GirlMapper girlMapper;

    /**
     *  查询女生列表
     * @return
     */
    @GetMapping("/getGirls2")
    public List<Girl> getAGirlList() {
        return girlMapper.getGirlList();
    }
    /**
     *  保存一个女生
     * @return
     */
    @PostMapping("insertAGirl2")
    public void insertAGirl(@Valid Girl girl, BindingResult bindingResult){//表单验证
        if(bindingResult.hasErrors()){
            System.out.println(bindingResult.getFieldError().getDefaultMessage());
        }else{
            girlMapper.insertAGirl(girl);
        }
    }
    /**
     *  查询一个女生
     * @return
     */
    @GetMapping("/getAGirl2/{id}")
    public Girl getAGirl(@PathVariable("id") int id) {
        return girlService.getGirlById(id);
    }
    /**
     *  更新一个女生
     * @return
     */
    @PutMapping("/updateAGirl2/{id}")
    public void updateAGirl(@PathVariable("id") int id,@RequestParam("name") String name, @RequestParam("cupSize") String cupSize,@RequestParam("age") int age) {
        Girl girl = new Girl();
        girl.setId(id);
        girl.setName(name);
        girl.setCupSize(cupSize);
        girl.setAge(age);
        girlMapper.updateAGirl(girl);
    }
    /**
     *  查询一个女生
     * @return
     */
    @DeleteMapping("/deleteAGirl2/{id}")
    public void deleteAGirl(@PathVariable("id") int id) {
        girlMapper.deleteAGirl(id);
    }
    /**
     *  插入两个女孩，测试shiwu
     * @return
     */
    @PostMapping("/insertTwo2")
    public void deleteAGirl() {
        girlService.insertTwo();
    }
}
