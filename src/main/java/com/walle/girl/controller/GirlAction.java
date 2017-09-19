package com.walle.girl.controller;

import com.walle.girl.entity.Girl;
import com.walle.girl.mapper.GirlMapper;
import com.walle.girl.service.GirlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
public class GirlAction {

    @Resource
    private GirlService girlService;

    @Autowired
    private GirlMapper girlMapper;

    /**
     *  查询女生列表
     * @return
     */
    @GetMapping("/getGirls")
    public List<Girl> getAGirlList() {
        return girlMapper.getGirlList();
    }
    /**
     *  保存一个女生
     * @return
     */
    @PostMapping("insertAGirl")
    public void insertAGirl(@RequestParam("name") String name, @RequestParam("cupSize") String cupSize,@RequestParam("age") int age){
        Girl girl = new Girl();
        girl.setName(name);
        girl.setCupSize(cupSize);
        girl.setAge(age);
        girlMapper.insertAGirl(girl);
    }
    /**
     *  查询一个女生
     * @return
     */
    @GetMapping("/getAGirl/{id}")
    public Girl getAGirl(@PathVariable("id") int id) {
        return girlService.getGirlById(id);
    }
    /**
     *  更新一个女生
     * @return
     */
    @PutMapping("/updateAGirl/{id}")
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
    @DeleteMapping("/deleteAGirl/{id}")
    public void deleteAGirl(@PathVariable("id") int id) {
        girlMapper.deleteAGirl(id);
    }
    /**
     *  插入两个女孩，测试shiwu
     * @return
     */
    @PostMapping("/insertTwo")
    public void deleteAGirl() {
        girlService.insertTwo();
    }
}
