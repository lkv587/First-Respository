package com.example.awesome.controller;

import com.example.awesome.pojo.base.ErrorCodeEnum;
import com.example.awesome.pojo.base.R;
import com.example.awesome.pojo.dto.UserDTO;
import com.example.awesome.service.UserService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * Created by likang on 2019/3/9.
 */
@RestController("user")
public class UserController {

    private static final Logger log = LoggerFactory.getLogger(UserController.class);


    @Resource
    private UserService userService;

    /**
     * 根据ID查询用户
     * @param id
     * @return
     */
    @ApiOperation(value="获取用户详细信息", notes="根据id来获取用户详细信息")
    @ApiImplicitParam(name = "id", value = "用户ID", required = true, dataType = "Integer", paramType = "path")
    @GetMapping(value = "/getUserById",produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public R<UserDTO> getUserById (@PathVariable(value = "id") Integer id){
        log.info("enter getUserId method,id:{}",id);
        UserDTO user = userService.getUserById(id);
        return new R<UserDTO>().Ok(user);
    }

    /**
     * @Description: 添加用户信息
     * @Param:
     * @return:
     * @Author: lkV587
     * @Date: 2020/8/20 10:12
     */
    @PostMapping(value = "/addUser", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public R<UserDTO> addUser(@RequestBody UserDTO user){
        log.info("enter addUser method,user:{}",user);
        R<UserDTO> r = null;
        try {
//             r=userService.addUser(user);
        }catch (Exception e){
            r = new R<UserDTO>().Failed(ErrorCodeEnum.INTERNAL_SERVER_ERROR);
        }
        log.debug("exit addUser method,r:{}",r);
        return r;
    }

}
