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
package com.edison.eaction;

import android.content.Context;
import android.os.AsyncTask;
import android.text.TextUtils;

import com.edison.model.CouponBO;
import com.edison.model.PhoneInfo;
import com.edison.netapi.Api;
import com.edison.netapi.ApiImpl;
import com.edison.netapi.ApiResponse;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


/**
 * AppAction接口的实现类
 *
 * @author xiaotufei
 * @date 16/03/06
 * @version 1.0
 */
public class AppActionImpl implements AppAction {

    private final static int LOGIN_OS = 1; // 表示Android
    private final static int PAGE_SIZE = 20; // 默认每页20条

    private Context context;
    private Api api;

    public AppActionImpl(Context context) {
        this.context = context;
        this.api = new ApiImpl();
    }





    @Override
    public void phoneInfo(final String phoneNum, final ActionCallbackListener<PhoneInfo> listener) {
        if (TextUtils.isEmpty(phoneNum)) {
            if (listener != null) {
                listener.onFailure(ErrorEvent.PARAM_NULL, "手机号为空");
            }
            return;
        }
        Pattern pattern = Pattern.compile("1\\d{10}");
        Matcher matcher = pattern.matcher(phoneNum);
        if (!matcher.matches()) {
            if (listener != null) {
                listener.onFailure(ErrorEvent.PARAM_ILLEGAL, "手机号不正确");
            }
            return;
        }
        // 请求Api
        new AsyncTask<Void,Void,ApiResponse<PhoneInfo>>(){

            @Override
            protected ApiResponse<PhoneInfo> doInBackground(Void... params) {
                return api.phoneInfoByNumber(phoneNum);
            }

            @Override
            protected void onPostExecute(ApiResponse<PhoneInfo> phoneInfoApiResponse) {
                if (listener != null && phoneInfoApiResponse != null) {
                    if (phoneInfoApiResponse.isSuccess()) {
                        listener.onSuccess(phoneInfoApiResponse.getRetData());
                    } else {
                        listener.onFailure(phoneInfoApiResponse.getErrNum(), phoneInfoApiResponse.getErrMsg());
                    }
                }
            }
        }.execute();
    }

    @Override
    public void listCoupon(final int currentPage, final ActionCallbackListener<List<CouponBO>> listener) {
        // 参数检查
        if (currentPage < 0) {
            if (listener != null) {
                listener.onFailure(ErrorEvent.PARAM_ILLEGAL, "当前页数小于零");
            }
        }

        // 请求Api
        new AsyncTask<Void, Void, ApiResponse<List<CouponBO>>>() {
            @Override
            protected ApiResponse<List<CouponBO>> doInBackground(Void... voids) {
                return api.listNewCoupon(currentPage, PAGE_SIZE);
            }

            @Override
            protected void onPostExecute(ApiResponse<List<CouponBO>> response) {
                if (listener != null && response != null) {
                    if (response.isSuccess()) {
                        listener.onSuccess(response.getRetData());
                    } else {
                        listener.onFailure(response.getErrNum(), response.getErrMsg());
                    }
                }
            }
        }.execute();
    }

}
