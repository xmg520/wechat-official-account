package com.mzx.wechat321.service;


import com.mzx.wechat321.pojo.MsgCodeKey;

import java.util.List;

public interface MsgService {
    // 消息关键字查询回复接口
    List<MsgCodeKey> searchMsgbyKey(String keyword);

    // 消息code码查询回复接口
    MsgCodeKey searchMsgbyCode(String code);

    // 查询所有消息数据接口
    List<MsgCodeKey> findAll();

    // 查询所有消息数据总数
    int findAllCount();

    // 根据id删除接口
    int deleteById(int did);

    // 修改对象接口
    int updateByMsg(MsgCodeKey msgCodeKey);

    // 添加对象接口
    int addByMsg(MsgCodeKey msgCodeKey);

    // 开启关闭消息状态
    MsgCodeKey updateAbleByMsg(MsgCodeKey msgCodeKey);

    // 根据对象查询数据
    List<MsgCodeKey> findByMsgKey(MsgCodeKey msgCodeKey);

    // 分页查询
    public List<MsgCodeKey> queryUserListPaged(MsgCodeKey msgCodeKey, Integer page, Integer pageSize);
}
