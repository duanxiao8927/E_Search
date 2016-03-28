/**
 * Copyright (C) 2015. Keegan小钢（http://keeganlee.me）
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.edison.netapi;

import com.edison.model.CouponBO;
import com.edison.model.PhoneInfo;
import com.edison.netapi.net.HttpEngine;
import com.edison.netapi.util.EncryptUtil;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * Api实现类
 *
 * @author xiaotufei
 * @date 16/03/06
 * @version 1.0
 */
public class ApiImpl implements Api {
    private final static String APP_KEY = "3104196bbb06d75ceb27755e8b56688e";
    private final static String TIME_OUT_EVENT = "CONNECT_TIME_OUT";
    private final static String TIME_OUT_EVENT_MSG = "连接服务器失败";

    private HttpEngine httpEngine;

    public ApiImpl() {
        httpEngine = HttpEngine.getInstance();
    }

    @Override
    public ApiResponse<PhoneInfo> phoneInfoByNumber(String phoneNum) {
        Map<String, String> paramMap = new HashMap<String, String>();
//        paramMap.put("appKey", APP_KEY);
        paramMap.put("phone", phoneNum);

        Type type = new TypeToken<ApiResponse<PhoneInfo>>(){}.getType();
        return httpEngine.getHandle("http://apis.baidu.com/apistore/mobilenumber/mobilenumber", paramMap, type);
    }


    @Override
    public ApiResponse<List<CouponBO>> listNewCoupon(int currentPage, int pageSize) {
        Map<String, String> paramMap = new HashMap<String, String>();
        paramMap.put("appKey", APP_KEY);
        paramMap.put("currentPage", String.valueOf(currentPage));
        paramMap.put("pageSize", String.valueOf(pageSize));

        Type type = new TypeToken<ApiResponse<List<CouponBO>>>(){}.getType();
        try {
            return httpEngine.postHandle(paramMap, type);
        } catch (IOException e) {
            return new ApiResponse(TIME_OUT_EVENT, TIME_OUT_EVENT_MSG);
        }
    }

}
