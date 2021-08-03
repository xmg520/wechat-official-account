package com.mzx.wechat321.service.impl;

import com.github.pagehelper.PageHelper;
import com.mzx.wechat321.dao.MsgDao;
import com.mzx.wechat321.pojo.MsgCodeKey;
import com.mzx.wechat321.service.MsgService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MsgServiceImpl implements MsgService {

    @Autowired(required = false)
    MsgDao msgDao;

    @Override
    public List<MsgCodeKey> searchMsgbyKey(String keyword) {
        return msgDao.searchMsgbyKey(keyword);
    }

    @Override
    public MsgCodeKey searchMsgbyCode(String code) {
        return msgDao.searchMsgbyCode(code);
    }

    @Override
    public List<MsgCodeKey> findAll() {
        return msgDao.findAll();
    }

    @Override
    public int findAllCount() {
        return msgDao.findAllCount();
    }

    @Override
    public int deleteById(int did) {
        return msgDao.deleteById(did);
    }

    @Override
    public MsgCodeKey updateByMsg(MsgCodeKey msgCodeKey) {
        return msgDao.updateByMsg(msgCodeKey);
    }

    @Override
    public MsgCodeKey addByMsg(MsgCodeKey msgCodeKey) {
        return msgDao.addByMsg(msgCodeKey);
    }

    @Override
    public MsgCodeKey updateAbleByMsg(MsgCodeKey msgCodeKey) {
        // 逻辑判断,只要不是1(开启状态) 一律修改失败保持关闭状态
        int code = 0;
        if (msgCodeKey.getMsg_isable()==1){
            code = 1;
        }
        return msgDao.updateAbleByMsg(code);
    }

    @Override
    public List<MsgCodeKey> queryUserListPaged(MsgCodeKey msgCodeKey, Integer page, Integer pageSize) {
        // 开始分页
        PageHelper.startPage(page,pageSize);

        List<MsgCodeKey> msgCodeKeyList = msgDao.findAll();

        return msgCodeKeyList;
    }
}
