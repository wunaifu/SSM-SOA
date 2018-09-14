package com.taotao.fastdfs;

import com.taotao.util.FastDFSClient;
import org.csource.fastdfs.*;
import org.junit.Test;

public class TestFastDFS {

	@Test
	public void uploadFile() throws Exception {
		//1、向工程中添加jar包
		//2、创建一个配置文件。配置tracker服务器地址
		//3、加载配置文件
		ClientGlobal.init("resource/client.conf");
		//4、创建一个TrackerClient对象。
		TrackerClient trackerClient = new TrackerClient();
		//5、使用TrackerClient对象获得trackerserver对象。
		TrackerServer trackerServer = trackerClient.getConnection();
		//6、创建一个StorageServer的引用null就可以。
		StorageServer storageServer = null;
		//7、创建一个StorageClient对象。trackerserver、StorageServer两个参数。
		StorageClient storageClient = new StorageClient(trackerServer, storageServer);
		//8、使用StorageClient对象上传文件。
		String[] strings = storageClient.upload_file("D:/IdeaCode/二维码4820290.png", "png", null);
		for (String string : strings) {
			System.out.println(string);
			
		}
	}
	
	@Test
	public void testFastDfsClient() throws Exception {
		FastDFSClient fastDFSClient = new FastDFSClient("D:/workspaces-itcast/JavaEE28/taotao-manager-web/src/main/resources/resource/client.conf");
		String string = fastDFSClient.uploadFile("D:/Documents/Pictures/images/2010091809520375_S.jpg");
		System.out.println(string);
	}
}
