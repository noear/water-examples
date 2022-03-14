package demo.controller;

public class ApiCodes {
    /**
     * 失败，未知错误
     */
    public static final ApiCode CODE_0 = new ApiCode(0);
    /**
     * 成功
     */
    public static final ApiCode CODE_1 = new ApiCode(1);

    /**
     * 请求的接口不存在或不再支持
     */
    public static final ApiCode CODE_11 = new ApiCode(11);
    /**
     * 请求的签名校验失败
     */
    public static final ApiCode CODE_12 = new ApiCode(12);

    /**
     * 请求的参数缺少或有错误
     */
    public static final ApiCode CODE_13(String names) {
        return new ApiCode(13, names);
    }

    /**
     * 请求的不符合规范
     */
    public static final ApiCode CODE_14 = new ApiCode(14);

    /**
     * 请求太频繁了
     */
    public static final ApiCode CODE_15 = new ApiCode(15);

    /**
     * 请求不在白名单
     */
    public static final ApiCode CODE_16(String ip) {
        return new ApiCode(16, ip);
    }

    public static final String getDescription(ApiCode error) {
        switch (error.getCode()) {
            case 1:
                return "Succeed";
            case 11:
                return "The api not exist";
            case 12:
                return "The signature error";
            case 13:
                return "Parameter missing or error" + (error.getDescription() == null ? "" : "(" + error.getDescription() + ")");
            case 14:
                return "The request is not up to par";
            case 15:
                return "Too many requests";
            case 16:
                return "The request is not in the whitelist" + (error.getDescription() == null ? "" : "(" + error.getDescription() + ")");
            default:
                return "Unknown error!";
        }
    }
}
