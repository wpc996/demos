package client;

import redis.clients.jedis.Jedis;

/**
 * @author wangpeican
 * @date 2022/8/6 23:32
 */
public class Test {
    public static void main(String[] args) {
        new Test().testJedis();
    }
    public void testJedis() {
        //创建一个Jedis的连接
        Jedis jedis = new Jedis("192.168.74.111", 6379);
        jedis.auth("123");
        //执行redis命令
        jedis.set("mytest", "dajiayu");
        //从redis中取值
        String result = jedis.get("mytest");
        //打印结果
        System.out.println(result);
        //关闭连接
        jedis.close();
    }
}
