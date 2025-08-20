package hello.core.lifecycle;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

public class NetworkClient   {

    private String url;

    public  NetworkClient() {
        System.out.println("생성자 호출, url="+url);
    }

    public void setUrl(String url) {
        this.url = url;
    }

    // 서비스 시작 호출
    public void connect() {
        System.out.println("connect:" +url );
    }

    public void call(String message) {
        System.out.println("call" + url + "message = " + message);

    }

    // 서비스 종료시 호출
    public void disConnect(){
        System.out.println("close: " + url);

    }
    public void init() {
        System.out.println("NetworkClient.init");
        connect();
    }
    public  void close() {
        System.out.println("NetworkClient.close");
        disConnect();
    }
//    // 의존관계 주입 후, 초기화 콜백
//    @Override
//    public void afterPropertiesSet() throws Exception {
//        System.out.println("NetworkClient.afterPropertiesSet");
//        connect();
//        call("초기화 연결 메시지");
//    }
//
//    @Override
//    public void destroy() throws Exception {
//        System.out.println("NetworkClient.destroy");
//        disConnect();
//    }
}
