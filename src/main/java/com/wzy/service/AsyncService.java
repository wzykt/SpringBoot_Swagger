package com.wzy.service;

import org.springframework.stereotype.Service;

/*
模拟异步任务
 */
@Service
public class AsyncService {

    public void async(){
        try {
            //模拟一个长时间的需求
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("数据正在加载");
    }
}
