package demo.controller;

import org.noear.solon.validation.annotation.Valid;

/**
 * 假设协议返回结构为：{code:1, msg:"", data:{}}，则：
 * 所有接口实现处理三种情况即可：
 * 1.无反回
 * 2.返回 data 部份
 * 3.抛出 ApiCode 或者 其它异常
 *
 * @author noear 2021/1/13 created
 */
@Valid
public class ApiBase {
}
