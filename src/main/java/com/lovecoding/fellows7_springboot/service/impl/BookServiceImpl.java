package com.lovecoding.fellows7_springboot.service.impl;


import com.lovecoding.fellows7_springboot.pojo.Book;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class BookServiceImpl {

    /**
     * @RabbitListener : 监听，需要设定监听队列
     * @param book
     */
    @RabbitListener(queues = "sifu.news")
    public void getBook(Book book){
        System.out.println("收到一条消息：" + book);
    }
}
