package com.qmai.openapi.controller.baking;

import com.alibaba.fastjson.JSONObject;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * 类描述:
 *
 * @author Wang Jinglei
 * @date 2023/6/7 17:26
 * @modifier Wang Jinglei
 * @date 2023/6/7 17:26
 * @Version V1.0
 */
@RestController
@Api(value = "开放平台-烘焙接口", tags = "4. 烘焙接口")
public class BakingController {

    @PostMapping("usableCouponList")
    @ApiOperation(value = "1.1 获取用户可用的优惠券列表", notes = "7.4.11 可用的优惠券列表(烘焙)")
    public JSONObject usableCouponList(@Validated @RequestBody JSONObject param, HttpServletRequest request) {

        return new JSONObject();
    }
}
