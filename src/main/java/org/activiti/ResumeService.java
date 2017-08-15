package org.activiti;

import org.springframework.stereotype.Component;

@Component
public class ResumeService {

    public void storeResume() throws Exception {
        System.out.println("Storing resume ...");
        //throw new Exception(); 模拟错误信息。
    }

}
