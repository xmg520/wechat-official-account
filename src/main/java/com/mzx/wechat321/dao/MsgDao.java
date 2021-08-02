package com.mzx.wechat321.dao;


import com.mzx.wechat321.pojo.MsgCodeKey;

import java.util.List;

public interface MsgDao {
    // 消息关键字查询回复接口
    List<MsgCodeKey> searchMsgbyKey(String keyword);

    // 消息code码查询回复接口
    MsgCodeKey searchMsgbyCode(String code);

    // 查询所有消息数据接口
    List<MsgCodeKey> findAll();

    // 根据id删除接口
    int deleteById(int did);

    // 修改对象接口
    MsgCodeKey updateByMsg(MsgCodeKey msgCodeKey);

    // 添加对象接口
    MsgCodeKey addByMsg(MsgCodeKey msgCodeKey);

    // 开启关闭消息状态
    MsgCodeKey updateAbleByMsg(int code);
}
