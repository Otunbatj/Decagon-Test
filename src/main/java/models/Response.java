package models;

public class Response {
    private String respCode;
    private String respDesc;
    private Object respBody;

    public Response() {
    }

    public Response(String respCode, String respDesc, Object respBody) {
        this.respCode = respCode;
        this.respDesc = respDesc;
        this.respBody = respBody;
    }

    public String getRespCode() {
        return respCode;
    }

    public void setRespCode(String respCode) {
        this.respCode = respCode;
    }

    public String getRespDesc() {
        return respDesc;
    }

    public void setRespDesc(String respDesc) {
        this.respDesc = respDesc;
    }

    public Object getRespBody() {
        return respBody;
    }

    public void setRespBody(Object respBody) {
        this.respBody = respBody;
    }

    @Override
    public String toString() {
        return "Response{" +
                "respCode='" + respCode + '\'' +
                ", respDesc='" + respDesc + '\'' +
                ", respBody=" + respBody +
                '}';
    }
}
