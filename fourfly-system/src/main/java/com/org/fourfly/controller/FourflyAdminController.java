package com.org.fourfly.controller;

import com.org.fourfly.exception.InvalidArgumentException;
import com.org.fourfly.mapper.FourflyAdminMapper;
import com.org.fourfly.model.FourflyAdmin;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Author Jian
 * @Date 2021/2/16 17:42:39
 * @Description 用户管理控制器
 * @Version 1.0
 **/
@RestController
@RequestMapping(value = "system")
@Api(value = "Fourfly-Admin-Controller", tags = "后台-用户管理控制器")
public class FourflyAdminController {

    @Resource
    private FourflyAdminMapper fourflyAdminMapper;
    
    /**
     *@Description insert
     *@Param [fourflyAdmin]
     *@Return com.org.fourfly.model.FourflyAdmin
     *@date 2021/2/16 18:00:07
     **/
    @RequestMapping(value = "{id}/insert", method = RequestMethod.POST)
    @ApiOperation(value = "添加用户")
    public FourflyAdmin insert(
            @ApiParam(value = "用户对象") @RequestBody FourflyAdmin fourflyAdmin
    ){
        if  (null == fourflyAdmin){
            throw new InvalidArgumentException("参数错误！");
        }
        fourflyAdminMapper.insertSelective(fourflyAdmin);
        return fourflyAdmin;
    }
    
    /**
     *@Description delete
     *@Param [fourflyAdmin]
     *@Return com.org.fourfly.model.FourflyAdmin
     *@date 2021/2/16 18:00:14
     **/
    @RequestMapping(value = "{id}/delete", method = RequestMethod.DELETE)
    @ApiOperation(value = "删除用户")
    public FourflyAdmin delete(
            @ApiParam(value = "用户id") @RequestBody Integer id
    ){
//        fourflyAdminMapper.deleteByPrimaryKey();
        return null;
    }
    
    /**
     *@Description update
     *@Param [fourflyAdmin]
     *@Return com.org.fourfly.model.FourflyAdmin
     *@date 2021/2/16 18:00:20
     **/
    @RequestMapping(value = "{id}/update", method = RequestMethod.PUT)
    @ApiOperation(value = "修改用户")
    public FourflyAdmin update(
            @ApiParam(value = "用户对象") @RequestBody FourflyAdmin fourflyAdmin
    ){
        return null;
    }
    
   /**
    *@Description select
    *@Param [fourflyAdmin]
    *@Return com.org.fourfly.model.FourflyAdmin
    *@date 2021/2/23 18:05:43
    **/
    @RequestMapping(value = "{id}/select", method = RequestMethod.GET)
    @ApiOperation(value = "查询用户")
    public FourflyAdmin select(
            @ApiParam(value = "用户对象") @RequestBody FourflyAdmin fourflyAdmin
    ){
        return null;
    }
}
