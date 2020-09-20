package com.demo.zookeeper.curator;

import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.recipes.cache.NodeCache;
import org.apache.curator.framework.recipes.cache.NodeCacheListener;

/**
 * Curator 的使用
 */
public class TestCurator {
    public static void main(String[] args) {
        CuratorFramework client = null;
        //通过上一步获取到的client,直接启动该client,值得注意的是client在使用前必须先启动:

        try {
            client = ZkClientUtil.build();
            client.start();
/*            client
                    .create()//创建节点
                    .withMode(CreateMode.PERSISTENT)//节点属性:永久节点/临时节点/有序节点 通过CreateMode.即可看到
                    .withACL(ZooDefs.Ids.OPEN_ACL_UNSAFE)//节点访问权限,通过Ids.即可看到 默认是OPEN_ACL_UNSAFE(开放不安全权限)
                    .forPath("/yourpath", "yourdata".getBytes());//指明你的节点路径,数据可以不指定,数据必须是byte[]*/

             //比如我想一次性创建/yourpath/a/b/c/1/2/3...这样的节点,如果按传统方法会累死你
            //curator可以一次性创建好,只需要在创建时添加creatingParentsIfNeeded即可.
/*            client
                    .create()//创建节点
                    .creatingParentsIfNeeded()//创建父节点,如果需要的话
                     .forPath("/yourpath/a/b/c/1/2/3");*/

/*            client
                    .delete() //删除
                    .guaranteed()//保证一定帮你删了它
                    .withVersion(-1)//指定要删节点的版本号
                    .forPath("/yourpath");//指定要删节点的路径  */

                //比如我当前的节点结构是这样:/yourpath/a/b/c/1/2/3  我想删除a节点下面的所有目录
                //传统方法累死个人,现在只需要添加deletingChildrenIfNeeded即可
/*            client
                    .delete() //删除
                    .deletingChildrenIfNeeded()//如果它有儿子都给删了...
                    .forPath("/yourpath");*/

            //为了保证安全,有时需要对节点的访问权限做一些限制,否则可能会引起重要信息泄露/篡改/删除等
           //节点ACL的创建方式有两种,一种是使用ZK提供的,一种是自定义的
           //1.ZK提供的,比较简单,拿来即用,在创建节点时指明withACL即可
/*            client
                    .create()
                    .withACL(ZooDefs.Ids.READ_ACL_UNSAFE)//指明该节点是只读节点,还有其他属性,可以通过Ids.查看*/

            //创建自定义ACL,需要自己new Id(),并指明是否是加密的,然后账号和密码是多少,加密策略使用zk提供的:
/*            List<ACL> aclList = new ArrayList<ACL>();
            ACL acl1 = new ACL(ZooDefs.Perms.READ,new Id("digest", DigestAuthenticationProvider.generateDigest("user:123456")));
            ACL acl2 = new ACL(ZooDefs.Perms.ALL,new Id("digest",DigestAuthenticationProvider.generateDigest("root:123456")));
            aclList.add(acl1);
            aclList.add(acl2);*/
            //如此我就创建好了两种不同的权限账号,user只能对该节点有读的权限,但root用户对该节点有所有权限
            //为了保证安全,有时需要对节点的访问权限做一些限制,否则可能会引起重要信息泄露/篡改/删除等
            //节点ACL的创建方式有两种,一种是使用ZK提供的,一种是自定义的
            //2.ZK提供的,比较简单,拿来即用,在创建节点时指明withACL即可
/*            client
                    .create()
                    .withACL(aclList)//指明该节点是只读节点,还有其他属性,可以通过Ids.查看
                    .forPath("/yourpath2", "yourdata2".getBytes());*/




            //ACL验证,创建好节点之后,可以在服务器的zk安装目录的bin目录下 连接客户端./zkCli
            //然后通过ls /该目录  查看是否可以访问 正常是不能访问的 会提示权限不够
            //下面我们通过curator去连接,要想访问该节点需要在创建client时就指明账号和密码:
/*            CuratorFramework client1 = CuratorFrameworkFactory
                    .builder()
                    .authorization("digest","root:123456".getBytes()).build();//指明使用了加密,用户名和密码用:隔开,以byte[]输入
            //如此,接下来通过该client可以对刚刚创建的节点具有所有权限,如果登录的是user,则只具有读权限.
            client1.setData().forPath("/yourpath2", "yourdata-authorization".getBytes());*/

/*            RetryPolicy retryPolicy = new ExponentialBackoffRetry(ZkClientUtil.BASE_SLEEP_TIME_MS,ZkClientUtil.MAX_RETRIES);//重试策略
            client = CuratorFrameworkFactory
                    .builder()
                    .authorization("digest","root:123456".getBytes())
                    .connectString(ZkClientUtil.ZK_URI)
                    .retryPolicy(retryPolicy)
                    .namespace(ZkClientUtil.NAMESPACE)
                    .sessionTimeoutMs(ZkClientUtil.SESSION_TIME_OUT)
                    .build();
            client.start();*/

            //client.setData().withVersion(-1).forPath("/yourpath2","yourdata33".getBytes());
/*            byte[] bytes = client.getData().forPath("/yourpath2");
            System.out.println("##########"+new String(bytes));*/


            //client.create().forPath("/yourpath22", "yourdata".getBytes());
            //对单个节点创建watch事件
            //定义NodeCache,指明被监听节点的路径:
            //final NodeCache nodeCache = new NodeCache(client,"/yourpath");
           // nodeCache.start(true);// 如果为true则首次不会缓存节点内容到cache中，默认为false,设置为true首次不会触发监听事件
/*            nodeCache
                    .getCurrentData()//可以获取该监听节点的数据
                    .getPath();//可以获取该监听节点的路径*/
            //client.create().forPath("/yourpath", "yourdata".getBytes());
            NodeCache nodeCache = new NodeCache(client,"/yourpath");
           nodeCache.start(true); // 如果为true则首次不会缓存节点内容到cache中，默认为false,设置为true首次不会触发监听事件
            nodeCache.getListenable().addListener(new NodeCacheListener(){

                @Override
                public void nodeChanged() throws Exception {
                    // 节点发生变化，回调方法
                    byte[] ret = nodeCache.getCurrentData().getData();
                    // getData()方法实现返回byte[]
                    System.out.println("####数据发生变化: " + new String(ret));
                }

            });
            client.delete().forPath("/yourpath");
            //client1.close();

            //client.delete().forPath("/yourpath22");
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            client.close();

        }

    }
}
