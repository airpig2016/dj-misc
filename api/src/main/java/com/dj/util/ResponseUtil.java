package com.dj.util;

//import com.alibaba.fastjson.JSON;
import com.dj.config.Constant;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;

/**
 * Created by dajiechen on 2017/8/3.
 */
public class ResponseUtil {

    /**
     * 请求返回数据处理
     * @param res
     * @return
     */
    public static CommonResponse general(CommonResponse res){
//        return new ResponseEntity<String>(JSON.toJSONString(res), HttpStatus.OK);
//        return res.toString();
        return res;
    }

    /**
     * 成功请求
     * @param data
     * @return
     */
    public static CommonResponse success(Object data){
        CommonResponse res = new CommonResponse();
        res.setCode(Constant.RESCODE_SUCCESS);
        res.setData(data);

        return general(res);
    }

    public static CommonResponse success(){
        CommonResponse res = new CommonResponse();
        res.setCode(Constant.RESCODE_SUCCESS);
        return general(res);
    }

    public static CommonResponse success(String msg){
        CommonResponse res = new CommonResponse();
        res.setCode(Constant.RESCODE_SUCCESS_MSG);
        res.setMsg(msg);
        return general(res);
    }

    /**
     * 请求抛出异常
     * @param msg
     * @return
     */
    public static CommonResponse exception(String msg){
        CommonResponse res = new CommonResponse();
        res.setCode(Constant.RESCODE_EXCEPTION);
        res.setMsg(msg);
        return general(res);
    }

    public static CommonResponse unKonwException(){
        CommonResponse res = new CommonResponse();
        res.setCode(Constant.RESCODE_EXCEPTION);
        res.setMsg("请稍后再试");
        return general(res);
    }

    /**
     * 自定义
     * @param code
     * @param msg
     * @return
     */
    public static CommonResponse custom(Integer code, String msg){
        CommonResponse res = new CommonResponse();
        res.setCode(code);
        res.setMsg(msg);
        return general(res);
    }
}
