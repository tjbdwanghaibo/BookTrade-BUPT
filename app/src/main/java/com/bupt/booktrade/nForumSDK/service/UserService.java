/*
 * Copyright (C) 2010-2014 dss886
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.bupt.booktrade.nForumSDK.service;

import com.bupt.booktrade.nForumSDK.http.GetMethod;
import com.bupt.booktrade.nForumSDK.http.NForumException;
import com.bupt.booktrade.nForumSDK.model.User;

import java.io.IOException;

import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONException;

/**
 * 该类封装了用户接口，
 * 见https://github.com/xw2423/nForum/wiki/nForum-API
 * @author dss886
 * @since 2014-9-7
 */
public class UserService {

	private DefaultHttpClient httpClient;
	private String host;
	private String returnFormat;
	private String appkey;
	private String auth; 
	
	public UserService(DefaultHttpClient httpClient, String host,
			String returnFormat, String appkey, String auth){
		this.httpClient = httpClient;
		this.host = host;
		this.returnFormat = returnFormat;
		this.appkey = appkey;
		this.auth = auth;
	}
	
	/**
	 * 获取指定用户的信息
	 * @param id 合法的用户id
	 * @throws java.io.IOException
	 * @throws NForumException 
	 * @throws org.json.JSONException
	 * */
	public User queryById(String id) throws JSONException,
            NForumException, IOException {
		String url = host + "user/query/" + id + returnFormat + appkey;
		GetMethod getMethod = new GetMethod(httpClient, auth, url);
		return User.parse(getMethod.getJSON());
	}
	
	/**
	 * 用户登录，
	 * 此API没有实际功能，可不需要调用
	 * @return 当前登录用户的元数据
	 * @throws org.json.JSONException
	 * @throws NForumException
	 * @throws java.io.IOException
	 */
	public User login() throws JSONException,
		NForumException, IOException {
		String url = host + "user/login" + returnFormat + appkey;
		GetMethod getMethod = new GetMethod(httpClient, auth, url);
		return User.parse(getMethod.getJSON());
	}
	
	
	/**
	 * 用户退出
	 * @return 当前登录用户的元数据
	 * @throws org.json.JSONException
	 * @throws NForumException
	 * @throws java.io.IOException
	 */
	public User logout() throws JSONException,
		NForumException, IOException {
		String url = host + "user/logout" + returnFormat + appkey;
		GetMethod getMethod = new GetMethod(httpClient, auth, url);
		return User.parse(getMethod.getJSON());
	}
}
