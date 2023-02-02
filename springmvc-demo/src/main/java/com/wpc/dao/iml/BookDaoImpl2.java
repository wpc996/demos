package com.wpc.dao.iml;

import com.wpc.dao.BookDao;
import org.springframework.stereotype.Repository;

/**
 * @author wangpeican
 * @date 2023/1/11 20:20
 */
@Repository
public class BookDaoImpl2 implements BookDao {

    public void save() {
//        System.out.println(System.currentTimeMillis());
        System.out.println("book2 dao save ...");
    }

    public void update(){
        System.out.println("book2 dao update ...");
    }
}