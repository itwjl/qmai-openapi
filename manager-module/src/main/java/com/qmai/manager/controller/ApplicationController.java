package com.qmai.manager.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 类描述:
 *
 * @author Wang Jinglei
 * @date 2023/6/7 17:32
 * @modifier Wang Jinglei
 * @date 2023/6/7 17:32
 * @Version V1.0
 */
@RestController
@RequestMapping("/manager/openapi")
@Api(value = "manager后台管理", tags = "manage 后台交互接口")
public class ApplicationController {

    @ApiOperation(value = "应用信息", notes = "应用信息")
    @RequestMapping("info")
    public String applicationInfomation(String param) {
        return "";
    }

}
