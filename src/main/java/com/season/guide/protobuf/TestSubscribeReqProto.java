package com.season.guide.protobuf;

import com.google.protobuf.InvalidProtocolBufferException;
import com.season.guide.protobuf.SubscribeReqProto;

/**
 * Created by Administrator on 2018/9/1.
 */
public class TestSubscribeReqProto {


    private static byte[] encode(SubscribeReqProto.SubscribeReq req) {
        return req.toByteArray();
    }

    private static SubscribeReqProto.SubscribeReq decode(byte[] body) throws InvalidProtocolBufferException {
        return SubscribeReqProto.SubscribeReq.parseFrom(body);
    }

    private static SubscribeReqProto.SubscribeReq createSubscribeReq() {
        SubscribeReqProto.SubscribeReq.Builder builder = SubscribeReqProto.SubscribeReq.newBuilder();
        return builder.setSubReqId(1)
                .setProductName("test")
                .setUserName("season")
                .setAddress("shenzhen").build();
    }

    public static void main(String... args) throws InvalidProtocolBufferException {
        SubscribeReqProto.SubscribeReq req = createSubscribeReq();
        System.out.println("编码前：" + req);
        SubscribeReqProto.SubscribeReq req2 = decode(encode(req));
        System.out.println("编码后：" + req2);
        System.out.println("assert equal: " + req2.equals(req));
    }
}
