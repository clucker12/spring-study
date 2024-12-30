package com.care.di_test;

import org.springframework.context.support.GenericXmlApplicationContext;  // Spring의 XML 기반 ApplicationContext를 사용하기 위한 import

public class MainClass {
    public static void main(String[] args) {
        // XML 파일의 경로를 지정합니다. classpath:는 클래스패스를 기준으로 파일을 찾겠다는 의미입니다.
        String path = "classpath:application_test.xml";
        
        // GenericXmlApplicationContext는 XML 설정 파일을 읽어들여 Bean을 관리하는 Spring 컨테이너를 생성합니다.
        // 이 컨테이너는 XML 파일을 통해 Bean을 정의하고 관리합니다.
        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext(path);
        
        // getBean 메소드를 사용하여 XML 파일에 정의된 id가 "pr"인 Bean을 가져옵니다.
        // 첫 번째 인자("pr"): 이 값은 Spring 컨테이너 내에서 id가 pr인 Bean을 찾겠다는 의미입니다.
        //두 번째 인자 (PrintBean.class): getBean은 반환되는 객체의 타입을 PrintBean으로 지정해주고 있습니다. 이 타입은 Class<PrintBean> 객체를 의미합니다.
        // ctx.getBean("pr", PrintBean.class)는 "pr"라는 id를 가진 Bean을 PrintBean 타입으로 가져오는 코드입니다.
        PrintBean pr = ctx.getBean("pr", PrintBean.class);  // XML 파일에서 "pr"라는 id로 정의된 Bean을 가져옵니다.
        
        // 가져온 pr 객체의 prinString 메소드를 호출하여 콘솔에 출력합니다.
        pr.prinString();  // pr Bean의 prinString() 메소드를 호출하여 출력.
    }
}
